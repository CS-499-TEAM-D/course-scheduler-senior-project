package coursescheduler;

/**
 * TODO: Javadoc.
 */
public class User {
    private final String email;
    private final char[] password;
    private final String role;
    private final String department;

    public User(String email, char[] password, String role, String department) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
    }
}
