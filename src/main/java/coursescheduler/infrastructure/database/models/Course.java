package coursescheduler.infrastructure.database.models;
/**
 * @author https://www.csodom.com
 */
public class Course {

    private final int courseIndex;
    private final int courseId;
    private final int sectionId;
    private final int prelimEnroll;
    private final int maxEnroll;

    /**
     * @param courseIndex
     * @param courseId
     * @param sectionId
     * @param prelimEnroll
     * @param maxEnroll
     */
    public Course(int courseIndex, int courseId, int sectionId, int prelimEnroll, int maxEnroll){

        this.courseIndex = courseIndex;
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.prelimEnroll = prelimEnroll;
        this.maxEnroll = maxEnroll;

    }

    public int getCourseIndex() {
        return courseIndex;
    }
    public int getSectionId() {
        return sectionId;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getPrelimEnroll() {
        return prelimEnroll;
    }

    public int getMaxEnroll() {
        return maxEnroll;
    }


}
