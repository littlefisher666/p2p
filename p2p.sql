-- MySQL dump 10.13  Distrib 5.7.3-m13, for Win32 (x86)
--
-- Host: localhost    Database: p2p
-- ------------------------------------------------------
-- Server version	5.7.3-m13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apply`
--

DROP TABLE IF EXISTS `apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply` (
  `applyId` int(11) NOT NULL AUTO_INCREMENT,
  `applyPerson` varchar(10) DEFAULT NULL,
  `applyPersonIDCard` varchar(10) DEFAULT NULL,
  `applyNum` int(11) DEFAULT '0',
  `applyDate` date DEFAULT NULL,
  `applyProductName` varchar(20) DEFAULT NULL,
  `applyProductId` int(11) DEFAULT NULL,
  `status` varchar(1) DEFAULT 'W',
  PRIMARY KEY (`applyId`),
  KEY `FK_APPLY_PRODUCT` (`applyProductId`),
  CONSTRAINT `FK_APPLY_PRODUCT` FOREIGN KEY (`applyProductId`) REFERENCES `product` (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply`
--

LOCK TABLES `apply` WRITE;
/*!40000 ALTER TABLE `apply` DISABLE KEYS */;
INSERT INTO `apply` VALUES (1,'123','123',123,'2015-03-18','苏科贷',1,'W'),(2,'123','123',200,'2015-03-26','南京银行',62,'W'),(3,'123123','123123',1231,'2015-03-26','南京银行',62,'W'),(4,'123','234',1,'2015-03-27','工商贷',61,'W'),(5,'123','234',1,'2015-03-27','工商贷',61,'W'),(6,'123','234',1,'2015-03-27','工商贷',61,NULL),(7,'','',NULL,'2015-03-27','工商贷',61,NULL),(8,'','',NULL,'2015-03-27','工商贷',61,NULL),(9,'1211','123123',14,'2015-03-27','低利率产品',3,'W'),(10,'1231','12341',21,'2015-03-27','低利率产品',3,'W'),(11,'','',0,'2015-03-27','低利率产品',3,'W'),(12,'','',0,'2015-03-27','低利率产品',3,'W'),(13,'','',0,'2015-03-27','低利率产品',3,'W'),(14,'','',0,'2015-03-27','苏科贷',1,'W'),(15,'123','123',123,'2015-03-27',NULL,1,'W'),(16,'123','123',123,'2015-03-27',NULL,1,'W'),(17,'123','123123123',0,'1970-01-01',NULL,1,'W'),(18,'123','123123123',0,'1970-01-01',NULL,1,'W'),(19,'123','123123123',0,'2015-03-27',NULL,1,'W'),(20,'','',0,'2015-03-27',NULL,1,'W');
/*!40000 ALTER TABLE `apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apply_status`
--

DROP TABLE IF EXISTS `apply_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply_status` (
  `apply_statusId` int(11) NOT NULL AUTO_INCREMENT,
  `apply_statusShortName` varchar(1) NOT NULL,
  `apply_statusMeaning` varchar(40) NOT NULL,
  PRIMARY KEY (`apply_statusId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply_status`
--

LOCK TABLES `apply_status` WRITE;
/*!40000 ALTER TABLE `apply_status` DISABLE KEYS */;
INSERT INTO `apply_status` VALUES (1,'P','passed'),(2,'R','refused'),(3,'W','wait to pass ; Default'),(4,'D','Deleted');
/*!40000 ALTER TABLE `apply_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `companyId` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(20) DEFAULT NULL,
  `financingInReturn` double DEFAULT NULL,
  `companyDetail` text,
  `status` varchar(1) DEFAULT 'W',
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'中国银行',2.2,'中国银行全称是中国银行股份有限公司（Bank of China Limited，简称BOC），\n总行(Head Office)位于北京复兴门内大街1号，是五大国有商业银行之一。\n中国银行的业务范围涵盖商业银行、投资银行、保险和航空租赁，旗下有中银香港、\n中银国际、中银保险等控股金融机构，在全球范围内为个人和公司客户提供金融服务。\n中国银行作为中国国际化和多元化程度最高的银行，在中国内地、香港、澳门、\n台湾及37个国家为客户提供全面的金融服务。主要经营商业银行业务，包括公司金融业务、\n个人金融业务和金融市场业务等多项业务。2013年7月，英国《银行家》（The Banker）\n杂志公布了2013年“全球1000家大银行”排名，位居第9位，与2012年排名一致。此外，\n世界品牌实验室发布2012年“中国500最具价值品牌”排名结果，中国银行以885.16亿元品牌价值排名第10位，\n较2011年排名上升1位，位居银行业第2位。','W'),(2,'南京银行',2,'','D');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_status`
--

DROP TABLE IF EXISTS `company_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_status` (
  `company_statusId` int(11) NOT NULL AUTO_INCREMENT,
  `company_statusShortName` varchar(1) NOT NULL,
  `company_statusMeaning` varchar(40) NOT NULL,
  PRIMARY KEY (`company_statusId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_status`
--

LOCK TABLES `company_status` WRITE;
/*!40000 ALTER TABLE `company_status` DISABLE KEYS */;
INSERT INTO `company_status` VALUES (1,'P','passed'),(2,'R','refused'),(3,'W','wait to pass ; Default'),(4,'D','Deleted');
/*!40000 ALTER TABLE `company_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lendingperiod`
--

DROP TABLE IF EXISTS `lendingperiod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lendingperiod` (
  `lendingPeriodId` int(11) NOT NULL AUTO_INCREMENT,
  `period` varchar(20) DEFAULT NULL,
  `status` varchar(1) DEFAULT 'C',
  PRIMARY KEY (`lendingPeriodId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lendingperiod`
--

LOCK TABLES `lendingperiod` WRITE;
/*!40000 ALTER TABLE `lendingperiod` DISABLE KEYS */;
INSERT INTO `lendingperiod` VALUES (1,'1','O'),(2,'3','C'),(3,'6','C'),(4,'12','C'),(5,'15','C');
/*!40000 ALTER TABLE `lendingperiod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lendingperiod_status`
--

DROP TABLE IF EXISTS `lendingperiod_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lendingperiod_status` (
  `lendingperiod_statusId` int(11) NOT NULL AUTO_INCREMENT,
  `lendingperiod_statusShortName` varchar(1) NOT NULL,
  `lendingperiod_statusMeaning` varchar(40) NOT NULL,
  PRIMARY KEY (`lendingperiod_statusId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lendingperiod_status`
--

LOCK TABLES `lendingperiod_status` WRITE;
/*!40000 ALTER TABLE `lendingperiod_status` DISABLE KEYS */;
INSERT INTO `lendingperiod_status` VALUES (1,'O','Open'),(2,'C','Closed ; Default'),(3,'D','Deleted');
/*!40000 ALTER TABLE `lendingperiod_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `newsId` int(11) NOT NULL AUTO_INCREMENT,
  `newsTitle` varchar(50) NOT NULL,
  `content` longtext NOT NULL,
  `createAt` date DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  `status` varchar(1) DEFAULT 'C',
  PRIMARY KEY (`newsId`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'中国银行晋级全球银行前十','中国银行在本年初，晋级全球银行前十行列','2008-08-09','c://','C'),(2,'123','abc','2015-03-17',NULL,'D'),(3,'3','abc',NULL,NULL,'C'),(4,'4','abc',NULL,NULL,'C'),(5,'5','abc',NULL,NULL,'C'),(6,'6','abc',NULL,NULL,'C'),(7,'7','abc',NULL,NULL,'C'),(8,'8','abc',NULL,NULL,'C'),(9,'9','abc',NULL,NULL,'C'),(10,'10','abc',NULL,NULL,'C'),(11,'11','abc',NULL,NULL,'C'),(12,'12','abc',NULL,NULL,'C'),(13,'13','abc',NULL,NULL,'C'),(14,'14','abc',NULL,NULL,'C'),(15,'15','abc',NULL,NULL,'C'),(16,'16','abc',NULL,NULL,'C'),(17,'17','abc',NULL,NULL,'C'),(18,'18','abc',NULL,NULL,'C'),(19,'19','abc',NULL,NULL,'C'),(20,'20','abc',NULL,NULL,'C'),(21,'21','abc',NULL,NULL,'C'),(22,'22','abc',NULL,NULL,'C'),(23,'23','abc',NULL,NULL,'C'),(24,'24','abc',NULL,NULL,'C'),(25,'25','abc',NULL,NULL,'C'),(26,'26','abc',NULL,NULL,'C'),(27,'27','abc',NULL,NULL,'C'),(28,'28','abc',NULL,NULL,'C'),(29,'29','abc',NULL,NULL,'C'),(30,'阿斯顿发送到发送到发送到','阿斯蒂芬阿斯顿法师打发士大夫大是大非阿斯顿发士大夫','2015-03-26',NULL,'C'),(34,'111','111','2015-04-02','1427951708287.jpg','C'),(35,'123','123','2015-04-02','1427951964539.jpg','C');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news_status`
--

DROP TABLE IF EXISTS `news_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news_status` (
  `news_statusId` int(11) NOT NULL AUTO_INCREMENT,
  `news_statusShortName` varchar(1) NOT NULL,
  `news_statusMeaning` varchar(40) NOT NULL,
  PRIMARY KEY (`news_statusId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news_status`
--

LOCK TABLES `news_status` WRITE;
/*!40000 ALTER TABLE `news_status` DISABLE KEYS */;
INSERT INTO `news_status` VALUES (1,'C','The current news ; Default'),(2,'F','The finished news'),(3,'D','Deleted');
/*!40000 ALTER TABLE `news_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(20) DEFAULT NULL,
  `primeLendingRateFrom` double DEFAULT NULL,
  `primeLendingRateTo` double DEFAULT NULL,
  `company` int(11) DEFAULT NULL,
  `financingAmountFrom` int(11) DEFAULT '0',
  `financingAmountTo` int(11) DEFAULT '0',
  `productType` int(11) DEFAULT NULL,
  `lendingPeriod` int(11) DEFAULT NULL,
  `linkMan` varchar(20) DEFAULT NULL,
  `ownedBank` varchar(20) DEFAULT NULL,
  `productDescription` text,
  `createTime` date DEFAULT NULL,
  `status` varchar(1) DEFAULT 'E',
  PRIMARY KEY (`productId`),
  KEY `FK_Pro_company` (`company`),
  KEY `FK_PRO_PROTYPE` (`productType`),
  KEY `FK_PRO_LEADINGPRI` (`lendingPeriod`),
  CONSTRAINT `FK_Pro_company` FOREIGN KEY (`company`) REFERENCES `company` (`companyId`),
  CONSTRAINT `FK_PRO_LEADINGPRI` FOREIGN KEY (`lendingPeriod`) REFERENCES `lendingperiod` (`lendingPeriodId`),
  CONSTRAINT `FK_PRO_PROTYPE` FOREIGN KEY (`productType`) REFERENCES `producttype` (`productTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'苏科贷',7,8,1,100,500,1,1,'张三','中国银行南京分行','银投联贷业务是指对于合作范围内的PE拟投或已投的科技型中小企业的借款申请，\n本行在综合考虑私募股权投资机构的投资管理能力和借款人未来发展前景等因素的基础上，\n以信用、股权质押、PE保证或类保证等方式，向科技型中小企业发放用于满足其日常经营资金需求的授信业务。','2008-08-09','E'),(2,'高利率产品',8,9,1,1000,2000,1,1,'李四','中国银行南京分行',NULL,NULL,'D'),(3,'低利率产品',8,9,1,200,300,1,1,'李四','中国银行南京分行',NULL,'2015-03-17','E'),(39,'4',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(40,'5',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(41,'6',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(42,'7',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(43,'8',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(44,'9',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(45,'10',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(46,'11',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(47,'12',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(48,'13',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(49,'14',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(50,'15',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(51,'16',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(52,'17',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(53,'18',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(54,'19',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(55,'20',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(56,'21',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(57,'22',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(58,'23',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(59,'24',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(60,'25',7,8,1,100,200,1,1,NULL,NULL,NULL,NULL,'E'),(61,'工商贷',15,16,1,2000,3000,6,5,'123','123',NULL,'2015-03-25','E'),(62,'南京银行',3,5,2,100,200,2,2,'123','123',NULL,'2015-03-26','E');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_status`
--

DROP TABLE IF EXISTS `product_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_status` (
  `product_statusId` int(11) NOT NULL AUTO_INCREMENT,
  `product_statusShortName` varchar(1) NOT NULL,
  `product_statusMeaning` varchar(40) NOT NULL,
  PRIMARY KEY (`product_statusId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_status`
--

LOCK TABLES `product_status` WRITE;
/*!40000 ALTER TABLE `product_status` DISABLE KEYS */;
INSERT INTO `product_status` VALUES (1,'E','The effective product ; Default'),(2,'I','The Invalid product'),(3,'D','Deleted');
/*!40000 ALTER TABLE `product_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producttype`
--

DROP TABLE IF EXISTS `producttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producttype` (
  `productTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `productTypeName` varchar(20) DEFAULT NULL,
  `status` varchar(1) DEFAULT 'C',
  PRIMARY KEY (`productTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producttype`
--

LOCK TABLES `producttype` WRITE;
/*!40000 ALTER TABLE `producttype` DISABLE KEYS */;
INSERT INTO `producttype` VALUES (1,'信用贷','O'),(2,'抵押贷','C'),(3,'质押贷','C'),(4,'担保贷','C'),(5,'票据贴现','C'),(6,'工商贷','C');
/*!40000 ALTER TABLE `producttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producttype_status`
--

DROP TABLE IF EXISTS `producttype_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producttype_status` (
  `productType_statusId` int(11) NOT NULL AUTO_INCREMENT,
  `productType_statusShortName` varchar(1) NOT NULL,
  `productType_statusMeaning` varchar(40) NOT NULL,
  PRIMARY KEY (`productType_statusId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producttype_status`
--

LOCK TABLES `producttype_status` WRITE;
/*!40000 ALTER TABLE `producttype_status` DISABLE KEYS */;
INSERT INTO `producttype_status` VALUES (1,'O','Open'),(2,'C','Closed ; Default'),(3,'D','Deleted');
/*!40000 ALTER TABLE `producttype_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sysuser`
--

DROP TABLE IF EXISTS `sysuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sysuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `loginName` varchar(20) NOT NULL,
  `loginPassword` varchar(64) NOT NULL,
  `status` varchar(1) DEFAULT 'O',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sysuser`
--

LOCK TABLES `sysuser` WRITE;
/*!40000 ALTER TABLE `sysuser` DISABLE KEYS */;
INSERT INTO `sysuser` VALUES (1,'superAdmin','itany','itany','O'),(2,'superAdmin','admin','admin','O'),(3,'张三','zhangsan','12345','O');
/*!40000 ALTER TABLE `sysuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sysuser_status`
--

DROP TABLE IF EXISTS `sysuser_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sysuser_status` (
  `sysuser_statusId` int(11) NOT NULL AUTO_INCREMENT,
  `sysuser_statusShortName` varchar(1) NOT NULL,
  `sysuser_statusMeaning` varchar(40) NOT NULL,
  PRIMARY KEY (`sysuser_statusId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sysuser_status`
--

LOCK TABLES `sysuser_status` WRITE;
/*!40000 ALTER TABLE `sysuser_status` DISABLE KEYS */;
INSERT INTO `sysuser_status` VALUES (1,'S','SuperAdministrator'),(2,'A','Administrator'),(3,'O','Ordinary Person ; Default'),(4,'D','Deleted');
/*!40000 ALTER TABLE `sysuser_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-02 14:05:08
