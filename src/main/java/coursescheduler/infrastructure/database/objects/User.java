package coursescheduler.infrastructure.database.objects;

import java.util.List;

public class User {
    private final String name;
    private final String pass;
    private final String role;

    public User(Object name, Object pass, Object role) {
        this.name = name.toString();
        this.pass = pass.toString();
        this.role = role.toString();
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getRole() {
        return role;
    }
}
