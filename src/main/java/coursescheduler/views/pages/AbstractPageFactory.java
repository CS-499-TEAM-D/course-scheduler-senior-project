package coursescheduler.views.pages;

import javax.swing.JComponent;


import coursescheduler.client.models.User;



/** Builds and retrieves pages for the Course Scheduler application. */
public interface AbstractPageFactory {
  JComponent buildLoginPage();

  JComponent buildAccountCreationPage();

  JComponent buildUserPage(User user);
}
