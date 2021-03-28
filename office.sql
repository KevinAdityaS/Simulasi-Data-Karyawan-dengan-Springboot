-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2021 at 05:50 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `office`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Number_Of_Workers` ()  NO SQL
Select departement, count(*) AS Number_Of_Workers from worker group by Departement$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `bonus`
--

CREATE TABLE `bonus` (
  `Worker_Ref_Id` varchar(10) NOT NULL,
  `Bonus_Date` datetime NOT NULL,
  `Bonus_Amount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bonus`
--

INSERT INTO `bonus` (`Worker_Ref_Id`, `Bonus_Date`, `Bonus_Amount`) VALUES
('1', '2016-02-20 00:00:00', 5000),
('2', '2016-06-11 00:00:00', 3000),
('3', '2016-02-20 00:00:00', 4000),
('1', '2016-02-20 00:00:00', 4500),
('2', '2016-06-11 00:00:00', 3500);

-- --------------------------------------------------------

--
-- Table structure for table `title`
--

CREATE TABLE `title` (
  `Worker_Ref_Id` varchar(20) NOT NULL,
  `Worker_Title` varchar(50) NOT NULL,
  `Affected_From` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `title`
--

INSERT INTO `title` (`Worker_Ref_Id`, `Worker_Title`, `Affected_From`) VALUES
('1', 'Manager', '2016-02-20 00:00:00'),
('2', 'Executive', '2016-06-11 00:00:00'),
('8', 'Executive', '2016-06-11 00:00:00'),
('5', 'Manager', '2016-06-11 00:00:00'),
('4', 'Asst. Manager', '2016-06-11 00:00:00'),
('7', 'Executive', '2016-06-11 00:00:00'),
('6', 'Lead', '2016-06-11 00:00:00'),
('3', 'Lead', '2016-06-11 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `worker`
--

CREATE TABLE `worker` (
  `Worker_Id` varchar(20) NOT NULL,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  `Salary` int(20) NOT NULL,
  `Joining_Date` datetime NOT NULL,
  `Departement` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `worker`
--

INSERT INTO `worker` (`Worker_Id`, `First_Name`, `Last_Name`, `Salary`, `Joining_Date`, `Departement`) VALUES
('1', 'Monika', 'Arora', 100000, '2014-02-20 09:00:00', 'HR'),
('2', 'Niharika', 'Verma', 80000, '2014-06-11 09:00:00', 'Admin'),
('3', 'Vishal', 'Singhal', 300000, '2014-02-20 09:00:00', 'HR'),
('4', 'Amitabh', 'Singh', 500000, '2014-02-20 09:00:00', 'Admin'),
('5', 'Vivek', 'Bhati', 500000, '2014-06-11 09:00:00', 'Admin'),
('6', 'Vipul', 'Diwan', 200000, '2014-06-11 09:00:00', 'Account'),
('7', 'Satish', 'Kumar', 75000, '2014-01-20 09:00:00', 'Account'),
('8', 'Geetika', 'Chauhan', 90000, '2014-04-11 09:00:00', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `worker`
--
ALTER TABLE `worker`
  ADD PRIMARY KEY (`Worker_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
