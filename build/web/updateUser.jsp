<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Utilisateur</title>
</head>
<body>
    <h1>Modifier l'Utilisateur</h1>

    <%
        String id = request.getParameter("id");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String age = request.getParameter("age");
    %>

    <form action="updateUser" method="post">
        <input type="hidden" name="id" value="<%= id %>">

        <label>Nom:</label><br>
        <input type="text" name="nom" value="<%= nom %>" required><br><br>

        <label>Prénom:</label><br>
        <input type="text" name="prenom" value="<%= prenom %>" required><br><br>

        <label>Âge:</label><br>
        <input type="number" name="age" value="<%= age %>" required><br><br>

        <button type="submit">Mettre à jour</button>
    </form>
    <br>
    <a href="readUsers">Retour à la liste des utilisateurs</a>
</body>
</html>
