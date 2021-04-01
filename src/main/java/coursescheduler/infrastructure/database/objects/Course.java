package coursescheduler.infrastructure.database.objects;

public class Course {
    private final String departmentId;
    private final int courseId;
    private final int sectionId;
    private final String professor;
    private final String classroomId;
    private final int timeId;
    private int prelimEnroll;
    private int maxEnroll;

    public Course(String departmentId, int courseId, int sectionId, String professor, String classroomId, int timeId, int prelimEnroll, int maxEnroll) {
        this.departmentId = departmentId;
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.professor = professor;
        this.classroomId = classroomId;
        this.timeId = timeId;
        this.prelimEnroll = prelimEnroll;
        this.maxEnroll = maxEnroll;
    }
    public Course(String departmentId, int courseId, int sectionId, String professor, int timeId, String classroomId) {
        this.departmentId = departmentId;
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.professor = professor;
        this.classroomId = classroomId;
        this.timeId = timeId;
        this.prelimEnroll = 0;
        this.maxEnroll = 0;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public String getProfessor() {
        return professor;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public int getTimeId() {
        return timeId;
    }

    public int getPrelimEnroll() {
        return prelimEnroll;
    }

    public void setPrelimEnroll(int x) {
        this.prelimEnroll = x;
    }

    public int getMaxEnroll() {
        return maxEnroll;
    }

    public void setMaxEnroll(int x) {
        this.maxEnroll = x;
    }

    public String getDepartmentId() {
        return departmentId;
    }
}
