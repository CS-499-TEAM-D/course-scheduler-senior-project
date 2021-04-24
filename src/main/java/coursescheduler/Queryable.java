package coursescheduler;

import java.util.List;

import coursescheduler.views.pages.CourseEvent;

/** Allows for querying of structures that support course scheduling. */
public interface Queryable {
  List<CourseEvent> findByDepartment(String department);

  List<CourseEvent> findByFaculty(String email);

  List<CourseEvent> findByRoom(String roomId);
}
