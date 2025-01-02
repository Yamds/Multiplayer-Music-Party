package cafe.yamds.multiplayermusicparty.controller;

import cafe.yamds.multiplayermusicparty.dto.Result;
import cafe.yamds.multiplayermusicparty.entity.User;
import cafe.yamds.multiplayermusicparty.service.UserManagerService;
import cafe.yamds.multiplayermusicparty.service.Impl.UserManagerServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import java.io.IOException;

@WebServlet("/user-manager")
public class UserManagerServlet extends HttpServlet {
    // 创建一个service层对象
    UserManagerService userManagerService = new UserManagerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        //设置请求与响应编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        // 获取前端请求数据
        // System.out.println(req);
        String method = req.getParameter("method");
        System.out.println(method);
        if("login".equals(method)) {
            login(req, resp);
        }

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost - login");
        // 获取登录所需的参数 - 用户名
        String username = req.getParameter("username");
        // 调用service层的登录方法
        Result userResult = userManagerService.loginUser(username);
        String json_str = JSONObject.fromObject(userResult).toString();
        //将JSON字符串响应给前端
        resp.getWriter().write(json_str);
    }
}
