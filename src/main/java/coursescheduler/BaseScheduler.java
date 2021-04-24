package coursescheduler;

import java.util.List;

import coursescheduler.views.pages.CourseEvent;


/**
 * {@inheritDoc}
 */
public final class BaseScheduler implements Scheduler {
  @Override
  public List<List<CourseEvent>> schedule(List<CourseEvent> toSchedule) {
    return null;
  }
}
