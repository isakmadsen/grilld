-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2019 at 03:47 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `grilld`
--

-- --------------------------------------------------------

--
-- Table structure for table `client_list`
--

CREATE TABLE `client_list`
(
    `id`       int(10) UNSIGNED                NOT NULL,
    `name`     varchar(50) COLLATE latin1_bin  NOT NULL,
    `tlf`      varchar(10) COLLATE latin1_bin  NOT NULL,
    `drowssap` varchar(150) COLLATE latin1_bin NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1
  COLLATE = latin1_bin;

--
-- Dumping data for table `client_list`
--

INSERT INTO `client_list` (`id`, `name`, `tlf`, `drowssap`)
VALUES (1, 'Valera', '63871233', 'ad74894b94eecd65d1b86061b83f84d74f414a82a7c2463a069cba75fdae7d36');

-- --------------------------------------------------------

--
-- Table structure for table `dish_list`
--

CREATE TABLE `dish_list`
(
    `id`          int(10) UNSIGNED                NOT NULL,
    `name`        varchar(50) COLLATE latin1_bin  NOT NULL,
    `meal_ref`    int(10) UNSIGNED                         DEFAULT NULL,
    `description` varchar(150) COLLATE latin1_bin NOT NULL,
    `price`       double UNSIGNED                 NOT NULL,
    `available`   tinyint(1)                      NOT NULL DEFAULT '1'
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1
  COLLATE = latin1_bin;

--
-- Dumping data for table `dish_list`
--

INSERT INTO `dish_list` (`id`, `name`, `meal_ref`, `description`, `price`, `available`)
VALUES (1, 'vafli', 1, 'as das dqw dasd qwd asd ', 22, 1),
       (2, 'pon4iki', 2, 'qw qd qw dq12313 1 3213 1as dasd ', 65, 1),
       (3, 'Kruasani', 4, 'dqwwdasdasd asd asd qwe123 asd 12dasqwd a', 16, 1);

-- --------------------------------------------------------

--
-- Table structure for table `meal_type`
--

CREATE TABLE `meal_type`
(
    `id`   int(10) UNSIGNED               NOT NULL,
    `type` varchar(50) COLLATE latin1_bin NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1
  COLLATE = latin1_bin;

--
-- Dumping data for table `meal_type`
--

INSERT INTO `meal_type` (`id`, `type`)
VALUES (1, 'breakfast'),
       (2, 'second breakfast'),
       (3, 'brunch'),
       (4, 'lunch'),
       (5, 'tea'),
       (6, 'dinner'),
       (7, 'supper'),
       (8, 'snack');

-- --------------------------------------------------------

--
-- Table structure for table `order_table`
--

CREATE TABLE `order_table`
(
    `id`             int(10) UNSIGNED                                     NOT NULL,
    `ordered_on`     datetime                                             NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `restaurant_ref` tinyint(3) UNSIGNED                                           DEFAULT NULL,
    `guests_amount`  set ('1','2','3','4','5','6','7') COLLATE latin1_bin NOT NULL DEFAULT '1',
    `ordered_for`    datetime                                             NOT NULL,
    `client_ref`     int(10) UNSIGNED                                              DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1
  COLLATE = latin1_bin;

--
-- Dumping data for table `order_table`
--

INSERT INTO `order_table` (`id`, `ordered_on`, `restaurant_ref`, `guests_amount`, `ordered_for`, `client_ref`)
VALUES (1, '2019-11-27 18:16:25', 1, '2', '2019-12-17 15:20:00', 1),
       (2, '2019-11-27 18:16:25', 1, '3', '2019-12-17 15:20:00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `order_takeaway`
--

CREATE TABLE `order_takeaway`
(
    `id`             int(10) UNSIGNED                         NOT NULL,
    `ordered_on`     timestamp                                NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `restaurant_ref` tinyint(3) UNSIGNED                               DEFAULT NULL,
    `client_ref`     int(10) UNSIGNED                                  DEFAULT NULL,
    `status`         set ('0','1','2','3') COLLATE latin1_bin NOT NULL DEFAULT '0'
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1
  COLLATE = latin1_bin;

--
-- Dumping data for table `order_takeaway`
--

INSERT INTO `order_takeaway` (`id`, `ordered_on`, `restaurant_ref`, `client_ref`, `status`)
VALUES (1, '2019-11-27 17:48:09', 1, 1, '3');

-- --------------------------------------------------------

--
-- Table structure for table `order_takeaway_list`
--

CREATE TABLE `order_takeaway_list`
(
    `row_id`      int(10) UNSIGNED NOT NULL,
    `invoice_ref` int(10) UNSIGNED DEFAULT NULL,
    `dish_ref`    int(10) UNSIGNED DEFAULT '1'
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1
  COLLATE = latin1_bin;

--
-- Dumping data for table `order_takeaway_list`
--

INSERT INTO `order_takeaway_list` (`row_id`, `invoice_ref`, `dish_ref`)
VALUES (1, 1, 1),
       (2, 1, 1),
       (3, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_list`
--

CREATE TABLE `restaurant_list`
(
    `id`         tinyint(3) UNSIGNED             NOT NULL,
    `guests_max` smallint(5) UNSIGNED            NOT NULL,
    `address`    varchar(150) COLLATE latin1_bin NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1
  COLLATE = latin1_bin;

--
-- Dumping data for table `restaurant_list`
--

INSERT INTO `restaurant_list` (`id`, `guests_max`, `address`)
VALUES (1, 14, 'Tuborg Havnepark 15, 2900 Hellerup'),
       (2, 22, 'Strandvejen 203, 2900 Hellerup');

-- --------------------------------------------------------

--
-- Table structure for table `terces`
--

CREATE TABLE `terces`
(
    `name`     varchar(50) COLLATE latin1_bin              NOT NULL,
    `type`     set ('admin','employee') COLLATE latin1_bin NOT NULL DEFAULT 'employee',
    `drowssap` varchar(150) COLLATE latin1_bin                      DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1
  COLLATE = latin1_bin;

--
-- Dumping data for table `terces`
--

INSERT INTO `terces` (`name`, `type`, `drowssap`)
VALUES ('Issa', 'employee', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'),
       ('admin', 'admin', '20f3765880a5c269b747e1e906054a4b4a3a991259f1e16b5dde4742cec2319a');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client_list`
--
ALTER TABLE `client_list`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `tlf` (`tlf`);

--
-- Indexes for table `dish_list`
--
ALTER TABLE `dish_list`
    ADD PRIMARY KEY (`id`),
    ADD KEY `meal_ref` (`meal_ref`);

--
-- Indexes for table `meal_type`
--
ALTER TABLE `meal_type`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_table`
--
ALTER TABLE `order_table`
    ADD PRIMARY KEY (`id`),
    ADD KEY `order_table_ibfk_2` (`client_ref`),
    ADD KEY `restaurant_ref` (`restaurant_ref`);

--
-- Indexes for table `order_takeaway`
--
ALTER TABLE `order_takeaway`
    ADD PRIMARY KEY (`id`),
    ADD KEY `client_id` (`client_ref`),
    ADD KEY `restaurant_ref` (`restaurant_ref`);

--
-- Indexes for table `order_takeaway_list`
--
ALTER TABLE `order_takeaway_list`
    ADD PRIMARY KEY (`row_id`),
    ADD KEY `invoice_id` (`invoice_ref`),
    ADD KEY `dish_id` (`dish_ref`);

--
-- Indexes for table `restaurant_list`
--
ALTER TABLE `restaurant_list`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `terces`
--
ALTER TABLE `terces`
    ADD PRIMARY KEY (`name`),
    ADD UNIQUE KEY `name` (`name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client_list`
--
ALTER TABLE `client_list`
    MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 2;

--
-- AUTO_INCREMENT for table `dish_list`
--
ALTER TABLE `dish_list`
    MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 4;

--
-- AUTO_INCREMENT for table `meal_type`
--
ALTER TABLE `meal_type`
    MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 9;

--
-- AUTO_INCREMENT for table `order_table`
--
ALTER TABLE `order_table`
    MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 3;

--
-- AUTO_INCREMENT for table `order_takeaway`
--
ALTER TABLE `order_takeaway`
    MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 2;

--
-- AUTO_INCREMENT for table `order_takeaway_list`
--
ALTER TABLE `order_takeaway_list`
    MODIFY `row_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 4;

--
-- AUTO_INCREMENT for table `restaurant_list`
--
ALTER TABLE `restaurant_list`
    MODIFY `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dish_list`
--
ALTER TABLE `dish_list`
    ADD CONSTRAINT `dish_list_ibfk_1` FOREIGN KEY (`meal_ref`) REFERENCES `meal_type` (`id`);

--
-- Constraints for table `order_table`
--
ALTER TABLE `order_table`
    ADD CONSTRAINT `order_table_ibfk_2` FOREIGN KEY (`client_ref`) REFERENCES `client_list` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
    ADD CONSTRAINT `order_table_ibfk_3` FOREIGN KEY (`restaurant_ref`) REFERENCES `restaurant_list` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Constraints for table `order_takeaway`
--
ALTER TABLE `order_takeaway`
    ADD CONSTRAINT `order_takeaway_ibfk_1` FOREIGN KEY (`client_ref`) REFERENCES `client_list` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
    ADD CONSTRAINT `order_takeaway_ibfk_2` FOREIGN KEY (`restaurant_ref`) REFERENCES `restaurant_list` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Constraints for table `order_takeaway_list`
--
ALTER TABLE `order_takeaway_list`
    ADD CONSTRAINT `order_takeaway_list_ibfk_1` FOREIGN KEY (`invoice_ref`) REFERENCES `order_takeaway` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
    ADD CONSTRAINT `order_takeaway_list_ibfk_2` FOREIGN KEY (`dish_ref`) REFERENCES `dish_list` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
