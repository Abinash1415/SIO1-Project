<?php

const UTILISATEUR="root";
const MOTDEPASSE="";
const SERVEUR="localhost";
const BASEDEDONNEES="Obi";
function getConnection(){
    $utilisateur = UTILISATEUR;
    $motDePasse = MOTDEPASSE;
    $server = SERVEUR;
    $db = BASEDEDONNEES;
    $accesBDD="mysql:host=$server;dbname=$db;port=3306" ;
    try {
        $connection = new PDO($accesBDD,$utilisateur,$motDePasse);
        $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    } catch (PDOException $e) {
        echo 'Échec lors de la connexion : ' . $e->getMessage();
    }
    return $connection;
}
function queryList($sql){
    $connection = getConnection();
    $instructions = $connection->prepare($sql);
    $instructions->execute();
    return $instructions;
}

require ('./ConnectionMySQL.php');
$sql = "select nom, prenom from ELEVES";
$connection = getConnection();
$instructions = $connection->prepare($sql);
$instructions->execute();
$resultat = $instructions->fetchAll();
echo "<p>Liste des élèves de la classe de madame Maitresse<p>";
foreach ($resultat as $value) {
    echo "$value <br>";
}

// Informations de connexion à la base de données
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "Obi";

// Connexion à la base de données
$conn = mysqli_connect($servername, $username, $password, $dbname);

// Vérification de la connexion
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
?>