-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 07 Lut 2020, 16:26
-- Wersja serwera: 10.4.10-MariaDB
-- Wersja PHP: 7.3.12

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
(6, 22222222222, 'Adam', 'Mocny', 'Błotna 3/4'),
(34, 97123125364, 'Kamil', 'Lasek', 'Laszczyny 65'),
(35, 89576534568, 'Bartosz', 'Gawlik', 'Pruszkow 12'),
(36, 75846382644, 'Roman', 'Kornafel', 'Pigany 56'),
(37, 95637485623, 'Paulina', 'Toszyc', 'Wierzawice 78');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `vehicles`
--

CREATE TABLE `vehicles` (
  `idve` int(11) NOT NULL,
  `make` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `model` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `year` date NOT NULL,
  `color` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `plates` varchar(45) COLLATE utf8_polish_ci NOT NULL,
  `hasOwner` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci COMMENT='Contains all vehicles';

--
-- Zrzut danych tabeli `vehicles`
--

INSERT INTO `vehicles` (`idve`, `make`, `model`, `year`, `color`, `plates`, `hasOwner`) VALUES
(26, 'Mazda', 'Miata', '2020-01-01', 'Red', 'RZE4567', 1),
(27, 'Lexus', 'IS200', '1999-01-14', 'Red', 'RPZ', 0),
(30, 'Nissan', 'Skyline R32 GTR', '2008-01-11', 'Blue', 'RLU 123', 1),
(39, 'Dodge', 'Viper', '2010-02-19', 'White', 'ERT 567', 0),
(40, 'Chevrolet', 'Corvette', '2010-02-23', 'Purple', 'RLU 24578', 0),
(41, 'Ford', 'Mustang', '2015-07-15', 'Black', 'FGR 325', 1),
(42, 'Lexus', 'RC F', '2015-07-15', 'Black', 'UTR 333', 0),
(43, 'Chevrolet', 'Camaro', '2010-09-10', 'Unkown', 'ZXC 2432', 1),
(44, 'Nissan', 'GTR', '2010-09-10', 'Pink', 'FH 124', 0),
(45, 'Subaru', 'WRX', '2020-03-03', 'White', 'SDF 457', 1),
(46, 'Mitsubishi', 'Lancer Evo', '1995-03-17', 'Silver', 'JFJ 2356', 0),
(47, 'Lamborghini', 'Huraccan', '2012-02-07', 'Gray', 'SD 68', 0),
(48, 'Mazda', 'Atenza', '2012-02-07', 'Red', 'FUT 2345', 1);

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
(45, 43, 36, 1),
(46, 30, 37, 1),
(47, 45, 35, 1),
(48, 26, 37, 1),
(49, 41, 37, 1),
(50, 48, 37, 1);

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
-- AUTO_INCREMENT dla tabel zrzutów
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
  MODIFY `idow` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT dla tabeli `vehicles`
--
ALTER TABLE `vehicles`
  MODIFY `idve` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT dla tabeli `wiw`
--
ALTER TABLE `wiw`
  MODIFY `idwiw` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
