package coursescheduler.infrastructure.database.models;
/**
 * @author https://www.csodom.com
 */
public class CourseEvent{

    public final String professorEmail;
    public final int coursePreferenceId;
    public final String roomId;
    public final int periodId;

    public CourseEvent(String professorEmail, int coursePreferenceId, String roomId, int periodId) {

        this.professorEmail = professorEmail;
        this.coursePreferenceId = coursePreferenceId;
        this.roomId = roomId;
        this.periodId = periodId;
    }
}
