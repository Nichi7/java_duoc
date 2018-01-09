-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.2.10-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para video
CREATE DATABASE IF NOT EXISTS `video` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `video`;

-- Volcando estructura para tabla video.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla video.categoria: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id`, `descripcion`) VALUES
	(-1, 'Seleccione'),
	(1, 'Accion'),
	(2, 'Romance'),
	(3, 'Terror'),
	(4, 'Comedia'),
	(10, 'Futuro');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Volcando estructura para tabla video.pelicula
CREATE TABLE IF NOT EXISTS `pelicula` (
  `codigo` int(11) NOT NULL,
  `precio` int(11) DEFAULT NULL,
  `categoria` int(11) DEFAULT NULL,
  `formato4k` varchar(1) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `pelicula_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla video.pelicula: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` (`codigo`, `precio`, `categoria`, `formato4k`, `nombre`) VALUES
	(10001, 0, 3, NULL, NULL),
	(70000, 5000, 4, 'S', 'soldador ryan');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
