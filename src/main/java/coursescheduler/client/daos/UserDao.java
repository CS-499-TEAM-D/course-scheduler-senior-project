package coursescheduler.client.daos;

import com.google.common.collect.ImmutableList;

import java.util.Optional;

import coursescheduler.client.models.User;

/** Data access object for a {@link User} object. */
public interface UserDao {

  boolean addUser(User user);

  Optional<User> getUserByEmail(String email);

  ImmutableList<User> getUsers();
}
