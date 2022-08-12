package servlets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.HomeItem;
import models.User;
import services.Manager;

/**
 *
 * @author 835178
 */
public class InventoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        String username = (String) s.getAttribute("username");

        if (username != null) {
            Manager.path = getServletContext().getRealPath("/WEB-INF/homeitems.txt");
            String totalValueOfUser = Manager.getValue(username);
            request.setAttribute("message", totalValueOfUser);
            getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);

        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        String username = (String) s.getAttribute("username");
        String category = (String) request.getParameter("category");
        String itemName = (String) request.getParameter("itemName");
        String priceString = (String) request.getParameter("price");
        
        
        HomeItem i = new HomeItem(itemName, username, category, priceString);

        request.setAttribute("category", i.getCategory());
        request.setAttribute("itemName", i.getName());

        int price = 0;
        try {
            price = Integer.valueOf(i.getPrice());

            if (price < 0 || price > 10_000) {
                throw new Exception();
            }

            if (i.getName().equals("")) {
                throw new Exception();
            }

            request.setAttribute("price", price);

            String path = getServletContext().getRealPath("/WEB-INF/homeitems.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            pw.println(i.getOwner() + "," + i.getCategory() + "," + i.getName() + "," + i.getPrice());
            pw.close();

            request.setAttribute("errorMessage", "Added successfully");

        } catch (Exception e) {
            request.setAttribute("errorMessage", "Invalid entry");
        }

        Manager.path = getServletContext().getRealPath("/WEB-INF/homeitems.txt");
        String totalValueOfUser = Manager.getValue(username);
        request.setAttribute("message", totalValueOfUser);
        getServletContext().getRequestDispatcher("/WEB-INF/inventory.jsp").forward(request, response);
    }
}
