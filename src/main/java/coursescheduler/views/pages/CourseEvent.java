package coursescheduler.views.pages;

import coursescheduler.Room;

/** Represents a faculty preference to be handled by the scheduling algorithm. */
public class CourseEvent {
  private final String professorId;
  private final Room room;
  private final Course course;
  private boolean conflict;

  CourseEvent(String professorId, Room room, Course course, boolean conflict) {
    this.professorId = professorId;
    this.room = room;
    this.course = course;
    this.conflict = conflict;
  }
}
