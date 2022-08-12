package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.HomeItem;
import services.Manager;

/**
 *
 * @author 835178
 */
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession s = request.getSession();
        String username = (String) s.getAttribute("username");
        if (username != null){
            if (username.contentEquals("admin")){
                Manager.path = getServletContext().getRealPath("/WEB-INF/homeitems.txt");
                String totalValue = Manager.getTotal();
                HomeItem i = Manager.getMostExpensive();

                
                request.setAttribute("totalValue", totalValue);
                request.setAttribute("itemName", i.getName());
                request.setAttribute("price", i.getPrice());
                request.setAttribute("name", i.getOwner());
                
                getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}