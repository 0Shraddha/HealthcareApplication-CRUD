CREATE DATABASE  IF NOT EXISTS `patient_directory`;
USE `patient_directory`;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `disease` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `patient`
--

INSERT INTO `patient` VALUES 
	(1,'Leslie Andrews','leslie@luv2code.com','980000000','12th July','Tuberculosis'),
	(2,'Emma Baumgarten','emma@luv2code.com','9803234000','18th August','Common Cold'),
	(3,'Kevin Gupta','avani@luv2code.com','980120000','24th December','Cancer'),
    (4,'Ana Landis','ana@luv2code.com','9801290111','14th January','Blood Cancer');
