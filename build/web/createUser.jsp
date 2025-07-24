<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Créer un Utilisateur</title>
</head>
<body>
    <h1>Créer un Nouvel Utilisateur</h1>
    <form action="createUser" method="post">
        <label>Nom:</label><br>
        <input type="text" name="nom" required><br><br>

        <label>Prénom:</label><br>
        <input type="text" name="prenom" required><br><br>

        <label>Âge:</label><br>
        <input type="number" name="age" required><br><br>

        <button type="submit">Créer</button>
    </form>
    <br>
    <a href="index.jsp">Retour à l'accueil</a>
</body>
</html>
