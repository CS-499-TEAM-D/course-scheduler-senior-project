package mongodb.client;

import com.google.common.collect.ImmutableList;
import mongodb.client.models.User;

/**
 * Its in all referred as DAO Pattern, It consist of following:
 *
 * <p>Data Access Object Interface - This interface defines the standard operations to be performed
 * on a model object(s). Data Access Object concrete class -This class implements above interface.
 * This class is responsible to get data from a datasource which can be database / xml or any other
 * storage mechanism. Model Object or Value Object - This object is simple POJO containing get/set
 * methods to store data retrieved using DAO class.
 */

/** */
public interface UserDao {
  /** @return */
  ImmutableList<User> findAll();

  /** @return */
  User findById(String id);

  /** @return */
  User findByEmail(String email);

  /** @return */
  boolean insertUser(User user);

  /** @return */
  boolean updateUser(User user);

  /** @return */
  boolean deleteUser(User user);
}
