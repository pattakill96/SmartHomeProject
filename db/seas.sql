-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Lug 15, 2022 alle 23:28
-- Versione del server: 10.1.37-MariaDB
-- Versione PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `seas`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `values`
--

CREATE TABLE `values` (
  `id` int(11) NOT NULL,
  `kdmin` float NOT NULL,
  `kdmax` float NOT NULL,
  `knmin` float NOT NULL,
  `knmax` float NOT NULL,
  `ldmin` float NOT NULL,
  `ldmax` float NOT NULL,
  `lnmin` float NOT NULL,
  `lnmax` float NOT NULL,
  `bdmin` float NOT NULL,
  `bdmax` float NOT NULL,
  `bnmin` float NOT NULL,
  `bnmax` float NOT NULL,
  `btdmin` float NOT NULL,
  `btdmax` float NOT NULL,
  `btnmin` float NOT NULL,
  `btnmax` float NOT NULL,
  `kmin` float NOT NULL,
  `kmax` float NOT NULL,
  `lmin` float NOT NULL,
  `lmax` float NOT NULL,
  `bmin` float NOT NULL,
  `bmax` float NOT NULL,
  `btmin` float NOT NULL,
  `btmax` float NOT NULL,
  `timestamp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `values`
--
ALTER TABLE `values`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `values`
--
ALTER TABLE `values`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
