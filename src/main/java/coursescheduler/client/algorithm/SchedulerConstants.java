package coursescheduler.client.algorithm;


public final class SchedulerConstants {

    private SchedulerConstants() {
    }


    public static final int SUCCESSFULLY_COURSE_ADDED_TO_SCHEDULE = 100;
    public static final int SUCCESSFUL_SCHEDULE_GENERATED = 101;
    public static final int NOT_ENOUGH_ROOMS = 1;
    public static final String BAD_DATA_TITLE = "BAD DATA INPUTTED!";
    public static final String BAD_DATA_WARNING = "The data imported is not in the correct format, or contains incorrect data types";
    public static final String NOT_ENOUGH_ROOMS_TITLE = "ERROR! Not Enough Rooms";
    public static final String NOT_ENOUGH_ROOMS_WARNING = "There are not enough rooms to fit all the courses!";
    public static final int COURSE_NOT_AVAILABLE = 2;
    public static final String COURSE_NOT_AVAILABLE_TITLE = "ERROR! Course Already Taken";
    public static final String COURSE_NOT_AVAILABLE_WARNING = "The course is already taken that is desired by Faculty Preference at Row: ";
    public static final int INVALID_ROOM_IN_PREFERENCE = 3;
    public static final String INVALID_ROOM_IN_PREFERENCE_TITLE = "ERROR! Invalid Room";
    public static final String INVALID_ROOM_IN_PREFERENCE_WARNING = "There is an invalid Room at Faculty Preference at Row: ";
    public static final int INVALID_PERIOD_IN_PREFERENCE = 4;
    public static final String INVALID_PERIOD_IN_PREFERENCE_TITLE = "ERROR! Invalid Period";
    public static final String INVALID_PERIOD_IN_PREFERENCE_WARNING = "There is an invalid Period at Faculty Preference at Row: ";
    public static final int INVALID_COURSE_IN_PREFERENCE = 5;
    public static final String INVALID_COURSE_IN_PREFERENCE_TITLE = "ERROR! Invalid Course";
    public static final String INVALID_COURSE_IN_PREFERENCE_WARNING = "There is an invalid Course at Faculty Preference at Row: ";

}
