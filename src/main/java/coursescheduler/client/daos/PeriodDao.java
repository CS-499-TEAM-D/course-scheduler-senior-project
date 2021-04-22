package coursescheduler.client.daos;

import coursescheduler.infrastructure.database.models.Period;

import java.util.List;
/**
 * @author https://www.csodom.com
 */
public interface PeriodDao {
    Period getPeriodById(int id);
    List<Period> getAllPeriods();
}
