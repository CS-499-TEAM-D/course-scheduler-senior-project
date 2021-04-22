/**
 * @author https://www.csodom.com
 */


package coursescheduler.infrastructure.algorithm;

import coursescheduler.client.daos.PeriodDao;
import coursescheduler.infrastructure.database.ExcelImportUtil;
import coursescheduler.infrastructure.database.models.*;

import java.util.*;

public class PreferenceSolver {

    private final List<FacultyPreference> facultyPreferences;
    private final List<Period> periods;
    private final List<Room> rooms;
    private final List<Course> courses;
    private HashMap<Room, HashMap<Period, Boolean>> roomPeriodAvailabilityMap;
    private List<Integer> courseAvailability;
    private List<FacultyPreference> facultyPreferencesNotHonored;
    private List<CourseEvent> courseEvents;


    class SortRoomByCapacityDescending implements Comparator<Room> {
        @Override
        public int compare(Room a, Room b) {
            return b.getCapacity() - a.getCapacity();
        }
    }
    static final int SUCCESSFULLY_COURSE_ADDED_TO_SCHEDULE = 100;
    static final int SUCCESSFUL_SCHEDULE_GENERATED = 101;
    static final int NOT_ENOUGH_ROOMS = 1;
    static final int COURSE_NOT_AVAILABLE = 2;
    static final int INVALID_ROOM_IN_PREFERENCE = 3;
    static final int INVALID_PERIOD_IN_PREFERENCE = 4;
    static final int INVALID_COURSE_IN_PREFERENCE = 5;

    public PreferenceSolver(PeriodDao periodDao){
        this.facultyPreferences = ExcelImportUtil.getInstance().getFacultyPreferenceDataTable();
        this.periods = periodDao.getAllPeriods();
        this.rooms = ExcelImportUtil.getInstance().getRoomInformationDataTable();
        this.courses = ExcelImportUtil.getInstance().getCourseListingDataTable();
        Collections.sort(rooms, new SortRoomByCapacityDescending());
        this.roomPeriodAvailabilityMap = new HashMap<>();
        this.courseAvailability = new ArrayList<>();
        this.facultyPreferencesNotHonored = new ArrayList<>();
        this.courseEvents = new ArrayList<>();

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

        }
        return SUCCESSFUL_SCHEDULE_GENERATED;
    }

    /**
     * @param facultyPreference object containing the preference of a faculty member
     * @param room the preferred room, or if recursively called, the next available room
     * @param period the preferred period, or if recursively called, the next available period
     * @param course the preferred course
     * @return
     */
    public int attemptToSchedule(FacultyPreference facultyPreference, Room room, Period period, Course course){
        if(courseAvailability.contains(facultyPreference.coursePreferenceId)){
            return COURSE_NOT_AVAILABLE;
        }
        if(roomAndTimeIsAvailable(room, period)){
            // this runs if the preference can be honored
            // first check and make sure the room can fit the course
            if(courseFitsRoomPreferred(room, course)){
                roomPeriodAvailabilityMap.get(room).put(period, true);
                // create a course event out of the faculty preference, then add it to course event list
                courseEvents.add(new CourseEvent(facultyPreference.professorEmail, facultyPreference.coursePreferenceId, facultyPreference.roomId, facultyPreference.periodId));
                courseAvailability.add(facultyPreference.coursePreferenceId);
                return SUCCESSFULLY_COURSE_ADDED_TO_SCHEDULE;
            }else{
                // we need to find a bigger room
                // if NOT at largest room (0th room) then try next largest room, else return not enough rooms
                if(!(rooms.indexOf(room)>0)){
                    return NOT_ENOUGH_ROOMS;
                }
                Room nextBigRoom = rooms.get(rooms.indexOf(room)-1);
                return attemptToSchedule(facultyPreference, nextBigRoom, period, course);
            }
        }else{
            // we need to see if another time in the same room would work
            for(Period possiblePeriod : periods){
                if(roomAndTimeIsAvailable(room, possiblePeriod)){
                    return attemptToSchedule(facultyPreference, room, possiblePeriod, course);
                }
            }
            // if no other time would work, we need to iterate to the next largest room
            // if NOT at largest room (0th room) then try next largest room, else return not enough rooms
            if(!(rooms.indexOf(room)>0)){
                return NOT_ENOUGH_ROOMS;
            }
            Room nextBigRoom = rooms.get(rooms.indexOf(room)-1);
            return attemptToSchedule(facultyPreference, nextBigRoom, period, course);
        }
    }

    /**
     * @param room room to check
     * @param period period to check
     * @return returns true if both the room and period combination are available, else returns false
     */
    public boolean roomAndTimeIsAvailable(Room room, Period period){
        return roomPeriodAvailabilityMap.get(room).get(period) == null;
    }

    /**
     * @param room room to check
     * @param course course to check
     * @return returns true if the room is large enough to hold the course, else returns false
     */
    public boolean courseFitsRoomPreferred(Room room, Course course){
        return room.getCapacity()>course.getMaxEnroll();
    }


}
