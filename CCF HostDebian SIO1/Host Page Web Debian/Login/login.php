<?php
// Démarrage de la session
session_start();

// Vérification si l'utilisateur est déjà connecté
if(isset($_SESSION["loggedin"]) && $_SESSION["loggedin"] === true){
    header("location: welcome.php");
    exit;
}

// Inclusion du fichier de connexion à la base de données
require_once "db_connection.php";

// Définition des variables et initialisation avec des valeurs vides
$username = $password = "";
$username_err = $password_err = "";

// Traitement des données du formulaire lors de la soumission
if($_SERVER["REQUEST_METHOD"] == "POST"){

    // Vérification si le nom d'utilisateur est vide
    if(empty(trim($_POST["username"]))){
        $username_err = "Veuillez entrer votre nom d'utilisateur.";
    } else{
        $username = trim($_POST["username"]);
    }

    // Vérification si le mot de passe est vide
    if(empty(trim($_POST["password"]))){
        $password_err = "Veuillez entrer votre mot de passe.";
    } else{
        $password = trim($_POST["password"]);
    }

    // Validation des informations d'identification
    if(empty($username_err) && empty($password_err)){
        // Préparation de la requête SQL
        $sql = "SELECT id, username, password FROM users WHERE username = ?";

        if($stmt = $conn->prepare($sql)){
            // Lier les variables à la déclaration préparée en tant que paramètres
            $stmt->bind_param("s", $param_username);

            // Paramètres
            $param_username = $username;

            // Tentative d'exécution de la déclaration préparée
            if($stmt->execute()){
                // Stocker le résultat
                $result = $stmt->get_result();

                // Vérification si le nom d'utilisateur existe et si le mot de passe est correct
                if($result->num_rows == 1){
                    // Lier les variables de résultat
                    $row = $result->fetch_assoc();
                    $id = $row["id"];
                    $username = $row["username"];
                    $hashed_password = $row["password"];
                    if(password_verify($password, $hashed_password)){
                        // Si le mot de passe est correct, démarrer une nouvelle session
                        session_start();

                        // Stocker les données de session
                        $_SESSION["loggedin"] = true;
                        $_SESSION["id"] = $id;
                        $_SESSION["username"] = $username;

                        // Rediriger l'utilisateur vers la page de bienvenue
                        header("location: welcome.php");
                    } else{
                        // Si le mot de passe est incorrect, afficher un message d'erreur
                        $password_err = "Le mot de passe que vous avez entré n'est pas valide.";
                    }
                } else{
                    // Si le nom d'utilisateur n'existe pas, afficher un message d'erreur
                    $username_err = "Aucun compte trouvé avec ce nom d'utilisateur.";
                }
            } else{
                echo "Oops! Quelque chose s'est mal passé. Veuillez réessayer plus tard.";
            }
        }

        // Fermer la déclaration préparée
        $stmt->close();
    }

    // Fermer la connexion à la base de données
    $conn->close();
}
?>

<!DOCTYPE html>
<html>
<head>
