-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 09, 2022 at 05:48 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smartie`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `Account_No` int(11) NOT NULL,
  `User_ID` int(11) NOT NULL,
  `Account_Type` varchar(40) NOT NULL,
  `Balance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`Account_No`, `User_ID`, `Account_Type`, `Balance`) VALUES
(997711, 7711, 'Savings Account', 2200),
(997712, 7712, 'Savings Account', 1650),
(997713, 7713, 'Savings Account', 2850),
(997714, 7714, 'Savings Account', 2000);

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Admin_ID` int(11) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Gender` varchar(40) NOT NULL,
  `Contact` varchar(40) NOT NULL,
  `Address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Admin_ID`, `Name`, `Gender`, `Contact`, `Address`) VALUES
(370013, 'Rio Lixa', 'Male', '6573309', 'Pinu'),
(370014, 'Trishna', 'Female', '01623456789', 'Khulna');

-- --------------------------------------------------------

--
-- Table structure for table `count_table`
--

CREATE TABLE `count_table` (
  `count_id` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `employee` int(11) NOT NULL,
  `admin` int(11) NOT NULL,
  `login` int(11) NOT NULL,
  `transaction` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `count_table`
--

INSERT INTO `count_table` (`count_id`, `user`, `employee`, `admin`, `login`, `transaction`) VALUES
(1, 5, 3, 4, 9, 12);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Employee_ID` int(11) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Contact` varchar(20) NOT NULL,
  `Address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Employee_ID`, `Name`, `Gender`, `Contact`, `Address`) VALUES
(999911, 'Mina', 'Female', '9080', 'Dhaka');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `Login_ID` int(11) NOT NULL,
  `Identity_ID` int(11) NOT NULL,
  `Role_ID` int(11) NOT NULL,
  `Username` varchar(40) NOT NULL,
  `Password` varchar(40) NOT NULL,
  `Profile_picture` varchar(100) NOT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Login_ID`, `Identity_ID`, `Role_ID`, `Username`, `Password`, `Profile_picture`, `Status`) VALUES
(17121, 7711, 3, 'saikat@gmail.com', '12345', '01763088973skb.png', 'Approved'),
(17122, 7712, 3, 'tasfia@gmail.com', 'tasfia', '01723456789pro.png', 'Approved'),
(17123, 999911, 2, 'mina@gmail.com', 'mina', '9080apple.png', 'Approved'),
(17124, 7713, 3, 'raju@gmail.com', 'rajus', '9908budget.png', 'Approved'),
(17125, 7714, 3, 'vim@gmail.com', 'vims', '98760bird.png', 'Approved'),
(17127, 370013, 1, 'pila@gmail.com', '3242', '6573309bird.png', 'Approved'),
(17128, 370014, 1, 'maksuda@gmail.com', '123', '01623456789pro.png', 'Approved');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `Role_ID` int(11) NOT NULL,
  `Role_Name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`Role_ID`, `Role_Name`) VALUES
(1, 'ADMIN'),
(2, 'EMPLOYEE'),
(3, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `Transaction_ID` int(11) NOT NULL,
  `Account_No` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Deposit` int(11) NOT NULL,
  `Withdraw` int(11) NOT NULL,
  `Available_Balance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`Transaction_ID`, `Account_No`, `Date`, `Deposit`, `Withdraw`, `Available_Balance`) VALUES
(55316461, 997711, '2022-11-09', 500, 0, 2500),
(55316462, 997714, '2022-11-09', 0, 500, 1500),
(55316463, 997711, '2022-11-09', 0, 500, 2000),
(55316464, 997714, '2022-11-09', 500, 0, 2000),
(55316465, 997712, '2022-11-09', 0, 350, 1650),
(55316466, 997713, '2022-11-09', 350, 0, 2350),
(55316467, 997711, '2022-11-09', 500, 0, 2500),
(55316468, 997711, '2022-11-09', 250, 0, 2750),
(55316469, 997711, '2022-11-09', 0, 50, 2700),
(55316470, 997711, '2022-11-09', 0, 500, 2200),
(55316471, 997713, '2022-11-09', 500, 0, 2850);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `User_ID` int(11) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Gender` varchar(40) NOT NULL,
  `Contact` varchar(40) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `DOB` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`User_ID`, `Name`, `Gender`, `Contact`, `Address`, `DOB`) VALUES
(7711, 'Sakib Saikat', 'Male', '01763088973', 'Badda, Dhaka', '2000-04-20'),
(7712, 'Tasfia Trishna', 'Female', '01723456789', 'Khulna', '2001-06-12'),
(7713, 'Raju', 'Male', '9908', 'Rangpur', '1952-02-03'),
(7714, 'Bheem', 'Male', '98760', 'Rajshahi', '1955-05-04');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`Account_No`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Admin_ID`);

--
-- Indexes for table `count_table`
--
ALTER TABLE `count_table`
  ADD PRIMARY KEY (`count_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Employee_ID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`Login_ID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`Role_ID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`Transaction_ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`User_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `Account_No` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=997715;

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `Admin_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=370015;

--
-- AUTO_INCREMENT for table `count_table`
--
ALTER TABLE `count_table`
  MODIFY `count_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `Employee_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=999913;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `Login_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17129;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `Role_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `Transaction_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55316472;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `User_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7715;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
