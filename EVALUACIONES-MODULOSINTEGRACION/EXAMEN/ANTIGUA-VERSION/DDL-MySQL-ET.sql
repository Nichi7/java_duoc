CREATE TABLE IF NOT EXISTS `Producto` (
  `pr_id` INT NOT NULL COMMENT '',
  `pr_nombre` VARCHAR(45) NULL COMMENT '',
  `pr_moneda` VARCHAR(45) NULL COMMENT '',
  `pr_valormoneda` DECIMAL(5,2) NULL COMMENT '',
  PRIMARY KEY (`pr_id`)  COMMENT '')
ENGINE = InnoDB;