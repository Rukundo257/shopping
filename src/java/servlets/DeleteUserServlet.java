package servlets;

import config.DatabaseConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection con = new DatabaseConfig().getConnection()) {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException("Erreur lors de la suppression de l'utilisateur", e);
        }  catch (ClassNotFoundException ex) {
            System.getLogger(DeleteUserServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        response.sendRedirect("readUsers");
    }
}
