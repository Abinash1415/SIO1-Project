<?php
// Initialisation de la session
session_start();

// Vérification si l'utilisateur est déjà connecté, si oui alors le rediriger vers la page de profil
if(isset($_SESSION["loggedin"]) && $_SESSION["loggedin"] === true){
    header("location: profile.php");
    exit;
}

// Inclusion du fichier de configuration de la base de données
require_once "config.php";

// Définition des variables d'inscription et initialisation à des valeurs vides
$username = $password = $confirm_password = "";
$username_err = $password_err = $confirm_password_err = "";

// Traitement des données du formulaire d'inscription après la soumission du formulaire
if($_SERVER["REQUEST_METHOD"] == "POST"){

    // Validation du nom d'utilisateur
    if(empty(trim($_POST["username"]))){
        $username_err = "Please enter a username.";
    } else{
        // Préparation d'une déclaration SELECT pour vérifier l'existence de l'utilisateur dans la base de données
        $sql = "SELECT id FROM users WHERE username = ?";

        if($stmt = $conn->prepare($sql)){
            // Lier les variables à la déclaration préparée en tant que paramètres
            $stmt->bind_param("s", $param_username);

            // Paramètres
            $param_username = trim($_POST["username"]);

            // Tentative d'exécution de la déclaration préparée
            if($stmt->execute()){
                // Stockage du résultat de la déclaration préparée
                $stmt->store_result();

                if($stmt->num_rows == 1){
                    $username_err = "This username is already taken.";
                } else{
                    $username = trim($_POST["username"]);
                }
            } else{
                echo "Oops! Something went wrong. Please try again later.";
            }

            // Fermeture de la déclaration préparée
            $stmt->close();
        }
    }

    // Validation du mot de passe
    if(empty(trim($_POST["password"]))){
        $password_err = "Please enter a password.";     
    } elseif(strlen(trim($_POST["password"])) < 6){
        $password_err = "Password must have at least 6 characters.";
    } else{
        $password = trim($_POST["password"]);
    }

    // Validation de la confirmation de mot de passe
    if(empty(trim($_POST["confirm_password"]))){
        $confirm_password_err = "Please confirm password.";     
    } else{
        $confirm_password = trim($_POST["confirm_password"]);
        if(empty($password_err) && ($password != $confirm_password)){
            $confirm_password_err = "Password did not match.";
        }
    }

    // Validation des informations d'inscription
    if(empty($username_err) && empty($password_err) && empty($confirm_password_err)){
        // Préparation de la requête SQL pour insérer l'utilisateur dans la base de données
        $sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        if($stmt = $conn->prepare($sql)){
            // Lier les variables à la déclaration préparée en tant que paramètres
            $stmt->bind_param("ss", $param_username, $param_password);

            // Paramètres
            $param_username = $username;
            $param_password = password_hash($password, PASSWORD_DEFAULT); // Hashage du mot de passe

            // Tentative d'exécution de la déclaration préparée
        if($stmt->execute()){
            // Rediriger l'utilisateur vers la page de connexion
            header("location: login.php");
        } else{
            echo "Oops! Quelque chose a mal tourné. Veuillez réessayer plus tard.";
        }

        // Fermeture de la déclaration préparée
        $stmt->close();
        }

        // Fermeture de la connexion
        $conn->close();
        }

           
