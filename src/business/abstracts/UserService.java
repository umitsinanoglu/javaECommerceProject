package business.abstracts;

import entities.concretes.User;

public interface UserService {

    void login(String emailAddress, String password);

    void register(String firstName, String lastName, String emailAddress, String password);

    boolean loginWithGoogleService(User user);

}
