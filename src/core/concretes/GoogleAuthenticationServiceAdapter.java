package core.concretes;

import core.abstracts.ExternalAuthenticationService;
import entities.concretes.User;
import googleService.GoogleAuthentication;

public class GoogleAuthenticationServiceAdapter implements ExternalAuthenticationService {

    @Override
    public boolean authenticate(User user) {
        GoogleAuthentication googleAuthentication = new GoogleAuthentication();
        return googleAuthentication.authenticateWithGoogle(user);
    }
}
