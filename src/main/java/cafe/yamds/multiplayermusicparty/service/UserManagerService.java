package cafe.yamds.multiplayermusicparty.service;

import cafe.yamds.multiplayermusicparty.dto.Result;
import cafe.yamds.multiplayermusicparty.entity.User;

public interface UserManagerService {
    // 登录用户
    public Result loginUser(String username);
}
