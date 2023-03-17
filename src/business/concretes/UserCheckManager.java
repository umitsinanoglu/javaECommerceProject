package business.concretes;

import business.abstracts.UserCheckService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.List;
import java.util.regex.Pattern;

public class UserCheckManager implements UserCheckService {

    List<User> users;

    public UserCheckManager(UserDao userDao) {
        this.users = userDao.getAll();
    }

    @Override
    public boolean checkFirstName(String firstName) {
        if (firstName.isEmpty()) {
            System.out.println("Burası boş bırakılmaz bir isim giriniz.");
            return false;
        } else {
            if (firstName.length() <= 2) {
                System.out.println("İsim en az 2 karakterden oluşmalıdır");
                return false;
            }

        }
        return true;
    }

    @Override
    public boolean checkLastName(String lastName) {
        if (lastName.isEmpty()) {
            System.out.println("Burası boş bırakılmaz bir soyisim giriniz.");
            return false;
        } else {
            if (lastName.length() <= 2) {
                System.out.println("Soyisim en az 2 karakterden oluşmalıdır");
                return false;
            }

        }
        return true;
    }

    @Override
    public boolean isValidPassword(String password) {
        if (password.isEmpty()) {
            System.out.println("Burası boş bırakılmaz bir parolla giriniz.");
            return false;
        } else {
            if (password.length() < 6) {
                System.out.println("Parola en az 6 karakterden oluşturulmalıdır.");
                return false;

            }
        }
        return true;
    }

    @Override
    public boolean isValidMail(String emailAddress) {
        String regex = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        if (emailAddress.isEmpty()) {
            System.out.println("Burası boş bırakılmaz bir e-mail giriniz.");
            return false;

        } else {
            if (!pattern.matcher(emailAddress).find()) {
                System.out.println("Geçersiz!");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isUniqueMail(String emailAddress) {
        for (User u : users) {
            if (u.getEmailAddress().equals(emailAddress)) {
                System.out.println("Bu e-mail sistemde kayıtlıdır yeni bir mail adresi giriniz.");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValid(User user) {
        return checkFirstName(user.getFirstName()) && checkLastName(user.getLastName()) &&
                isUniqueMail(user.getEmailAddress()) && isValidPassword(user.getPassword()) && isValidMail(user.getEmailAddress());
    }

}
