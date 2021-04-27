package coursescheduler;

/** User model for the Course Scheduler application. */
public class User {
  private final String email;
  private final String role;
  private final String department;

  public User(String email, String role, String department) {
    this.email = email;
    this.role = role;
    this.department = department;
  }

  public String getRole() {
    return role;
  }

  public String getDepartment() { return department; }
}