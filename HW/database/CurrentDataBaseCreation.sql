use emorton;
Show TABLES;


-- -----------------------------------------------------
-- Table `mailAddress`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mailAddress` ;

CREATE  TABLE IF NOT EXISTS `mailAddress` (
  `mailAddressID` INT NOT NULL AUTO_INCREMENT ,
  `street` VARCHAR(45) NULL ,
  `city` VARCHAR(45) NULL ,
  `state` VARCHAR(45) NULL ,
  `zip` VARCHAR(45) NULL ,
  `contry` VARCHAR(45) NULL ,
  PRIMARY KEY (`mailAddressID`) ,
  UNIQUE INDEX `mailAddressID_UNIQUE` (`mailAddressID` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET latin1 
COLLATE latin1_general_cs;


-- -----------------------------------------------------
-- Table `Person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Person` ;

CREATE  TABLE IF NOT EXISTS `Person` (
  `personID` INT NOT NULL AUTO_INCREMENT ,
  `personCode` VARCHAR(45) NOT NULL ,
  `brokerCode` VARCHAR(45) NULL ,
  `lastName` VARCHAR(255) NULL ,
  `firstName` VARCHAR(255) NULL ,
  `mailAddressID` INT NOT NULL ,
  UNIQUE INDEX `idPerson_UNIQUE` (`personID` ASC) ,
  UNIQUE INDEX `personCode_UNIQUE` (`personCode` ASC) ,
  UNIQUE INDEX `brokerCode_UNIQUE` (`brokerCode` ASC) ,
  PRIMARY KEY (`personID`) ,
  INDEX `fk_Person_mailAddress1` (`mailAddressID` ASC) ,
  CONSTRAINT `fk_Person_mailAddress1`
    FOREIGN KEY (`mailAddressID` )
    REFERENCES `mailAddress` (`mailAddressID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET latin1 
COLLATE latin1_general_cs;


-- -----------------------------------------------------
-- Table `emailAddress`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `emailAddress` ;

CREATE  TABLE IF NOT EXISTS `emailAddress` (
  `emailAddressID` INT NOT NULL AUTO_INCREMENT ,
  `personID` INT NOT NULL ,
  `emailAddress` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`emailAddressID`) ,
  UNIQUE INDEX `emailAddressID_UNIQUE` (`emailAddressID` ASC) ,
  UNIQUE INDEX `emailAddresscol_UNIQUE` (`emailAddress` ASC) ,
  INDEX `fk_emailAddress_Person1` (`personID` ASC) ,
  CONSTRAINT `fk_emailAddress_Person1`
    FOREIGN KEY (`personID` )
    REFERENCES `Person` (`personID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET latin1 
COLLATE latin1_general_cs;


-- -----------------------------------------------------
-- Table `Asset`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Asset` ;

CREATE  TABLE IF NOT EXISTS `Asset` (
  `assetID` INT NOT NULL AUTO_INCREMENT ,
  `code` VARCHAR(45) NOT NULL ,
  `char` VARCHAR(1) NOT NULL ,
  `label` VARCHAR(255) NOT NULL ,
  `annualPercentRate` VARCHAR(45) NULL ,
  `quarterlyDivident` VARCHAR(45) NULL ,
  `baseRateOfReturn` VARCHAR(45) NULL ,
  `omega` VARCHAR(45) NULL ,
  `stockSymbol` VARCHAR(45) NULL ,
  `sharePrice` VARCHAR(45) NULL ,
  `totalValue` VARCHAR(45) NULL ,
  PRIMARY KEY (`assetID`) ,
  UNIQUE INDEX `idAsset_UNIQUE` (`assetID` ASC) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) ,
  UNIQUE INDEX `label_UNIQUE` (`label` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET latin1 
COLLATE latin1_general_cs;


-- -----------------------------------------------------
-- Table `Portfolio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Portfolio` ;

CREATE  TABLE IF NOT EXISTS `Portfolio` (
  `portfolioID` INT NOT NULL AUTO_INCREMENT ,
  `ownerID` INT NOT NULL ,
  `managerID` INT NOT NULL ,
  `beneficiaryID` INT NULL ,
  `assetID` INT NULL ,
  PRIMARY KEY (`portfolioID`) ,
  UNIQUE INDEX `portfolioID_UNIQUE` (`portfolioID` ASC) ,
  INDEX `fk_Portfolio_Person1` (`ownerID` ASC) ,
  INDEX `fk_Portfolio_Person2` (`managerID` ASC) ,
  INDEX `fk_Portfolio_Person3` (`beneficiaryID` ASC) ,
  CONSTRAINT `fk_Portfolio_Person1`
    FOREIGN KEY (`ownerID` )
    REFERENCES `Person` (`personID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Portfolio_Person2`
    FOREIGN KEY (`managerID` )
    REFERENCES `Person` (`personID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Portfolio_Person3`
    FOREIGN KEY (`beneficiaryID` )
    REFERENCES `Person` (`personID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET latin1 
COLLATE latin1_general_cs;


-- -----------------------------------------------------
-- Table `portfolioAsset`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `portfolioAsset` ;

CREATE  TABLE IF NOT EXISTS `portfolioAsset` (
  `portfolioAssetID` INT UNSIGNED NOT NULL ,
  `portfolioID` INT NOT NULL ,
  `assetID` INT NOT NULL ,
  PRIMARY KEY (`portfolioAssetID`) ,
  UNIQUE INDEX `portfolioAssetID_UNIQUE` (`portfolioAssetID` ASC) ,
  INDEX `fk_portfolioAsset_Portfolio1` (`portfolioID` ASC) ,
  INDEX `fk_portfolioAsset_Asset1` (`assetID` ASC) ,
  CONSTRAINT `fk_portfolioAsset_Portfolio1`
    FOREIGN KEY (`portfolioID` )
    REFERENCES `Portfolio` (`portfolioID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_portfolioAsset_Asset1`
    FOREIGN KEY (`assetID` )
    REFERENCES `Asset` (`assetID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET latin1 
COLLATE latin1_general_cs;