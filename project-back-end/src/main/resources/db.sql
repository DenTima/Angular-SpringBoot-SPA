USE `dbtask`;


DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert  into `user`(`user_name`,`password`) values ('roy','ae685575101ee7165c90a8f2c30c6e60cdd9e482');

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `user_role` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  KEY `fk_user` (`user_name`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


insert  into `user_role`(`user_name`,`role_name`) values ('roy','ADMIN_USER');

CREATE TABLE `tbl_departments` (
  `depid` int(11) NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`depid`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_employees` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `emp_active` bit(1) NOT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `depid` int(11) DEFAULT NULL,
  PRIMARY KEY (`empid`),
  KEY `FKe43jbl59igiioa6er3pr3u41t` (`depid`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
