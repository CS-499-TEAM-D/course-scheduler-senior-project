package coursescheduler.security;

/**
 * TODO: Javadoc.
 */
public class BaseCredentialsVerifier implements CredentialsVerifier {
    @Override
    public boolean validUserCredentials(String email, char[] password) {
        return true;
    }
}
