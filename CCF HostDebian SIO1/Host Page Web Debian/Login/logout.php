<?php
// Démarrage de la session
session_start();

// Destruction des variables de session
$_SESSION = array();

// Destruction de la session
session_destroy();

// Redirection vers la page de connexion
header("location: login.php");
exit;
?>
