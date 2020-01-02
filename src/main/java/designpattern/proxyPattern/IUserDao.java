package designpattern.proxyPattern;

public interface IUserDao {
    /**
     *
     * @param userName
     * @param password
     */
    void addUser(String userName,String password);

    String getUserInfo(String userName,String password);
}
