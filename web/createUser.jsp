<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cr�er un Utilisateur</title>
</head>
<body>
    <h1>Cr�er un Nouvel Utilisateur</h1>
    <form action="createUser" method="post">
        <label>Nom:</label><br>
        <input type="text" name="nom" required><br><br>

        <label>Pr�nom:</label><br>
        <input type="text" name="prenom" required><br><br>

        <label>�ge:</label><br>
        <input type="number" name="age" required><br><br>

        <button type="submit">Cr�er</button>
    </form>
    <br>
    <a href="index.jsp">Retour � l'accueil</a>
</body>
</html>
