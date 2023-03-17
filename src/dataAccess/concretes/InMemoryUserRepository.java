package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserDao {
    List<User> users;

    public InMemoryUserRepository() {
        this.users = new ArrayList<>();
        users.add(new User(1, "Ümit", "Sinan", "usinan@dummy.com", "1234567890"));
        users.add(new User(2, "Eren", "Tunç", "eren@dummy.com", "123456778"));
    }

    @Override
    public void add(User user) {
        users.add(user);

    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getByEmailAddress(String emailAddress) {
        for (User user : users) {
            if (user.getEmailAddress().equals(emailAddress)) {
                return user;
            }
        }
        return null;
    }
}
