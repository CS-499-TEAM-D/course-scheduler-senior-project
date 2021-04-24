package coursescheduler;

import java.util.List;

import coursescheduler.views.pages.CourseEvent;

/** Schedules courses based on provided {@linkplain CourseEvent CourseEvents}. */
public interface Scheduler {
  List<List<CourseEvent>> schedule(List<CourseEvent> toSchedule);
}
