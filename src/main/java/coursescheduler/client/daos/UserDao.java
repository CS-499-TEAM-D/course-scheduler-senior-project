package coursescheduler.client.daos;

import com.google.common.collect.ImmutableList;

import java.util.Optional;

import coursescheduler.client.models.User;

/** Data access object for a {@link User} object. */
public interface UserDao {

  /**
   * Adds user to database.
   *
   * @param user to be added to database.
   * @return boolean represented successful and unsuccessful adds respectively.
   */
  boolean addUser(User user);

  /**
   * Returns optional of user matching the email address.
   *
   * @param email of the user to be retrieved from the database.
   * @return Optional of User object to be unpacked.
   */
  Optional<User> getUserByEmail(String email);

  /**
   * Gets an ImmutableList of Users.
   *
   * @return ImmutableList of users.
   */
  ImmutableList<User> getUsers();
}
