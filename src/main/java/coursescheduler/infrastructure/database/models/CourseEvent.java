package coursescheduler.infrastructure.database.models;

public final class CourseEvent{

    private final String professorEmail;
    private final int coursePreferenceId;
    private final String roomId;
    private final int periodId;

    public CourseEvent(String professorEmail, int coursePreferenceId, String roomId, int periodId) {

        this.professorEmail = professorEmail;
        this.coursePreferenceId = coursePreferenceId;
        this.roomId = roomId;
        this.periodId = periodId;
    }

}
