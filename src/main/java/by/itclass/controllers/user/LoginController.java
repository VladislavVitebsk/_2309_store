package by.itclass.controllers.user;

import by.itclass.controllers.AbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static by.itclass.constants.AppConst.*;

@WebServlet(LOGIN_CONTROLLER)
public class LoginController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter(LOGIN_PARAM);
        var password = req.getParameter(PASS_PARAM);
        var user = userService.getUser(login, password);
        if (user != null) {
            req.getSession().setAttribute(USER_ATTR, user);
            forward(req, resp, HOME_JSP);
        } else {
            forward(req, resp, LOGIN_JSP, "User not found");
        }
    }
}
