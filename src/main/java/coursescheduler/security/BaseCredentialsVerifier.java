package coursescheduler.security;

/** {@inheritDoc} */

public final class BaseCredentialsVerifier implements CredentialsVerifier {

  @Override
  public boolean validUserCredentials(String email, char[] password) {
    return true;
  }
}
