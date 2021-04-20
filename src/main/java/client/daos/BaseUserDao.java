package client.daos;

import coursescheduler.User;

/**
 * TODO: Javadoc.
 */
public final class BaseUserDao implements UserDao {
    @Override
    public boolean addUser(User user) {
        // TODO: Add functionality to write new user to database.
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        // TODO: Add functionality to get user by email.
        return null;
    }
}
