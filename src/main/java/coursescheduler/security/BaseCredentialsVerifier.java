package coursescheduler.security;

/** {@inheritDoc} */
public class BaseCredentialsVerifier implements CredentialsVerifier {
  @Override
  public boolean validUserCredentials(String email, char[] password) {
    return true;
  }
}
