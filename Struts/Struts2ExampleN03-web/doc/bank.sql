SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `bank` ;
CREATE SCHEMA IF NOT EXISTS `bank` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `bank` ;

-- -----------------------------------------------------
-- Table `bank`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bank`.`person` ;

CREATE  TABLE IF NOT EXISTS `bank`.`person` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `first_name` VARCHAR(100) NOT NULL ,
  `last_name` VARCHAR(100) NOT NULL ,
  `birth_date` DATE NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bank`.`account` ;

CREATE  TABLE IF NOT EXISTS `bank`.`account` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `owner` BIGINT(20) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `FK_Person` (`owner` ASC) ,
  CONSTRAINT `FK_Person`
    FOREIGN KEY (`owner` )
    REFERENCES `bank`.`person` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`transfer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bank`.`transfer` ;

CREATE  TABLE IF NOT EXISTS `bank`.`transfer` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `senders_account` BIGINT(20) NOT NULL ,
  `recievers_account` BIGINT(20) NOT NULL ,
  `amount` DECIMAL(10,2) NOT NULL ,
  `comment` VARCHAR(1000) NOT NULL DEFAULT 'Платеж в пользу физического лица' ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `FK_senders_account` (`senders_account` ASC) ,
  INDEX `FK_recievers_account` (`recievers_account` ASC) ,
  CONSTRAINT `FK_senders_account`
    FOREIGN KEY (`senders_account` )
    REFERENCES `bank`.`account` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_recievers_account`
    FOREIGN KEY (`recievers_account` )
    REFERENCES `bank`.`account` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `bank`.`person`
-- -----------------------------------------------------
START TRANSACTION;
USE `bank`;
INSERT INTO `bank`.`person` (`id`, `first_name`, `last_name`, `birth_date`) VALUES (NULL, 'Ivan', 'Ivanov', '1985-01-01');
INSERT INTO `bank`.`person` (`id`, `first_name`, `last_name`, `birth_date`) VALUES (NULL, 'Petr', 'Petrov', '1980-02-03');
INSERT INTO `bank`.`person` (`id`, `first_name`, `last_name`, `birth_date`) VALUES (NULL, 'Sidor', 'Sidorov', '1993-04-12');

COMMIT;

-- -----------------------------------------------------
-- Data for table `bank`.`account`
-- -----------------------------------------------------
START TRANSACTION;
USE `bank`;
INSERT INTO `bank`.`account` (`id`, `owner`) VALUES (NULL, 1);
INSERT INTO `bank`.`account` (`id`, `owner`) VALUES (NULL, 1);
INSERT INTO `bank`.`account` (`id`, `owner`) VALUES (NULL, 1);
INSERT INTO `bank`.`account` (`id`, `owner`) VALUES (NULL, 2);
INSERT INTO `bank`.`account` (`id`, `owner`) VALUES (NULL, 2);
INSERT INTO `bank`.`account` (`id`, `owner`) VALUES (NULL, 3);

COMMIT;

-- -----------------------------------------------------
-- Data for table `bank`.`transfer`
-- -----------------------------------------------------
START TRANSACTION;
USE `bank`;
INSERT INTO `bank`.`transfer` (`id`, `senders_account`, `recievers_account`, `amount`, `comment`) VALUES (NULL, 1, 4, 100, 'Долг за пиво');
INSERT INTO `bank`.`transfer` (`id`, `senders_account`, `recievers_account`, `amount`, `comment`) VALUES (NULL, 6, 3, 29000.01, 'Оплата квартиры за вычетом коммунальных платежей');

COMMIT;
