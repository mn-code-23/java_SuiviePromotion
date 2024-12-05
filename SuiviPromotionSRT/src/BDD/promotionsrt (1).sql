-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 10 fév. 2024 à 15:29
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `promotionsrt`
--

-- --------------------------------------------------------

--
-- Structure de la table `authentification`
--

DROP TABLE IF EXISTS `authentification`;
CREATE TABLE IF NOT EXISTS `authentification` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `users` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `status` varchar(100) DEFAULT 'etudiant',
  PRIMARY KEY (`id`),
  UNIQUE KEY `users` (`users`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `authentification`
--

INSERT INTO `authentification` (`id`, `users`, `pwd`, `status`) VALUES
(1, 'ibrahima.seck@email.com', 'seck1234', 'etudiant'),
(2, 'diop@email.com', 'P@ssw0rd1', 'etudiant'),
(3, 'babacar.sow@email.com', 'SecureP@ss2', 'etudiant'),
(4, 'coumba.ndiaye@email.com', 'SafeP@ss3', 'etudiant'),
(5, 'daouda.mbengue@email.com', 'SecretP@ss4', 'etudiant'),
(6, 'aminata.gueye@email.com', 'HiddenP@ss5', 'etudiant'),
(7, 'mamadou.cisse@email.com', 'EncryptedP@ss6', 'etudiant'),
(8, 'ndeye.fall@email.com', 'ProtectedP@ss7', 'etudiant'),
(9, 'pape.diallo@email.com', 'ShieldedP@ss8', 'etudiant'),
(10, 'khady.ndao@email.com', 'DefendedP@ss9', 'etudiant'),
(20, 'maguette@gmail.com', 'maguette1234', 'personnel'),
(19, 'mncode@gmail.com', 'mncode2025', 'admin'),
(15, 'niang@gmail.com', 'niang2023', 'personnel'),
(16, 'laye@gmail.com', 'mbaye1789', 'personnel'),
(23, 'wade@gmail.com', 'wade1234', 'etudiant');

-- --------------------------------------------------------

--
-- Structure de la table `cursusuniver`
--

DROP TABLE IF EXISTS `cursusuniver`;
CREATE TABLE IF NOT EXISTS `cursusuniver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anneeD` date DEFAULT NULL,
  `anneeF` date DEFAULT NULL,
  `diplome` varchar(225) DEFAULT NULL,
  `etabliss` varchar(225) DEFAULT NULL,
  `etudiantID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cursusUniver_infosEtudiant` (`etudiantID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Déchargement des données de la table `cursusuniver`
--

INSERT INTO `cursusuniver` (`id`, `anneeD`, `anneeF`, `diplome`, `etabliss`, `etudiantID`) VALUES
(1, '2010-02-01', '2013-10-30', 'Technicien réseau', 'UADB', 1234567),
(2, '2010-02-01', '2013-10-30', 'Technicien réseau', 'UADB', 2345678),
(3, '2010-02-01', '2013-10-30', 'Technicien réseau', 'UADB', 3456789),
(4, '2010-02-01', '2013-10-30', 'Technicien réseau', 'UADB', 4567890),
(5, '2010-02-01', '2013-10-30', 'Technicien réseau', 'UADB', 5678901),
(6, '2010-02-01', '2013-10-30', 'Technicien réseau', 'UADB', 6789012),
(7, '2010-02-01', '2013-10-30', 'Technicien réseau', 'UADB', 7890123),
(8, '2010-02-01', '2013-10-30', 'Technicien réseau', 'UADB', 8901234),
(9, '2010-02-01', '2013-10-30', 'Technicien réseau', 'UADB', 9012345),
(10, '2010-02-01', '2013-10-30', 'Technicien réseau', 'UADB', 123456),
(11, '2020-02-12', '2024-02-12', 'Technicien réseau', 'UADB', 1510982),
(12, '2010-02-15', '2013-02-15', 'Technicien réseau', 'UADB', 1510263),
(14, '2020-03-15', '2024-03-15', 'Technicien', 'UADB', 1509980);

-- --------------------------------------------------------

--
-- Structure de la table `infosetudiant`
--

DROP TABLE IF EXISTS `infosetudiant`;
CREATE TABLE IF NOT EXISTS `infosetudiant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(255) DEFAULT NULL,
  `nom` varchar(225) DEFAULT NULL,
  `domicil` varchar(225) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `email` varchar(225) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9012346 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `infosetudiant`
--

INSERT INTO `infosetudiant` (`id`, `prenom`, `nom`, `domicil`, `tel`, `email`, `pwd`) VALUES
(123456, 'Ibrahima', 'Seck', '707 Rue Matam', '+221760123456', 'ibrahima.seck@email.com', 'seck1234'),
(1234567, 'Aissatou', 'Diop', '123 Rue Dakar', '+221771234567', 'diop@email.com', 'P@ssw0rd1'),
(1509980, 'Cheikh', 'wade', 'bambey', '778945612', 'wade@gmail.com', 'wade1234'),
(1510263, 'Mouhamadou', 'Niang', 'cite lamy, Thies', '789456123', 'niang23@gmail.com', 'mn-code'),
(1510982, 'Malick', 'Ndiaye', 'diokoul', '781234568', 'milk@gmail.com', 'milg2023'),
(2345678, 'Babacar', 'Sow', '456 Avenue Thiès', '+221762345678', 'babacar.sow@email.com', 'SecureP@ss2'),
(3456789, 'Coumba', 'Ndiaye', '789 Boulevard Saint-Louis', '+221703456789', 'coumba.ndiaye@email.com', 'SafeP@ss3'),
(4567890, 'Daouda', 'Mbengue', '101 Rue Louga', '+221784567890', 'daouda.mbengue@email.com', 'SecretP@ss4'),
(5678901, 'Aminata', 'Gueye', '202 Rue Kaolack', '+221765678901', 'aminata.gueye@email.com', 'HiddenP@ss5'),
(6789012, 'Mamadou', 'Cissé', '303 Avenue Ziguinchor', '+221776789012', 'mamadou.cisse@email.com', 'EncryptedP@ss6'),
(7890123, 'Ndeye', 'Fall', '404 Boulevard Tambacounda', '+221767890123', 'ndeye.fall@email.com', 'ProtectedP@ss7'),
(8901234, 'Pape', 'Diallo', '505 Rue Fatick', '+221708901234', 'pape.diallo@email.com', 'ShieldedP@ss8'),
(9012345, 'Khady', 'Ndao', '606 Avenue Kolda', '+221789012345', 'khady.ndao@email.com', 'DefendedP@ss9');

-- --------------------------------------------------------

--
-- Structure de la table `master`
--

DROP TABLE IF EXISTS `master`;
CREATE TABLE IF NOT EXISTS `master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `niveauM` varchar(45) DEFAULT NULL,
  `etabliss` varchar(225) DEFAULT NULL,
  `etudiantID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_master_infosEtudiant1` (`etudiantID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `master`
--

INSERT INTO `master` (`id`, `niveauM`, `etabliss`, `etudiantID`) VALUES
(1, 'Master 2', 'UADB', 5678901),
(2, 'Master 2', 'UCAD', 6789012),
(3, 'Master 2', 'UADB', 7890123),
(4, 'Master 2', 'UGB', 8901234),
(5, 'Master 2', 'UADB', 9012345),
(6, 'Master 2', 'UADB', 1510982),
(9, 'Master 2', 'UADB', 1509980);

-- --------------------------------------------------------

--
-- Structure de la table `parcourpro`
--

DROP TABLE IF EXISTS `parcourpro`;
CREATE TABLE IF NOT EXISTS `parcourpro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anneeD` date DEFAULT NULL,
  `anneeF` date DEFAULT NULL,
  `poste` varchar(225) DEFAULT NULL,
  `contrat` varchar(45) DEFAULT NULL,
  `entreprise` varchar(225) DEFAULT NULL,
  `etudiantID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_parcourPro_infosEtudiant1` (`etudiantID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `parcourpro`
--

INSERT INTO `parcourpro` (`id`, `anneeD`, `anneeF`, `poste`, `contrat`, `entreprise`, `etudiantID`) VALUES
(1, '2013-08-19', '2015-12-30', 'Technicien en Reseau', 'Stage', 'Free', 5678901),
(2, '2019-11-20', '2021-06-25', 'Ingénieur en Big Data', 'CDD', 'Wave', 6789012),
(3, '2021-03-10', '2023-01-15', 'Ingénieur en Systèmes Réseaux', 'Stage', 'Free', 7890123),
(4, '2018-07-01', '2020-04-18', 'Ingénieur en Telecom', 'CDI', 'Sonatel', 8901234),
(5, '2019-05-05', '2022-02-12', 'Ingénieur en Systèmes Réseaux', 'Stage', 'Expresso', 9012345),
(6, '2014-05-19', '2015-05-18', 'Technicien réseau', 'CDI', 'Free', 1234567),
(7, '2014-08-22', '2015-08-21', 'Technicien réseau', 'CDD', 'Expresso', 2345678),
(8, '2014-04-15', '2015-04-14', 'Technicien réseau', 'Stage', 'Sonatel', 3456789),
(9, '2014-11-10', '2015-11-09', 'Technicien réseau', 'CDI', 'Sonatel', 4567890);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cursusuniver`
--
ALTER TABLE `cursusuniver`
  ADD CONSTRAINT `fk_cursusUniver_infosEtudiant` FOREIGN KEY (`etudiantID`) REFERENCES `infosetudiant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `master`
--
ALTER TABLE `master`
  ADD CONSTRAINT `fk_master_infosEtudiant1` FOREIGN KEY (`etudiantID`) REFERENCES `infosetudiant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `parcourpro`
--
ALTER TABLE `parcourpro`
  ADD CONSTRAINT `fk_parcourPro_infosEtudiant1` FOREIGN KEY (`etudiantID`) REFERENCES `infosetudiant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
