package coursescheduler.security;

import java.io.IOException;

/**
 * TODO: Javadoc.
 */
public interface CredentialsVerifier {
    boolean validUserCredentials(String email, char[] password) throws IOException;
}
