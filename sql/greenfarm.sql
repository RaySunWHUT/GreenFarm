# Host: localhost  (Version 5.7.27)
# Date: 2020-07-28 09:48:35
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "farm"
#

DROP TABLE IF EXISTS `farm`;
CREATE TABLE `farm` (
  `farmId` int(11) NOT NULL AUTO_INCREMENT,
  `farmName` varchar(30) NOT NULL DEFAULT '',
  `farmIntro` varchar(255) NOT NULL DEFAULT '',
  `farmSize` varchar(30) NOT NULL DEFAULT '',
  `farmPrice` varchar(255) NOT NULL DEFAULT '',
  `farmAddress` varchar(100) NOT NULL DEFAULT '',
  `farmImg` varchar(255) DEFAULT '',
  PRIMARY KEY (`farmId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

#
# Data for table "farm"
#

INSERT INTO `farm` VALUES (3,'myFarm','It\'s a very nice farm!','918','990918元/月','Japan',''),(6,'myFarm','It\'s a very nice farm!','918','990918元/月','Japan',''),(8,'myFarm','It\'s a very nice farm!','918','100元/月','Japan',''),(11,'hello','Hello','9000m2','888','CHina, Wuhan',NULL),(12,'ryutyu','YUI','yuiyuUIO','YUIO','YUI',NULL),(13,'iop','io','io','io','io',NULL),(14,'i','io','oi','oi','o',NULL);

#
# Structure for table "protype"
#

DROP TABLE IF EXISTS `protype`;
CREATE TABLE `protype` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

#
# Data for table "protype"
#

INSERT INTO `protype` VALUES (1,'水果'),(2,'蔬菜'),(3,'其它');

#
# Structure for table "product"
#

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `proId` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品Id',
  `proName` varchar(30) NOT NULL DEFAULT '' COMMENT '产品名',
  `proIntro` varchar(255) NOT NULL DEFAULT '' COMMENT '产品描述',
  `proPrice` varchar(10) NOT NULL DEFAULT '' COMMENT '产品价格',
  `stock` varchar(30) NOT NULL DEFAULT '' COMMENT '库存',
  `proImg` varchar(255) DEFAULT '' COMMENT '产品图片展示',
  `state` varchar(2) DEFAULT '' COMMENT '状态： 上架/下架',
  `typeId` int(11) NOT NULL DEFAULT '0' COMMENT '产品类型',
  `proAddress` varchar(100) NOT NULL DEFAULT '',
  `updateTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`proId`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `typeId` FOREIGN KEY (`typeId`) REFERENCES `protype` (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

#
# Data for table "product"
#

INSERT INTO `product` VALUES (4,'火鸡','余家头火鸡，活蹦乱跳，鲜嫩多汁','80元/kg','50',NULL,'1',1,'余家头养鸡场','0000-00-00 00:00:00'),(6,'小黄牛','科尔沁大草原！！！！','5000元/kg','456',NULL,'1',3,'科尔沁','0000-00-00 00:00:00'),(8,'草原红牛肉','科尔沁大草原红牛肉闻名中外, 嚼劲十足，居家旅行必备食品。','60元/kg','5000kg',NULL,'1',3,'科尔沁大草原','0000-00-00 00:00:00'),(9,'农家小笨鸡','白城市特产\"农家小笨鸡\"乃厨房必备食材, 纯粮饲养！假一赔十！ ','80元/kg','50',NULL,'1',3,'吉林白城','0000-00-00 00:00:00'),(10,'丑小鸭','阳澄湖大闸蟹，黄鹤楼丑小鸭！','60元/kg','99',NULL,'1',3,'黄鹤楼','0000-00-00 00:00:00'),(12,'东北大米','东北大米是最好的大米！','20元/kg','5000',NULL,'1',3,'中国东北','0000-00-00 00:00:00'),(13,'dcasca','asc','cas','scac',NULL,'1',3,'asc','0000-00-00 00:00:00'),(14,'456','hello world','456','456',NULL,'1',3,'CHina','0000-00-00 00:00:00'),(15,'hi','你好，武汉！','56元/kg','888',NULL,'1',2,'WuHan','0000-00-00 00:00:00'),(16,'TYU','GUYI','UYI','UIO',NULL,'1',2,'IOP','0000-00-00 00:00:00');

#
# Structure for table "role"
#

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

#
# Data for table "role"
#

INSERT INTO `role` VALUES (1,'admin'),(2,'user'),(3,'business');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userAccount` varchar(30) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL DEFAULT '',
  `salt` varchar(255) DEFAULT '',
  `phoneNumber` varchar(20) NOT NULL DEFAULT '',
  `roleId` int(11) NOT NULL DEFAULT '1',
  `email` varchar(30) DEFAULT '',
  `userName` varchar(30) DEFAULT '',
  `gender` varchar(8) NOT NULL DEFAULT '男',
  `head` varchar(255) DEFAULT '',
  PRIMARY KEY (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (15,'oo','914D5EB63A50113E7522363BD1019431','A8F2A3B9-5FAE-4FA4-BF20-5F78E93B0C5E','17354429242',3,'12345667@qq.com',NULL,'男',''),(17,'meiji','604AD537C5ED9769CD954D7D6DBD725D','F2A20BC7-7767-4F48-86C1-BDFF00024831','4596',3,NULL,NULL,'男',NULL),(18,'liwenchang','B294041615831B92EC5AF702E406F101','9E209AA7-AAF9-418F-9990-55443C407E4E','12345678910',3,NULL,NULL,'女',NULL),(19,'lwc','020377248CC0FEDDC6BD4FB0434961F6','14572442-E30E-4481-8877-B20CF085DA18','15017400946',3,'',NULL,'男',''),(20,'qq','C2F757B905FE06BA74179EBDAF862AC1','BB80369C-6955-44E5-B7AC-CC2D01A92910','17354429242',3,'',NULL,'男',''),(21,'dca','EF9BC758479325475644A72EC014A456','974265D7-211E-4391-A5BD-667C84B607A5','',3,'',NULL,'男','');
