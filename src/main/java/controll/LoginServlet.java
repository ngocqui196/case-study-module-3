package controll;

import dao.IProductDAO;
import dao.LoginDAOImpl;
import dao.ProductDAOImpl;
import model.Login;
import model.Product;

//import javax.servlet.RequestDispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//import java.sql.SQLException;

@javax.servlet.annotation.WebServlet(name = "ProductServlet", urlPatterns = "/linkkool")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    private Login login;
    IProductDAO productDAO = new ProductDAOImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try {
            String account = request.getParameter("account");
            String password = request.getParameter("password");
            LoginDAOImpl loginDAO = new LoginDAOImpl();
            login = loginDAO.checkLogin(account, password);

            if (login == null) {
                response.sendRedirect("index.jsp");
            } else if (login.getAccount().equals("admin")) {

//               response.sendRedirect("menu.jsp");
                listProduct(request, response);
            } else {
                response.sendRedirect("home.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> productList = productDAO.listProduct();
        System.out.println(productList);
        request.setAttribute("listProduct", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
        dispatcher.forward(request, response);
    }

}
