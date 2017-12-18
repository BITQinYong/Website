CREATE DATABASE IF NOT EXISTS `BookManagement` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `BookManagement`;

DROP TABLE IF EXISTS `BookInfo`;
CREATE TABLE `BookInfo` (
	`bookID` char(50) NOT NULL DEFAULT '',
	`bookType` char(50) DEFAULT NULL,
	`bookName` char(50) DEFAULT NULL,
	`bookAuthor` char(50) DEFAULT NULL,
	`bookPublisher` char(50) DEFAULT NULL,
	`bookPublicTime` char(50) DEFAULT NULL,
	`bookPlace` char(50) DEFAULT NULL,
	`bookBorrowCondition` char(50) DEFAULT NULL,
	PRIMARY KEY  (`bookID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 ROW_FORMAT=REDUNDANT;

INSERT INTO `BookInfo` VALUES ('0010001','����','����ǹ�ֿ�ǹ��','�ָ���','�����ֵ�','2016','TP101','2016-1-1');
INSERT INTO `BookInfo` VALUES ('0010002','����','������ľ��������','���ෲ','�����ֵ�','2016','TP101','2016-1-1');
INSERT INTO `BookInfo` VALUES ('0020001','����','��Ӱ�ع�','ʷ̩��','������','2016','TP201','2016-1-1');
INSERT INTO `BookInfo` VALUES ('0030001','����','�����','�Ա�ɽ','��ɽ��ý����','2016','TP301','0-0-0');
INSERT INTO `BookInfo` VALUES ('0040001','�ƻ�','�ڶ���','����ΰ','����Ӱҵ','2016','TP401','0-0-0'); 
INSERT INTO `BookInfo` VALUES ('0050001','ϲ��','�����ӳ�','���ڻ�','������','2016','TP501','0-0-0');
INSERT INTO `BookInfo` VALUES ('1000001','��Ϸ','����ʦ','����Ԫ','�ξ���˾','2016','TP601','0-0-0');



DROP TABLE IF EXISTS `BorrowInfo`;
CREATE TABLE `BorrowInfo` (
	`userID` char(50) NOT NULL DEFAULT '',
	`bookID` char(50) NOT NULL DEFAULT '',
	`borrowBeginDate` char(50) DEFAULT NULL,
	`borrowEndDate` char(50) DEFAULT NULL,
	PRIMARY KEY  (`userID`,`bookID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO `BorrowInfo` VALUES ('1111','0010001','2016-11-1','2016-12-1');
INSERT INTO `BorrowInfo` VALUES ('1111','0010002','2016-11-1','2016-12-1');
INSERT INTO `BorrowInfo` VALUES ('2222','0020001','2016-11-1','2016-12-1');

DROP TABLE IF EXISTS `ManagerInfo`;
CREATE TABLE `ManagerInfo` (
	`managerID` char(50) NOT NULL DEFAULT '',
	`managerPassword` char(50) DEFAULT NULL,
	PRIMARY KEY  (`managerID`)
) ENGINE = InnoDB DEFAULT CHARSET  = utf8 ROW_FORMAT=REDUNDANT;


INSERT INTO `ManagerInfo` VALUES ('qy','qy');

DROP TABLE IF EXISTS `UserInfo`;
CREATE TABLE `UserInfo` (
	`userID` char(50) NOT NULL DEFAULT '',
	`userPassword` char(50) DEFAULT NULL,
	`userName` char(50) DEFAULT NULL,
	`userSex` char(50) DEFAULT NULL,
	`userPhone` char(50) DEFAULT NULL,
	`userEmail` char(50) DEFAULT NULL,
	PRIMARY KEY  (`userID`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 ROW_FORMAT=REDUNDANT;

INSERT INTO `UserInfo` VALUES ('1111','111111','����һ','��','11111111111','1@111.com');
INSERT INTO `UserInfo` VALUES ('2222','222222','���¶�','Ů','22222222222','2@222.com');
