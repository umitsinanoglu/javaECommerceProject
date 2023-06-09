package dataAccess.abstracts;

import entities.concretes.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> getAll();

    User getById(int id);

    User getByEmailAddress(String userName);

}
