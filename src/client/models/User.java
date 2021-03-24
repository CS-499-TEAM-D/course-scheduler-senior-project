package mongodb.client.models;

import static mongodb.client.DatabaseNames.USER_COLLECTION;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

// Application package.
// Server package.
// > models
// Security package.

/** User object to be used with Builder. */
@Entity(USER_COLLECTION)
public class User {
  @Id private ObjectId _id;
  private String email;
  private String password;
  private String role; // role_id (key Value)
  private String department; // department_id (key Value)

  /** Explicit default constructor for Morphia. */
  public User() {}

  public User(
      ObjectId _id,
      String email,
      String password,
      String role, // role_id (key Value)
      String department // department_id (key Value)
      ) {
    this._id = _id;
    this.email = email;
    this.password = password;
    this.role = role;
    this.department = department;
  }

  public User setId(ObjectId id) {
    this._id = id;
    return this;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public User setRole(String role) {
    this.role = role;
    return this;
  }

  public User setDepartment(String department) {
    this.department = department;
    return this;
  }

  public ObjectId getId() {
    return _id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getRole() {
    return role;
  }

  public String getDepartment() {
    return department;
  }

  @Override
  public String toString() {
    return "\n_id: %s\nemail: %s\nrole: %s\ndepartment: %s\n"
        .formatted(_id, email, role, department);
  }
}
