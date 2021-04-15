package coursescheduler.views.pages;

import java.io.IOException;
import java.security.GeneralSecurityException;

/** Interfacing functionality for role pages. */
public interface IRolePage {
  /**
   * Allows the page to initialize itself.
   *
   * <p>This is where an object that extends a Swing component can initialize itself.
   *
   * <p>Similar to Swing's initComponents method.
   */
  void init() throws IOException, GeneralSecurityException;
}
