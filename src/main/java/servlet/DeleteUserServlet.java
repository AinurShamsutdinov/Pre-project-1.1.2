package servlet;

import User.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteUserServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        request.setCharacterEncoding("UTF8");
        if (!UserService.isIDValid(request)){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            long id = Long.parseLong(request.getParameter("id"));
            UserService.deleteUser(id);
            new AddUserServlet().doGet(request, response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
