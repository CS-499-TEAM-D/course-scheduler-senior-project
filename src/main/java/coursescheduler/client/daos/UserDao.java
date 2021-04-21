package coursescheduler.client.daos;

import coursescheduler.User;

/** Data access object for {@link User}. */
public interface UserDao {
  User addUser(User user);

  User getUserByEmail(String email);
}
