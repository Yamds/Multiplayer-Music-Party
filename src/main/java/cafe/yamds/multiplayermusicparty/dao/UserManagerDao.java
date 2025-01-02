package cafe.yamds.multiplayermusicparty.dao;

import cafe.yamds.multiplayermusicparty.entity.User;

import java.sql.Timestamp;
import java.util.Map;

public interface UserManagerDao {
//    第一次使用该用户名时，调用创建方法，往数据库插入数据
    public boolean createUser(String username);
//    当数据库中有该用户，使用登录方法
    public User login(String username);
//    退出
    public boolean logout(String username);
//    查询用户是否存在
    public boolean findUser(String username);
//    查询用户最近更新时间    java.sql.Timestamp 的格式：
//    标准格式：yyyy-[m]m-[d]d hh:mm:ss[.fffffffff]
    public Timestamp getLastLogin(String username);

}
