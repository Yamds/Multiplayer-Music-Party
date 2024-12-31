package cafe.yamds.multiplayermusicparty.dao.Impl;

// 实现类

import cafe.yamds.multiplayermusicparty.dao.UserManager;
import cafe.yamds.multiplayermusicparty.utils.Jdbc;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class UserManagerImpl implements UserManager {
    @Override
    public boolean createUser(String username) {
        return false;
    }

    @Override
    public boolean login(String username) {
        String sql = "select * from user where username=?";
        Map<String, Object> user = Jdbc.queryOne(sql, username);
        if(user.isEmpty()) {
            return false;
        }
        return false;
    }

    @Override
    public boolean logout(String username) {
        return false;
    }

    @Override
    public boolean findUser(String username) {
        return false;
    }

    @Override
    public Timestamp getLastLogin(String username) {
        return null;
    }
}
