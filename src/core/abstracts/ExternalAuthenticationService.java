package core.abstracts;

import entities.concretes.User;

public interface ExternalAuthenticationService {
    boolean authenticate(User user);
}
