package designPatternDemo.proxyPattern.staticProxyPattern;

import designPatternDemo.proxyPattern.IUserDao;

public class UserDaoProxy implements IUserDao {
    private IUserDao sUserDao;

    public UserDaoProxy(IUserDao iUserDao) {
        this.sUserDao = iUserDao;
    }

    @Override
    public void addUser(String userName, String password) {
        System.out.println("开始事务...");
        sUserDao.addUser(userName, password);
        System.out.println("提交事务...");
    }

    @Override
    public String getUserInfo(String userName, String password) {
        System.out.println("static proxy start :");
        return sUserDao.getUserInfo(userName, password);
    }
}
