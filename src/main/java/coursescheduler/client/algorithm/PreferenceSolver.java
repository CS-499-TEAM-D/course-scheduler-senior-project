package coursescheduler.client.algorithm;

import coursescheduler.client.daos.PeriodDao;
import coursescheduler.client.importer.ImportedData;
import coursescheduler.client.objects.*;

import java.util.*;

import static coursescheduler.client.algorithm.SchedulerConstants.*;

/**
 * @author https://www.csodom.com
 */
public class PreferenceSolver {

    private final List<FacultyPreference> facultyPreferences;
    private final List<Period> periods;
    private final List<Room> rooms;
    private final List<Course> courses;
    private final HashMap<Room, HashMap<Period, Boolean>> roomPeriodAvailabilityMap;
    private final List<Integer> courseAvailability;
    private final List<FacultyPreference> facultyPreferencesNotHonored;
    private final List<CourseEvent> courseEvents;
    private boolean scheduleIsGenerated;
    private int preferenceRow;

    class SortRoomByCapacityDescending implements Comparator<Room> {
        @Override
        public int compare(Room a, Room b) {
            return b.getCapacity() - a.getCapacity();
        }
    }

    public PreferenceSolver(PeriodDao periodDao, boolean debugPeriods){
        this.facultyPreferences = ImportedData.getInstance().getFacultyPreferences();
        this.periods = periodDao.getAllPeriods(debugPeriods);
        this.rooms = ImportedData.getInstance().getSanctionedRooms();
        this.courses = ImportedData.getInstance().getCoursesOffered();
        Collections.sort(rooms, new SortRoomByCapacityDescending());
        this.roomPeriodAvailabilityMap = new HashMap<>();
        this.courseAvailability = new ArrayList<>();
        this.facultyPreferencesNotHonored = new ArrayList<>();
        this.courseEvents = new ArrayList<>();
        this.scheduleIsGenerated = false;

    }

    public void clearSchedule(){
        this.scheduleIsGenerated = false;
        this.courseEvents.clear();
    }

    /**
     * this generates a schedule with data provided to the PreferenceSolver, and returns a int code
     * @return returns a scheduler code
     * 101 = successful schedule generated,
     *   1 = not enough rooms,
     *   2 = course not available,
     *   3 = invalid room in preference,
     *   4 = invalid period in preference,
     *   5 = invalid course in preference
     */
    public int generateSchedule(){
        int schedulerCode;
        this.preferenceRow = 2;
        for (FacultyPreference facultyPreference : facultyPreferences){
            // verify faculty preference data complies with course data, room data, and period data
            Room roomPreferred = rooms.stream().filter(room -> facultyPreference.roomId.equals(room.getRoomId())).findAny().orElse(null);
            if(roomPreferred == null){
                return INVALID_ROOM_IN_PREFERENCE;
            }
            Period periodPreferred = periods.stream().filter(period -> facultyPreference.periodId == period.getPeriodIndex()).findAny().orElse(null);
            if(periodPreferred == null){
                return INVALID_PERIOD_IN_PREFERENCE;
            }
            Course coursePreferred = courses.stream().filter(course -> facultyPreference.coursePreferenceId == course.getCourseIndex()).findAny().orElse(null);
            if(coursePreferred == null){
                return INVALID_COURSE_IN_PREFERENCE;
            }
            // if all is in compliance, attempt to schedule the faculty preference, or find alternatives
            schedulerCode = attemptToSchedule(facultyPreference, roomPreferred, periodPreferred, coursePreferred);
            if(schedulerCode != SUCCESSFULLY_COURSE_ADDED_TO_SCHEDULE){
                return schedulerCode;
            }
            preferenceRow++;
        }
        // update so getGeneratedSchedule() will return the list of CourseEvent s
        this.scheduleIsGenerated = true;

        return SUCCESSFUL_SCHEDULE_GENERATED;
    }

    /**
     * @return if the schedule is generated, returns it as a list of course events
     */
    public List<CourseEvent> getGeneratedSchedule(){
        if(this.scheduleIsGenerated){
            return this.courseEvents;
        }else{
            return null;
        }
    }


    /**
     * @param facultyPreference object containing the preference of a faculty member
     * @param room the preferred room, or if recursively called, the next available room
     * @param period the preferred period, or if recursively called, the next available period
     * @param coursePreferred the preferred course
     * @return
     */
    public int attemptToSchedule(FacultyPreference facultyPreference, Room room, Period period, Course coursePreferred){
        if(courseAvailability.contains(facultyPreference.coursePreferenceId)){
            return COURSE_NOT_AVAILABLE;
        }
        if(roomAndTimeIsAvailable(room, period)){
            // this runs if the preference can be honored
            // first check and make sure the room can fit the course
            if(courseFitsRoomPreferred(room, coursePreferred)){
                return addCourseToSchedule(facultyPreference, room, period);
            }else{
                // we need to find a bigger room
                // if NOT at largest room (0th room) then try next largest room, else return not enough rooms
                if(!(rooms.indexOf(room)>0)){
                    return NOT_ENOUGH_ROOMS;
                }
                Room nextBigRoom = rooms.get(rooms.indexOf(room)-1);
                return attemptToSchedule(facultyPreference, nextBigRoom, period, coursePreferred);
            }
        }else{
            // we need to see if another time in the same room would work
            for(Period possiblePeriod : periods){
                if(roomAndTimeIsAvailable(room, possiblePeriod)){
                    return attemptToSchedule(facultyPreference, room, possiblePeriod, coursePreferred);
                }
            }
            // if no other time would work, we need to iterate to the next largest room
            // if NOT at largest room (0th room) then try next largest room, else return not enough rooms
            if(!(rooms.indexOf(room)>0)){
                return NOT_ENOUGH_ROOMS;
            }
            Room nextBigRoom = rooms.get(rooms.indexOf(room)-1);
            return attemptToSchedule(facultyPreference, nextBigRoom, period, coursePreferred);
        }
    }

    /**
     * @param facultyPreference faculty preference object containing professor email and course id
     * @param room room that the professor and course are being assigned to
     * @param period time that the professor and course are being assigned to
     * @return will always return code 100 SUCCESSFULLY_COURSE_ADDED_TO_SCHEDULE
     */
    public int addCourseToSchedule(FacultyPreference facultyPreference, Room room, Period period){
        // update the room and time availability
        roomPeriodAvailabilityMap.get(room).put(period, true);
        // check to see if room and period match preference, if not add to preference not honored list
        if(facultyPreference.periodId != period.getPeriodIndex() || facultyPreference.roomId != room.getRoomId()){
            facultyPreferencesNotHonored.add(facultyPreference);
        }
        // create a course event then add it to course event list
        courseEvents.add(new CourseEvent(facultyPreference.professorEmail, facultyPreference.coursePreferenceId, room, period));
        courseAvailability.add(facultyPreference.coursePreferenceId);
        return SUCCESSFULLY_COURSE_ADDED_TO_SCHEDULE;
    }

    /**
     * @param room room to check
     * @param period period to check
     * @return returns true if both the room and period combination are available, else returns false
     */
    public boolean roomAndTimeIsAvailable(Room room, Period period){
        if(roomPeriodAvailabilityMap.containsKey(room)){
            if(roomPeriodAvailabilityMap.get(room).containsKey(period)){
                return roomPeriodAvailabilityMap.get(room).get(period); // if we get here, it will always return false
            }else{
                // if we get here, that means that the there is no value at room and period
                // which means it is available
                // so we add false to prevent it from being double booked, and we return true
                roomPeriodAvailabilityMap.get(room).put(period, false);
                return true;
            }
        }else{
            roomPeriodAvailabilityMap.put(room, new HashMap<Period, Boolean>());
            return roomAndTimeIsAvailable(room, period);
        }
    }

    /**
     * @param room room to check
     * @param course course to check
     * @return returns true if the room is large enough to hold the course, else returns false
     */
    public boolean courseFitsRoomPreferred(Room room, Course course){
        return room.getCapacity()>course.getMaxEnroll();
    }

    public void printScheduleToConsole(){
        //for(CourseEvent courseEvent : this.courseEvents){
        //    courseEvent.print();
        //}
    }

    public int getCurrentFacultyPreferenceRow() {
        return preferenceRow;
    }

}