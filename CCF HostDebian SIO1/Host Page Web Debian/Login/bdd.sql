-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.7.24 - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Listage de la structure de la base pour obi
CREATE DATABASE IF NOT EXISTS `obi` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `obi`;

-- Listage de la structure de la table obi. notes_etudiants
CREATE TABLE IF NOT EXISTS `notes_etudiants` (
  `PRENOM_ETUDIANT` char(50) DEFAULT NULL,
  `NOM_ETUDIANT` char(50) DEFAULT NULL,
  `SECTION_ETUDIANT` varchar(10) DEFAULT NULL,
  `BIRTH_ETUDIANT` date DEFAULT NULL,
  `MATIERE_ETUDIANT` varchar(100) DEFAULT NULL,
  `TYPE_EVALUATION_ETUDIANT` varchar(10) DEFAULT NULL,
  `DATEVAL_ETUDIANT` date DEFAULT NULL,
  `COEFFICIENT_ETUDIANT` float DEFAULT NULL,
  `NOTE_ETUDIANT` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Listage des données de la table obi.notes_etudiants : ~0 rows (environ)
/*!40000 ALTER TABLE `notes_etudiants` DISABLE KEYS */;
INSERT INTO `notes_etudiants` (`PRENOM_ETUDIANT`, `NOM_ETUDIANT`, `SECTION_ETUDIANT`, `BIRTH_ETUDIANT`, `MATIERE_ETUDIANT`, `TYPE_EVALUATION_ETUDIANT`, `DATEVAL_ETUDIANT`, `COEFFICIENT_ETUDIANT`, `NOTE_ETUDIANT`) VALUES
	('Abinash', 'Roy', 'SIO1', '2022-08-14', NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `notes_etudiants` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
