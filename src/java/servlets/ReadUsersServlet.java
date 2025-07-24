package servlets;

import config.DatabaseConfig;
import models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/readUsers")
public class ReadUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> users = new ArrayList<>();

        try (Connection con = new DatabaseConfig().getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                int age = rs.getInt("age");

                users.add(new User(id, nom, prenom, age));
            }
        } catch (SQLException e) {
            throw new ServletException("Erreur lors de la lecture des utilisateurs", e);
        }catch (ClassNotFoundException ex) {
            System.getLogger(ReadUsersServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("readUsers.jsp");
        dispatcher.forward(request, response);
    }
}
