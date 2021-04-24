package coursescheduler.views.pages;

import java.util.List;
import java.util.Map;

import coursescheduler.Room;
import coursescheduler.client.daos.DepartmentDao;
import coursescheduler.client.daos.RoomDao;

/** Represents a university department used for Course Scheduling. */
public class Department implements CourseEventParent {
  private final String abbrev;
  private final Map<String, Map<String, Map<Room, List<CourseEvent>>>> mutableSchedule;
  private final RoomDao roomDao;
  private final DepartmentDao departmentDao;

  Department(
      String abbrev,
      Map<String, Map<String, Map<Room, List<CourseEvent>>>> mutableSchedule,
      RoomDao roomDao,
      DepartmentDao departmentDao) {
    this.abbrev = abbrev;
    this.mutableSchedule = mutableSchedule;
    this.roomDao = roomDao;
    this.departmentDao = departmentDao;
  }

  @Override
  public List<CourseSchedulerConflict> getConflicts() {
    return null;
  }
}
