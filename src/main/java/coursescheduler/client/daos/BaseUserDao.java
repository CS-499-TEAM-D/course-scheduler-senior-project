package coursescheduler.client.daos;


import com.google.common.collect.ImmutableList;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import java.util.Optional;

import coursescheduler.client.MongoCollectionNames;
import coursescheduler.client.models.User;

/** Default operations for the {@link UserDao} for the CourseScheduler application. */
public final class BaseUserDao implements UserDao {
  private final MongoDatabase database;

  public BaseUserDao(MongoDatabase database) {
    this.database = database;
  }

  @Override
  public boolean addUser(User user) {
    // duplicate user
    if (getUserByEmail(user.getEmail()).isPresent()) {
      return false;
    }

    database.getCollection(MongoCollectionNames.USER, User.class).insertOne(user);
    return true;
  }

  @Override
  public Optional<User> getUserByEmail(String email) {
    FindIterable<User> usersCollection =
        database
            .getCollection(MongoCollectionNames.USER, User.class)
            .find(Filters.eq("email", email));
    User user = usersCollection.first();
    return user == null ? Optional.empty() : Optional.of(user);
  }

  @Override
  public ImmutableList<User> getUsers() {
    MongoCollection<User> usersCollection =
        database.getCollection(MongoCollectionNames.USER, User.class);
    return ImmutableList.copyOf(usersCollection.find());

  }
}
