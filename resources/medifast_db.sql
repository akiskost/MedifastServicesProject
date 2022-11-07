-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema patientsdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema patientsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `patientsdb` DEFAULT CHARACTER SET utf8mb3 ;
USE `patientsdb` ;

-- -----------------------------------------------------
-- Table `patientsdb`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patientsdb`.`departments` (
  `DEPID` INT NOT NULL,
  `DEP_NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`DEPID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patientsdb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patientsdb`.`users` (
  `UID` INT NOT NULL AUTO_INCREMENT,
  `EMAIL` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  `FNAME` VARCHAR(45) NOT NULL,
  `LNAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UID`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patientsdb`.`doctors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patientsdb`.`doctors` (
  `DID` INT NOT NULL AUTO_INCREMENT COMMENT 'THe ID of the CCoctor - Surrogate Key',
  `UID` INT NOT NULL,
  `SPECIALTY` VARCHAR(45) NOT NULL,
  `ADDRESS` VARCHAR(45) NOT NULL,
  `PHONENUMBER` VARCHAR(45) NOT NULL,
  `DEP_ID` INT NOT NULL,
  PRIMARY KEY (`DID`),
  INDEX `UID_FK_idx` (`UID` ASC) VISIBLE,
  INDEX `DEPID_FK_idx` (`DEP_ID` ASC) VISIBLE,
  INDEX `DEPARTID_FK_idx` (`DEP_ID` ASC) VISIBLE,
  CONSTRAINT `DEPID_DOCTOR_FK`
    FOREIGN KEY (`DEP_ID`)
    REFERENCES `patientsdb`.`departments` (`DEPID`),
  CONSTRAINT `UID_DOCTOR_FK`
    FOREIGN KEY (`UID`)
    REFERENCES `patientsdb`.`users` (`UID`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patientsdb`.`exams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patientsdb`.`exams` (
  `EID` INT NOT NULL,
  `EXAM_NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`EID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patientsdb`.`patients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patientsdb`.`patients` (
  `PID` INT NOT NULL COMMENT 'The id of the patient',
  `LNAME` VARCHAR(45) NOT NULL COMMENT 'The last name of the patient',
  `FNAME` VARCHAR(45) NOT NULL COMMENT 'The first name of the patient',
  `ADDRESS` TINYINT NOT NULL COMMENT '0 MAPS TO NOT MARRIED\\\\n1 MAPS TO MARRIED',
  `PHONENUMBER` DATE NOT NULL,
  `AMKA` INT NOT NULL,
  `ID_NO` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`PID`),
  INDEX `LASTNAME_IDX` (`LNAME` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `patientsdb`.`patients_exams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `patientsdb`.`patients_exams` (
  `PEID` INT NOT NULL,
  `PID` INT NOT NULL,
  `EID` INT NOT NULL,
  `DATE` DATE NOT NULL,
  `RESULT` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PEID`),
  INDEX `PID_PAEX_FK_idx` (`PID` ASC) VISIBLE,
  INDEX `EID_PAEX_FK_idx` (`EID` ASC) VISIBLE,
  CONSTRAINT `EID_PAEX_FK`
    FOREIGN KEY (`EID`)
    REFERENCES `patientsdb`.`exams` (`EID`),
  CONSTRAINT `PID_PAEX_FK`
    FOREIGN KEY (`PID`)
    REFERENCES `patientsdb`.`patients` (`PID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

CREATE USER 'admin' IDENTIFIED BY 'admin';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
