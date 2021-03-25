package coursescheduler;

import coursescheduler.infrastructure.database.DatabaseClient;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Entry-point for Course Scheduler desktop application.
 */
final class CourseScheduler {

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        DatabaseClient DB = new DatabaseClient();
    }

}
