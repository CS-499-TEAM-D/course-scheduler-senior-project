package coursescheduler;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import javax.swing.JComponent;
import javax.swing.JFrame;

import coursescheduler.client.MongoDbClient;
import coursescheduler.client.daos.BaseUserDao;
import coursescheduler.client.daos.UserDao;
import coursescheduler.managers.BaseFrameManager;
import coursescheduler.managers.PanelController;
import coursescheduler.security.BaseCredentialsVerifier;
import coursescheduler.security.CredentialsVerifier;
import coursescheduler.views.pages.AbstractPageFactory;
import coursescheduler.views.pages.BaseAbstractPageFactory;
import coursescheduler.views.pages.BaseLoginPage;
import coursescheduler.views.pages.Page;

/** Sets up and starts the CourseScheduler application. */
final class CourseScheduler implements CourseSchedulerApplication {
  private final PanelController controller;
  private final JComponent loginPage;

  CourseScheduler(PanelController controller, Page loginPage) {
    this.controller = controller;
    this.loginPage = loginPage.init();
  }

  public static void main(String... args) {

    MongoClient mongoClient = MongoDbClient.getInstance();

    MongoDatabase database = mongoClient.getDatabase("prod");

    UserDao userDao = new BaseUserDao(database);

    JFrame mainFrame = new CourseSchedulerFrame();
    PanelController panelController = new BaseFrameManager(mainFrame);

    CredentialsVerifier credentialsVerifier = new BaseCredentialsVerifier();

    AbstractPageFactory factory =
        new BaseAbstractPageFactory(panelController, credentialsVerifier, userDao);

    Page loginPage = new BaseLoginPage(panelController, credentialsVerifier, factory, userDao);

    CourseSchedulerApplication app = new CourseScheduler(panelController, loginPage);
    app.run();

  }

  @Override
  public void run() {


    controller.init(loginPage); // start course scheduler application with loginPage


  }
}
