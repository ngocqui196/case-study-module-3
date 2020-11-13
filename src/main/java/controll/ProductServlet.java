package controll;

import dao.CategoriDAOImpl;
import dao.ICategoriDAO;
import dao.IProductDAO;
import dao.ProductDAOImpl;
import model.Categori;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductsServlet",urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    IProductDAO productDAO = new ProductDAOImpl();
    ICategoriDAO categoriDAO =new CategoriDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String acction = request.getParameter("action");
        if (acction == null) acction = "";
        try {
            switch (acction) {
                case "create":
                    insertProduct(request,response);
                    break;
                case "edit":
                    updateProduct(request,response);
                    break;
                case "search":
                    searchProductByName(request,response);
                default:
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idCategori = Integer.parseInt(request.getParameter("idCategori"));
        String name = request.getParameter("name");
        int amount = Integer.parseInt(request.getParameter("amount"));
        String size = request.getParameter("size");
        double price = Double.parseDouble(request.getParameter("price"));
        Categori categori = categoriDAO.getCategoriByID(idCategori);
        productDAO.update(new Product(id,categori,name,amount,size,price));
        listProduct(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

            switch (action) {
                case "create":
                    showCreateProduct(request,response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
//                case "search":
//                    searchProductByName(request,response);
//                    break;
                case "categoriList":
                    showListCategori(request,response);
                default:
                    listProduct(request, response);
                    break;
            }


    }

    private void searchProductByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Product> productList = productDAO.searchProduct(request.getParameter("search"));
        request.setAttribute("products",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
        dispatcher.forward(request,response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            List<Product> productList = productDAO.listProduct();
            System.out.println(productList);
            request.setAttribute("listProduct", productList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
            dispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            productDAO.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        listProduct(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
            Product product = productDAO.getProductByID(id);
            request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/product/update.jsp");
        dispatcher.forward(request, response);
    }

    private void showListCategori(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Categori> categoriList = categoriDAO.listCategori();
        request.setAttribute("categori", categoriList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/categori/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/product/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        int idProduct = Integer.parseInt(request.getParameter("id_product"));
        String name = request.getParameter("name_product");
        int idCategori = Integer.parseInt(request.getParameter("id_categori"));
        Categori categori = categoriDAO.getCategoriByID(idCategori);
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(idProduct,categori,name,1,"M",price);
        productDAO.insertProduct(product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/product/create.jsp");
        dispatcher.forward(request, response);
    }
}
