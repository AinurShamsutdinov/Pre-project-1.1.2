package servlet;

import User.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/update")
public class UpdateUserServlet extends javax.servlet.http.HttpServlet{
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        request.setCharacterEncoding("UTF8");
        if (!UserService.isReqValid(request)){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            Long id = Long.parseLong(request.getParameter("id"));
            String name = request.getParameter("name");
            Long age = Long.parseLong(request.getParameter("age"));
            UserService.updateUser(new User(id, name, age));
            new AddUserServlet().doGet(request, response);
        }
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        if (!UserService.isIDValid(request)){
            new AddUserServlet().doGet(request, response);
        } else {
            User user = UserService.getUsers(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }
    }
}
