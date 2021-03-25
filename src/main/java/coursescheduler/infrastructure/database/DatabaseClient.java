package coursescheduler.infrastructure.database;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

/**
 * Entry-point for Course Scheduler desktop application.
 */
public final class DatabaseClient {


    public DatabaseClient() throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.

        // final String spreadsheetId = "1NNZsNlZRHzTG1w977LBTz_wVJ8YTYgJfLMPCSYWpE6Y"; // <-- LIVE DATA
        final String spreadsheetId = "17hrTlcbE9zvMlg8eH2Q7wsZjzXcCEqYfv_oVBqe4GKc"; // <-- TEST DATA
        
        Sheets service = SheetsServiceUtil.getSheetsService();


        // write request for the service
        List<List<Object>> valuesToWrite = Arrays.asList(
                Arrays.asList(
                        "~Chris", "Odom"
                )
        );

        ValueRange rangeToWrite = new ValueRange().setValues(valuesToWrite);
        UpdateValuesResponse writeRequestResult = service.spreadsheets()
                                                         .values()
                                                         .update(spreadsheetId, "C4:D4", rangeToWrite)
                                                         .setValueInputOption("RAW")
                                                         .execute();

        // read request for the service
        final String range = "A1:D4";
        ValueRange response = service.spreadsheets()
                                     .values()
                                     .get(spreadsheetId, range)
                                     .execute();

        List<List<Object>> valuesToRead = response.getValues();


        if (valuesToRead == null || valuesToRead.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (List row : valuesToRead) {
                // Print columns A and E, which correspond to indices 0 and 4.
                System.out.printf("%s, %s, %s, %s\n", row.get(0), row.get(1), row.get(2), row.get(3));
            }
        }
    }
}

