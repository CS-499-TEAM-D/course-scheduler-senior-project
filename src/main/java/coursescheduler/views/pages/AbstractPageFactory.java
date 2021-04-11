package coursescheduler.views.pages;

import javax.swing.JComponent;

import coursescheduler.User;

/**
 *  TODO: Javadoc.
 */
public interface AbstractPageFactory {
    JComponent buildLoginPage();
    JComponent buildAccountCreationPage();
    JComponent buildUserPage(User user);
}
