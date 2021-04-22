package coursescheduler.security;

/** Verifies credentials across the Course Scheduler application. */
public interface CredentialsVerifier {
    boolean validUserCredentials(String email, char[] password);

}
