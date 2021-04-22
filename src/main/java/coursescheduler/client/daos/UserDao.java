package coursescheduler.client.daos;

import coursescheduler.User;

/** Data access object for a {@link User} object. */
public interface UserDao {
  User addUser(User user);

  User getUserByEmail(String email);
}
