CREATE DATABASE IF NOT EXISTS `db_senac`;

DROP TABLE IF EXISTS `db_senac`.`tbl_senac`;

CREATE TABLE `db_senac`.`tbl_senac` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

LOCK TABLES `db_senac`.`tbl_senac` WRITE;

INSERT INTO `db_senac`.`tbl_senac` 
  VALUES 
    (1,'Alexk sandro','alexks@andro.com','123456','caozinho-aleatorio.jpg'),
    (5,'Aldo','tio@ldo.com','654987',NULL),
    (12,'Anderson','neo@matrix.com','1593547',NULL),
    (15,'rodrigo','rodrigo@rodrigo.rodrigo','rodrigo',NULL),
    (16,'rodrigo','rodrigo','rodrigo',NULL),
    (17,'teste','teste','teste',NULL);
UNLOCK TABLES;
