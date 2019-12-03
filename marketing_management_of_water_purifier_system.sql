/*
Navicat MySQL Data Transfer

Source Server         : text
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : marketing_management_of_water_purifier_system

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-12-03 13:44:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` int(6) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '公司名称',
  `totalcompanyid` int(6) NOT NULL COMMENT '总公司id',
  `tel` char(11) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '中国净水器公司', '1', '18290893588');
INSERT INTO `company` VALUES ('2', '重庆净水器公司', '1', '18250409588');
INSERT INTO `company` VALUES ('3', '武汉净水器销售公司', '1', '19089892277');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cusname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tel` char(11) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '重庆市组源通信公司', '13808326532');
INSERT INTO `customer` VALUES ('2', '重庆市龙湖地产', '12398326756');
INSERT INTO `customer` VALUES ('3', '重庆市中国移动', '15111671356');
INSERT INTO `customer` VALUES ('5', '重庆市电信规划局', '19023236757');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(6) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `depname` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '生产部');
INSERT INTO `department` VALUES ('2', '销售部');
INSERT INTO `department` VALUES ('3', '售后部');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `tel` char(11) COLLATE utf8_unicode_ci NOT NULL,
  `depid` int(11) NOT NULL,
  `companyid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '张三', '19290409628', '1', '2');
INSERT INTO `employee` VALUES ('3', '刘达', '19689095423', '1', '1');
INSERT INTO `employee` VALUES ('4', '刘冬实', '15678786969', '1', '2');
INSERT INTO `employee` VALUES ('5', '刘东', '15923234769', '2', '1');
INSERT INTO `employee` VALUES ('6', '许兵河', '19067678902', '3', '1');
INSERT INTO `employee` VALUES ('7', 'Jack张', '19068689797', '2', '1');
INSERT INTO `employee` VALUES ('8', '刘小溪', '13267894542', '3', '2');
INSERT INTO `employee` VALUES ('9', '华强', '19089897682', '1', '1');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `typeid` int(11) NOT NULL,
  `unitid` int(4) NOT NULL COMMENT '物料衡量单位id',
  `count` int(11) NOT NULL COMMENT '物料数量',
  `supplierid` int(11) NOT NULL,
  `storeid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('1', '1', '1', '22', '1', '1');
INSERT INTO `material` VALUES ('3', '2', '1', '20', '1', '1');
INSERT INTO `material` VALUES ('4', '1', '1', '10', '1', '2');
INSERT INTO `material` VALUES ('10', '3', '1', '10', '1', '1');
INSERT INTO `material` VALUES ('11', '3', '1', '10', '3', '3');
INSERT INTO `material` VALUES ('13', '4', '2', '20', '1', '3');
INSERT INTO `material` VALUES ('14', '3', '1', '5', '2', '5');
INSERT INTO `material` VALUES ('15', '2', '1', '10', '1', '3');
INSERT INTO `material` VALUES ('16', '2', '1', '15', '2', '3');
INSERT INTO `material` VALUES ('17', '1', '1', '10', '2', '2');
INSERT INTO `material` VALUES ('18', '2', '1', '40', '2', '2');

-- ----------------------------
-- Table structure for materialtype
-- ----------------------------
DROP TABLE IF EXISTS `materialtype`;
CREATE TABLE `materialtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of materialtype
-- ----------------------------
INSERT INTO `materialtype` VALUES ('1', 'EM3333');
INSERT INTO `materialtype` VALUES ('2', 'EM0113');
INSERT INTO `materialtype` VALUES ('3', 'EM1122');
INSERT INTO `materialtype` VALUES ('4', 'KM1949');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeid` int(11) NOT NULL,
  `inorout` int(11) NOT NULL COMMENT '1出库0入库',
  `time` date NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1', '0', '0000-00-00', '10');
INSERT INTO `record` VALUES ('2', '1', '0', '2019-10-17', '20');
INSERT INTO `record` VALUES ('3', '2', '0', '2019-10-17', '20');
INSERT INTO `record` VALUES ('14', '2', '0', '2019-10-22', '10');
INSERT INTO `record` VALUES ('15', '3', '0', '2019-10-22', '10');
INSERT INTO `record` VALUES ('16', '3', '0', '2019-10-22', '10');
INSERT INTO `record` VALUES ('17', '3', '0', '2019-10-22', '5');
INSERT INTO `record` VALUES ('18', '3', '0', '2019-10-22', '10');
INSERT INTO `record` VALUES ('19', '3', '1', '2019-10-22', '5');
INSERT INTO `record` VALUES ('20', '4', '0', '2019-10-23', '40');
INSERT INTO `record` VALUES ('21', '4', '1', '2019-10-23', '10');
INSERT INTO `record` VALUES ('22', '4', '0', '2019-10-23', '10');
INSERT INTO `record` VALUES ('23', '4', '0', '2019-10-23', '50');
INSERT INTO `record` VALUES ('24', '4', '1', '2019-10-23', '20');
INSERT INTO `record` VALUES ('25', '3', '1', '2019-10-23', '10');
INSERT INTO `record` VALUES ('26', '4', '1', '2019-10-23', '10');
INSERT INTO `record` VALUES ('27', '3', '0', '2019-10-23', '10');
INSERT INTO `record` VALUES ('28', '2', '0', '2019-10-23', '10');
INSERT INTO `record` VALUES ('29', '2', '0', '2019-10-23', '20');
INSERT INTO `record` VALUES ('30', '2', '1', '2019-10-23', '5');
INSERT INTO `record` VALUES ('31', '4', '1', '2019-10-23', '20');
INSERT INTO `record` VALUES ('32', '4', '1', '2019-10-23', '20');
INSERT INTO `record` VALUES ('33', '3', '1', '2019-10-23', '5');
INSERT INTO `record` VALUES ('34', '1', '0', '2019-10-23', '20');
INSERT INTO `record` VALUES ('35', '1', '1', '2019-10-23', '10');
INSERT INTO `record` VALUES ('36', '2', '0', '2019-10-23', '100');
INSERT INTO `record` VALUES ('37', '2', '1', '2019-10-23', '50');
INSERT INTO `record` VALUES ('38', '2', '1', '2019-10-23', '10');

-- ----------------------------
-- Table structure for servicerecord
-- ----------------------------
DROP TABLE IF EXISTS `servicerecord`;
CREATE TABLE `servicerecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `employeeid` int(11) NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of servicerecord
-- ----------------------------
INSERT INTO `servicerecord` VALUES ('1', '1', '1', '净水器保养', '0000-00-00');
INSERT INTO `servicerecord` VALUES ('5', '5', '6', '空调安装', '2019-10-23');

-- ----------------------------
-- Table structure for storehouse
-- ----------------------------
DROP TABLE IF EXISTS `storehouse`;
CREATE TABLE `storehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of storehouse
-- ----------------------------
INSERT INTO `storehouse` VALUES ('1', '2', '2号仓库');
INSERT INTO `storehouse` VALUES ('2', '1', '3号仓库');
INSERT INTO `storehouse` VALUES ('3', '1', '4号仓库');
INSERT INTO `storehouse` VALUES ('5', '3', '1号仓库');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tel` char(11) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', '重庆市净水器配件制造公司', '15111951783');
INSERT INTO `supplier` VALUES ('2', '广东省东莞市净水器配件公司', '13807863451');
INSERT INTO `supplier` VALUES ('3', '深圳市源泉净水器制造有限公司', '13290409688');

-- ----------------------------
-- Table structure for units
-- ----------------------------
DROP TABLE IF EXISTS `units`;
CREATE TABLE `units` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of units
-- ----------------------------
INSERT INTO `units` VALUES ('1', '台');
INSERT INTO `units` VALUES ('2', '个');
INSERT INTO `units` VALUES ('3', '颗');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `companyid` int(11) NOT NULL,
  `depid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin1', '123456', '1', '1');
INSERT INTO `user` VALUES ('2', 'admin2', '123456', '1', '3');
INSERT INTO `user` VALUES ('6', 'admin3', '123456', '1', '3');
INSERT INTO `user` VALUES ('7', 'admin4', '123456', '1', '1');
INSERT INTO `user` VALUES ('8', 'admin5', '123456', '1', '1');
INSERT INTO `user` VALUES ('9', 'admin6', '123456', '1', '1');
INSERT INTO `user` VALUES ('10', 'admin7', '123456', '1', '1');
