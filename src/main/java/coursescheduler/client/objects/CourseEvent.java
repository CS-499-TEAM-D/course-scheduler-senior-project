package coursescheduler.client.objects;

import coursescheduler.client.objects.*;

/** Represents a faculty preference to be handled by the scheduling algorithm. */
public class CourseEvent {
    private final String facultyEmail;
    private final Room room;
    private final int courseUUID;
    private final Period period;

    public CourseEvent(String facultyEmail, int courseUUID, Room room,  Period period) {
        this.facultyEmail = facultyEmail;
        this.room = room;
        this.courseUUID = courseUUID;
        this.period = period;
    }

    public void print(){
        System.out.print("\nProfessor Email: "+facultyEmail+"\tCourse Assigned UUID: "+courseUUID+"\tRoom ID: "+room.getRoomId()+"\tPeriod: "+period.getDaySection()+" "+period.getTimeSection());
    }

    public String getFacultyEmail(){
        return this.facultyEmail;
    }

    public Room getRoom(){
        return this.room;
    }

    public int getCourseUUID(){
        return this.courseUUID;
    }

    public Period getPeriod(){
        return this.period;
    }

}