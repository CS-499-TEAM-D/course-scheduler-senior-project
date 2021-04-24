package coursescheduler;

import java.util.List;
import java.util.Map;

import coursescheduler.client.daos.DayPeriodDao;
import coursescheduler.client.daos.RoomDao;
import coursescheduler.client.daos.TimePeriodDao;
import coursescheduler.views.pages.CourseEvent;
import coursescheduler.views.pages.CourseEventParent;
import coursescheduler.views.pages.CourseSchedulerConflict;
import coursescheduler.views.pages.Department;

/** Holds and managers scheduling information for all University departments. */
public class University implements CourseEventParent, Queryable {

  private final Map<String, Department>
      departments; // represents the schedule of all departments separately
  private final List<CourseEvent> schedule; // represents the schedule of all departments together
  private final TimePeriodDao timePeriodDao; // accesses time periods across the university
  private final DayPeriodDao dayPeriodDao; // accesses day periods across the university
  private final RoomDao roomDao; // accesses rooms across the university
  private final List<List<CourseEvent>> schedules;

  University(
      Map<String, Department> departments,
      List<CourseEvent> schedule,
      TimePeriodDao timePeriodDao,
      DayPeriodDao dayPeriodDao,
      RoomDao roomDao,
      List<List<CourseEvent>> schedules) {
    this.departments = departments;
    this.schedule = schedule;
    this.timePeriodDao = timePeriodDao;
    this.dayPeriodDao = dayPeriodDao;
    this.roomDao = roomDao;
    this.schedules = schedules;
  }

  @Override
  public List<CourseSchedulerConflict> getConflicts() {
    return null;
  }

  @Override
  public List<CourseEvent> findByDepartment(String department) {
    return null;
  }

  @Override
  public List<CourseEvent> findByFaculty(String email) {
    return null;
  }

  @Override
  public List<CourseEvent> findByRoom(String roomId) {
    return null;
  }
}