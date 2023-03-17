# CREATE USER 'mike'@'localhost' IDENTIFIED BY 'root'
# GRANT ALL PRIVILEGES ON MEMBER.* TO 'mike'@'localhost'
# FLUSH PRIVILEGES

# =======================
# USE member
CREATE TABLE `member_account`(
	
	`ID` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`EMAIL` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
	`PASSWORD` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
	`ADDRESS` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
	`CELLPHONE` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
	`CREATE_DATE` DATETIME DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='會員資料表'
