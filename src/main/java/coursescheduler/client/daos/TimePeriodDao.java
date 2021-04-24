package coursescheduler.client.daos;

import java.util.Set;

/** Retrieves time periods. */
public interface TimePeriodDao {
  Set<String> getTimePeriods();
}
