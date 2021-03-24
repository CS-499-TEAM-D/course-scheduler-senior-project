package mongodb.client.daos;

import static dev.morphia.query.experimental.filters.Filters.eq;
import static mongodb.client.DatabaseNames.USERS_DB;

import com.google.common.collect.ImmutableList;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.updates.UpdateOperators;
import mongodb.client.UserDao;
import mongodb.client.models.User;

/** User object to access data from MongoDB database. */
public class MongoDbUserDao extends MongoDao implements UserDao {

  // protected static final Morphia morphia = new Morphia();// responsible for mapping our Java
  // POJOs to MongoDB Collections.
   protected static final Datastore datastore =
        Morphia.createDatastore(MongoDao.mongoClient, USERS_DB);


  public MongoDbUserDao() {
    super();
  }

  /**
   * @param field
   * @param value
   * @param <T>
   * @return
   */
  private <T> ImmutableList<User> findBy(String field, T value) {
    return ImmutableList.copyOf(datastore.find(User.class).filter(eq(field, value)).iterator());
  }

  @Override
  public ImmutableList<User> findAll() {
    return ImmutableList.copyOf(datastore.find(User.class).filter().iterator());
  }

  @Override
  public User findById(String id) {
    return findBy("id", id).get(0);
  }

  @Override
  public User findByEmail(String email) {
    return findBy("email", email).get(0);
  }

  @Override
  public boolean insertUser(User user) {
    datastore.save(user);
    return true;
  }

  @Override
  public boolean updateUser(User user) {
    Query<User> toUpdate = datastore.find(User.class).filter(eq("_id", user.getId()));
    toUpdate.update(UpdateOperators.set("email", "new email")).execute();
    toUpdate.update(UpdateOperators.set("department", "new department")).execute();
    toUpdate.update(UpdateOperators.set("role", "new role")).execute();
    return true;
  }

  @Override
  public boolean deleteUser(User user) {
    datastore.delete(user);
    return true;
  }
}
