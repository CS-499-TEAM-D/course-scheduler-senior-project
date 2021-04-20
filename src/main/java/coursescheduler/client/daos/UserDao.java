package coursescheduler.client.daos;

import coursescheduler.User;

/**
 * Data access object for {@link User}.
 */
public interface UserDao {
    boolean addUser(User user);
    User getUserByEmail(String email);
}
