package designpattern.proxyPattern;

public class UserDao implements IUserDao {
    @Override
    public void addUser(String userName, String password) {
        System.out.println("user :" + userName + " | " + password);
    }

    @Override
    public String getUserInfo(String userName, String password) {
        return "user :" + userName + " | " + password;
    }
}
