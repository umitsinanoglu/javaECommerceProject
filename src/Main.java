import business.abstracts.UserService;
import business.concretes.UserCheckManager;
import business.concretes.UserManager;
import core.concretes.GoogleAuthenticationServiceAdapter;
import dataAccess.concretes.InMemoryUserRepository;
import entities.concretes.User;

public class Main {

    public static void main(String[] args) {

        UserService userManager = new UserManager(
                new InMemoryUserRepository(),
                new UserCheckManager(new InMemoryUserRepository()),
                new GoogleAuthenticationServiceAdapter()
        );

        InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
        User user1 = inMemoryUserRepository.getByEmailAddress("usinan@dummy.com");

        userManager.login("udummy", "1234567890");
        userManager.register( "Mine", "Sinan", "dummy@g.com", "1234567890");
        userManager.loginWithGoogleService(user1);

    }

}
