<?php
// Démarrage de la session
session_start();

// Inclusion du fichier de connexion à la base de données
include 'db_connection.php';

// Récupération des informations de connexion envoyées par le formulaire
$username = $_POST['username'];
$password = $_POST['password'];

// Vérification des informations de connexion dans la base de données
$sql = "SELECT * FROM users WHERE username = '$username' AND password = '$password'";
$result = mysqli_query($conn, $sql);

// Si les informations de connexion sont correctes, définir les paramètres de session et rediriger l'utilisateur
if (mysqli_num_rows($result) == 1) {
    $_SESSION['username'] = $username;
    $_SESSION['loggedin'] = true;
    header("Location: page_suivante.php");
}
