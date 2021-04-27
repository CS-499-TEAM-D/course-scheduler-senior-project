package coursescheduler.client.daos;

import coursescheduler.client.objects.Period;

import java.util.List;
/**
 * @author https://www.csodom.com
 */
public interface PeriodDao {
    Period getPeriodById(int id);
    List<Period> getAllPeriods();
}