package cafe.yamds.multiplayermusicparty.service.Impl;

import cafe.yamds.multiplayermusicparty.dao.Impl.UserManagerDaoImpl;
import cafe.yamds.multiplayermusicparty.dao.UserManagerDao;
import cafe.yamds.multiplayermusicparty.dto.Result;
import cafe.yamds.multiplayermusicparty.entity.User;
import cafe.yamds.multiplayermusicparty.service.UserManagerService;

public class UserManagerServiceImpl implements UserManagerService {
    // 创建数据持久层对象
    UserManagerDao userManagerDao = new UserManagerDaoImpl();
    @Override
    public Result loginUser(String username) {
        System.out.println("loginUser");
        if(userManagerDao.findUser(username)) {
            // 有重复用户名 - 登录
            User user = userManagerDao.login(username);
            if(user != null) {
                return new Result(200, "用户登录成功", user);
            }else {
                return new Result(100, "登录失败！没有用户数据", null);
            }

        }else {
            // 无重复用户名 - 注册
            if(userManagerDao.createUser(username)) {
                User user = userManagerDao.login(username);
                if(user != null) {
                    return new Result(200, "用户登录成功", user);
                }else {
                    return new Result(100, "注册成功 登录失败，没有找到注册的用户数据", null);
                }
            }else {
                return new Result(100, "注册失败！", null);
            }
        }
    }

}
