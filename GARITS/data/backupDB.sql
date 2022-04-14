-- MariaDB dump 10.19  Distrib 10.6.4-MariaDB, for osx10.15 (x86_64)
--
-- Host: localhost    Database: GARITS
-- ------------------------------------------------------
-- Server version	10.6.4-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `postcode` varchar(10) NOT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `Customer_Accountaccount_id` varchar(255) DEFAULT NULL,
  `accountHolder` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCustomer968330` (`Customer_Accountaccount_id`),
  CONSTRAINT `FKCustomer968330` FOREIGN KEY (`Customer_Accountaccount_id`) REFERENCES `Customer_Account` (`account_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1229371203 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (4,'s','s','s','s','07565182979','ss@ss.com',NULL,NULL),(1229371195,'s','s','s','s','07565182979','ss@ss.com',NULL,NULL),(1229371196,'b','b','b','b','07565182979','bb@bb.com',NULL,1),(1229371197,'Transco Gas','Supplies','Methane Buildings','HP192MT','01494683725','jack@tgs.com',NULL,0),(1229371198,'Transco Gas','Services','Methane House','HP192MT','01494683725','jack@tgs.com',NULL,1),(1229371199,'John','Doherty','Miscallaneous House','MT1 2UP','07070707070','john@gmail.com',NULL,0),(1229371200,'William','Gates','World Domination House','NW10 4AT','06666666666','will@gmail.com',NULL,1);
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer_Account`
--

DROP TABLE IF EXISTS `Customer_Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer_Account` (
  `account_id` varchar(255) NOT NULL,
  `discountType` varchar(255) DEFAULT NULL,
  `payLater` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer_Account`
--

LOCK TABLES `Customer_Account` WRITE;
/*!40000 ALTER TABLE `Customer_Account` DISABLE KEYS */;
INSERT INTO `Customer_Account` VALUES ('','Fixed',1),('1229371196','Fixed',1),('1229371198','Fixed',1),('1229371200','Flexible',0);
/*!40000 ALTER TABLE `Customer_Account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Invoice`
--

DROP TABLE IF EXISTS `Invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Invoice` (
  `invoice_no` int(6) NOT NULL AUTO_INCREMENT,
  `Customerid` int(10) NOT NULL,
  `Jobid` varchar(255) NOT NULL,
  PRIMARY KEY (`invoice_no`),
  KEY `FKInvoice989275` (`Customerid`),
  KEY `FKInvoice292761` (`Jobid`),
  CONSTRAINT `FKInvoice292761` FOREIGN KEY (`Jobid`) REFERENCES `Job` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKInvoice989275` FOREIGN KEY (`Customerid`) REFERENCES `Customer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Invoice`
--

LOCK TABLES `Invoice` WRITE;
/*!40000 ALTER TABLE `Invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `Invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Job`
--

DROP TABLE IF EXISTS `Job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Job` (
  `id` varchar(255) NOT NULL,
  `desc` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Job`
--

LOCK TABLES `Job` WRITE;
/*!40000 ALTER TABLE `Job` DISABLE KEYS */;
/*!40000 ALTER TABLE `Job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mechanic`
--

DROP TABLE IF EXISTS `Mechanic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Mechanic` (
  `name` varchar(255) NOT NULL,
  `Usersid` int(10) NOT NULL,
  PRIMARY KEY (`Usersid`),
  CONSTRAINT `FKMechanic901447` FOREIGN KEY (`Usersid`) REFERENCES `Users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mechanic`
--

LOCK TABLES `Mechanic` WRITE;
/*!40000 ALTER TABLE `Mechanic` DISABLE KEYS */;
/*!40000 ALTER TABLE `Mechanic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MoT`
--

DROP TABLE IF EXISTS `MoT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MoT` (
  `Vehiclereg_no` varchar(7) NOT NULL,
  `renewal_date` date NOT NULL,
  PRIMARY KEY (`Vehiclereg_no`),
  CONSTRAINT `FKMoT493830` FOREIGN KEY (`Vehiclereg_no`) REFERENCES `Vehicle` (`reg_no`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MoT`
--

LOCK TABLES `MoT` WRITE;
/*!40000 ALTER TABLE `MoT` DISABLE KEYS */;
/*!40000 ALTER TABLE `MoT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orders`
--

DROP TABLE IF EXISTS `Orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orders` (
  `order_no` int(100) NOT NULL,
  `date` int(10) NOT NULL,
  PRIMARY KEY (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orders`
--

LOCK TABLES `Orders` WRITE;
/*!40000 ALTER TABLE `Orders` DISABLE KEYS */;
INSERT INTO `Orders` VALUES (-2065686013,542022),(-1500886542,542022),(-1148936938,542022),(-1019061823,542022),(-413209597,542022),(-173607923,542022),(0,0),(1,542022),(2,542022),(1135718918,542022),(1796521884,542022);
/*!40000 ALTER TABLE `Orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Parts_Sale`
--

DROP TABLE IF EXISTS `Parts_Sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Parts_Sale` (
  `SalessaleID` int(10) NOT NULL,
  `SparePartspart_code` varchar(255) NOT NULL,
  PRIMARY KEY (`SalessaleID`),
  KEY `FKParts_Sale392853` (`SparePartspart_code`),
  CONSTRAINT `FKParts_Sale392853` FOREIGN KEY (`SparePartspart_code`) REFERENCES `SpareParts` (`part_code`) ON DELETE CASCADE,
  CONSTRAINT `FKParts_Sale623630` FOREIGN KEY (`SalessaleID`) REFERENCES `Sales` (`saleID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Parts_Sale`
--

LOCK TABLES `Parts_Sale` WRITE;
/*!40000 ALTER TABLE `Parts_Sale` DISABLE KEYS */;
/*!40000 ALTER TABLE `Parts_Sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Purchase_Order`
--

DROP TABLE IF EXISTS `Purchase_Order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Purchase_Order` (
  `Ordersorder_no` int(10) NOT NULL,
  `SparePartspart_code` varchar(255) NOT NULL,
  `noToOrder` int(10) DEFAULT NULL,
  KEY `FKPurchase_O539168` (`Ordersorder_no`),
  KEY `FKPurchase_O636657` (`SparePartspart_code`),
  CONSTRAINT `FKPurchase_O539168` FOREIGN KEY (`Ordersorder_no`) REFERENCES `Orders` (`order_no`) ON DELETE CASCADE,
  CONSTRAINT `FKPurchase_O636657` FOREIGN KEY (`SparePartspart_code`) REFERENCES `SpareParts` (`part_code`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Purchase_Order`
--

LOCK TABLES `Purchase_Order` WRITE;
/*!40000 ALTER TABLE `Purchase_Order` DISABLE KEYS */;
INSERT INTO `Purchase_Order` VALUES (-1019061823,'mot',4),(-1019061823,'hgmj',2),(-1500886542,'mot',4),(-1500886542,'hgmj',2),(-413209597,'mot',4),(-413209597,'hgmj',2),(-173607923,'mot',4),(-173607923,'hgmj',2),(-1148936938,'mot',4),(-1148936938,'hgmj',2);
/*!40000 ALTER TABLE `Purchase_Order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Receptionist`
--

DROP TABLE IF EXISTS `Receptionist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Receptionist` (
  `Usersid` int(10) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Usersid`),
  CONSTRAINT `FKReceptioni859961` FOREIGN KEY (`Usersid`) REFERENCES `Users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Receptionist`
--

LOCK TABLES `Receptionist` WRITE;
/*!40000 ALTER TABLE `Receptionist` DISABLE KEYS */;
/*!40000 ALTER TABLE `Receptionist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sales`
--

DROP TABLE IF EXISTS `Sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sales` (
  `saleID` int(10) NOT NULL AUTO_INCREMENT,
  `cust_type` int(10) NOT NULL,
  `date` int(10) NOT NULL,
  `parts` int(10) NOT NULL,
  `ReceptionistUsersid` int(10) NOT NULL,
  PRIMARY KEY (`saleID`),
  KEY `FKSales377496` (`ReceptionistUsersid`),
  CONSTRAINT `FKSales377496` FOREIGN KEY (`ReceptionistUsersid`) REFERENCES `Receptionist` (`Usersid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sales`
--

LOCK TABLES `Sales` WRITE;
/*!40000 ALTER TABLE `Sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `Sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SpareParts`
--

DROP TABLE IF EXISTS `SpareParts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SpareParts` (
  `part_code` varchar(255) NOT NULL,
  `part_name` varchar(255) NOT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `vehicle_type` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `price` int(10) NOT NULL,
  `stock_level` int(10) NOT NULL,
  `min_threshold` int(10) NOT NULL,
  PRIMARY KEY (`part_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SpareParts`
--

LOCK TABLES `SpareParts` WRITE;
/*!40000 ALTER TABLE `SpareParts` DISABLE KEYS */;
INSERT INTO `SpareParts` VALUES ('0','0',NULL,NULL,NULL,0,0,0),('AF1','Air Filter','Halfords','All','2000',15,15,10),('E1','Exhaust','Fjord Supplies','Fjord Estate','2005',200,3,2),('EM1','Engine Mounts','Halfords','All Makes','1970',15,6,4),('hgmj','unnamed','ford','suv','2002',20,53,3),('khkjh','wheel','wheels r us','all','1970',1000,20,4),('mot','jilm',NULL,NULL,NULL,20,48,32),('OF1','Oil Filter','Halfords','All','2000',10,16,15),('P1','Paint','Halfords','All','2000',60,3,2),('SL1','Spark Leads','Halfords','All','1970',13,16,10),('SP1','Spark Plugs','Halfords','All','1970',2,23,20),('T1','Tyre','Fjord Supplies','Fjord Transit Van','2020',45,8,6),('thgj','jop','ford','suv','2004',89,7,6);
/*!40000 ALTER TABLE `SpareParts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vehicle`
--

DROP TABLE IF EXISTS `Vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Vehicle` (
  `reg_no` varchar(7) NOT NULL,
  `make` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `engine_serial` varchar(255) NOT NULL,
  `vin` varchar(255) NOT NULL,
  `color` varchar(255) NOT NULL,
  `Customerid` int(10) NOT NULL,
  PRIMARY KEY (`reg_no`),
  KEY `FKVehicle142263` (`Customerid`),
  CONSTRAINT `FKVehicle142263` FOREIGN KEY (`Customerid`) REFERENCES `Customer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vehicle`
--

LOCK TABLES `Vehicle` WRITE;
/*!40000 ALTER TABLE `Vehicle` DISABLE KEYS */;
INSERT INTO `Vehicle` VALUES ('AA69CPG','Fjord','Transit Van','1111','2222','white',1229371197),('BB19OLE','Rolls Royce','Silver Shadow','9182','1928','red',1229371200),('CT70DWR','Fjord','Transit Van','3333','4444','white',1229371197),('eu10jhy','ford','ford','ford','ford','red',1229371195),('FF71GHT','Fjord','Transit Van','5555','6666','white',1229371197),('GG14PUB','Fjord','Estate MK8','4321','8765','green',1229371199),('VV71BHN','Fjord','Transit Van','1234','5678','white',1229371197);
/*!40000 ALTER TABLE `Vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vehicle_Job`
--

DROP TABLE IF EXISTS `Vehicle_Job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Vehicle_Job` (
  `Vehiclereg_no` varchar(7) NOT NULL,
  `Jobid` varchar(255) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `date_booked` date NOT NULL,
  `employee_id` int(10) DEFAULT NULL,
  `MechanicUsersid` int(10) NOT NULL,
  `SparePartspart_code` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`Vehiclereg_no`,`Jobid`,`status`,`date_booked`),
  KEY `FKVehicle_Jo271353` (`Jobid`),
  KEY `FKVehicle_Jo842932` (`MechanicUsersid`),
  KEY `FKVehicle_Jo690580` (`SparePartspart_code`),
  CONSTRAINT `FKVehicle_Jo271353` FOREIGN KEY (`Jobid`) REFERENCES `Job` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKVehicle_Jo690580` FOREIGN KEY (`SparePartspart_code`) REFERENCES `SpareParts` (`part_code`) ON DELETE CASCADE,
  CONSTRAINT `FKVehicle_Jo842932` FOREIGN KEY (`MechanicUsersid`) REFERENCES `Mechanic` (`Usersid`) ON DELETE CASCADE,
  CONSTRAINT `FKVehicle_Jo877032` FOREIGN KEY (`Vehiclereg_no`) REFERENCES `Vehicle` (`reg_no`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vehicle_Job`
--

LOCK TABLES `Vehicle_Job` WRITE;
/*!40000 ALTER TABLE `Vehicle_Job` DISABLE KEYS */;
/*!40000 ALTER TABLE `Vehicle_Job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('dytu','dytu','Administrator',NULL),('vron','vron1','Receptionist','Veronica'),('Penelope','PinkMobile','Receptionist','Penelope Carr'),('Glynne','Gnasher','Franchisee','Glynne Lancaster'),('SYSDBA','Masterkey','Administrator','Administrator Role'),('Sunny','Attitude','Foreperson','Sunny Evans'),('Gavin','LondonWeight','Mechanic','Gavin Ross'),('Anthony','MelodyMan','Mechanic','Anthony Wild');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-14 10:25:38
