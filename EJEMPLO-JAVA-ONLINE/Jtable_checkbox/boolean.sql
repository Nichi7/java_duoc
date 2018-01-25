/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.1.9-MariaDB : Database - productos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE productos;

USE `productos`;

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `id_Producto` int(10) NOT NULL AUTO_INCREMENT,
  `nombre_prod` varchar(30) DEFAULT NULL,
  `precio` double(11,2) DEFAULT NULL,
  `marca` varchar(30) DEFAULT NULL,
  `activo` int(1) DEFAULT NULL,
  PRIMARY KEY (`id_Producto`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `producto` */

insert  into `producto`(`id_Producto`,`nombre_prod`,`precio`,`marca`,`activo`) values (1,'Leche Evaporada',3.00,'GLORIA S.A',0),(2,'Fideos delgados',3.00,'LAVAGI',1),(3,'Mermelada',1.00,'MOLITALIA S.A',1),(4,'Galletas',0.50,'QUAKER',1),(5,'Salsa de Tomate',2.00,'MOLITALIA S.A',1),(6,'Vinagre de Manzana',5.00,'KIKO S.A',1),(7,'Chocolate',2.00,'WONKA',1),(8,'Aceite de Cocina',4.00,'COCINERO',1),(9,'Arroz selecto',3.00,'SAN VICTORIO',1),(10,'Sillao',2.00,'KIKO S.A',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
