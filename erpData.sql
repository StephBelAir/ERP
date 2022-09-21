-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mer. 21 sep. 2022 à 16:50
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `erp`
--

--
-- Déchargement des données de la table `lot`
--

INSERT INTO `lot` (`id`, `length`, `product_name`, `quantity`, `special_type`, `type`, `width`, `process_process_id`) VALUES
(1, 0, 'string', 0, 0, 'string', 0, 1);

--
-- Déchargement des données de la table `machine`
--

INSERT INTO `machine` (`machine_id`, `machine_type`, `process_order`, `production_time`) VALUES
(1, 'string', 0, '2022-09-21 14:36:59'),
(2, 'string', 0, '2022-09-21 14:36:59'),
(3, 'string', 0, '2022-09-21 14:36:59'),
(4, 'string', 0, '2022-09-21 12:26:40'),
(5, 'string', 0, '2022-09-21 12:26:40'),
(6, 'string', 0, '2022-09-21 14:36:03'),
(7, 'string', 0, '2022-09-21 14:36:03'),
(8, 'string', 0, '2022-09-21 14:36:03'),
(9, 'string', 0, '2022-09-21 14:36:03'),
(10, 'string', 0, '2022-09-21 14:36:03');

--
-- Déchargement des données de la table `process`
--

INSERT INTO `process` (`process_id`, `actual_end_date`, `end_date`, `process_name`, `start_date`) VALUES
(1, '2022-09-21 14:36:27', '2022-09-21 14:36:27', 'string', '2022-09-21 14:36:27'),
(2, '2022-09-21 14:36:27', '2022-09-21 14:36:27', 'string', '2022-09-21 14:36:27'),
(3, '2022-09-21 14:36:27', '2022-09-21 14:36:27', 'string', '2022-09-21 14:36:27'),
(4, '2022-09-21 14:36:27', '2022-09-21 14:36:27', 'string', '2022-09-21 14:36:27'),
(5, '2022-09-21 14:36:27', '2022-09-21 14:36:27', 'string', '2022-09-21 14:36:27');

--
-- Déchargement des données de la table `process_machine`
--

INSERT INTO `process_machine` (`process_process_id`, `machine_machine_id`) VALUES
(1, 1),
(1, 2),
(1, 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
