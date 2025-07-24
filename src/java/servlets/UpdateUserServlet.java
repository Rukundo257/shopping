package servlets;

import config.DatabaseConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        int age = Integer.parseInt(request.getParameter("age"));

        try (Connection con = new DatabaseConfig().getConnection()) {
            String sql = "UPDATE users SET nom = ?, prenom = ?, age = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setInt(3, age);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException("Erreur lors de la mise à jour de l'utilisateur", e);
        }catch (ClassNotFoundException ex) {
            System.getLogger(UpdateUserServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        response.sendRedirect("readUsers");
    }
}
