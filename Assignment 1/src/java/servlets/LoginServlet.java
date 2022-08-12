package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.Manager;

/**
 *
 * @author 835178
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String shouldLogout = request.getParameter("logout");
        HttpSession s =  request.getSession();
        
        if (shouldLogout != null) {
            s.invalidate();
            request.setAttribute("message", "Logged out.");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        
        request.setAttribute("username", username);
        request.setAttribute("password", password); 
        
        User u = new User(username, password);
        
        if (username == null || password == null || username == "" || password == "") {
            request.setAttribute("message", "Enter login details");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        } 
        
        Manager.path = getServletContext().getRealPath("/WEB-INF/users.txt");
        
        if (Manager.checkAuth(u)) {
            HttpSession s = request.getSession();
            s.setAttribute("username", u.getUsername());
            if (u.getUsername().contentEquals("admin")){
                response.sendRedirect("/admin");
            } else {
                response.sendRedirect("/inventory");
            }
            
        } else {
            request.setAttribute("message", "Invalid login");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
