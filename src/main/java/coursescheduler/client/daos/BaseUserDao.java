package coursescheduler.client.daos;

import coursescheduler.User;

/** Default operations for the {@link UserDao} for the CourseScheduler application. */
public final class BaseUserDao implements UserDao {
  @Override
  public User addUser(User user) {
    // TODO: Add functionality to write new user to database throwing an exception on failure.
    return null;
  }

  @Override
  public User getUserByEmail(String email) {
    // TODO: Add functionality to get user by email.
    return null;
  }
}
