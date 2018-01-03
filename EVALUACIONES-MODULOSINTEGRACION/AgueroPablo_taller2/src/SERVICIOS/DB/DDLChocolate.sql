/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Leo
 * Created: 03-12-2017
 */

/*CREAR ESQUENA MYSQL llamado 'corfoDuoc'    ojo:distingue mayusculasMinusculas
*/

DROP TABLE chocolates;
CREATE TABLE `chocolate` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `precioventa` varchar(45) NULL,
  `cantidad` int(11) NULL,
  `tipocolor` varchar(11) NULL,
  `tiposabor` varchar(45) NULL,
  `marca` varchar(45) NULL,
  `azucar` tiny() NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into chocolate values ('1', 'Chocolate uno' , 'Cuadrado', '100', '10', 'Negro', 'Manjar', 'Choco', true);
insert into chocolate values ('2', 'Chocolate dos' , 'Rectangular', '200', '20', 'Blanco','Frutilla', 'Late', true);
insert into chocolate values ('3', 'Chocolate tres', 'Huevo', '300', '30', 'Negro', 'Almendras', 'Fruna', false);

select * from chocolate;


