package controll;

import dao.CategoriDAOImpl;
import dao.ICategoriDAO;
import model.Categori;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoriServlet", urlPatterns = "/categori")
public class CategoriServlet extends HttpServlet {

    ICategoriDAO categoriDAO =new CategoriDAOImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "create":
                insertCategori(request,response);
                break;
            case "edit":
                updateCategori(request,response);
                break;
            default:
                break;
        }

    }

    private void deleteCategori(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        categoriDAO.delete(id);
        showListCategori(request,response);
    }

    private void updateCategori(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        Categori categori = new Categori(id,name);
        categoriDAO.update(categori);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/categori/update.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCategori(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Categori newCategori = new Categori(id,name);
        categoriDAO.save(newCategori);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/categori/create.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) { action = ""; }
        try {
            switch (action) {
                case "create" :
                    showFormCreateCategori(request,response);
                    break;
                case "edit" :
                    showformEditCategori(request,response);
                    break;
                case "delete":
                    deleteCategori(request,response);
                    break;
                default:
                    showListCategori(request,response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void showListCategori(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categori> categoriList = categoriDAO.listCategori();
        request.setAttribute("categori", categoriList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/categori/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showformEditCategori(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/categori/update.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormCreateCategori(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/categori/create.jsp");
        dispatcher.forward(request, response);
    }
}
