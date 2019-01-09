-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 08 Sty 2019, 16:37
-- Wersja serwera: 10.1.37-MariaDB
-- Wersja PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `genericdatabase`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `officials`
--

CREATE TABLE `officials` (
  `idof` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `surname` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `function` varchar(45) COLLATE utf8_polish_ci NOT NULL DEFAULT 'Motor Vehicles Dept.',
  `passwd` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `login` varchar(45) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci COMMENT='Base of civil servants';

--
-- Zrzut danych tabeli `officials`
--

INSERT INTO `officials` (`idof`, `name`, `surname`, `function`, `passwd`, `login`) VALUES
(1, 'Adam', 'Kowal', 'DMV Official', 'password', 'login'),
(2, 'Damian', 'Nowak', 'DMV Potato', 'notpassword', 'notlogin');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `owners`
--

CREATE TABLE `owners` (
  `idow` int(11) NOT NULL,
  `pesel` bigint(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `surname` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `address` varchar(45) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci COMMENT='Owners/Co-owners table';

--
-- Zrzut danych tabeli `owners`
--

INSERT INTO `owners` (`idow`, `pesel`, `name`, `surname`, `address`) VALUES
(3, 99999999999, 'Janusz', 'Polak', 'Polna 3A'),
(6, 22222222222, 'Adam', 'Mocny', 'Błotna 3/4');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `vehicles`
--

CREATE TABLE `vehicles` (
  `idve` int(11) NOT NULL,
  `make` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `model` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `year` datetime NOT NULL,
  `color` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `plates` varchar(45) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci COMMENT='Contains all vehicles';

--
-- Zrzut danych tabeli `vehicles`
--

INSERT INTO `vehicles` (`idve`, `make`, `model`, `year`, `color`, `plates`) VALUES
(2, 'Renault', 'Zoe', '2016-08-05 00:00:00', 'BLUE', 'R4 6969');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wiw`
--

CREATE TABLE `wiw` (
  `idwiw` int(11) NOT NULL,
  `vid` int(11) NOT NULL,
  `oid` int(11) NOT NULL,
  `gid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci COMMENT='Which vehicle Is Whom?';

--
-- Zrzut danych tabeli `wiw`
--

INSERT INTO `wiw` (`idwiw`, `vid`, `oid`, `gid`) VALUES
(7, 2, 3, 1),
(8, 2, 6, 1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `officials`
--
ALTER TABLE `officials`
  ADD PRIMARY KEY (`idof`);

--
-- Indeksy dla tabeli `owners`
--
ALTER TABLE `owners`
  ADD PRIMARY KEY (`idow`);

--
-- Indeksy dla tabeli `vehicles`
--
ALTER TABLE `vehicles`
  ADD PRIMARY KEY (`idve`);

--
-- Indeksy dla tabeli `wiw`
--
ALTER TABLE `wiw`
  ADD PRIMARY KEY (`idwiw`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `officials`
--
ALTER TABLE `officials`
  MODIFY `idof` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `owners`
--
ALTER TABLE `owners`
  MODIFY `idow` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT dla tabeli `vehicles`
--
ALTER TABLE `vehicles`
  MODIFY `idve` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `wiw`
--
ALTER TABLE `wiw`
  MODIFY `idwiw` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
