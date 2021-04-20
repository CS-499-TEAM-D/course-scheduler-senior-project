package coursescheduler;

import java.util.List;

import coursescheduler.views.pages.CourseEvent;

/**
 * TODO: Javadoc.
 */
public interface Scheduler {
    List<List<CourseEvent>> schedule(List<CourseEvent> toSchedule);

}
