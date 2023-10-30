-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-10-2023 a las 00:38:52
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cuartel27`
--
CREATE DATABASE IF NOT EXISTS `cuartel27` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE `cuartel27`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bombero`
--

CREATE TABLE `bombero` (
  `codBombero` int(11) NOT NULL,
  `dni` varchar(11) NOT NULL,
  `nombreCompleto` varchar(100) NOT NULL,
  `grupoSanguineo` varchar(25) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `telCelular` varchar(25) NOT NULL,
  `codBrigada` int(11) NOT NULL,
  `estadoBombero` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `bombero`
--

INSERT INTO `bombero` (`codBombero`, `dni`, `nombreCompleto`, `grupoSanguineo`, `fechaNacimiento`, `telCelular`, `codBrigada`, `estadoBombero`) VALUES
(2, '01020304', 'Rodriguez, Pedro', 'A (+)', '1981-01-31', '000-1111', 1, 1),
(3, '01020702', 'Perez,Diego', '0 (+)', '2010-10-05', '000-2222', 1, 1),
(5, '01020803', 'Gonzalez,Hector', '0(-)', '1995-06-03', '000-3333', 1, 1),
(6, '01020333', 'Gefco,German', 'A(+)', '1988-04-15', '000-4444', 3, 1),
(7, '01020123', 'Riquelme,Fabian', 'AB(+)', '1988-04-15', '000-5555', 1, 1),
(8, '01020888', 'Jofre,Ricardo', 'B(+)', '1970-05-21', '000-6666', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brigada`
--

CREATE TABLE `brigada` (
  `codBrigada` int(11) NOT NULL,
  `nombreClave` varchar(60) NOT NULL,
  `especialidad` varchar(60) NOT NULL,
  `codCuartel` int(11) NOT NULL,
  `estadoBrigada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `brigada`
--

INSERT INTO `brigada` (`codBrigada`, `nombreClave`, `especialidad`, `codCuartel`, `estadoBrigada`) VALUES
(1, 'Brigada Alfa', 'Rescate en altura', 6, 1),
(2, 'Brigada Beta', 'Rescate en altura', 7, 1),
(3, 'Brigada Gamma', 'Inundaciones', 7, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuartel`
--

CREATE TABLE `cuartel` (
  `codCuartel` int(11) NOT NULL,
  `nombreCuartel` varchar(60) NOT NULL,
  `direccion` double NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `mail` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `cuartel`
--

INSERT INTO `cuartel` (`codCuartel`, `nombreCuartel`, `direccion`, `telefono`, `mail`) VALUES
(6, 'CuartelUno', 5.1, '000-222222', 'cuarteluno@cuartel27.com'),
(7, 'CuartelDos', 1.2, '000-333333', 'cuarteldos@cuartel27.com'),
(8, 'CuartelDos', 5.6, '000-333333', 'cuarteldos@cuartel27.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `siniestro`
--

CREATE TABLE `siniestro` (
  `codSiniestro` int(11) NOT NULL,
  `direccionSiniestro` double NOT NULL,
  `fechaSiniestro` date NOT NULL,
  `hora` time NOT NULL,
  `tipo` varchar(60) NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `fechaResolucion` date NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `codBrigada` int(11) NOT NULL,
  `estadoSiniestro` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `siniestro`
--

INSERT INTO `siniestro` (`codSiniestro`, `direccionSiniestro`, `fechaSiniestro`, `hora`, `tipo`, `detalle`, `fechaResolucion`, `puntuacion`, `codBrigada`, `estadoSiniestro`) VALUES
(1, 7.3, '2006-06-04', '14:28:48', 'Incendio', 'Incendio complejo viviendas', '2006-06-05', 9, 1, 1),
(2, 5.2, '2006-07-03', '14:37:36', 'Accidente', 'Accidente en altura', '2006-07-04', 9, 1, 0),
(3, 10.4, '2007-03-05', '14:43:30', 'Rescate', 'Rescate en rio', '2007-03-02', 8, 1, 1),
(4, 4.3, '2008-01-05', '18:33:57', 'Inundacion', 'Inundacion de calles', '2008-01-02', 10, 1, 1),
(9, 9.3, '2009-01-07', '21:11:05', 'Deceso', 'Deceso en vias de tren', '2009-01-06', 8, 1, 1),
(10, 4.9, '2023-10-25', '21:01:06', 'ACV', 'ACV en via publica', '2023-10-25', 8, 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD PRIMARY KEY (`codBombero`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `codBrigada` (`codBrigada`);

--
-- Indices de la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD PRIMARY KEY (`codBrigada`),
  ADD UNIQUE KEY `nombreClave` (`nombreClave`),
  ADD KEY `codCuartel` (`codCuartel`);

--
-- Indices de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  ADD PRIMARY KEY (`codCuartel`);

--
-- Indices de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD PRIMARY KEY (`codSiniestro`),
  ADD KEY `codBrigada` (`codBrigada`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bombero`
--
ALTER TABLE `bombero`
  MODIFY `codBombero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `brigada`
--
ALTER TABLE `brigada`
  MODIFY `codBrigada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  MODIFY `codCuartel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  MODIFY `codSiniestro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD CONSTRAINT `bombero_ibfk_1` FOREIGN KEY (`codBrigada`) REFERENCES `brigada` (`codBrigada`);

--
-- Filtros para la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD CONSTRAINT `brigada_ibfk_1` FOREIGN KEY (`codCuartel`) REFERENCES `cuartel` (`codCuartel`);

--
-- Filtros para la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD CONSTRAINT `siniestro_ibfk_1` FOREIGN KEY (`codBrigada`) REFERENCES `brigada` (`codBrigada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
