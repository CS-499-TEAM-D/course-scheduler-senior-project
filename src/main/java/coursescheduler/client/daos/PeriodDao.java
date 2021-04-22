package coursescheduler.client.daos;

import coursescheduler.infrastructure.database.models.Period;

import java.util.List;

public interface PeriodDao {
    Period getPeriodById(int id);
    List<Period> getAllPeriods();
}
