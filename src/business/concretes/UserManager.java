package business.concretes;

import business.abstracts.UserCheckService;
import business.abstracts.UserService;
import core.abstracts.ExternalAuthenticationService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {

    private final ExternalAuthenticationService googleService;
    private UserDao userDao;
    private UserCheckService userCheckService;

    public UserManager(UserDao userDao,
                       UserCheckService userCheckService,
                       ExternalAuthenticationService googleService) {
        this.userDao = userDao;
        this.googleService = googleService;
        this.userCheckService = userCheckService;
    }


    @Override
    public void login(String emailAddress, String password) {
        User user = userDao.getByEmailAddress(emailAddress);
        if (user.getEmailAddress().equals(emailAddress) && user.getPassword().equals(password)) {
            System.out.println("giriş başarılı");
        } else {
            System.out.println("şifre veya kullanıcı adı yanlış");
        }
    }

    @Override
    public void register(String firstName, String lastName, String emailAddress, String password) {

        if (userCheckService.checkFirstName(firstName) &&
                userCheckService.checkLastName(lastName) &&
                userCheckService.isValidMail(emailAddress) &&
                userCheckService.isUniqueMail(emailAddress) &&
                userCheckService.isValidPassword(password)
        ) {
            System.out.println(firstName + lastName + "kullanıcı ismi ile sisteme kayıt oldunuz...Eposta adresinize doğrulama linki gönderildi.");
        } else {
            System.out.println(" Giriş başarısız e-posta ve ya Parola hatalı e-posta ve parolanızı kontrol edip tekrar deneyiniz.");
        }


    }

    @Override
    public boolean loginWithGoogleService(User user) {
        return googleService.authenticate(user);
    }
}
