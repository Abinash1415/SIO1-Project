<?php
// Démarrage de la session
session_start();

// Vérification si l'utilisateur n'est pas connecté
if(!isset($_SESSION["loggedin"]) || $_SESSION["loggedin"] !== true){
    header("location: login.php");
    exit;
}
?>
