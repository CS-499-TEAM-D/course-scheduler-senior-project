package coursescheduler.client.daos;

import com.google.api.services.sheets.v4.Sheets;
import coursescheduler.User;
import coursescheduler.security.BaseCredentialsVerifier;
import coursescheduler.security.utilties.SheetsService;

import java.io.IOException;
import java.security.GeneralSecurityException;


import static coursescheduler.security.utilties.SheetsConstants.*;

/**
 * Default operations for the {@link UserDao} for the CourseScheduler application.
 */
public final class BaseUserDao implements UserDao {
    @Override
    public User addUser(User user) {
        // TODO: Add functionality to write new user to database throwing an exception on failure.
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            Sheets service = SheetsService.getSheetsService();
            int userIndex = BaseCredentialsVerifier.findIndexOfStringInSheetColumn(service, CREDENTIALS_SPREADSHEET, CREDENTIALS_SHEET, USERNAME_COLUMN, email);
            if (userIndex == -1) {
                return null;
            }
            String userEmail = service.spreadsheets().values().get(
                    CREDENTIALS_SPREADSHEET,
                    CREDENTIALS_SHEET + USERNAME_COLUMN + userIndex)
                    .execute()
                    .getValues()
                    .get(0).get(0)
                    .toString();
            String userRole = service.spreadsheets().values().get(
                    CREDENTIALS_SPREADSHEET,
                    CREDENTIALS_SHEET + ROLE_COLUMN + userIndex)
                    .execute()
                    .getValues()
                    .get(0).get(0)
                    .toString();
            String userDepartment = service.spreadsheets().values().get(
                    CREDENTIALS_SPREADSHEET,
                    CREDENTIALS_SHEET + DEPARTMENT_COLUMN + userIndex)
                    .execute()
                    .getValues()
                    .get(0).get(0)
                    .toString();
            return new User(userEmail, userRole, userDepartment);
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
        return null;
    }
}
