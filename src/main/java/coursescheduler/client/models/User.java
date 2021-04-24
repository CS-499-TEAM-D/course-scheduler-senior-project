package coursescheduler.client.models;

import org.bson.types.ObjectId;

import java.text.MessageFormat;

/** User model for the Course Scheduler application. */
public final class User {
  private ObjectId id;
  private String email;
  private String role;
  private String department;

  /** For the MongoDB Codec configuration. */
  public User() {}

  public User(ObjectId id, String email, String role, String department) {
    this.id = id;
    this.email = email;
    this.role = role;
    this.department = department;
  }

  public ObjectId getId() {
    return id;
  }

  public User setId(ObjectId id) {
    this.id = id;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getRole() {
    return role;
  }

  public User setRole(String role) {
    this.role = role;
    return this;
  }

  public String getDepartment() {
    return department;
  }

  public User setDepartment(String department) {
    this.department = department;
    return this;
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append(System.getProperty("line.separator"))
        .append(MessageFormat.format("email: {0}", email))
        .append(System.getProperty("line.separator"))
        .append(MessageFormat.format("role: {0}", role))
        .append(System.getProperty("line.separator"))
        .append(MessageFormat.format("department: {0}", department))
        .toString();
  }
}
