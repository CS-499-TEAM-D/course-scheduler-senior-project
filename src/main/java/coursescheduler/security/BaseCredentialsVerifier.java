package coursescheduler.security;

import com.google.api.services.sheets.v4.model.ValueRange;
import coursescheduler.client.daos.UserDao;

import java.io.IOException;
import java.util.Arrays;

/**
 * TODO: Javadoc.
 */
public class BaseCredentialsVerifier implements CredentialsVerifier {

    private final UserDao userDao;
    public BaseCredentialsVerifier(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public boolean validUserCredentials(String email, char[] password) throws IOException {
        return userDao.verifyUserLogin(email, password);
    }
}
