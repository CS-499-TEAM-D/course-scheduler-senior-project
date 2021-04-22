package coursescheduler;


import javax.swing.JComponent;
import javax.swing.JFrame;

import com.google.api.services.sheets.v4.Sheets;
import coursescheduler.client.daos.BaseUserDao;
import coursescheduler.client.daos.UserDao;
import coursescheduler.infrastructure.database.SheetsServiceUtil;
import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;
import coursescheduler.security.BaseCredentialsVerifier;
import coursescheduler.security.CredentialsVerifier;
import coursescheduler.views.pages.AbstractPageFactory;
import coursescheduler.views.pages.BaseAbstractPageFactory;
import coursescheduler.views.pages.BaseLoginPage;
import coursescheduler.views.pages.Page;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static coursescheduler.DatabaseSheetIDs.TEST;

/** Sets up and starts the CourseScheduler application. */
final class CourseScheduler implements CourseSchedulerApplication {
  private final PanelController controller;
  private final JComponent loginPage;
  private final Sheets service;
  private final String spreadsheetId;

  CourseScheduler(PanelController controller, Page loginPage, Sheets service, String spreadsheetId) {
    this.controller = controller;
    this.loginPage = loginPage.init();
    this.service = service;
    this.spreadsheetId = spreadsheetId;
  }

  @Override
  public void run() {
    controller.initializeStartPage(loginPage);
  }

  public static void main(String... args) throws IOException, GeneralSecurityException {

    Sheets service = SheetsServiceUtil.getSheetsService();


    JFrame mainFrame = new CourseSchedulerFrame();
    PanelController panelController = new BaseFrameManager(mainFrame);

    UserDao userDao = new BaseUserDao(service, TEST);
    CredentialsVerifier credentialsVerifier = new BaseCredentialsVerifier(userDao, service, TEST);

    AbstractPageFactory factory = new BaseAbstractPageFactory(panelController, credentialsVerifier, userDao);

    Page loginPage = new BaseLoginPage(panelController, credentialsVerifier, factory, userDao);

    CourseSchedulerApplication app = new CourseScheduler(panelController, loginPage, service, TEST);
    app.run();
  }
}
