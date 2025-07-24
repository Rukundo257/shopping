package servlets;

import config.DatabaseConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/createUser")
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        int age = Integer.parseInt(request.getParameter("age"));

        try (Connection con = new DatabaseConfig().getConnection()) {
            String sql = "INSERT INTO users (nom, prenom, age) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setInt(3, age);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException("Erreur lors de la création de l'utilisateur", e);
        }
        catch (ClassNotFoundException ex) {
    ex.printStackTrace(); // Affiche l'erreur dans le terminal NetBeans
    throw new ServletException("Driver JDBC introuvable", ex);
}
       System.out.println("Insertion réussie : " + nom + " " + prenom + " " + age);

        response.sendRedirect("readUsers");
    }
}
