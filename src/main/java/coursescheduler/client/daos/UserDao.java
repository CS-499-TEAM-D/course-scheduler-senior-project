package coursescheduler.client.daos;

import coursescheduler.User;
import coursescheduler.infrastructure.database.DatabaseClient;

import java.io.IOException;

/**
 * Data access object for {@link User}.
 */
public interface UserDao {
    boolean addUser(User user, char[] password) throws IOException;
    User getUserByEmail(String email) throws IOException;
    DatabaseClient getDatabaseClient();
}
