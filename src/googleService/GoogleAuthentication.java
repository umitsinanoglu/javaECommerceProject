package googleService;

import entities.concretes.User;

public class GoogleAuthentication {

    public boolean authenticateWithGoogle(User user) {
        System.out.println(user.getEmailAddress() + " kullanıcısı google ile yetkilendirildi..");
        return true;
    }

}
