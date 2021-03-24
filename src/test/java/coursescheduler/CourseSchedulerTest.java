package coursescheduler;

import org.junit.Before;
import org.junit.Test;

public class CourseSchedulerTest {
  @Before
  public void setUp() {}

  @Test
  public void main_defaultState_shouldNotFail() {
    CourseScheduler.main(new String[] {});
  }
}
