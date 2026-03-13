CREATE DATABASE  IF NOT EXISTS `petrescueprogram` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `petrescueprogram`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: petrescueprogram
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pets`
--

DROP TABLE IF EXISTS `pets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `owner` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pets`
--

LOCK TABLES `pets` WRITE;
/*!40000 ALTER TABLE `pets` DISABLE KEYS */;
INSERT INTO `pets` VALUES (1,'小花','12',2,'猫','阿拉斯加','2023-01-02','小明','漂亮的','1'),(2,'小雷','15',3,'狗','泰迪','2022-01-01','小明','好看的','2'),(3,'小米','13',5,'猫','胖橘','2022-01-03','小明','没毛病的','3'),(4,'小修','16',4,'狗','杜宾','2022-01-06','小明','健康的','4'),(5,'小七','15',2,'猫','胖橘','2021-01-04','小明','强壮的','5'),(6,'小智','16',4,'猫','加菲','2011-02-05','小李','有灵魂的','6'),(7,'小妮','16',2,'狗','大黄','2014-05-04','小李','有公信力的','7'),(8,'小兵','14',3,'狗','田园','2022-06-01','小李','生命力顽强的','8'),(9,'小宁','15',1,'狗','金毛','2022-06-05','小李','不服输的','9'),(10,'小蜜','15',2,'猫','胖橘','2022-04-01','小明','桀骜不驯的','10'),(11,'小虎','20',3,'猫','加菲','2022-05-08','小明','有智慧的','11'),(12,'小六','15',5,'狗','哈士奇','2022-07-05','小芳','自信的','12'),(13,'小辉','12',2,'猫','无毛','2022-08-09','小芳','强大的','13');
/*!40000 ALTER TABLE `pets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-14  0:46:36
