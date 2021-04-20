package coursescheduler;

import java.util.List;
import java.util.Map;

import coursescheduler.views.pages.CourseEvent;

/** TODO: Javadoc. */
public final class BaseScheduler {
  private final Map<String, Map<String, Map<Room, List<CourseEvent>>>> conflictTree;

  BaseScheduler(Map<String, Map<String, Map<Room, List<CourseEvent>>>> conflictTree) {
    this.conflictTree = conflictTree;
  }
}
