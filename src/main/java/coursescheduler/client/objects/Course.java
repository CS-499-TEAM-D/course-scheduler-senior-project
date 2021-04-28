package coursescheduler.client.objects;


/**
 * Represents the form of a course offered by a department at a University.
 */
public final class Course {
    private int UUID;
    private String deptAbbrev;
    private int id;
    private int section;
    private int maxEnrollment;

    public Course(int UUID, String deptAbbrev, int id, int section, int preliminaryEnrollment) {
        this.UUID = UUID;
        this.deptAbbrev = deptAbbrev;
        this.id = id;
        this.section = section;
        this.maxEnrollment = maxEnrollment;
    }

    public int getCourseIndex() {
        return this.UUID;
    }

    public int getMaxEnroll() {
        return this.maxEnrollment;
    }

    public int getId() {
        return id;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }
}