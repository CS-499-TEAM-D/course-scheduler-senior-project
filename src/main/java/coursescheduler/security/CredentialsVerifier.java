package coursescheduler.security;


import java.io.IOException;


/** Verifies credentials across the Course Scheduler application. */
public interface CredentialsVerifier {
    boolean validUserCredentials(String email, char[] password);

}
