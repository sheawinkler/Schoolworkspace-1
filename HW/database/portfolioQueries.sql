
-- number 1 *
SELECT p.personCode, p.brokerCode, p.lastName, p.firstName FROM Person AS p;

-- number 2 *
SELECT e.emailAddress FROM Email AS e JOIN Person AS per ON per.personID = e.personID WHERE personCode = '321f';

-- number 3
INSERT INTO Email (personID,emailAddress)  VALUES ((SELECT personID FROM Person WHERE personCode= 'ma12' ),'newEmail@me.com');

-- number 4 *
UPDATE Email SET emailAddress='anotherNew@me.com' WHERE emailAddress='bfox@gmail.com';

-- number 5
SET SQL_SAFE_UPDATES=0;
DELETE FROM portfolioAsset WHERE portfolioID = (SELECT portfolioID FROM Portfolio WHERE ownerID = 
                                                    (SELECT personID FROM Person WHERE personCode = 'doc05'));
                                                    
DELETE FROM portfolioAsset WHERE portfolioID = (SELECT portfolioID FROM Portfolio WHERE managerID = 
                                                    (SELECT personID FROM Person WHERE personCode = 'doc05'));
                                                    
DELETE FROM portfolioAsset WHERE portfolioID = (SELECT portfolioID FROM Portfolio WHERE beneficiaryID = 
                                                    (SELECT personID FROM Person WHERE personCode = 'doc05'));
                                                    
DELETE FROM Portfolio WHERE ownerID = (SELECT personID FROM Person WHERE personCode = 'doc05') OR 
                            managerID = (SELECT personID FROM Person WHERE personCode = 'doc05') OR
                            beneficiaryID = (SELECT personID FROM Person WHERE personCode = 'doc05');
DELETE FROM Email WHERE personID = (SELECT personID FROM Person WHERE personCode = 'doc05');
DELETE FROM mailAddress WHERE personID = (SELECT personID FROM Person WHERE personCode = 'doc05');
DELETE FROM Person WHERE personCode = 'doc05';


-- number 6
INSERT INTO Person (personCode,lastName,firstName) VALUES ('954j','jones','jesse');

-- number 7
SELECT a.assetCode, a.`label` FROM Asset AS a JOIN portfolioAsset AS pa ON pa.assetID=a.assetID 
                                              JOIN Portfolio AS p ON p.portfolioID=pa.portfolioID 
                                              WHERE p.portfolioCode = 'PF300';

-- number 8
SELECT a.assetCode, a.`label` FROM Asset AS a JOIN portfolioAsset AS pa ON pa.assetID=a.assetID 
                                                JOIN Portfolio AS p ON p.portfolioID=pa.portfolioID 
                                                JOIN Person AS per ON per.personID = p.ownerID 
                                                WHERE per.PersonCode = '944c';

-- number 9
INSERT INTO Asset(assetCode,`char`,`label`, annualPercentRate) VALUES ('APLSAV','D','Savings Account Apples','0.75');

-- number 10
INSERT INTO Portfolio (portfolioCode,ownerID,managerID) VALUES ('PF060',
                                                                (SELECT personID FROM Person WHERE personCode = '1svndr'),
                                                                (SELECT personID FROM Person WHERE personCode = '954j'));

-- number 11
INSERT INTO portfolioAsset (portfolioID,assetID) VALUES ((SELECT portfolioID FROM Portfolio WHERE portfolioCode = 'PT001'),
                                                            (SELECT assetID FROM Asset WHERE assetCode = 'AGTSAV' ));

-- number 12
SELECT per.personID,COUNT(*) FROM Portfolio AS p JOIN Person AS per ON per.personID=p.ownerID GROUP BY p.ownerID;

-- number 13
SELECT per.personID,COUNT(*) FROM Portfolio AS p JOIN Person AS per ON per.personID=p.managerID GROUP BY p.managerID;

-- number 14
SELECT p.portfolioCode As 'Porfolio Code', sum(pa.numberShare * a.sharePrice) AS 'Total Value of Stock by Portfolio' FROM Portfolio AS p 
                                  JOIN portfolioAsset AS pa ON pa.portfolioID = p.portfolioID
                                  JOIN Asset AS a ON a.assetID=pa.assetID
                                  WHERE a.`char` = 'S' GROUP BY p.portfolioID;
                                  
-- number 15
SELECT a.`label`,pa.percentStake from Asset AS a JOIN portfolioAsset AS pa ON a.assetID=pa.assetID WHERE a.`char` = 'P' HAVING pa.percentStake >100;


-- number extra 1
SELECT SUM(a.totalValue) AS Total_Value_private_investments FROM Portfolio AS p 
                                  JOIN portfolioAsset AS pa ON pa.portfolioID = p.portfolioID
                                  JOIN Asset AS a ON a.assetID=pa.assetID
                                  WHERE a.`char` = 'P';
-- number 2 extra
SELECT p.personCode,brokerCode,lastName,firstName,SECIdentifier, e.emailAddress, ma.street,city,state,zip,contry,a.label
                                FROM Person AS p 
                                JOIN Email AS e ON p.personID = e.personID
                                JOIN mailAddress AS ma ON p.personID = ma.personID
                                JOIN Portfolio AS pf ON p.personID = pf.ownerID
                                JOIN portfolioAsset AS pa ON pf.portfolioID = pa.portfolioID
                                JOIN Asset AS a ON pa.assetID=a.AssetID;