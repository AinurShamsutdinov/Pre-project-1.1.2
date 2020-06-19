package servlet;

import User.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class AddUserServlet extends javax.servlet.http.HttpServlet  {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException  {
        request.setCharacterEncoding("UTF8");
        if (!UserService.isAddReqValid(request)){
            doGet(request,response);
        } else {
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            User user = new User(name, Long.parseLong(age));
            UserService.addUser(user);
            doGet(request, response);
        }
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        List<User> usersList = UserService.getAllUsers();
        if (usersList != null){
            request.setCharacterEncoding("UTF8");
            request.setAttribute("users", usersList);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
