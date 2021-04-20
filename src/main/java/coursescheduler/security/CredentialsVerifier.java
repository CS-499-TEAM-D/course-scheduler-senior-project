package coursescheduler.security;

/**
 * TODO: Javadoc.
 */
public interface CredentialsVerifier {
    boolean validUserCredentials(String email, char[] password);
}
