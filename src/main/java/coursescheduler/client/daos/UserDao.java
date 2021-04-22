package coursescheduler.client.daos;

import coursescheduler.User;
import coursescheduler.infrastructure.database.DatabaseClient;

import java.io.IOException;

/**
 * Data access object for {@link User}.
 */
public interface UserDao {
    boolean addUser(User user, char[] password);
    User getUserByEmail(String email);
    int findUserIndex(String email);
}
