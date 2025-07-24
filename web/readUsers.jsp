<%@ page import="java.util.List" %>
<%@ page import="models.User" %>
<%@ page import="java.net.URLEncoder" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Utilisateurs</title>
</head>
<body>
    <h1>Liste des Utilisateurs</h1>

    <a href="createUser.jsp">Cr�er un nouvel utilisateur</a><br><br>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Pr�nom</th>
            <th>�ge</th>
            <th>Actions</th>
        </tr>
        <%
            List<User> users = (List<User>) request.getAttribute("users");
            for (User user : users) {
        %>
        <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getNom() %></td>
            <td><%= user.getPrenom() %></td>
            <td><%= user.getAge() %></td>
            <td>
                <a href="updateUser.jsp?id=<%= user.getId() %>&nom=<%= URLEncoder.encode(user.getNom(), "UTF-8") %>&prenom=<%= URLEncoder.encode(user.getPrenom(), "UTF-8") %>&age=<%= user.getAge() %>">Modifier</a> |
                <a href="deleteUser?id=<%= user.getId() %>">Supprimer</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>

    <br>
    <a href="index.jsp">Retour � l'accueil</a>
</body>
</html>
