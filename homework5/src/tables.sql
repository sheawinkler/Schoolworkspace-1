-- MySQL dump 9.07
--
-- Table structure for table 'exams' and 'students'
--
DROP TABLE IF EXISTS exams;
DROP TABLE IF EXISTS students;

CREATE TABLE students(
	firstName VARCHAR(30), 
	lastName VARCHAR(30), 
	first INT(3) default NULL,
	second INT(3) default NULL, 
	third INT(3) default NULL, 
	fourth INT(3) default NULL,
);

CREATE TABLE exams(
	total INT(4) default NULL,
	score INT(3) default NULL,
	weight INT(2) default NULL;
);