package coursescheduler;

/**
 * TODO: Javadoc.
 */
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

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }
}
