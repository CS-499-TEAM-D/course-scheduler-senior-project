package coursescheduler;

import org.junit.Test;

public class CourseSchedulerTest {
  private final CourseScheduler courseScheduler = new CourseScheduler();

  @Test
  public void main_defaultState_shouldNotFail() {
    courseScheduler.run();
  }
}
