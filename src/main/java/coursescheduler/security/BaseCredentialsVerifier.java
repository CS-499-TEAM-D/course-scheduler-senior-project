package coursescheduler.security;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import coursescheduler.security.utilties.SheetsService;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;


import static coursescheduler.security.utilties.SecurityConstants.*;

/**
 * {@inheritDoc}
 */
public class BaseCredentialsVerifier implements CredentialsVerifier {

    @Override
    public boolean validUserCredentials(String email, char[] password) {
        try {
            Sheets service = SheetsService.getSheetsService();
            int userIndex = findIndexOfStringInSheetColumn(service, CREDENTIALS_SPREADSHEET, CREDENTIALS_SHEET, USERNAME_COLUMN, email);

            ValueRange uploadPasswordValueRange = new ValueRange().setValues(Arrays.asList(
                    Arrays.asList(String.valueOf(password))
            ));
            // write the password attempt to the remote sheet
            service.spreadsheets().values().update(
                    CREDENTIALS_SPREADSHEET,
                    CREDENTIALS_SHEET + PASSWORD_UPLOAD_COLUMN + userIndex,
                    uploadPasswordValueRange)
                    .setValueInputOption("RAW")
                    .execute();
            // fetch from the verification column either true if the password attempt = password saved or false if not
            boolean verified = Boolean.parseBoolean(service.spreadsheets().values().get(
                    CREDENTIALS_SPREADSHEET,
                    CREDENTIALS_SHEET+VERIFICATION_COLUMN+userIndex)
                    .execute()
                    .getValues()
                    .get(0).get(0)
                    .toString()
            );
            // clear the password attempt column on the remote sheet
            uploadPasswordValueRange.getValues().get(0).set(0, "");
            service.spreadsheets().values().update(
                    CREDENTIALS_SPREADSHEET,
                    CREDENTIALS_SHEET + PASSWORD_UPLOAD_COLUMN + userIndex,
                    uploadPasswordValueRange)
                    .setValueInputOption("RAW")
                    .execute();
            return verified;

        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
            return false;
        }
    }

    private int findIndexOfStringInSheetColumn(Sheets service, String spreadsheetID, String sheetTitle, String column, String stringToFind) {
        try {
            String columnToGet = (new StringBuilder()).append(sheetTitle).append(column).append(":").append(column).toString();
            List<List<Object>> stringsInColumn = service.spreadsheets().values().get(
                    spreadsheetID,
                    columnToGet)
                    .execute()
                    .getValues();
            int index = 0;
            for (List string : stringsInColumn){
                if(string.get(0).toString().equals(stringToFind)){
                    index++; // add one because the row calls are 1th based
                    return index;
                }
                index++;
            }
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
