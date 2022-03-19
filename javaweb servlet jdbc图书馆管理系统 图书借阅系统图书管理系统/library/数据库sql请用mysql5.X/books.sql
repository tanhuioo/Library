/*
 Navicat Premium Data Transfer

 Source Server         : library
 Source Server Type    : MySQL
 Source Server Version : 50019
 Source Host           : localhost:3306
 Source Schema         : books

 Target Server Type    : MySQL
 Target Server Version : 50019
 File Encoding         : 65001

 Date: 23/07/2021 22:53:09
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET gbk COLLATE gbk_bin NOT NULL DEFAULT '',
  `name` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT 1,
  `lend_num` int(11) NULL DEFAULT NULL,
  `max_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`aid`)
) ENGINE = MyISAM AUTO_INCREMENT = 14 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (2, 'admin', '小红', '123', '1888@qq.com', '18866668888', 2, 99, 99);
INSERT INTO `admin` VALUES (9, '8888', '小绿', '123', '188666@qq.com', '18866668888', 1, 999, 999);
INSERT INTO `admin` VALUES (7, '1001', '小白', '123', '12', '12', 1, 10, 10);
INSERT INTO `admin` VALUES (12, 'test1', '123', '123', '123', '123', 1, 30, 5);
INSERT INTO `admin` VALUES (13, 'tan', '谭慧', '41911094', '2018232584@qq.com', '17828197558', 1, 30, 5);

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(205) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL DEFAULT '',
  `card` varchar(205) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `autho` varchar(205) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `num` int(11) NOT NULL DEFAULT '',
  `press` varchar(205) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `leftnum` int(11) NOT NULL DEFAULT '',
  `lendnum` int(11) NOT NULL DEFAULT '',
  PRIMARY KEY USING BTREE (`bid`),
  UNIQUE INDEX `ISBN` USING BTREE(`card`)
) ENGINE = MyISAM AUTO_INCREMENT = 14 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (9, '五年高考三年模拟', '1002', '成龙', 70, '成龙出版社', '教育教辅', 24, 36);
INSERT INTO `book` VALUES (10, '宇宙的起源', '1003', '史蒂芬霍金', 99, '史蒂夫出版社', '科普', 29, 31);
INSERT INTO `book` VALUES (11, '秘密花园', '1004', '范冰冰', 88, '范冰冰出版社', '小说', 30, 30);
INSERT INTO `book` VALUES (13, '明朝那些事儿', '1005', '犀利哥', 99, '李白出版社', '历史', 29, 31);
INSERT INTO `book` VALUES (1, '三国演义', '1001', '罗贯中', 88, '清华大学出版社', '世界名著', 28, 32);

-- ----------------------------
-- Table structure for booktype
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype`  (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL DEFAULT '',
  PRIMARY KEY USING BTREE (`tid`)
) ENGINE = MyISAM AUTO_INCREMENT = 15 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES (14, '名人传记');
INSERT INTO `booktype` VALUES (6, '科普');
INSERT INTO `booktype` VALUES (5, '世界名著');
INSERT INTO `booktype` VALUES (8, '历史');
INSERT INTO `booktype` VALUES (9, '教育教辅');
INSERT INTO `booktype` VALUES (10, '小说');

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NULL DEFAULT NULL,
  `bid` int(11) NULL DEFAULT NULL,
  `card` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bookname` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `adminname` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `begintime` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endtime` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`hid`)
) ENGINE = MyISAM AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES (33, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-23', 0);
INSERT INTO `history` VALUES (32, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-22', 0);
INSERT INTO `history` VALUES (31, 13, 13, '1005', '明朝那些事儿', 'tan', '谭慧', '2021-7-22', '2021-7-22', 0);
INSERT INTO `history` VALUES (30, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-22', 0);
INSERT INTO `history` VALUES (29, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-22', 0);
INSERT INTO `history` VALUES (28, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-22', 0);
INSERT INTO `history` VALUES (27, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-22', 0);
INSERT INTO `history` VALUES (26, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-22', 0);
INSERT INTO `history` VALUES (25, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-22', 0);
INSERT INTO `history` VALUES (24, 13, 6, '1000', '三国演义', 'tan', '谭慧', '2021-7-21', '2021-7-21', 0);
INSERT INTO `history` VALUES (23, 13, 7, '1001', '红楼梦', 'tan', '谭慧', '2021-7-21', '2021-7-22', 0);
INSERT INTO `history` VALUES (22, 13, 7, '1001', '红楼梦', 'tan', '谭慧', '2021-7-21', '2021-7-22', 0);
INSERT INTO `history` VALUES (19, 13, 9, '1002', '五年高考三年模拟', 'tan', '谭慧', '2021-7-17', '2021-7-17', 0);
INSERT INTO `history` VALUES (20, 13, 7, '1001', '红楼梦', 'tan', '谭慧', '2021-7-19', '2021-7-21', 0);
INSERT INTO `history` VALUES (21, 13, 6, '1000', '三国演义', 'tan', '谭慧', '2021-7-21', '2021-7-21', 0);
INSERT INTO `history` VALUES (34, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-23', 0);
INSERT INTO `history` VALUES (35, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-23', 0);
INSERT INTO `history` VALUES (36, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-23', 0);
INSERT INTO `history` VALUES (37, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-23', 0);
INSERT INTO `history` VALUES (38, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-23', 0);
INSERT INTO `history` VALUES (39, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-23', 0);
INSERT INTO `history` VALUES (40, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-22', '2021-7-23', 0);
INSERT INTO `history` VALUES (41, 13, 9, '1002', '五年高考三年模拟', 'tan', '谭慧', '2021-7-22', '2021-7-23', 0);
INSERT INTO `history` VALUES (42, 13, 1, '1001', '三国演义', 'tan', '谭慧', '2021-7-22', '2021-7-23', 0);
INSERT INTO `history` VALUES (43, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-23', '2021-7-23', 0);
INSERT INTO `history` VALUES (44, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-23', '2021-7-23', 0);
INSERT INTO `history` VALUES (45, 13, 9, '1002', '五年高考三年模拟', 'tan', '谭慧', '2021-7-23', '2021-7-23', 0);
INSERT INTO `history` VALUES (46, 13, 9, '1002', '五年高考三年模拟', 'tan', '谭慧', '2021-7-23', '2021-7-23', 0);
INSERT INTO `history` VALUES (47, 13, 9, '1002', '五年高考三年模拟', 'tan', '谭慧', '2021-7-23', '2021-7-23', 0);
INSERT INTO `history` VALUES (48, 13, 13, '1005', '明朝那些事儿', 'tan', '谭慧', '2021-7-23', '2021-7-23', 0);
INSERT INTO `history` VALUES (49, 13, 10, '1003', '宇宙的起源', 'tan', '谭慧', '2021-7-23', '2021-7-23', 0);
INSERT INTO `history` VALUES (50, 13, 10, '1003', '宇宙的起源', 'tan', '谭慧', '2021-7-23', '2021-7-23', 0);
INSERT INTO `history` VALUES (51, 13, 11, '1004', '秘密花园', 'tan', '谭慧', '2021-7-23', '2021-7-23', 0);
INSERT INTO `history` VALUES (52, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-23', '2021-7-23', 0);
INSERT INTO `history` VALUES (53, 13, 13, '1005', '明朝那些事儿', 'tan', '谭慧', '2021-7-23', '2021-7-23', 0);
INSERT INTO `history` VALUES (54, 13, 8, '6666', 'java修炼之道', 'tan', '谭慧', '2021-7-23', '2021-7-23', 0);
INSERT INTO `history` VALUES (55, 13, 1, '1001', '三国演义', 'tan', '谭慧', '2021-7-23', '2021-8-23', 1);
INSERT INTO `history` VALUES (56, 13, 9, '1002', '五年高考三年模拟', 'tan', '谭慧', '2021-7-23', '2021-8-23', 1);
INSERT INTO `history` VALUES (57, 13, 9, '1002', '五年高考三年模拟', 'tan', '谭慧', '2021-7-23', '2021-8-23', 1);
INSERT INTO `history` VALUES (58, 13, 9, '1002', '五年高考三年模拟', 'tan', '谭慧', '2021-7-23', '2021-8-23', 1);
INSERT INTO `history` VALUES (59, 13, 9, '1002', '五年高考三年模拟', 'tan', '谭慧', '2021-7-23', '2021-8-23', 1);
INSERT INTO `history` VALUES (60, 13, 9, '1002', '五年高考三年模拟', 'tan', '谭慧', '2021-7-23', '2021-8-23', 1);

SET FOREIGN_KEY_CHECKS = 1;
