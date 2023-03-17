package business.abstracts;

import entities.concretes.User;

public interface UserCheckService {

    boolean checkFirstName(String firstName);

    boolean checkLastName(String lastName);

    boolean isValidPassword(String password);

    boolean isValidMail(String emailAddress);

    boolean isUniqueMail(String emailAddress);

    boolean isValid(User user);
}
