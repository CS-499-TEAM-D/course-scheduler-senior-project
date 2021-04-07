package coursescheduler.infrastructure.database.models;

public class Course {

    protected final int courseIndex;
    protected final int courseId;
    protected final int sectionId;
    protected final int prelimEnroll;
    protected final int maxEnroll;

    /**
     * @param courseIndex
     * @param courseId
     * @param sectionId
     * @param prelimEnroll
     * @param maxEnroll
     */
    Course(int courseIndex, int courseId, int sectionId, int prelimEnroll, int maxEnroll){

        this.courseIndex = courseIndex;
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.prelimEnroll = prelimEnroll;
        this.maxEnroll = maxEnroll;

    }

}
