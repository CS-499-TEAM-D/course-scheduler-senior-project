package coursescheduler.security;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import coursescheduler.client.daos.UserDao;
import coursescheduler.infrastructure.database.SheetsServiceUtil;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/**
 * TODO: Javadoc.
 */
public class BaseCredentialsVerifier implements CredentialsVerifier {

    private final UserDao userDao;
    private final Sheets service;
    private final String spreadsheetId;
    public BaseCredentialsVerifier(UserDao userDao, Sheets service, String spreadsheetId) {
        this.service = service;
        this.spreadsheetId = spreadsheetId;
        this.userDao = userDao;
    }

    @Override
    public boolean validUserCredentials(String email, char[] password){
        int index = userDao.findUserIndex(email);
        if (index == -1) {
            return false;
        }
        // write password to column d
        ValueRange valueRange = new ValueRange().setValues(Arrays.asList(
                Arrays.asList(String.valueOf(password))
        ));
        try {
            service.spreadsheets().values().update(spreadsheetId, "CREDS!D" + index, valueRange).setValueInputOption("RAW").execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read column e boolean verify that compares password attempt and password saved
        boolean verified = false;
        try {
            verified = Boolean.parseBoolean(service.spreadsheets().values().get(spreadsheetId, "CREDS!E" + index).execute().getValues().get(0).get(0).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // reset column d so previous attempts are not saved
        valueRange.getValues().get(0).set(0, "");
        try {
            service.spreadsheets().values().update(spreadsheetId, "CREDS!D" + index, valueRange).setValueInputOption("RAW").execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return verified;
    }
}
