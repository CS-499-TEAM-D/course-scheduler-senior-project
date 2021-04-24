package coursescheduler.views.pages;

import java.util.List;

/** Marks a container that can have conflicts from a schedule. */
public interface CourseEventParent {
  List<CourseSchedulerConflict> getConflicts();
}
