package coursescheduler.client.daos;

import java.util.List;

import coursescheduler.views.pages.Course;

/**
 * TODO: Javadoc.
 */
public interface DepartmentDao {
    List<Course> getCourseOfferings();
}
