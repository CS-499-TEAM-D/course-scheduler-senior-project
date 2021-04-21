package coursescheduler.infrastructure.database;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import coursescheduler.User;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

/**
 * @author CSODOM
 */
public final class DatabaseClient {

    private static DatabaseClient dataBaseClientInstance = null;
    private final Sheets service;
    private final String spreadsheetId;
    private final int sectionLimit;
    private HashMap<String, Integer> sheetIDMap;

    /**
     *
     * Builds singleton object of the Sheets service object used to make API calls to the remote google sheet
     *
     * @throws IOException
     * @throws GeneralSecurityException
     */
    private DatabaseClient(int sectionLimit) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        // final String spreadsheetId = "1NNZsNlZRHzTG1w977LBTz_wVJ8YTYgJfLMPCSYWpE6Y"; // <-- LIVE DATA
        final String spreadsheetId = "17hrTlcbE9zvMlg8eH2Q7wsZjzXcCEqYfv_oVBqe4GKc"; // <-- TEST DATA
        this.service = SheetsServiceUtil.getSheetsService();
        this.spreadsheetId = spreadsheetId;
        this.sectionLimit = sectionLimit;
        updateSheetsIDList();
    }

    /**
     * @param sectionLimit limit the number of sections of a course that can be made
     * @return a singleton instance of the database client
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public static DatabaseClient getInstance(int sectionLimit) throws IOException, GeneralSecurityException {
        return (dataBaseClientInstance == null) ? dataBaseClientInstance = new DatabaseClient(sectionLimit) : dataBaseClientInstance;
    }

    /**
     *
     * Updates a mapping of the sheet titles and their URL IDs, which is used for making calls to sheets that do not use ranges
     *
     * @throws IOException
     */
    public void updateSheetsIDList() throws IOException {
        HashMap<String, Integer> sheetIDMap = new HashMap<>();
        Sheets.Spreadsheets.Get thisSheet = service.spreadsheets().get(spreadsheetId);
        List<String> ranges = new ArrayList<>();
        thisSheet.setRanges(ranges);
        thisSheet.setIncludeGridData(false);
        Spreadsheet response = thisSheet.execute();
        List<Sheet> sheetList = response.getSheets();
        for(Sheet sheet : sheetList){
            sheetIDMap.put(sheet.getProperties().getTitle(), sheet.getProperties().getSheetId());
        }
        this.sheetIDMap = sheetIDMap;
    }


    /**
     * @return returns the spreadsheetId
     */
    public String getSpreadsheetId() {
        return this.spreadsheetId;
    }

    /**
     * @return returns the sheets api service
     */
    public Sheets getSheetsService(){
        return this.service;
    }


    /**
     * @return returns the sheet ID hashmap containing all the sheet ids and titles
     */
    public HashMap<String, Integer> getSheetIDMap(){
        return sheetIDMap;
    }

    /*
       =========== USER METHODS ===========
     */



}

