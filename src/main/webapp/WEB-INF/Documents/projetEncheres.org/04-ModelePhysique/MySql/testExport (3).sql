-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: encheres
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
-- Table structure for table `articles_vendus`
--

DROP TABLE IF EXISTS `articles_vendus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articles_vendus` (
  `no_article` int NOT NULL AUTO_INCREMENT,
  `nom_article` varchar(30) NOT NULL,
  `description` varchar(300) NOT NULL,
  `date_debut_encheres` date NOT NULL,
  `date_fin_encheres` date NOT NULL,
  `prix_initial` int DEFAULT NULL,
  `prix_vente` int DEFAULT NULL,
  `no_utilisateur` int NOT NULL,
  `no_categorie` int NOT NULL,
  `no_acquereur` int DEFAULT NULL,
  PRIMARY KEY (`no_article`),
  KEY `articles_vendus_categories_fk_idx` (`no_categorie`),
  KEY `ventes_utilisateur_fk_idx` (`no_utilisateur`),
  CONSTRAINT `articles_vendus_categories_fk` FOREIGN KEY (`no_categorie`) REFERENCES `categories` (`no_categorie`),
  CONSTRAINT `ventes_utilisateur_fk` FOREIGN KEY (`no_utilisateur`) REFERENCES `utilisateurs` (`no_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles_vendus`
--

LOCK TABLES `articles_vendus` WRITE;
/*!40000 ALTER TABLE `articles_vendus` DISABLE KEYS */;
INSERT INTO `articles_vendus` VALUES (10,'casque corsaire','casque corsaire en très bon état. il a beaucoup servi donc une mousse se décolle un peu mais sinon RAS prix neuf 200€','2023-03-27','2023-03-28',50,55,24,9,2),(11,'carte magic','collection de 3600 cartes du jeu magic the gathering toutes en tres bon etat','2023-03-27','2023-04-09',2000,2012,2,6,NULL),(14,'tasse','tasse a café','2023-03-27','2023-03-28',10,150,2,3,24),(15,'figurine pop','figurine pop a l\'effigie de tangiro','2023-03-28','2023-03-28',10,11,24,6,2),(16,'bouteil de vodka a l\'eau','doucement et lentement melanger avec un chouille de citron fait par le celebre barista \"EL MATHIEU PERIN\"','2023-03-28','2023-03-28',10,60,2,10,24),(17,'hind','jeune développeuse bourré de talent , en recherche de défis informatiques','2023-03-27','2023-03-28',500,600,24,9,2),(18,'mathieu ','THOUMIR OU PERIN QUI SAIT','2023-03-27','2023-03-28',200,300,2,7,24),(21,'thierry','le meilleur porgrammeur et prof du monde on taime thierry','2023-03-27','2023-03-28',300,400,24,2,2),(22,'cadre akatsuki perso ','desole bebou on m\'a forcé (c\'est la faute de hind elle habite a paris)','2023-03-27','2023-03-28',600,611,28,8,24),(23,'plopinousama','poloplpopllopp','2023-03-29','2023-04-07',200,300,28,11,NULL),(24,'test ouverture ok','le test ultime','2023-03-31','2023-04-06',1,1,2,11,NULL);
/*!40000 ALTER TABLE `articles_vendus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `no_categorie` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(30) NOT NULL,
  PRIMARY KEY (`no_categorie`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Hygiène et Santé'),(2,'Animalerie'),(3,'Maison'),(4,'Jardin'),(5,'Sports et Loisirs'),(6,'Jeux et Jouets'),(7,'Bricolage'),(8,'Mode'),(9,'High-Tech'),(10,'Vehicules'),(11,'Autres');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encheres`
--

DROP TABLE IF EXISTS `encheres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `encheres` (
  `no_enchere` int NOT NULL AUTO_INCREMENT,
  `date_enchere` datetime NOT NULL,
  `montant_enchere` int NOT NULL,
  `no_article` int NOT NULL,
  `no_utilisateur` int NOT NULL,
  PRIMARY KEY (`no_enchere`),
  KEY `encheres_utilisateur_fk_idx` (`no_utilisateur`),
  KEY `encheres_no_article_fk_idx` (`no_article`),
  CONSTRAINT `encheres_no_article_fk` FOREIGN KEY (`no_article`) REFERENCES `articles_vendus` (`no_article`),
  CONSTRAINT `encheres_utilisateur_fk` FOREIGN KEY (`no_utilisateur`) REFERENCES `utilisateurs` (`no_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encheres`
--

LOCK TABLES `encheres` WRITE;
/*!40000 ALTER TABLE `encheres` DISABLE KEYS */;
INSERT INTO `encheres` VALUES (1,'2023-03-28 00:00:00',20,14,2),(2,'2023-03-28 00:00:00',24,14,2),(3,'2023-03-28 00:00:00',25,14,2),(4,'2023-03-28 00:00:00',26,14,2),(5,'2023-03-28 00:00:00',28,14,2),(6,'2023-03-28 00:00:00',31,14,2),(7,'2023-03-28 00:00:00',100,14,2),(8,'2023-03-28 00:00:00',101,14,2),(9,'2023-03-28 00:00:00',102,14,24),(10,'2023-03-28 00:00:00',103,14,2),(11,'2023-03-28 00:00:00',104,14,24),(12,'2023-03-28 00:00:00',105,14,2),(13,'2023-03-28 00:00:00',106,14,24),(14,'2023-03-28 00:00:00',107,14,2),(15,'2023-03-28 00:00:00',11,15,2),(16,'2023-03-27 00:00:00',55,10,2),(17,'2023-03-28 00:00:00',150,14,24),(18,'2023-03-29 00:00:00',50,16,24),(19,'2023-03-29 00:00:00',55,16,2),(20,'2023-03-29 00:00:00',60,16,24),(21,'2023-03-29 00:00:00',600,17,2),(22,'2023-03-29 00:00:00',300,18,24),(23,'2023-03-29 00:00:00',400,21,2),(24,'2023-03-29 00:00:00',611,22,24),(25,'2023-03-30 00:00:00',300,23,2),(26,'2023-03-30 00:00:00',2012,11,28);
/*!40000 ALTER TABLE `encheres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retraits`
--

DROP TABLE IF EXISTS `retraits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `retraits` (
  `no_article` int NOT NULL,
  `rue` varchar(30) NOT NULL,
  `code_postal` varchar(15) NOT NULL,
  `ville` varchar(30) NOT NULL,
  PRIMARY KEY (`no_article`),
  CONSTRAINT `retrait_article_fk` FOREIGN KEY (`no_article`) REFERENCES `articles_vendus` (`no_article`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retraits`
--

LOCK TABLES `retraits` WRITE;
/*!40000 ALTER TABLE `retraits` DISABLE KEYS */;
INSERT INTO `retraits` VALUES (10,'4 place président carnot','38300','Bourgoin-Jallieu'),(11,'4 place president carnot','38300','bourgoin-jallieu'),(14,'4 place president carnot','38300','bourgoin-jallieu'),(15,'rue du sac','38300','Bourgoin-Jallieu'),(16,'4 place president carnot','38300','bourgoin-jallieu'),(17,'rue du sac','38300','Bourgoin-Jallieu'),(18,'4 place president carnot','38300','bourgoin-jallieu'),(21,'rue des grévistes','99998','greveLand'),(22,'chateau de Gamon','55555','hyruleCite'),(23,'chateau de Gamon','55555','hyruleCite'),(24,'4 place president carnot','38300','bourgoin-jallieu');
/*!40000 ALTER TABLE `retraits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateurs` (
  `no_utilisateur` int NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `rue` varchar(30) NOT NULL,
  `code_postal` varchar(10) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `mot_de_passe` varchar(50) NOT NULL,
  `credit` int NOT NULL,
  `administrateur` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`no_utilisateur`),
  UNIQUE KEY `no_utilisateur_UNIQUE` (`no_utilisateur`),
  UNIQUE KEY `pseudo_UNIQUE` (`pseudo`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateurs`
--

LOCK TABLES `utilisateurs` WRITE;
/*!40000 ALTER TABLE `utilisateurs` DISABLE KEYS */;
INSERT INTO `utilisateurs` VALUES (2,'MFail4562','PERIN','Mathieu','mathieu.perin2022@campus-eni.fr','','4 place president carnot','38300','bourgoin-jallieu','7110eda4d09e062aa5e4a390b0a572ac0d2c0220',9700,_binary ''),(3,'Chou','THOUMIRE','Mathieu','mathieu.thoumire2022@campus-eni.fr','0203010508','2 place des accacias','76200','Dieppe','7110eda4d09e062aa5e4a390b0a572ac0d2c0220',100,_binary ''),(4,'AppleGirl','PERCHERANCIER','Audrey','audrey.percherancier2022@campus-eni.fr','0102030405','18 place de chateau-fort','45258','New-York','7110eda4d09e062aa5e4a390b0a572ac0d2c0220',100,_binary ''),(5,'DoubleGirl','EL_MOUTAWAKIL','Hind','hind.elmoutawakil2022@campus-eni.fr','0905040203','7 place des haricotes volants','85456','Tahiti','7110eda4d09e062aa5e4a390b0a572ac0d2c0220',100,_binary ''),(24,'grimoire','CHATPKA','Yuumi','yuumiLeChat@miaou.fr','','rue du sac','38300','Bourgoin-Jallieu','608c176b0dc047d49bcbc5e55777d177f75485b2',989,_binary '\0'),(27,'plop','PLOP','plop','plop@plop.plop','','plop','01000','plop','plop',100,_binary '\0'),(28,'legend','LINK','Zelda','jeSuiszeldaLeHero@deLaSaga.Hyrule','','chateau de Gamon','55555','hyruleCite','1da44d8fe52eb99bd876494fff7918fd976a2f49',1754,_binary '\0');
/*!40000 ALTER TABLE `utilisateurs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-30 16:46:37
