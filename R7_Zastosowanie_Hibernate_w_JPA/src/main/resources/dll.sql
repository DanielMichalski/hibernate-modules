-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 01 Kwi 2014, 21:04
-- Wersja serwera: 5.6.12-log
-- Wersja PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `szkolenie`
--
CREATE DATABASE IF NOT EXISTS `szkolenie` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `szkolenie`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klient`
--

CREATE TABLE IF NOT EXISTS `klient` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `imie` varchar(50) NOT NULL,
  `nazwisko` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Zrzut danych tabeli `klient`
--

INSERT INTO `klient` (`id`, `imie`, `nazwisko`) VALUES
(2, 'Marcin', 'Nowak'),
(3, 'Andrzej', 'Kowalski');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klient_firmowy`
--

CREATE TABLE IF NOT EXISTS `klient_firmowy` (
  `klient_id` int(10) NOT NULL,
  `nazwa_firmy` varchar(50) DEFAULT NULL,
  `nip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`klient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `klient_firmowy`
--

INSERT INTO `klient_firmowy` (`klient_id`, `nazwa_firmy`, `nip`) VALUES
(3, 'Andrew Services', '118-7549-753');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `klient_prywatny`
--

CREATE TABLE IF NOT EXISTS `klient_prywatny` (
  `klient_id` int(10) NOT NULL,
  `data_urodzenia` date DEFAULT NULL,
  PRIMARY KEY (`klient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `klient_prywatny`
--

INSERT INTO `klient_prywatny` (`klient_id`, `data_urodzenia`) VALUES
(2, '2012-05-09');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `produkt`
--

CREATE TABLE IF NOT EXISTS `produkt` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(50) NOT NULL,
  `cena` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Zrzut danych tabeli `produkt`
--

INSERT INTO `produkt` (`id`, `nazwa`, `cena`) VALUES
(1, 'Jabłko', '3.00'),
(2, 'Gruszka', '2.00');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `skladnik`
--

CREATE TABLE IF NOT EXISTS `skladnik` (
  `produkt_id` int(10) NOT NULL,
  `zamowienie_id` int(10) NOT NULL,
  `ilosc` int(10) NOT NULL,
  PRIMARY KEY (`produkt_id`,`zamowienie_id`),
  KEY `zamowienie_skladnik` (`zamowienie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `skladnik`
--

INSERT INTO `skladnik` (`produkt_id`, `zamowienie_id`, `ilosc`) VALUES
(1, 2, 4),
(2, 2, 5);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `telefon`
--

CREATE TABLE IF NOT EXISTS `telefon` (
  `numer` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `klient` int(10) NOT NULL,
  PRIMARY KEY (`numer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `telefon`
--

INSERT INTO `telefon` (`numer`, `model`, `klient`) VALUES
('1122334455', 'K500', 1),
('22446688', 'K600i', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zamowienie`
--

CREATE TABLE IF NOT EXISTS `zamowienie` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `adres` text NOT NULL,
  `klient` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `klient` (`klient`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Zrzut danych tabeli `zamowienie`
--

INSERT INTO `zamowienie` (`id`, `data`, `adres`, `klient`) VALUES
(2, '2014-03-03 23:00:00', 'adres1', 2),
(3, '2014-03-05 23:00:00', 'adres2', 3),
(4, '2014-03-01 23:00:00', 'adres3', 3);

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `klient_firmowy`
--
ALTER TABLE `klient_firmowy`
  ADD CONSTRAINT `klient_klient_firmowy` FOREIGN KEY (`klient_id`) REFERENCES `klient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `klient_prywatny`
--
ALTER TABLE `klient_prywatny`
  ADD CONSTRAINT `klient_klient_prywatny` FOREIGN KEY (`klient_id`) REFERENCES `klient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `skladnik`
--
ALTER TABLE `skladnik`
  ADD CONSTRAINT `produkt_skladnik` FOREIGN KEY (`produkt_id`) REFERENCES `produkt` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `zamowienie_skladnik` FOREIGN KEY (`zamowienie_id`) REFERENCES `zamowienie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `zamowienie`
--
ALTER TABLE `zamowienie`
  ADD CONSTRAINT `zamowienie_klient` FOREIGN KEY (`klient`) REFERENCES `klient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
