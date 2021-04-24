package coursescheduler.views.pages;

import coursescheduler.Room;

/** Represents a faculty preference to be handled by the scheduling algorithm. */
public class CourseEvent {
  private final String facultyEmail;
  private final Room room;
  private final Course course;
  private boolean conflict;
  private CourseSchedulerConflict conflictDesc;

  public CourseEvent(String facultyEmail, Room room, Course course, boolean conflict) {
    this.facultyEmail = facultyEmail;
    this.room = room;
    this.course = course;
    this.conflict = conflict;
  }
}
