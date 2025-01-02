package cafe.yamds.multiplayermusicparty.dao.Impl;

// 实现类

import cafe.yamds.multiplayermusicparty.dao.UserManagerDao;
import cafe.yamds.multiplayermusicparty.entity.User;
import cafe.yamds.multiplayermusicparty.utils.Jdbc;

import java.sql.Timestamp;
import java.util.Map;

public class UserManagerDaoImpl implements UserManagerDao {
    @Override
    // 创建用户
    public boolean createUser(String username) {
        System.out.println("dao-createUser");
        String sql = "insert into user(username,create_time,update_time,status) values(?,?,?,?)";
        return Jdbc.insert(sql, username, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0);
    }
    // 登录
    @Override
    public User login(String username) {
        System.out.println("dao-login");
        User user = new User();
        String sql = "select * from user where username=?";
        Map<String, Object> userQuery = Jdbc.queryOne(sql, username);
        if (userQuery != null && userQuery.isEmpty()) {
            user.setId(Integer.parseInt(userQuery.get("id").toString()));   // 获取id
            user.setUsername(userQuery.get("username").toString()); // 获取用户名
            user.setCreateTime(Timestamp.valueOf(userQuery.get("create_time").toString())); // 拿到创建时间
            user.setUpdateTime(new Timestamp(System.currentTimeMillis()));  // 更新时间
            user.setStatus(1);  // 设置状态

            return user;
        }
        return null;
    }

    @Override
    public boolean logout(String username) {
        return false;
    }

    @Override
    public boolean findUser(String username) {
        System.out.println("dao-findUser");
        String sql = "select * from user where username=?";
        Map<String, Object> user = Jdbc.queryOne(sql, username);
        if (user != null && user.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public Timestamp getLastLogin(String username) {
        return null;
    }
}
