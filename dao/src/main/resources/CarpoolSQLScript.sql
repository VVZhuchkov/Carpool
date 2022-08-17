-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema carpool
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema carpool
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carpool` DEFAULT CHARACTER SET utf8mb3 ;
USE `carpool` ;

-- -----------------------------------------------------
-- Table `carpool`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carpool`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `role_UNIQUE` (`role` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `carpool`.`auth_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carpool`.`auth_users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_auth_users_roles1_idx` (`roles_id` ASC) VISIBLE,
  CONSTRAINT `fk_auth_users_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `carpool`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `carpool`.`cars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carpool`.`cars` (
  `id-cars` INT NOT NULL AUTO_INCREMENT,
  `reg-number` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `max-load` FLOAT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id-cars`),
  UNIQUE INDEX `idcars_UNIQUE` (`id-cars` ASC) VISIBLE,
  UNIQUE INDEX `reg-number_UNIQUE` (`reg-number` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `carpool`.`positions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carpool`.`positions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `position` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `carpool`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carpool`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `middle_name` VARCHAR(45) NULL DEFAULT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `gender` ENUM('MALE', 'FEMALE', 'UNDEFINED') NOT NULL,
  `birth_date` DATE NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `positions_id` INT NOT NULL,
  `auth_users_id` INT NOT NULL,
  PRIMARY KEY (`id`, `auth_users_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_users_positions1_idx` (`positions_id` ASC) VISIBLE,
  INDEX `fk_users_auth_users1_idx` (`auth_users_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_positions1`
    FOREIGN KEY (`positions_id`)
    REFERENCES `carpool`.`positions` (`id`),
  CONSTRAINT `fk_users_auth_users1`
    FOREIGN KEY (`auth_users_id`)
    REFERENCES `carpool`.`auth_users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `carpool`.`drivers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carpool`.`drivers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `license` VARCHAR(45) NOT NULL,
  `issue-date` DATETIME NOT NULL,
  `end-date` DATETIME NOT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`, `users_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_drivers_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_drivers_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `carpool`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `carpool`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carpool`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start-date` DATETIME NOT NULL,
  `end-date` DATETIME NOT NULL,
  `from` VARCHAR(45) NOT NULL,
  `to` VARCHAR(45) NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  `weight` VARCHAR(45) NOT NULL,
  `comment` VARCHAR(200) NULL DEFAULT NULL,
  `status` VARCHAR(45) NOT NULL,
  `cars_id-cars` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_order_cars1_idx` (`cars_id-cars` ASC) VISIBLE,
  CONSTRAINT `fk_order_cars1`
    FOREIGN KEY (`cars_id-cars`)
    REFERENCES `carpool`.`cars` (`id-cars`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `carpool`.`drivers_has_cars1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carpool`.`drivers_has_cars1` (
  `drivers_id` INT NOT NULL,
  `cars_id-cars` INT NOT NULL,
  `start_operation` DATE NOT NULL,
  `end_operation` DATE NOT NULL,
  PRIMARY KEY (`drivers_id`, `cars_id-cars`),
  INDEX `fk_drivers_has_cars1_cars1_idx` (`cars_id-cars` ASC) VISIBLE,
  INDEX `fk_drivers_has_cars1_drivers1_idx` (`drivers_id` ASC) VISIBLE,
  CONSTRAINT `fk_drivers_has_cars1_drivers1`
    FOREIGN KEY (`drivers_id`)
    REFERENCES `carpool`.`drivers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_drivers_has_cars1_cars1`
    FOREIGN KEY (`cars_id-cars`)
    REFERENCES `carpool`.`cars` (`id-cars`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
