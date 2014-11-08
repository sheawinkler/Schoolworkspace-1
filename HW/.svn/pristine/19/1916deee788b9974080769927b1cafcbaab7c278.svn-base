use emorton;
SHOW TABLES;
DROP TABLE IF EXISTS portfolioAsset;
DROP TABLE IF EXISTS Portfolio;
DROP TABLE IF EXISTS Asset;
DROP TABLE IF EXISTS Email;
DROP TABLE IF EXISTS mailAddress;
DROP TABLE IF EXISTS Person;
-- -----------------------------------------------------
-- Table `Person`

CREATE  TABLE IF NOT EXISTS `Person` (
  `personID` INT NOT NULL AUTO_INCREMENT ,
  `personCode` VARCHAR(45) NOT NULL ,
  `brokerCode` VARCHAR(45) NULL ,
  `lastName` VARCHAR(255) NULL ,
  `firstName` VARCHAR(255) NULL ,
  `SECIdentifier` VARCHAR(45) NULL ,
  UNIQUE INDEX `idPerson_UNIQUE` (`personID` ASC) ,
  UNIQUE INDEX `personCode_UNIQUE` (`personCode` ASC) ,
  PRIMARY KEY (`personID`),
  UNIQUE INDEX `SECIdentifier_UNIQUE` (`SECIdentifier` ASC) )
ENGINE = InnoDB
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `mailAddress`

CREATE  TABLE IF NOT EXISTS `mailAddress` (
  `mailAddressID` INT NOT NULL AUTO_INCREMENT ,
  `personID` INT NOT NULL ,
  `street` VARCHAR(255) NULL ,
  `city` VARCHAR(255) NULL ,
  `state` VARCHAR(255) NULL ,
  `zip` VARCHAR(255) NULL ,
  `country` VARCHAR(255) NULL ,
  PRIMARY KEY (`mailAddressID`) ,
  UNIQUE INDEX `mailAddressID_UNIQUE` (`mailAddressID` ASC) ,
  INDEX `fk_mailAddress_Person1` (`personID` ASC) ,
  CONSTRAINT `fk_mailAddress_Person1`
    FOREIGN KEY (`personID` )
    REFERENCES `Person` (`personID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `Email`

CREATE  TABLE IF NOT EXISTS `Email` (
  `emailID` INT NOT NULL AUTO_INCREMENT ,
  `personID` INT NOT NULL ,
  `emailAddress` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`emailID`) ,
  UNIQUE INDEX `emailAddressID_UNIQUE` (`emailID` ASC) ,
  UNIQUE INDEX `emailAddresscol_UNIQUE` (`emailAddress` ASC) ,
  INDEX `fk_emailAddress_Person1` (`personID` ASC) ,
  CONSTRAINT `fk_emailAddress_Person1`
    FOREIGN KEY (`personID` )
    REFERENCES `Person` (`personID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `Asset`

CREATE  TABLE IF NOT EXISTS `Asset` (
  `assetID` INT NOT NULL AUTO_INCREMENT ,
  `assetCode` VARCHAR(45) NOT NULL ,
  `char` VARCHAR(1) NOT NULL ,
  `label` VARCHAR(255) NOT NULL ,
  `annualPercentRate` FLOAT NULL ,
  `quarterlyDivident` FLOAT NULL ,
  `baseRateOfReturn` FLOAT NULL ,
  `omega` FLOAT NULL ,
  `stockSymbol` VARCHAR(255) NULL ,
  `sharePrice` FLOAT NULL ,
  `assetValue` FLOAT NULL ,
  PRIMARY KEY (`assetID`) ,
  UNIQUE INDEX `idAsset_UNIQUE` (`assetID` ASC) ,
  UNIQUE INDEX `assetCode_UNIQUE` (`assetCode` ASC) ,
  UNIQUE INDEX `label_UNIQUE` (`label` ASC) )
ENGINE = InnoDB
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `Portfolio`


CREATE  TABLE IF NOT EXISTS `Portfolio` (
  `portfolioID` INT NOT NULL AUTO_INCREMENT ,
  `portfolioCode` VARCHAR(45) NOT NULL ,
  `ownerID` INT NOT NULL ,
  `managerID` INT NOT NULL ,
  `beneficiaryID` INT NULL ,
  PRIMARY KEY (`portfolioID`) ,
  UNIQUE INDEX `portfolioID_UNIQUE` (`portfolioID` ASC) ,
  INDEX `fk_Portfolio_Person1` (`ownerID` ASC) ,
  INDEX `fk_Portfolio_Person2` (`managerID` ASC) ,
  INDEX `fk_Portfolio_Person3` (`beneficiaryID` ASC) ,
  CONSTRAINT `fk_Portfolio_Person1`
    FOREIGN KEY (`ownerID` )
    REFERENCES `Person` (`personID` ),
  CONSTRAINT `fk_Portfolio_Person2`
    FOREIGN KEY (`managerID` )
    REFERENCES `Person` (`personID` ),
  CONSTRAINT `fk_Portfolio_Person3`
    FOREIGN KEY (`beneficiaryID` )
    REFERENCES `Person` (`personID` ))
ENGINE = InnoDB
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `portfolioAsset`

CREATE  TABLE IF NOT EXISTS `portfolioAsset` (
  `portfolioAssetID` INT NOT NULL AUTO_INCREMENT ,
  `portfolioID` INT NOT NULL ,
  `assetID` INT NOT NULL ,
  `totalValue` FLOAT NOT NULL ,
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
COLLATE = utf8_unicode_ci;

-- ------------------------------------------------------ 
-- Add People to the Person Table 

INSERT INTO Person (personCode,lastName,firstName) VALUES ('944c','Castro', 'Starlin');
INSERT INTO Person (personCode,lastName,firstName) VALUES ('306a','Sampson', 'Brock');
INSERT INTO Person (personCode,lastName,firstName) VALUES ('2342','O\'Brien', 'Miles');
INSERT INTO Person (personCode,lastName,firstName,brokerCode,SECIdentifier) VALUES ('aef1','Gekko', 'Gordon','E','sec001');
INSERT INTO Person (personCode,lastName,firstName,brokerCode,SECIdentifier) VALUES ('321f','Fox', 'Bud','J','sec991');
INSERT INTO Person (personCode,lastName,firstName) VALUES ('ma12','Sveum', 'Dale');
INSERT INTO Person (personCode,lastName,firstName) VALUES ('321nd','Hartnell', 'William');
INSERT INTO Person (personCode,lastName,firstName) VALUES ('nf32a','Troughton', 'Patrick');
INSERT INTO Person (personCode,lastName,firstName,brokerCode,SECIdentifier) VALUES ('321na','Pertwee', 'Jon','E','sec125');
INSERT INTO Person (personCode,lastName,firstName,brokerCode,SECIdentifier) VALUES ('231','Baker','Tom','E','sec221');
INSERT INTO Person (personCode,lastName,firstName,brokerCode,SECIdentifier) VALUES ('6doc','Hurndall', 'Richard','J','sec982');
INSERT INTO Person (personCode,lastName,firstName,brokerCode,SECIdentifier) VALUES ('321dr','Baker', 'C.','J','sec543');
INSERT INTO Person (personCode,lastName,firstName) VALUES ('1svndr','McCoy','Sylvester');
INSERT INTO Person (personCode,lastName,firstName,brokerCode,SECIdentifier) VALUES ('123lst','McGann', 'Paul','E','sec31x');
INSERT INTO Person (personCode,lastName,firstName,brokerCode,SECIdentifier) VALUES ('nwdoc1','Eccleston', 'Chris','J','sec953');
INSERT INTO Person (personCode,lastName,firstName) VALUES ('2ndbestd','Tennant', 'David');
INSERT INTO Person (personCode,lastName,firstName) VALUES ('wrddoc','Smith', 'Matt');
INSERT INTO Person (personCode,lastName,firstName) VALUES ('bbchar','Ehrmantraut', 'Kaylee');
INSERT INTO Person (personCode,lastName,firstName) VALUES ('doc05','Davison', 'Peter');

-- ------------------------------------------------------------------
-- add address into mailAddress table

INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '944C'),'1060 West Addison Street','Chicago','IL','60613','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '306a'),'123 N 1st Street','Omaha','NE','68116','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '2342'),'123 Friendly Street','Ottawa','ON','K1A 0G9','Canada');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'aef1'),'1 Wall Street','New York','NY','10005-0012','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES     
((SELECT personID FROM Person WHERE personCode = '321f'),'321 Bronx Street','New York','NY','10004','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'ma12'),'1060 West Addison Street','Chicago','IL','60613','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '321nd'),'1060 West Addison Street','Chicago','IL','60613','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'nf32a'),'1060 West Addison Street','Chicago','IL','60613','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '321na'),'301 Front St W', 'Toronto', 'ON', 'M5V 2T6', 'Canada');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '231'),'1 Blue Jays Way', 'Toronto', 'ON', 'M5V 1J1', 'Canada');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '6doc'),'Campos El290','Mexico City', 'FD','', 'Mexico');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '321dr'),'Avery Hall','Lincoln','NE','68503','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '1svndr'),'126-01 Roosevelt Ave', 'Flushing', 'NY','11368','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '123lst'),'1 MetLife Stadium Dr', 'East Rutherford', 'NJ','07073','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'nwdoc1'),'1 E 161st St', 'Bronx', 'NY','10451','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '2ndbestd'),'700 E Grand Ave', 'Chicago', 'IL', '60611','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'wrddoc'),'333 W 35th St', 'Chicago', 'IL','60616','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'bbchar'),'800 West 7th Street', 'Albuquerque', 'NM', '87105','USA');
INSERT INTO mailAddress (personID, street, city, state, zip, country) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'doc05'),'123 Cabo San Lucas', 'Los Cabos', 'BCS', '', 'Mexico');
    
-- ------------------------------------------------------------------------------
-- add email address into Email table

INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '944C'),'scastro@cubs.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '944C'),'starlin_castro13@gmail.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '306a'),'brock_f_sampson@gmail.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '306a'),'bsampson@venture.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '321f'),'bfox@gmail.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '321f'),'csheen@crazy.net');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'ma12'),'sveum@cubs.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '321nd'),'whartnell@doctors.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '321nd'),'dr@who.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'nf32a'),'ptroug@cse.unl.edu');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'nf32a'),'ptrou32@unl.edu');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '321na'),'jpet@whofan.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '231'),'famousdoc@who.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '231'),'tbaker@cse.unl.edu');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '231'),'mostfamous@whovian.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '231'),'thedoctor@bbc.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '6doc'),'rhurndall@cse.unl.edu');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '6doc'),'richard@unl.edu');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '321dr'),'dr@baker.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '1svndr'),'slyguy@hotmail.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '1svndr'),'mccoy@whofan.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '123lst'),'pmcgann@mlb.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '123lst'),'foo@bar.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '123lst'),'pmc@unl.edu');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'nwdoc1'),'newguy@whovian.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '2ndbestd'),'actor@shakespeare.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = '2ndbestd'),'tdavid@unl.edu');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'wrddoc'),'msmith@who.com');
INSERT INTO Email (personID,emailAddress) VALUES 
    ((SELECT personID FROM Person WHERE personCode = 'wrddoc'),'thedoc@cse.unl.edu');

-- ------------------------------------------------------------------------
-- add Data into asset table 

INSERT INTO Asset(assetCode,`char`,`label`,annualPercentRate) VALUES ('AGTSAV','D','Savings Account','0.25');
INSERT INTO Asset(assetCode,`char`,`label`,annualPercentRate) VALUES ('BX001-23','D','Money Market Savings','1.05');
INSERT INTO Asset(assetCode,`char`,`label`,annualPercentRate) VALUES ('CD99312','D','5-year CD','4.35');
INSERT INTO Asset(assetCode,`char`,`label`,annualPercentRate) VALUES ('CD1Y3X','D','1-year Rollover CD','2.75');
INSERT INTO Asset(assetCode,`char`,`label`,annualPercentRate) VALUES ('RIRA01','D','Roth IRA','3.4');

INSERT INTO Asset(assetCode,`char`,`label`, quarterlyDivident, baseRateOfReturn,omega,stockSymbol,sharePrice) VALUES
    ('GOOG001','S','Google Inc.','0.0','5.6','.05','GOOG','814.708');
INSERT INTO Asset(assetCode,`char`,`label`, quarterlyDivident, baseRateOfReturn,omega,stockSymbol,sharePrice) VALUES
    ('DIAGEO12','S','Diageo PLC','12.00','3.2','.11','DEO','122.75');
INSERT INTO Asset(assetCode,`char`,`label`, quarterlyDivident, baseRateOfReturn,omega,stockSymbol,sharePrice) VALUES
    ('123APP','S','Apple','24.50','4.3','.03','AAPL','429.80');
INSERT INTO Asset(assetCode,`char`,`label`, quarterlyDivident, baseRateOfReturn,omega,stockSymbol,sharePrice) VALUES
    ('321CC','S','Coca-Cola','5.45','3.1','.025','KO','41.08');
INSERT INTO Asset(assetCode,`char`,`label`, quarterlyDivident, baseRateOfReturn,omega,stockSymbol,sharePrice) VALUES
    ('No1BURR','S','Chipotle Mexican Grill','45.57','3.19','.1','CMG','341.91');
INSERT INTO Asset(assetCode,`char`,`label`, quarterlyDivident, baseRateOfReturn,omega,stockSymbol,sharePrice) VALUES
    ('B0oWM','S','Costco','10.00','2.25','.23','COST','106.13');
INSERT INTO Asset(assetCode,`char`,`label`, quarterlyDivident, baseRateOfReturn,omega,stockSymbol,sharePrice) VALUES
    ('N0TPIX','S','3D Systems;','0.0','1.25','.18','DDD','35.40');
INSERT INTO Asset(assetCode,`char`,`label`, quarterlyDivident, baseRateOfReturn,omega,stockSymbol,sharePrice) VALUES
    ('wOOWoo1S','S','Canadian National Railway;','2.75','4.6','.22','CNI','97.75');
INSERT INTO Asset(assetCode,`char`,`label`, quarterlyDivident, baseRateOfReturn,omega,stockSymbol,sharePrice) VALUES
    ('BERK-B','S','Berkshire Hathaway','0.0;','7.2','.0','BRK-B','107.04');

INSERT INTO Asset(assetCode,`char`,`label`,quarterlyDivident, baseRateOfReturn,omega,assetValue) VALUES
    ('RENT445','P','Rental Property','2400.00','0.25','0.4','120000');
INSERT INTO Asset(assetCode,`char`,`label`,quarterlyDivident, baseRateOfReturn,omega,assetValue) VALUES
    ('CMPROP0121','P','Commercial Property-Red Oaks Mall','14240','5.35','.5','10456000');
INSERT INTO Asset(assetCode,`char`,`label`,quarterlyDivident, baseRateOfReturn,omega,assetValue) VALUES
    ('FOOD12','P','Cluckin\'s restaurant chain','35000.00','3.0','0.57','1212500.00');
INSERT INTO Asset(assetCode,`char`,`label`,quarterlyDivident, baseRateOfReturn,omega,assetValue) VALUES
    ('REALStr12','P','Fred\'s Fabulous Hardware Store','1232','1.23','0.38','54300.00');
INSERT INTO Asset(assetCode,`char`,`label`,quarterlyDivident, baseRateOfReturn,omega,assetValue) VALUES
    ('IND321','P','Industrial Widget Manufacturers Inc.','10500','2','0.1','4213333');
INSERT INTO Asset(assetCode,`char`,`label`,quarterlyDivident, baseRateOfReturn,omega,assetValue) VALUES
    ('RSTOR322','P','7" Vinyl Records','2453.21','2.1','0.79','13500.00');

INSERT INTO Asset(assetCode,`char`,`label`,quarterlyDivident, baseRateOfReturn,omega,assetValue) VALUES
    ('ovr100','P','Over 100 %','2453.21','2.1','0.79','13500.00');

-- ----------------------------------------------------------------------------------------
-- add Data into Portfolio table

INSERT INTO Portfolio(portfolioCode,ownerID,managerID,beneficiaryID) VALUES 
('PT001',(SELECT PersonID FROM Person WHERE PersonCode='944c'),
    (SELECT PersonID FROM Person WHERE PersonCode='aef1'),
    (SELECT PersonID FROM Person WHERE PersonCode='ma12'));
INSERT INTO Portfolio(portfolioCode,ownerID,managerID) VALUES 
    ('PF001',(SELECT PersonID FROM Person WHERE PersonCode='2342'),
    (SELECT PersonID FROM Person WHERE PersonCode='aef1'));
INSERT INTO Portfolio(portfolioCode,ownerID,managerID,beneficiaryID) VALUES 
    ('PD102',(SELECT PersonID FROM Person WHERE PersonCode='321dr'),
    (SELECT PersonID FROM Person WHERE PersonCode='321f'),
    (SELECT PersonID FROM Person WHERE PersonCode='aef1'));
INSERT INTO Portfolio(portfolioCode,ownerID,managerID,beneficiaryID) VALUES 
    ('PF002',(SELECT PersonID FROM Person WHERE PersonCode='wrddoc'),
    (SELECT PersonID FROM Person WHERE PersonCode='231'),
    (SELECT PersonID FROM Person WHERE PersonCode='1svndr'));
INSERT INTO Portfolio(portfolioCode,ownerID,managerID,beneficiaryID) VALUES 
    ('PF003',(SELECT PersonID FROM Person WHERE PersonCode='2ndbestd'),
    (SELECT PersonID FROM Person WHERE PersonCode='231'),
    (SELECT PersonID FROM Person WHERE PersonCode='1svndr'));
INSERT INTO Portfolio(portfolioCode,ownerID,managerID,beneficiaryID) VALUES 
    ('PF004',(SELECT PersonID FROM Person WHERE PersonCode='2ndbestd'),
    (SELECT PersonID FROM Person WHERE PersonCode='6doc'),
    (SELECT PersonID FROM Person WHERE PersonCode='bbchar'));
INSERT INTO Portfolio(portfolioCode,ownerID,managerID) VALUES 
    ('PF006',(SELECT PersonID FROM Person WHERE PersonCode='1svndr'),
    (SELECT PersonID FROM Person WHERE PersonCode='231'));
INSERT INTO Portfolio(portfolioCode,ownerID,managerID,beneficiaryID) VALUES 
    ('PF007',(SELECT PersonID FROM Person WHERE PersonCode='231'),
    (SELECT PersonID FROM Person WHERE PersonCode='231'),
    (SELECT PersonID FROM Person WHERE PersonCode='bbchar'));
INSERT INTO Portfolio(portfolioCode,ownerID,managerID,beneficiaryID) VALUES  
    ('PF200',(SELECT PersonID FROM Person WHERE PersonCode='6doc'),
    (SELECT PersonID FROM Person WHERE PersonCode='nwdoc1'),
    (SELECT PersonID FROM Person WHERE PersonCode='bbchar'));
INSERT INTO Portfolio(portfolioCode,ownerID,managerID) VALUES 
    ('PF300',(SELECT PersonID FROM Person WHERE PersonCode='1svndr'),
    (SELECT PersonID FROM Person WHERE PersonCode='6doc'));
INSERT INTO Portfolio(portfolioCode,ownerID,managerID) VALUES 
    ('PF600',(SELECT PersonID FROM Person WHERE PersonCode='1svndr'),
    (SELECT PersonID FROM Person WHERE PersonCode='123lst'));
INSERT INTO Portfolio(portfolioCode,ownerID,managerID) VALUES 
    ('PF666',(SELECT PersonID FROM Person WHERE PersonCode='doc05'),
    (SELECT PersonID FROM Person WHERE PersonCode='123lst'));
INSERT INTO Portfolio(portfolioCode,ownerID,managerID) VALUES 
    ('PF667',(SELECT PersonID FROM Person WHERE PersonCode='1svndr'),
    (SELECT PersonID FROM Person WHERE PersonCode='123lst'));
-- ------------------------------------------------------------------------
-- add Data into portfolioAsset table

INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PT001'),
    (SELECT assetID FROM Asset WHERE assetCode = 'BX001-23'),
    2403.32);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PT001'),
    (SELECT assetID FROM Asset WHERE assetCode = 'AGTSAV'),
    26534.22);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PT001'),
    (SELECT assetID FROM Asset WHERE assetCode = 'B0oWM'),
    125);


INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF001'),
    (SELECT assetID FROM Asset WHERE assetCode = 'BX001-23'),
    124.32);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF001'),
    (SELECT assetID FROM Asset WHERE assetCode = 'BERK-B'),
    1050);


INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PD102'),
    (SELECT assetID FROM Asset WHERE assetCode = 'RENT445'),
    100);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PD102'),
    (SELECT assetID FROM Asset WHERE assetCode = 'FOOD12'),
    35);


INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF002'),
    (SELECT assetID FROM Asset WHERE assetCode = '321CC'),
    25.5);



INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF003'),
    (SELECT assetID FROM Asset WHERE assetCode = 'N0TPIX'),
    21);


INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF004'),
    (SELECT assetID FROM Asset WHERE assetCode = 'RIRA01'),
    1032.12);



INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF007'),
    (SELECT assetID FROM Asset WHERE assetCode = '321CC'),
    10000);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF007'),
    (SELECT assetID FROM Asset WHERE assetCode = 'CMPROP0121'),
    23.5);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF007'),
    (SELECT assetID FROM Asset WHERE assetCode = 'REALStr12'),
    12);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF007'),
    (SELECT assetID FROM Asset WHERE assetCode = 'wOOWoo1S'),
    50);


INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF300'),
    (SELECT assetID FROM Asset WHERE assetCode = 'IND321'),
    25);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF300'),
    (SELECT assetID FROM Asset WHERE assetCode = 'RSTOR322'),
    100);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF300'),
    (SELECT assetID FROM Asset WHERE assetCode = '123APP'),
    1000);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF300'),
    (SELECT assetID FROM Asset WHERE assetCode = 'GOOG001'),
    100);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF300'),
    (SELECT assetID FROM Asset WHERE assetCode = 'CD1Y3X'),
    25000);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF300'),
    (SELECT assetID FROM Asset WHERE assetCode = 'RIRA01'),
    120000);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF300'),
    (SELECT assetID FROM Asset WHERE assetCode = 'wOOWoo1S'),
    50);
    
    
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF600'),
    (SELECT assetID FROM Asset WHERE assetCode = 'AGTSAV'),
    22222);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF666'),
    (SELECT assetID FROM Asset WHERE assetCode = 'BX001-23'),
    100000);
INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES 
    ((SELECT portfolioID FROM Portfolio WHERE portfolioCode='PF667'),
    (SELECT assetID FROM Asset WHERE assetCode = 'ovr100'),
    150)





