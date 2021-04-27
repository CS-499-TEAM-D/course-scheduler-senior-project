package coursescheduler.client.objects;
/**
 * @author https://www.csodom.com
 */
public final class FacultyPreference {

    public final String professorEmail;
    public final int coursePreferenceId;
    public final String roomId;
    public final int periodId;

    public FacultyPreference(String professorEmail, int coursePreferenceId, String roomId, int periodId) {

        this.professorEmail = professorEmail;
        this.coursePreferenceId = coursePreferenceId;
        this.roomId = roomId;
        this.periodId = periodId;
    }

}