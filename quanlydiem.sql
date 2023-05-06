-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: quanlydiem
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `dang_ki_hoc`
--

DROP TABLE IF EXISTS `dang_ki_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dang_ki_hoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ghi_chu` varchar(255) DEFAULT NULL,
  `id_lopHocPhan` int DEFAULT NULL,
  `id_userKhoa` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_lopHocPhan` (`id_lopHocPhan`),
  KEY `id_userKhoa` (`id_userKhoa`),
  CONSTRAINT `dang_ki_hoc_ibfk_1` FOREIGN KEY (`id_lopHocPhan`) REFERENCES `lop_hoc_phan` (`id`),
  CONSTRAINT `dang_ki_hoc_ibfk_2` FOREIGN KEY (`id_userKhoa`) REFERENCES `users_khoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dang_ki_hoc`
--

LOCK TABLES `dang_ki_hoc` WRITE;
/*!40000 ALTER TABLE `dang_ki_hoc` DISABLE KEYS */;
INSERT INTO `dang_ki_hoc` VALUES (1,NULL,1,4);
/*!40000 ALTER TABLE `dang_ki_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dau_diem`
--

DROP TABLE IF EXISTS `dau_diem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dau_diem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dau_diem`
--

LOCK TABLES `dau_diem` WRITE;
/*!40000 ALTER TABLE `dau_diem` DISABLE KEYS */;
INSERT INTO `dau_diem` VALUES (1,'cc'),(2,'kt'),(3,'th'),(4,'bt'),(5,'thi');
/*!40000 ALTER TABLE `dau_diem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ket_qua`
--

DROP TABLE IF EXISTS `ket_qua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ket_qua` (
  `id` int NOT NULL AUTO_INCREMENT,
  `diem` float NOT NULL,
  `ghi_chu` varchar(255) DEFAULT NULL,
  `id_dangKiHoc` int DEFAULT NULL,
  `id_monHocDauDiem` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_dangKiHoc` (`id_dangKiHoc`),
  KEY `id_monHocDauDiem` (`id_monHocDauDiem`),
  CONSTRAINT `ket_qua_ibfk_1` FOREIGN KEY (`id_dangKiHoc`) REFERENCES `dang_ki_hoc` (`id`),
  CONSTRAINT `ket_qua_ibfk_2` FOREIGN KEY (`id_monHocDauDiem`) REFERENCES `monhoc_daudiem` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ket_qua`
--

LOCK TABLES `ket_qua` WRITE;
/*!40000 ALTER TABLE `ket_qua` DISABLE KEYS */;
INSERT INTO `ket_qua` VALUES (1,10,NULL,1,1),(2,9,NULL,1,2),(3,0,NULL,1,3),(4,5,NULL,1,4),(5,7,NULL,1,5);
/*!40000 ALTER TABLE `ket_qua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa`
--

DROP TABLE IF EXISTS `khoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa`
--

LOCK TABLES `khoa` WRITE;
/*!40000 ALTER TABLE `khoa` DISABLE KEYS */;
INSERT INTO `khoa` VALUES (1,'CNTT'),(2,'ATTT'),(3,'QTKD'),(4,'DTVT');
/*!40000 ALTER TABLE `khoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ki_hoc`
--

DROP TABLE IF EXISTS `ki_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ki_hoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) NOT NULL,
  `trang_thai` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ki_hoc`
--

LOCK TABLES `ki_hoc` WRITE;
/*!40000 ALTER TABLE `ki_hoc` DISABLE KEYS */;
INSERT INTO `ki_hoc` VALUES (1,'Học kì 1 - Năm học 2019-2020',0);
/*!40000 ALTER TABLE `ki_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop_hoc_phan`
--

DROP TABLE IF EXISTS `lop_hoc_phan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lop_hoc_phan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) NOT NULL,
  `siso_toida` int NOT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `id_monhocKihoc` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_monhocKihoc` (`id_monhocKihoc`),
  CONSTRAINT `lop_hoc_phan_ibfk_1` FOREIGN KEY (`id_monhocKihoc`) REFERENCES `monhoc_kihoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop_hoc_phan`
--

LOCK TABLES `lop_hoc_phan` WRITE;
/*!40000 ALTER TABLE `lop_hoc_phan` DISABLE KEYS */;
INSERT INTO `lop_hoc_phan` VALUES (1,'LHP-01',70,NULL,1),(2,'LHP-02',70,NULL,2),(3,'LHP-03',70,NULL,3),(4,'LHP-04',70,NULL,4);
/*!40000 ALTER TABLE `lop_hoc_phan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mon_hoc`
--

DROP TABLE IF EXISTS `mon_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mon_hoc` (
  `id` varchar(255) NOT NULL,
  `ten` varchar(255) NOT NULL,
  `so_tc` int NOT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon_hoc`
--

LOCK TABLES `mon_hoc` WRITE;
/*!40000 ALTER TABLE `mon_hoc` DISABLE KEYS */;
INSERT INTO `mon_hoc` VALUES ('BAS1150','Triết học Mác - Lênin',3,NULL),('BAS1201','Đại số',3,NULL),('BAS1203','Giải tích 1',3,NULL),('INT1154','Tin học cơ sở 1',2,NULL);
/*!40000 ALTER TABLE `mon_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc_daudiem`
--

DROP TABLE IF EXISTS `monhoc_daudiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhoc_daudiem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_monhoc` varchar(255) DEFAULT NULL,
  `id_daudiem` int DEFAULT NULL,
  `tile_phantram` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_monhoc` (`id_monhoc`),
  KEY `id_daudiem` (`id_daudiem`),
  CONSTRAINT `monhoc_daudiem_ibfk_1` FOREIGN KEY (`id_monhoc`) REFERENCES `mon_hoc` (`id`),
  CONSTRAINT `monhoc_daudiem_ibfk_2` FOREIGN KEY (`id_daudiem`) REFERENCES `dau_diem` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc_daudiem`
--

LOCK TABLES `monhoc_daudiem` WRITE;
/*!40000 ALTER TABLE `monhoc_daudiem` DISABLE KEYS */;
INSERT INTO `monhoc_daudiem` VALUES (1,'BAS1201',1,10),(2,'BAS1201',2,10),(3,'BAS1201',3,0),(4,'BAS1201',4,10),(5,'BAS1201',5,70),(6,'INT1154',1,10),(7,'INT1154',2,10),(8,'INT1154',3,0),(9,'INT1154',4,10),(10,'INT1154',5,70),(11,'BAS1203',1,10),(12,'BAS1203',2,10),(13,'BAS1203',3,0),(14,'BAS1203',4,10),(15,'BAS1203',5,70),(16,'BAS1150',1,10),(17,'BAS1150',2,20),(18,'BAS1150',3,0),(19,'BAS1150',4,0),(20,'BAS1150',5,70);
/*!40000 ALTER TABLE `monhoc_daudiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc_kihoc`
--

DROP TABLE IF EXISTS `monhoc_kihoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhoc_kihoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_monhoc` varchar(255) DEFAULT NULL,
  `id_kihoc` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_monhoc` (`id_monhoc`),
  KEY `id_kihoc` (`id_kihoc`),
  CONSTRAINT `monhoc_kihoc_ibfk_1` FOREIGN KEY (`id_monhoc`) REFERENCES `mon_hoc` (`id`),
  CONSTRAINT `monhoc_kihoc_ibfk_2` FOREIGN KEY (`id_kihoc`) REFERENCES `ki_hoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc_kihoc`
--

LOCK TABLES `monhoc_kihoc` WRITE;
/*!40000 ALTER TABLE `monhoc_kihoc` DISABLE KEYS */;
INSERT INTO `monhoc_kihoc` VALUES (1,'BAS1201',1),(2,'INT1154',1),(3,'BAS1203',1),(4,'BAS1150',1);
/*!40000 ALTER TABLE `monhoc_kihoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `point_board`
--

DROP TABLE IF EXISTS `point_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `point_board` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `subject_id` int NOT NULL,
  `attendance_point` double NOT NULL,
  `test_point` double NOT NULL,
  `practice_point` double NOT NULL,
  `exercise_point` double NOT NULL,
  `exam_point` double NOT NULL,
  `semester` varchar(45) NOT NULL DEFAULT 'HK1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `student_id_idx` (`student_id`),
  KEY `subject_id_idx` (`subject_id`),
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  CONSTRAINT `subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `point_board`
--

LOCK TABLES `point_board` WRITE;
/*!40000 ALTER TABLE `point_board` DISABLE KEYS */;
INSERT INTO `point_board` VALUES (1,1,1,6,6,6,6,6,'HK1'),(2,2,1,8,10,8,9,6.5,'HK1');
/*!40000 ALTER TABLE `point_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` int NOT NULL,
  `msv` varchar(45) NOT NULL,
  `full_name` varchar(45) NOT NULL,
  `school_year` varchar(45) NOT NULL DEFAULT 'D19',
  `majors` varchar(45) NOT NULL DEFAULT 'CNTT',
  `class` varchar(45) NOT NULL DEFAULT 'CN6',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `msv_UNIQUE` (`msv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'B19DCCN558','Nguyễn Văn Sơn','D19','CNTT','CN6'),(2,'B19DCCN559','Chu Văn Sơn','D19','CNTT','CN6'),(3,'B19DDCn560','Chu Văn A','D19','ATTT','CN7');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `id` int NOT NULL,
  `subject_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `subject_name_UNIQUE` (`subject_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'Kiểm thử');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(50) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phone_number` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `role` varchar(50) NOT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'administrator','FJ89vdp5IEi4I5iBo8RqmQ==','Phạm','Thanh Sơn','Thanh Xuân','0987123123','admin@gmail.com','','admin',22),(10,'teacher01','SII/smFko94JRxk1OKEpwA==','Trần','Đức Long','Hà Nội','0987732132','longtd@gmail.com','','teacher',23),(11,'teacher02','4sb9E16XsndPUQ1fS/FVUQ==','Nguyễn','Hải Anh','Thanh Xuân','0987896752','Anhnh@gmail.com','','teacher',20),(12,'student01','Zu4GXn8K+UuAihD5siTqPQ==','Nguyễn','Hải Nam','Thanh Xuân','0987893212','Namnh@gmail.com','','student',20),(13,'student02','hBTULuTU84cw7+TLlbPfiw==','Nguyễn','Trường Giang','Thanh Xuân','0987893301','Giangnt@gmail.com','','student',20),(14,'student03','nHDOdMXdar78HnmZa52ySg==','Nguyễn','Hoàng Kiên','Thanh Xuân','0987893097','Kiennh@gmail.com','','student',20),(15,'manager01','gD0SlJJvt8DDCuTM6evL/g==','Trần','Trung Hiếu','Thanh Xuân','0987893123','Hieutt@gmail.com','','manager',20),(24,'manager04','NjLp6+Xu5tG6xVkIG/7S5A==','Vu','Quan LOL','Ha noi','0987654321','u73irwfx@duck.com','das','teacher',13),(27,'phiminhquang32','0SO2PNWieAzxEKdFYrp2OA==','abc123','quang','dahsjdkhas','1234567890','phiminhquang@gmail.com','adssda','manager',18),(32,'manager00','wzbiFC5cZLWEwFgrfrsQnA==','Pham','Thanh Son','Ha Dong','0862045324','admin@gmail.com','','manager',19);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_khoa`
--

DROP TABLE IF EXISTS `users_khoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_khoa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `khoa_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `khoa_id` (`khoa_id`),
  CONSTRAINT `users_khoa_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `users_khoa_ibfk_2` FOREIGN KEY (`khoa_id`) REFERENCES `khoa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_khoa`
--

LOCK TABLES `users_khoa` WRITE;
/*!40000 ALTER TABLE `users_khoa` DISABLE KEYS */;
INSERT INTO `users_khoa` VALUES (1,2,1),(2,14,1),(3,13,2),(4,12,3);
/*!40000 ALTER TABLE `users_khoa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-06 23:07:37
