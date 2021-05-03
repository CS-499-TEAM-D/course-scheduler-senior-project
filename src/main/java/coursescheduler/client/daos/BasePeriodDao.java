package coursescheduler.client.daos;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import coursescheduler.client.objects.Period;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static coursescheduler.security.utilties.SheetsConstants.*;

/**
 * @author https://www.csodom.com
 */
public class BasePeriodDao implements PeriodDao {

    private static final int PERIOD_ID = 0;
    private static final int DAY_SECTION = 1;
    private static final int TIME_SECTION = 2;
    private final Sheets service;
    private String spreadsheetId;


    public BasePeriodDao(Sheets service, String spreadsheetId) {
        this.service = service;
        this.spreadsheetId = spreadsheetId;
    }

    @Override
    public Period getPeriodById(int id) {
        // the id is equal to the index - 1, so we do not need to find the index of the id
        id--;
        // if user found, fetch information on the user and create a user object to return
        String rangeOfPeriodToGet = TIME_PERIODS_SHEET + PERIOD_ID_COLUMN + id + ":" + TIME_COLUMN + id;
        ValueRange periodRange = null;
        try {
            periodRange = service.spreadsheets().values().get(spreadsheetId, rangeOfPeriodToGet).execute();
            List<List<Object>> period = periodRange.getValues();

            return new Period(Integer.parseInt(String.valueOf(period.get(0).get(PERIOD_ID))), String.valueOf(period.get(0).get(DAY_SECTION)), String.valueOf(period.get(0).get(TIME_SECTION)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Period> getAllPeriods(Boolean debug) {
        String rangeOfAllPeriods = "";
        if (debug) {
            rangeOfAllPeriods = TIME_PERIODS_SHEET_DEBUG + PERIOD_ID_COLUMN + ":" + TIME_COLUMN;
        } else {
            rangeOfAllPeriods = TIME_PERIODS_SHEET + PERIOD_ID_COLUMN + ":" + TIME_COLUMN;
        }
        ValueRange periodRange = null;

        try {
            periodRange = service.spreadsheets().values().get(spreadsheetId, rangeOfAllPeriods).execute();
            List<List<Object>> periodTable = periodRange.getValues();
            // remove the header from the data table
            periodTable.remove(0);

            List<Period> periodList = new ArrayList<>();

            for (List<Object> period : periodTable) {
                periodList.add(new Period(Integer.parseInt(String.valueOf(period.get(PERIOD_ID))), String.valueOf(period.get(DAY_SECTION)), String.valueOf(period.get(TIME_SECTION))));
            }

            return periodList;
        } catch (IOException e) {
            return null;
        }
    }
}