/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306密码root
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : keshe

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 15/09/2019 11:13:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_bil
-- ----------------------------
DROP TABLE IF EXISTS `tb_bil`;
CREATE TABLE `tb_bil`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户',
  `flowmoney` decimal(10, 2) DEFAULT NULL COMMENT '金钱流动',
  `whatdoing` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '干啥了',
  `donetime` timestamp(0) DEFAULT CURRENT_TIMESTAMP COMMENT '啥时候干的',
  `isbuyoradd` int(2) DEFAULT NULL COMMENT '1为+0为-',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bill`(`user`) USING BTREE,
  CONSTRAINT `tb_bil_ibfk_1` FOREIGN KEY (`user`) REFERENCES `tb_secret_user` (`user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 226 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_bil
-- ----------------------------
INSERT INTO `tb_bil` VALUES (53, 'abc', 4.20, '购买了红西瓜2斤', '2019-08-10 19:31:18', 0);
INSERT INTO `tb_bil` VALUES (54, 'abc', 200.00, '充值', '2019-08-10 19:38:59', 1);
INSERT INTO `tb_bil` VALUES (55, 'abc', 123.00, '充值', '2019-08-10 20:07:33', 1);
INSERT INTO `tb_bil` VALUES (56, 'abc', 1.00, '充值', '2019-08-10 20:12:04', 1);
INSERT INTO `tb_bil` VALUES (57, 'abc', 1.00, '充值', '2019-08-10 20:14:57', 1);
INSERT INTO `tb_bil` VALUES (62, 'qiu', 3.00, '充值', '2019-08-10 20:25:26', 1);
INSERT INTO `tb_bil` VALUES (63, 'qiu', 100.00, '充值', '2019-08-10 20:25:33', 1);
INSERT INTO `tb_bil` VALUES (64, 'qiu', 6.00, '购买了向日癸子3斤', '2019-08-10 20:26:58', 0);
INSERT INTO `tb_bil` VALUES (65, 'qiu', 8.00, '购买了黄瓜4斤', '2019-08-10 20:27:17', 0);
INSERT INTO `tb_bil` VALUES (76, 'three', 100.00, '充值', '2019-08-10 20:42:06', 1);
INSERT INTO `tb_bil` VALUES (77, 'three', 100.00, '充值', '2019-08-10 20:42:23', 1);
INSERT INTO `tb_bil` VALUES (78, 'four', 20.00, '充值', '2019-08-10 20:43:52', 1);
INSERT INTO `tb_bil` VALUES (79, 'five', 100.00, '充值', '2019-08-10 20:49:53', 1);
INSERT INTO `tb_bil` VALUES (80, 'five', 4.20, '购买了红西瓜2斤', '2019-08-10 20:51:43', 0);
INSERT INTO `tb_bil` VALUES (81, 'six', 100.00, '充值', '2019-08-10 20:52:32', 1);
INSERT INTO `tb_bil` VALUES (82, 'six', 123.00, '充值', '2019-08-10 20:53:14', 1);
INSERT INTO `tb_bil` VALUES (83, 'six', 100.00, '充值', '2019-08-10 20:55:22', 1);
INSERT INTO `tb_bil` VALUES (84, 'six', 1.00, '充值', '2019-08-10 20:55:37', 1);
INSERT INTO `tb_bil` VALUES (85, 'se', 123.00, '充值', '2019-08-10 20:55:58', 1);
INSERT INTO `tb_bil` VALUES (86, 'se', 2.10, '购买了红西瓜1斤', '2019-08-10 21:02:45', 0);
INSERT INTO `tb_bil` VALUES (87, 'se', 2.10, '购买了红西瓜1斤', '2019-08-10 21:02:55', 0);
INSERT INTO `tb_bil` VALUES (88, 'se', 2.10, '购买了红西瓜1斤', '2019-08-10 21:05:22', 0);
INSERT INTO `tb_bil` VALUES (89, 'se', 2.10, '购买了红西瓜1斤', '2019-08-10 21:07:40', 0);
INSERT INTO `tb_bil` VALUES (90, 'se', 6.30, '购买了红西瓜3斤', '2019-08-10 21:07:44', 0);
INSERT INTO `tb_bil` VALUES (91, 'five', 1.00, '充值', '2019-08-10 21:08:38', 1);
INSERT INTO `tb_bil` VALUES (92, 'five', 2.00, '购买了向日癸子1斤', '2019-08-10 21:08:54', 0);
INSERT INTO `tb_bil` VALUES (93, 'five', 6.00, '购买了向日癸子3斤', '2019-08-10 21:08:59', 0);
INSERT INTO `tb_bil` VALUES (94, 'hh', 123.00, '充值', '2019-08-10 21:12:56', 1);
INSERT INTO `tb_bil` VALUES (95, 'hh', 2.10, '购买了红西瓜1斤', '2019-08-10 21:13:01', 0);
INSERT INTO `tb_bil` VALUES (96, 'hh', 8.40, '购买了红西瓜4斤', '2019-08-10 21:13:09', 0);
INSERT INTO `tb_bil` VALUES (97, 'abc', 425.00, '购买了黄西瓜17斤', '2019-08-10 23:21:43', 0);
INSERT INTO `tb_bil` VALUES (98, 'abc', 6.30, '购买了红西瓜3斤', '2019-08-10 23:21:59', 0);
INSERT INTO `tb_bil` VALUES (99, 'abc', 8.00, '购买了黄瓜4斤', '2019-08-10 23:22:06', 0);
INSERT INTO `tb_bil` VALUES (100, 'abc', 10.00, '充值', '2019-08-10 23:24:51', 1);
INSERT INTO `tb_bil` VALUES (101, 'abc', 100.00, '充值', '2019-08-11 11:24:26', 1);
INSERT INTO `tb_bil` VALUES (102, 'abc', 30.00, '购买了樱桃3斤', '2019-08-11 11:24:33', 0);
INSERT INTO `tb_bil` VALUES (103, 'abc', 15.00, '购买了车厘子1斤', '2019-08-11 11:54:19', 0);
INSERT INTO `tb_bil` VALUES (104, 'abc', 12.00, '购买了葡萄1斤', '2019-08-11 11:56:32', 0);
INSERT INTO `tb_bil` VALUES (105, 'abc', 4.00, '购买了梨子1斤', '2019-08-11 12:03:01', 0);
INSERT INTO `tb_bil` VALUES (106, 'abc', 30.00, '购买了车厘子2斤', '2019-08-11 14:43:32', 0);
INSERT INTO `tb_bil` VALUES (107, 'abc', 15.00, '购买了车厘子1斤', '2019-08-11 14:52:37', 0);
INSERT INTO `tb_bil` VALUES (108, 'abc', 2.10, '购买了红西瓜1斤', '2019-08-11 14:54:06', 0);
INSERT INTO `tb_bil` VALUES (109, 'abc', 100.00, '充值', '2019-08-11 14:55:32', 1);
INSERT INTO `tb_bil` VALUES (110, 'abc', 2.10, '购买了红西瓜1斤', '2019-08-11 14:55:45', 0);
INSERT INTO `tb_bil` VALUES (111, 'abc', 2.10, '购买了红西瓜1斤', '2019-08-11 15:15:57', 0);
INSERT INTO `tb_bil` VALUES (112, 'abc', 2.10, '购买了红西瓜1斤', '2019-08-11 15:17:38', 0);
INSERT INTO `tb_bil` VALUES (113, 'six', 2.10, '购买了红西瓜1斤', '2019-08-11 15:59:22', 0);
INSERT INTO `tb_bil` VALUES (114, 'six', 10.00, '购买了樱桃1斤', '2019-08-11 15:59:47', 0);
INSERT INTO `tb_bil` VALUES (115, 'six', 6.00, '购买了黄瓜3斤', '2019-08-11 17:13:05', 0);
INSERT INTO `tb_bil` VALUES (116, 'six', 10.00, '购买了樱桃1斤', '2019-08-11 17:13:37', 0);
INSERT INTO `tb_bil` VALUES (117, 'six', 12.00, '购买了葡萄1斤', '2019-08-11 17:13:55', 0);
INSERT INTO `tb_bil` VALUES (118, 'six', 25.00, '购买了黄西瓜1斤', '2019-08-11 17:14:49', 0);
INSERT INTO `tb_bil` VALUES (119, 'six', 20.00, '购买了海南芒果1斤', '2019-08-11 17:14:58', 0);
INSERT INTO `tb_bil` VALUES (120, 'six', 4.00, '购买了梨子1斤', '2019-08-11 17:16:46', 0);
INSERT INTO `tb_bil` VALUES (121, 'abc', 25.00, '购买了黄西瓜1斤', '2019-08-11 17:20:12', 0);
INSERT INTO `tb_bil` VALUES (122, 'abc', 15.00, '购买了车厘子1斤', '2019-08-11 17:21:09', 0);
INSERT INTO `tb_bil` VALUES (123, 'abc', 4.00, '购买了黄瓜2斤', '2019-08-11 18:46:09', 0);
INSERT INTO `tb_bil` VALUES (124, 'abc', 2.10, '购买了红西瓜1斤', '2019-08-11 22:00:23', 0);
INSERT INTO `tb_bil` VALUES (125, 'abc', 2.10, '购买了红西瓜1斤', '2019-08-11 22:10:18', 0);
INSERT INTO `tb_bil` VALUES (126, 'abc', 2.00, '购买了向日癸子1斤', '2019-08-11 22:10:52', 0);
INSERT INTO `tb_bil` VALUES (127, 'abc', 2.10, '购买了红西瓜1斤', '2019-08-11 22:12:30', 0);
INSERT INTO `tb_bil` VALUES (128, 'abc', 20.00, '购买了海南芒果1斤', '2019-08-11 22:15:04', 0);
INSERT INTO `tb_bil` VALUES (129, 'abc', 100.00, '充值', '2019-08-11 22:22:17', 1);
INSERT INTO `tb_bil` VALUES (130, 'abc', 100.00, '充值', '2019-08-11 22:25:26', 1);
INSERT INTO `tb_bil` VALUES (131, 'abc', 23.10, '购买了红西瓜11斤', '2019-08-11 22:26:34', 0);
INSERT INTO `tb_bil` VALUES (132, 'happy', 100.00, '充值', '2019-08-12 18:57:11', 1);
INSERT INTO `tb_bil` VALUES (133, 'happy', 8.40, '购买了红西瓜4斤', '2019-08-12 18:57:24', 0);
INSERT INTO `tb_bil` VALUES (134, 'happy', 6.00, '购买了黄瓜3斤', '2019-08-13 12:06:56', 0);
INSERT INTO `tb_bil` VALUES (135, 'happy', 30.00, '购买了樱桃3斤', '2019-08-13 15:46:52', 0);
INSERT INTO `tb_bil` VALUES (136, 'happy', 20.00, '购买了海南芒果1斤', '2019-08-13 15:48:38', 0);
INSERT INTO `tb_bil` VALUES (137, 'happy', 2.10, '购买了红西瓜1斤', '2019-08-13 15:49:56', 0);
INSERT INTO `tb_bil` VALUES (138, 'happy', 15.00, '购买了车厘子1斤', '2019-08-13 16:04:59', 0);
INSERT INTO `tb_bil` VALUES (139, 'happy', 2.00, '购买了向日癸子1斤', '2019-08-13 16:13:28', 0);
INSERT INTO `tb_bil` VALUES (140, 'happy', 2.10, '购买了红西瓜1斤', '2019-08-13 16:18:07', 0);
INSERT INTO `tb_bil` VALUES (141, 'happy', 100.00, '充值', '2019-08-13 16:48:35', 1);
INSERT INTO `tb_bil` VALUES (142, 'happy', 40.00, '购买了海南芒果2斤', '2019-08-13 16:48:45', 0);
INSERT INTO `tb_bil` VALUES (143, 'happy', 20.00, '购买了海南芒果1斤', '2019-08-13 16:54:47', 0);
INSERT INTO `tb_bil` VALUES (144, 'happy', 2.00, '购买了黄瓜1斤', '2019-08-13 16:56:45', 0);
INSERT INTO `tb_bil` VALUES (145, 'happy', 2.10, '购买了红西瓜1斤', '2019-08-13 17:01:30', 0);
INSERT INTO `tb_bil` VALUES (146, 'happy', 1000.00, '充值', '2019-08-13 17:04:33', 1);
INSERT INTO `tb_bil` VALUES (147, 'happy', 2.10, '购买了红西瓜1斤', '2019-08-13 17:04:43', 0);
INSERT INTO `tb_bil` VALUES (148, 'happy', 2.00, '购买了黄瓜1斤', '2019-08-13 17:04:49', 0);
INSERT INTO `tb_bil` VALUES (149, 'happy', 20.00, '购买了海南芒果1斤', '2019-08-13 17:10:16', 0);
INSERT INTO `tb_bil` VALUES (150, 'happy', 2.00, '购买了向日癸子1斤', '2019-08-13 17:10:34', 0);
INSERT INTO `tb_bil` VALUES (151, 'happy', 4.00, '购买了梨子1斤', '2019-08-13 17:11:58', 0);
INSERT INTO `tb_bil` VALUES (152, 'happy', 15.00, '购买了车厘子1斤', '2019-08-13 17:12:11', 0);
INSERT INTO `tb_bil` VALUES (153, 'happy', 4.00, '购买了梨子1斤', '2019-08-13 17:12:53', 0);
INSERT INTO `tb_bil` VALUES (154, 'happy', 2.10, '购买了红西瓜1斤', '2019-08-13 17:17:03', 0);
INSERT INTO `tb_bil` VALUES (155, 'happy', 12.00, '购买了葡萄1斤', '2019-08-13 17:20:02', 0);
INSERT INTO `tb_bil` VALUES (156, 'happy', 4.00, '购买了梨子1斤', '2019-08-13 17:21:59', 0);
INSERT INTO `tb_bil` VALUES (157, 'happy', 15.00, '购买了车厘子1斤', '2019-08-13 17:22:06', 0);
INSERT INTO `tb_bil` VALUES (158, 'happy', 10.00, '购买了樱桃1斤', '2019-08-13 17:22:12', 0);
INSERT INTO `tb_bil` VALUES (159, 'happy', 15.00, '购买了车厘子1斤', '2019-08-13 17:29:39', 0);
INSERT INTO `tb_bil` VALUES (160, 'happy', 4.00, '购买了梨子1斤', '2019-08-13 17:29:45', 0);
INSERT INTO `tb_bil` VALUES (161, 'happy', 10.00, '购买了樱桃1斤', '2019-08-13 17:31:42', 0);
INSERT INTO `tb_bil` VALUES (162, 'happy', 20.00, '购买了海南芒果1斤', '2019-08-13 17:31:53', 0);
INSERT INTO `tb_bil` VALUES (163, 'happy', 4.00, '购买了梨子1斤', '2019-08-13 17:35:27', 0);
INSERT INTO `tb_bil` VALUES (164, 'happy', 2.00, '购买了向日癸子1斤', '2019-08-13 17:36:45', 0);
INSERT INTO `tb_bil` VALUES (165, 'happy', 10.00, '购买了樱桃1斤', '2019-08-13 17:37:19', 0);
INSERT INTO `tb_bil` VALUES (166, 'happy', 4.00, '购买了梨子1斤', '2019-08-13 17:45:15', 0);
INSERT INTO `tb_bil` VALUES (167, 'happy', 15.00, '购买了车厘子1斤', '2019-08-13 17:45:22', 0);
INSERT INTO `tb_bil` VALUES (168, 'happy', 2.00, '购买了向日癸子1斤', '2019-08-13 17:46:43', 0);
INSERT INTO `tb_bil` VALUES (169, 'happy', 15.00, '购买了车厘子1斤', '2019-08-13 17:46:51', 0);
INSERT INTO `tb_bil` VALUES (170, 'happy', 2.00, '购买了黄瓜1斤', '2019-08-13 17:50:10', 0);
INSERT INTO `tb_bil` VALUES (171, 'happy', 20.00, '购买了海南芒果1斤', '2019-08-13 17:50:15', 0);
INSERT INTO `tb_bil` VALUES (172, 'happy', 2.10, '购买了红西瓜1斤', '2019-08-13 17:54:02', 0);
INSERT INTO `tb_bil` VALUES (173, 'happy', 20.00, '购买了海南芒果1斤', '2019-08-13 17:54:07', 0);
INSERT INTO `tb_bil` VALUES (174, 'happy', 2.00, '购买了向日癸子1斤', '2019-08-13 18:00:02', 0);
INSERT INTO `tb_bil` VALUES (175, 'happy', 2.10, '购买了红西瓜1斤', '2019-08-13 18:03:08', 0);
INSERT INTO `tb_bil` VALUES (176, 'happy', 10.00, '购买了樱桃1斤', '2019-08-13 18:06:16', 0);
INSERT INTO `tb_bil` VALUES (177, 'happy', 15.00, '购买了车厘子1斤', '2019-08-13 18:06:22', 0);
INSERT INTO `tb_bil` VALUES (178, 'happy', 4.00, '购买了梨子1斤', '2019-08-13 18:06:32', 0);
INSERT INTO `tb_bil` VALUES (179, 'happy', 20.00, '购买了海南芒果1斤', '2019-08-13 18:06:37', 0);
INSERT INTO `tb_bil` VALUES (180, 'happy', 2.00, '购买了向日癸子1斤', '2019-08-13 18:13:06', 0);
INSERT INTO `tb_bil` VALUES (181, 'happy', 2.10, '购买了红西瓜1斤', '2019-08-13 18:15:57', 0);
INSERT INTO `tb_bil` VALUES (182, 'happy', 20.00, '购买了樱桃2斤', '2019-08-13 19:30:02', 0);
INSERT INTO `tb_bil` VALUES (183, 'happy', 2.00, '购买了黄瓜1斤', '2019-08-13 19:40:20', 0);
INSERT INTO `tb_bil` VALUES (184, 'happy', 2.00, '购买了黄瓜1斤', '2019-08-13 20:26:19', 0);
INSERT INTO `tb_bil` VALUES (185, 'happy', 10.00, '购买了樱桃1斤', '2019-08-13 20:31:44', 0);
INSERT INTO `tb_bil` VALUES (186, 'happy', 15.00, '购买了车厘子1斤', '2019-08-13 20:32:55', 0);
INSERT INTO `tb_bil` VALUES (187, 'happy', 20.00, '购买了海南芒果1斤', '2019-08-13 20:35:42', 0);
INSERT INTO `tb_bil` VALUES (188, 'happy', 15.00, '购买了车厘子1斤', '2019-08-13 20:36:40', 0);
INSERT INTO `tb_bil` VALUES (189, 'happy', 10.00, '购买了樱桃1斤', '2019-08-13 20:37:50', 0);
INSERT INTO `tb_bil` VALUES (190, 'happy', 4.00, '购买了梨子1斤', '2019-08-13 20:40:27', 0);
INSERT INTO `tb_bil` VALUES (191, 'happy', 2.00, '购买了黄瓜1斤', '2019-08-13 20:40:46', 0);
INSERT INTO `tb_bil` VALUES (192, 'happy', 2.10, '购买了红西瓜1斤', '2019-08-13 20:41:25', 0);
INSERT INTO `tb_bil` VALUES (193, 'happy', 2.00, '购买了黄瓜1斤', '2019-08-13 20:42:23', 0);
INSERT INTO `tb_bil` VALUES (194, 'happy', 20.00, '购买了海南芒果1斤', '2019-08-13 20:56:17', 0);
INSERT INTO `tb_bil` VALUES (195, 'happy', 4.00, '购买了黄瓜2斤', '2019-08-14 11:18:35', 0);
INSERT INTO `tb_bil` VALUES (196, 'happy', 23.00, '购买了蓝莓1斤', '2019-08-14 14:00:18', 0);
INSERT INTO `tb_bil` VALUES (197, 'happy', 23.00, '购买了蓝莓1斤', '2019-08-14 15:22:14', 0);
INSERT INTO `tb_bil` VALUES (198, 'happy', 23.00, '购买了蓝莓1斤', '2019-08-14 15:22:55', 0);
INSERT INTO `tb_bil` VALUES (199, 'happy', 23.00, '购买了蓝莓1斤', '2019-08-14 15:27:54', 0);
INSERT INTO `tb_bil` VALUES (200, 'fire', 1000.00, '充值', '2019-08-14 15:50:33', 1);
INSERT INTO `tb_bil` VALUES (201, 'fire', 25.00, '购买了黄西瓜1斤', '2019-08-14 15:53:24', 0);
INSERT INTO `tb_bil` VALUES (202, 'fire', 4.20, '购买了红西瓜2斤', '2019-08-16 09:44:57', 0);
INSERT INTO `tb_bil` VALUES (203, 'fire', 30.00, '购买了车厘子2斤', '2019-08-16 09:46:48', 0);
INSERT INTO `tb_bil` VALUES (204, 'fire', 15.00, '购买了车厘子1斤', '2019-08-16 13:32:16', 0);
INSERT INTO `tb_bil` VALUES (205, 'fire', 20.00, '购买了海南芒果1斤', '2019-08-16 15:56:26', 0);
INSERT INTO `tb_bil` VALUES (206, 'fire', 2.00, '购买了黄瓜1斤', '2019-08-16 15:57:50', 0);
INSERT INTO `tb_bil` VALUES (207, 'fire', 2.00, '购买了黄瓜1斤', '2019-08-16 16:57:21', 0);
INSERT INTO `tb_bil` VALUES (208, 'fire', 15.00, '购买了车厘子1斤', '2019-08-16 16:57:21', 0);
INSERT INTO `tb_bil` VALUES (209, 'fire', 60.00, '购买了海南芒果3斤', '2019-08-16 17:13:18', 0);
INSERT INTO `tb_bil` VALUES (210, 'fire', 2.00, '购买了黄瓜1斤', '2019-08-16 17:14:15', 0);
INSERT INTO `tb_bil` VALUES (211, 'fire', 2.00, '购买了黄瓜1斤', '2019-08-16 17:14:39', 0);
INSERT INTO `tb_bil` VALUES (212, 'fire', 4.00, '购买了黄瓜2斤', '2019-08-16 17:14:52', 0);
INSERT INTO `tb_bil` VALUES (213, 'fire', 4.20, '购买了红西瓜2斤', '2019-08-16 17:15:06', 0);
INSERT INTO `tb_bil` VALUES (214, 'fire', 30.00, '购买了车厘子2斤', '2019-08-16 17:15:24', 0);
INSERT INTO `tb_bil` VALUES (215, 'fire', 46.00, '购买了蓝莓2斤', '2019-08-16 17:16:55', 0);
INSERT INTO `tb_bil` VALUES (216, 'fire', 46.00, '购买了蓝莓2斤', '2019-08-16 17:23:05', 0);
INSERT INTO `tb_bil` VALUES (217, NULL, NULL, NULL, '2019-08-16 17:31:40', 0);
INSERT INTO `tb_bil` VALUES (218, NULL, NULL, NULL, '2019-08-16 17:31:51', 0);
INSERT INTO `tb_bil` VALUES (219, 'fire', 23.00, '购买了蓝莓1斤', '2019-08-16 17:39:37', 0);
INSERT INTO `tb_bil` VALUES (220, 'fire', 2.10, '购买了红西瓜1斤', '2019-08-16 17:42:22', 0);
INSERT INTO `tb_bil` VALUES (221, 'fire', 4.00, '购买了梨子1斤', '2019-08-16 18:29:04', 0);
INSERT INTO `tb_bil` VALUES (222, 'fire', 2.00, '购买了黄瓜1斤', '2019-08-17 12:12:09', 0);
INSERT INTO `tb_bil` VALUES (223, 'lihaonan', 100.00, '充值', '2019-08-23 20:47:49', 1);
INSERT INTO `tb_bil` VALUES (224, 'qiujunbin', 100.00, '充值', '2019-08-28 09:42:24', 1);

-- ----------------------------
-- Table structure for tb_chat_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_chat_message`;
CREATE TABLE `tb_chat_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '信息发送者',
  `receiver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '信息接收者',
  `topic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主题',
  `message` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '信息主体',
  `isread` int(2) DEFAULT NULL COMMENT '1为未阅读、0未已读',
  `sendtime` timestamp(0) DEFAULT CURRENT_TIMESTAMP COMMENT '发送时间',
  `senderheadimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发送者的头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_chat_message
-- ----------------------------
INSERT INTO `tb_chat_message` VALUES (40, 'yang', 'admin', '123', '123', 0, '2019-07-31 11:33:17', '53361b59-d91f-407a-894a-4cdb6fccdc2c.png');
INSERT INTO `tb_chat_message` VALUES (41, 'yang', 'admin', '222', '222', 0, '2019-07-31 12:26:46', '53361b59-d91f-407a-894a-4cdb6fccdc2c.png');
INSERT INTO `tb_chat_message` VALUES (42, 'yang', 'admin', 'nihao', 'hhhhhhhh', 0, '2019-08-02 09:15:00', '53361b59-d91f-407a-894a-4cdb6fccdc2c.png');
INSERT INTO `tb_chat_message` VALUES (43, '吴纯纯', 'admin', '我顶我顶', '草你', 0, '2019-08-04 20:10:43', '40cc17b7-7c56-460f-9c0d-87cb36b5e1a7.jpg');
INSERT INTO `tb_chat_message` VALUES (44, '吴纯纯', 'admin', 'weqwd', 'wwqdqd', 0, '2019-08-04 20:13:07', '40cc17b7-7c56-460f-9c0d-87cb36b5e1a7.jpg');
INSERT INTO `tb_chat_message` VALUES (45, 'admin', 'henry', '你哈珀', '哈哈哈哈哈哈', 0, '2019-08-29 10:52:10', '023a2aaf-1db6-4d4c-abb7-af19e51b5806.jpg');

-- ----------------------------
-- Table structure for tb_express_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_express_info`;
CREATE TABLE `tb_express_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transfername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人昵称',
  `tellphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人电话',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人地址',
  `buyer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '购买者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_express_info
-- ----------------------------
INSERT INTO `tb_express_info` VALUES (1, 'wcc', '18858710494', '平阳省昆阳市大自然镇', 'abc');
INSERT INTO `tb_express_info` VALUES (4, 'qiujb', '18358727103', '平阳县昆阳市法院后面县', 'abc');
INSERT INTO `tb_express_info` VALUES (5, 'qiujb', '18358727103', '平阳', 'happy');
INSERT INTO `tb_express_info` VALUES (6, 'wcc', '123', '浙江省温州市平阳县昆阳镇', 'fire');
INSERT INTO `tb_express_info` VALUES (13, 'henry', '1234456', '温州', 'qiu');

-- ----------------------------
-- Table structure for tb_order_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_comment`;
CREATE TABLE `tb_order_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名',
  `buycount` int(11) DEFAULT NULL COMMENT '购买的斤数',
  `consume` decimal(10, 2) DEFAULT NULL COMMENT '花费数',
  `buyer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '购买者',
  `shopimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片',
  `commenttext` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评语',
  `commentpoint` decimal(10, 2) DEFAULT NULL COMMENT '评分',
  `commenttime` timestamp(0) DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `buyerheadimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '购买者头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_order_comment
-- ----------------------------
INSERT INTO `tb_order_comment` VALUES (1, '黄瓜', 3, 6.00, 'happy', '黄瓜.png', '好吃', 4.50, '2019-08-13 15:34:37', NULL);
INSERT INTO `tb_order_comment` VALUES (2, '红西瓜', 4, 8.40, 'happy', '红西瓜.png', '太老了', 3.50, '2019-08-13 15:45:40', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (3, '樱桃', 3, 30.00, 'happy', '樱桃.png', '没有评论', 4.00, '2019-08-13 15:47:12', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (4, '海南芒果', 1, 20.00, 'happy', '海南芒果.png', '没有评论', 5.00, '2019-08-13 15:48:58', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (5, '红西瓜', 1, 2.10, 'happy', '红西瓜.png', '没有评论', 5.00, '2019-08-13 15:50:07', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (6, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 16:05:10', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (7, '向日癸子', 1, 2.00, 'happy', '向日癸子.png', '没有评论', 5.00, '2019-08-13 16:13:38', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (8, '红西瓜', 1, 2.10, 'happy', '红西瓜.png', '没有评论', 5.00, '2019-08-13 16:18:15', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (9, '海南芒果', 2, 40.00, 'happy', '海南芒果.png', '没有评论', 5.00, '2019-08-13 16:53:02', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (10, '海南芒果', 2, 40.00, 'happy', '海南芒果.png', '没有评论', 5.00, '2019-08-13 16:55:14', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (11, '黄瓜', 1, 2.00, 'happy', '黄瓜.png', '没有评论', 5.00, '2019-08-13 17:01:51', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (12, '黄瓜', 1, 2.00, 'happy', '黄瓜.png', '123', 5.00, '2019-08-13 17:05:20', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (13, '黄瓜', 1, 2.00, 'happy', '黄瓜.png', '123', 5.00, '2019-08-13 17:05:28', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (14, '黄瓜', 1, 2.00, 'happy', '黄瓜.png', 'nihso', 5.00, '2019-08-13 17:06:09', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (15, '黄瓜', 1, 2.00, 'happy', '黄瓜.png', '没有评论', 5.00, '2019-08-13 17:06:32', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (16, '海南芒果', 1, 20.00, 'happy', '海南芒果.png', '没有评论', 5.00, '2019-08-13 17:06:41', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (17, '海南芒果', 1, 20.00, 'happy', '海南芒果.png', '没有评论', 5.00, '2019-08-13 17:06:49', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (18, '红西瓜', 1, 2.10, 'happy', '红西瓜.png', '没有评论', 5.00, '2019-08-13 17:08:18', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (19, '红西瓜', 1, 2.10, 'happy', '红西瓜.png', '没有评论', 5.00, '2019-08-13 17:08:19', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (20, '红西瓜', 1, 2.10, 'happy', '红西瓜.png', '没有评论', 5.00, '2019-08-13 17:09:18', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (21, '海南芒果', 1, 20.00, 'happy', '海南芒果.png', '没有评论', 5.00, '2019-08-13 17:10:44', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (22, '海南芒果', 1, 20.00, 'happy', '海南芒果.png', '没有评论', 5.00, '2019-08-13 17:10:47', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (23, '向日癸子', 1, 2.00, 'happy', '向日癸子.png', '没有评论', 5.00, '2019-08-13 17:11:09', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (24, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 17:13:16', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (25, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 17:13:20', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (26, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 17:13:26', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (27, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 17:13:37', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (28, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 17:14:55', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (29, '红西瓜', 1, 2.10, 'happy', '红西瓜.png', '没有评论', 5.00, '2019-08-13 17:17:32', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (30, '红西瓜', 1, 2.10, 'happy', '红西瓜.png', '没有评论', 5.00, '2019-08-13 17:17:35', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (31, '葡萄', 1, 12.00, 'happy', '紫葡萄.png', '没有评论', 5.00, '2019-08-13 17:20:28', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (32, '葡萄', 1, 12.00, 'happy', '紫葡萄.png', '没有评论', 5.00, '2019-08-13 17:21:17', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (33, '葡萄', 1, 12.00, 'happy', '紫葡萄.png', '没有评论', 5.00, '2019-08-13 17:21:26', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (34, '葡萄', 1, 12.00, 'happy', '紫葡萄.png', '没有评论', 5.00, '2019-08-13 17:22:39', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (35, '樱桃', 1, 10.00, 'happy', '樱桃.png', '没有评论', 5.00, '2019-08-13 17:22:52', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (36, '樱桃', 1, 10.00, 'happy', '樱桃.png', '没有评论', 5.00, '2019-08-13 17:22:55', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (37, '樱桃', 1, 10.00, 'happy', '樱桃.png', '没有评论', 5.00, '2019-08-13 17:23:19', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (38, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 17:29:21', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (39, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 17:30:03', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (40, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 17:30:08', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (41, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 17:30:11', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (42, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 17:30:14', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (43, '海南芒果', 1, 20.00, 'happy', '海南芒果.png', '没有评论', 5.00, '2019-08-13 17:32:12', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (44, '海南芒果', 1, 20.00, 'happy', '海南芒果.png', '没有评论', 5.00, '2019-08-13 17:32:32', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (45, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 17:45:39', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (46, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 17:45:41', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (47, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 17:47:17', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (48, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 17:47:24', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (49, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 17:50:22', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (50, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 17:50:25', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (51, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 17:51:39', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (52, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 17:53:09', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (53, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 17:53:15', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (54, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 17:53:22', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (55, '红西瓜', 1, 2.10, 'happy', '红西瓜.png', '没有评论', 5.00, '2019-08-13 17:53:34', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (56, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 17:53:42', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (57, '海南芒果', 1, 20.00, 'happy', '海南芒果.png', '没有评论', 5.00, '2019-08-13 17:54:31', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (58, '红西瓜', 1, 2.10, 'happy', '红西瓜.png', '没有评论', 5.00, '2019-08-13 17:54:33', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (59, '向日癸子', 1, 2.00, 'happy', '向日癸子.png', '没有评论', 5.00, '2019-08-13 18:00:34', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (60, '红西瓜', 1, 2.10, 'happy', '红西瓜.png', '没有评论', 5.00, '2019-08-13 18:03:28', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (61, '红西瓜', 1, 2.10, 'happy', '红西瓜.png', '没有评论', 5.00, '2019-08-13 18:07:09', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (62, '樱桃', 1, 10.00, 'happy', '樱桃.png', '没有评论', 5.00, '2019-08-13 18:07:43', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (63, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 18:08:25', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (64, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 18:08:40', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (65, '车厘子', 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 18:08:52', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (66, NULL, 1, 2.00, 'happy', '向日癸子.png', '没有评论', 5.00, '2019-08-13 18:13:36', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (67, NULL, 1, 2.00, 'happy', '向日癸子.png', '没有评论', 5.00, '2019-08-13 18:13:44', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (68, NULL, 1, 2.10, 'happy', '红西瓜.png', '没有评论', 5.00, '2019-08-13 18:16:09', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (69, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 18:16:14', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (70, '向日癸子', 1, 2.00, 'happy', '向日癸子.png', '没有评论', 5.00, '2019-08-13 18:17:57', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (71, NULL, 1, 2.00, 'happy', '黄瓜.png', '没有评论', 5.00, '2019-08-13 19:40:32', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (72, '樱桃', 2, 20.00, 'happy', '樱桃.png', '没有评论', 5.00, '2019-08-13 19:45:06', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (73, NULL, 1, 2.00, 'happy', '黄瓜.png', '没有评论', 5.00, '2019-08-13 20:26:47', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (74, NULL, 1, 10.00, 'happy', '樱桃.png', '没有评论', 5.00, '2019-08-13 20:31:55', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (75, NULL, 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 20:33:00', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (76, NULL, 1, 20.00, 'happy', '海南芒果.png', '没有评论', 5.00, '2019-08-13 20:36:15', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (77, NULL, 1, 15.00, 'happy', '车厘子.png', '没有评论', 5.00, '2019-08-13 20:36:48', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (78, NULL, 1, 10.00, 'happy', '樱桃.png', '没有评论', 4.00, '2019-08-13 20:37:56', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (79, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 20:40:34', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (80, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 20:40:56', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (81, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 5.00, '2019-08-13 20:41:31', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (82, '梨子', 1, 4.00, 'happy', '梨子.png', '没有评论', 0.50, '2019-08-13 20:42:31', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (83, '海南芒果', 1, 20.00, 'happy', '海南芒果.png', '没有评论', 1.00, '2019-08-13 20:56:54', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (84, '黄瓜', 2, 4.00, 'happy', '黄瓜.png', '没有评论', 5.00, '2019-08-14 13:59:43', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (85, '黄瓜', 2, 4.00, 'happy', '黄瓜.png', '没有评论', 5.00, '2019-08-14 14:00:25', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (86, '蓝莓', 1, 23.00, 'happy', '蓝莓.png', '没有评论', 4.00, '2019-08-14 15:22:28', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (87, '蓝莓', 1, 23.00, 'happy', '蓝莓.png', '没有评论', 4.00, '2019-08-14 15:23:12', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (88, '蓝莓', 1, 23.00, 'happy', '蓝莓.png', '太甜了', 4.50, '2019-08-14 15:28:12', '8806ec59-02d7-4493-a301-609126c5e130.jpg');
INSERT INTO `tb_order_comment` VALUES (89, '黄西瓜', 1, 25.00, 'fire', '黄西瓜.png', '真的很好吃，但是不知道有没有毒', 5.00, '2019-08-14 15:53:48', 'b69554c2-9d82-4916-b85f-b0279e5428e4.jpg');
INSERT INTO `tb_order_comment` VALUES (90, '车厘子', 1, 15.00, 'fire', '车厘子.png', '没有评论', 5.00, '2019-08-16 11:34:29', 'b69554c2-9d82-4916-b85f-b0279e5428e4.jpg');

-- ----------------------------
-- Table structure for tb_secret_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_secret_admin`;
CREATE TABLE `tb_secret_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户密码的id',
  `user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `power` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限',
  `fatheruser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父用户 ，绝对管理员的名字叫henry，它的父用户为无',
  `headimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像（uuid）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_secret_admin
-- ----------------------------
INSERT INTO `tb_secret_admin` VALUES (19, 'henry', '123', 'SUPERADMIN', '无', 'fd024dbe-5c50-4b57-8e66-903ab1b6d119.jpg');
INSERT INTO `tb_secret_admin` VALUES (21, 'admin', '111', 'ADMIN', 'henry', '023a2aaf-1db6-4d4c-abb7-af19e51b5806.jpg');
INSERT INTO `tb_secret_admin` VALUES (22, 'yang', '123', 'ADMIN', 'henry', '53361b59-d91f-407a-894a-4cdb6fccdc2c.png');
INSERT INTO `tb_secret_admin` VALUES (31, '吴纯纯', '123', 'ADMIN', 'henry', '40cc17b7-7c56-460f-9c0d-87cb36b5e1a7.jpg');

-- ----------------------------
-- Table structure for tb_secret_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_secret_user`;
CREATE TABLE `tb_secret_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户密码的id',
  `user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `power` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限',
  `fatheruser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父用户，默认为无',
  `headimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像(uuid)',
  `balance` decimal(10, 2) DEFAULT NULL COMMENT '余额',
  `buynum` int(10) DEFAULT NULL COMMENT '购买的数量',
  `paypassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '支付密码',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user`(`user`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 349 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_secret_user
-- ----------------------------
INSERT INTO `tb_secret_user` VALUES (332, 'abc', '123', 'USER', '任何管理员', '02f62aeb-069b-4607-be32-bccc598d1f79.jpg', 200.41, 123, '123');
INSERT INTO `tb_secret_user` VALUES (334, 'qiu', '123', 'USER', '任何管理员', 'ca3ec0ae-363f-46da-8a5f-939d20240384.jpg', 90.00, 8, '1234');
INSERT INTO `tb_secret_user` VALUES (337, 'three', '123', 'USER', '任何管理员', '064a1f31-4814-430b-93aa-c9386ba7f107.jpg', 100.00, NULL, '123');
INSERT INTO `tb_secret_user` VALUES (338, 'four', '123', 'USER', '任何管理员', '338a8f32-d19f-4acb-b1a2-16d048364120.jpg', 20.00, NULL, '123');
INSERT INTO `tb_secret_user` VALUES (339, 'five', '123', 'USER', '任何管理员', '49f1328e-b090-4cdc-8fcc-9ad1cd80ca53.png', 88.80, 6, '12345');
INSERT INTO `tb_secret_user` VALUES (340, 'six', '123', 'USER', '任何管理员', '6d74b6e3-39d6-4344-be1f-4e1a34563da7.jpg', 234.90, 10, '123');
INSERT INTO `tb_secret_user` VALUES (341, 'se', '123', 'USER', '任何管理员', NULL, 108.30, 7, '123');
INSERT INTO `tb_secret_user` VALUES (342, 'hh', '123', 'USER', '任何管理员', NULL, 112.50, 5, '123');
INSERT INTO `tb_secret_user` VALUES (343, 'happy', '123', 'USER', '任何管理员', '8806ec59-02d7-4493-a301-609126c5e130.jpg', 535.70, 75, '123');
INSERT INTO `tb_secret_user` VALUES (344, 'fire', '123', 'USER', '任何管理员', 'b69554c2-9d82-4916-b85f-b0279e5428e4.jpg', 626.50, 19, '123');
INSERT INTO `tb_secret_user` VALUES (345, 'lihaonan', '123', 'USER', '任何管理员', NULL, 100.00, NULL, '123');
INSERT INTO `tb_secret_user` VALUES (346, 'qiujunbin', '123', 'USER', '任何管理员', 'aacfcfdf-0ae6-4205-a119-27eb57ad3c7d.jpg', 100.00, NULL, '123456');
INSERT INTO `tb_secret_user` VALUES (347, 'yyz', '123', 'USER', '任何管理员', '8cf37b29-c332-43ff-8f78-77127a44456b.jpg', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tb_shop_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_item`;
CREATE TABLE `tb_shop_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '这是id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '这是eacharts列名  果蔬名',
  `sellcount` int(11) DEFAULT NULL COMMENT '这、是eacharts这个列的数量 销售数量',
  `price` decimal(10, 2) DEFAULT NULL COMMENT '价格/一斤',
  `stockcount` int(10) DEFAULT NULL COMMENT '库存',
  `evaluatepoint` decimal(10, 2) DEFAULT NULL COMMENT '评分：5最高',
  `simpleintroduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '简单的评价',
  `forvpicture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '果蔬的图片(路径)',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '归类2',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `forvpicture`(`forvpicture`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shop_item
-- ----------------------------
INSERT INTO `tb_shop_item` VALUES (1, '红富士', 14, 3.00, 4, 5.00, '好吃就对了', 'e04f2013-914e-4da1-b952-f4bf2691f179.png', '水果');
INSERT INTO `tb_shop_item` VALUES (2, '红西瓜', 91, 2.10, 100, 4.50, '好吃就对了', '82129787-7592-4fe2-8ae5-ede28e308e93.png', '水果');
INSERT INTO `tb_shop_item` VALUES (3, '黄瓜', 75, 2.00, 59, 4.94, '好吃就对了', '黄瓜.png', '蔬菜');
INSERT INTO `tb_shop_item` VALUES (4, '向日癸子', 26, 2.00, 84, 5.00, '好吃就对了', '向日癸子.png', '坚果');
INSERT INTO `tb_shop_item` VALUES (5, '海南芒果', 39, 20.00, 71, 4.64, '好吃就对了', '海南芒果.png', '水果');
INSERT INTO `tb_shop_item` VALUES (6, '车厘子', 49, 15.00, 71, 5.00, '好吃就对了', '车厘子.png', '水果');
INSERT INTO `tb_shop_item` VALUES (7, '樱桃', 21, 10.00, 80, 5.00, '好吃就对了', '樱桃.png', '水果');
INSERT INTO `tb_shop_item` VALUES (8, '梨子', 12, 4.00, 89, 5.00, '好吃就对了', '梨子.png', '水果');
INSERT INTO `tb_shop_item` VALUES (9, '黄西瓜', 24, 25.00, 80, 5.00, '好吃就对了', '黄西瓜.png', '水果');
INSERT INTO `tb_shop_item` VALUES (10, '葡萄', 9, 12.00, 96, 5.00, '好吃就对了', '紫葡萄.png', '水果');
INSERT INTO `tb_shop_item` VALUES (11, '蓝莓', 18, 23.00, 88, 4.17, '好吃就对了', '蓝莓.png', '水果');

-- ----------------------------
-- Table structure for tb_shop_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_order`;
CREATE TABLE `tb_shop_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `buyer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购买者',
  `buyshopitemname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '购买的商品名',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收货地址',
  `consume` decimal(10, 2) DEFAULT NULL COMMENT '这次订单所消费的金额',
  `onecount` int(10) DEFAULT NULL COMMENT '单次买的数量',
  `shopimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品的图片',
  `tellphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收货电话',
  `transfername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收货人名字',
  `buytime` timestamp(0) DEFAULT CURRENT_TIMESTAMP COMMENT '购买时间',
  `iscomment` int(2) DEFAULT NULL COMMENT '1为未评论，0未已评论',
  `isdone` int(2) DEFAULT NULL COMMENT '1为未确认收货，0确认收货',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ordername`(`buyer`) USING BTREE,
  INDEX `orderimg`(`shopimg`) USING BTREE,
  CONSTRAINT `tb_shop_order_ibfk_1` FOREIGN KEY (`shopimg`) REFERENCES `tb_shop_item` (`forvpicture`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_shop_order_ibfk_2` FOREIGN KEY (`buyer`) REFERENCES `tb_secret_user` (`user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 239 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shop_order
-- ----------------------------
INSERT INTO `tb_shop_order` VALUES (65, 'abc', '红西瓜', NULL, 2.10, NULL, NULL, NULL, NULL, '2018-06-10 19:31:18', 1, 0);
INSERT INTO `tb_shop_order` VALUES (68, 'qiu', '向日癸子', NULL, 2.00, NULL, NULL, NULL, NULL, '2019-06-10 20:26:58', 1, 0);
INSERT INTO `tb_shop_order` VALUES (69, 'qiu', '黄瓜', NULL, 2.00, NULL, NULL, NULL, NULL, '2019-07-10 20:27:17', 1, 0);
INSERT INTO `tb_shop_order` VALUES (76, 'five', '红西瓜', NULL, 2.10, NULL, NULL, NULL, NULL, '2019-08-10 20:51:43', 1, 0);
INSERT INTO `tb_shop_order` VALUES (77, 'se', '红西瓜', NULL, 2.10, NULL, NULL, NULL, NULL, '2019-08-10 21:02:45', 1, 0);
INSERT INTO `tb_shop_order` VALUES (78, 'se', '红西瓜', NULL, 2.10, NULL, NULL, NULL, NULL, '2019-08-10 21:02:55', 1, 0);
INSERT INTO `tb_shop_order` VALUES (79, 'se', '红西瓜', NULL, 2.10, NULL, NULL, NULL, NULL, '2019-08-10 21:05:22', 1, 0);
INSERT INTO `tb_shop_order` VALUES (80, 'se', '红西瓜', NULL, 2.10, NULL, NULL, NULL, NULL, '2019-08-10 21:07:40', 1, 0);
INSERT INTO `tb_shop_order` VALUES (81, 'se', '红西瓜', NULL, 2.10, NULL, NULL, NULL, NULL, '2019-08-10 21:07:44', 1, 0);
INSERT INTO `tb_shop_order` VALUES (82, 'five', '向日癸子', NULL, 2.00, NULL, NULL, NULL, NULL, '2019-08-10 21:08:54', 1, 0);
INSERT INTO `tb_shop_order` VALUES (83, 'five', '向日癸子', NULL, 2.00, NULL, NULL, NULL, NULL, '2019-08-10 21:08:59', 1, 0);
INSERT INTO `tb_shop_order` VALUES (84, 'hh', '红西瓜', NULL, 2.10, NULL, NULL, NULL, NULL, '2019-08-10 21:13:01', 1, 0);
INSERT INTO `tb_shop_order` VALUES (85, 'hh', '红西瓜', NULL, 2.10, NULL, NULL, NULL, NULL, '2019-08-10 21:13:09', 1, 0);
INSERT INTO `tb_shop_order` VALUES (86, 'abc', '黄西瓜', NULL, 25.00, NULL, NULL, NULL, NULL, '2019-08-10 23:21:43', 1, 0);
INSERT INTO `tb_shop_order` VALUES (87, 'abc', '红西瓜', NULL, 2.10, NULL, NULL, NULL, NULL, '2019-08-10 23:21:59', 1, 0);
INSERT INTO `tb_shop_order` VALUES (88, 'abc', '黄瓜', NULL, 2.00, NULL, NULL, NULL, NULL, '2019-08-10 23:22:06', 1, 0);
INSERT INTO `tb_shop_order` VALUES (89, 'abc', '樱桃', NULL, 30.00, NULL, NULL, NULL, NULL, '2019-08-11 11:24:33', 1, 0);
INSERT INTO `tb_shop_order` VALUES (90, 'abc', '车厘子', NULL, 15.00, NULL, NULL, NULL, NULL, '2019-08-11 11:54:19', 1, 0);
INSERT INTO `tb_shop_order` VALUES (91, 'abc', '葡萄', '浙江', 12.00, NULL, NULL, NULL, NULL, '2019-08-11 11:56:32', 1, 0);
INSERT INTO `tb_shop_order` VALUES (92, 'abc', '梨子', '平阳县', 4.00, NULL, NULL, NULL, NULL, '2019-08-11 12:03:01', 1, 0);
INSERT INTO `tb_shop_order` VALUES (93, 'abc', '车厘子', '杭州', 30.00, 2, NULL, NULL, NULL, '2019-08-11 14:43:32', 1, 0);
INSERT INTO `tb_shop_order` VALUES (94, 'abc', '红西瓜', '杭州', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', NULL, NULL, '2019-08-11 14:55:45', 1, 0);
INSERT INTO `tb_shop_order` VALUES (95, 'abc', '红西瓜', '杭州', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', NULL, NULL, '2019-08-11 15:17:38', 1, 1);
INSERT INTO `tb_shop_order` VALUES (96, 'six', '红西瓜', '温州', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', NULL, NULL, '2019-08-11 15:59:22', 1, 1);
INSERT INTO `tb_shop_order` VALUES (97, 'six', '樱桃', '北京', 10.00, 1, '樱桃.png', NULL, NULL, '2019-08-11 15:59:47', 1, 1);
INSERT INTO `tb_shop_order` VALUES (98, 'six', '黄瓜', '大连', 6.00, 3, '黄瓜.png', NULL, NULL, '2019-08-11 17:13:05', 1, 1);
INSERT INTO `tb_shop_order` VALUES (99, 'six', '樱桃', '新疆', 10.00, 1, '樱桃.png', NULL, NULL, '2019-08-11 17:13:37', 1, 1);
INSERT INTO `tb_shop_order` VALUES (100, 'six', '葡萄', '阿拉斯加', 12.00, 1, '紫葡萄.png', NULL, NULL, '2019-08-11 17:13:55', 1, 1);
INSERT INTO `tb_shop_order` VALUES (101, 'six', '黄西瓜', '上海', 25.00, 1, '黄西瓜.png', NULL, NULL, '2019-08-11 17:14:49', 1, 1);
INSERT INTO `tb_shop_order` VALUES (102, 'six', '海南芒果', '昆阳', 20.00, 1, '海南芒果.png', NULL, NULL, '2019-08-11 17:14:58', 1, 1);
INSERT INTO `tb_shop_order` VALUES (103, 'six', '梨子', '瑞安', 4.00, 1, '梨子.png', NULL, NULL, '2019-08-11 17:16:46', 1, 1);
INSERT INTO `tb_shop_order` VALUES (104, 'abc', '黄西瓜', '旅顺', 25.00, 1, '黄西瓜.png', NULL, NULL, '2019-08-11 17:20:12', 1, 1);
INSERT INTO `tb_shop_order` VALUES (105, 'abc', '车厘子', '广州', 15.00, 1, '车厘子.png', NULL, NULL, '2019-08-11 17:21:09', 1, 1);
INSERT INTO `tb_shop_order` VALUES (106, 'abc', '黄瓜', '北京', 4.00, 2, '黄瓜.png', NULL, NULL, '2019-08-11 18:46:09', 1, 1);
INSERT INTO `tb_shop_order` VALUES (107, 'abc', '红西瓜', '平阳省昆阳市大自然镇', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', NULL, NULL, '2019-08-11 22:00:23', 1, 1);
INSERT INTO `tb_shop_order` VALUES (108, 'abc', '海南芒果', '平阳省昆阳市大自然镇', 20.00, 1, '海南芒果.png', '18358727103', 'wcc', '2019-08-11 22:15:04', 1, 1);
INSERT INTO `tb_shop_order` VALUES (109, 'abc', '红西瓜', '平阳省昆阳市大自然镇', 23.10, 11, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '18358727103', 'wcc', '2019-08-11 22:26:34', 1, 1);
INSERT INTO `tb_shop_order` VALUES (110, 'happy', '红西瓜', '平阳', 8.40, 4, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '18358727103', 'qiujb', '2019-08-12 18:57:24', 0, 0);
INSERT INTO `tb_shop_order` VALUES (111, 'happy', '黄瓜', '平阳', 6.00, 3, '黄瓜.png', '18358727103', 'qiujb', '2019-08-13 12:06:56', 0, 0);
INSERT INTO `tb_shop_order` VALUES (112, 'happy', '樱桃', '平阳', 30.00, 3, '樱桃.png', '18358727103', 'qiujb', '2019-08-13 15:46:52', 0, 0);
INSERT INTO `tb_shop_order` VALUES (113, 'happy', '海南芒果', '平阳', 20.00, 1, '海南芒果.png', '18358727103', 'qiujb', '2019-08-13 15:48:38', 0, 0);
INSERT INTO `tb_shop_order` VALUES (114, 'happy', '红西瓜', '平阳', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '18358727103', 'qiujb', '2019-08-13 15:49:56', 0, 0);
INSERT INTO `tb_shop_order` VALUES (115, 'happy', '车厘子', '平阳', 15.00, 1, '车厘子.png', '18358727103', 'qiujb', '2019-08-13 16:04:59', 0, 0);
INSERT INTO `tb_shop_order` VALUES (116, 'happy', '向日癸子', '平阳', 2.00, 1, '向日癸子.png', '18358727103', 'qiujb', '2019-08-13 16:13:28', 0, 0);
INSERT INTO `tb_shop_order` VALUES (117, 'happy', '红西瓜', '平阳', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '18358727103', 'qiujb', '2019-08-13 16:18:07', 0, 0);
INSERT INTO `tb_shop_order` VALUES (118, 'happy', '海南芒果', '平阳', 40.00, 2, '海南芒果.png', '18358727103', 'qiujb', '2019-08-13 16:48:45', 0, 0);
INSERT INTO `tb_shop_order` VALUES (119, 'happy', '海南芒果', '平阳', 20.00, 1, '海南芒果.png', '18358727103', 'qiujb', '2019-08-13 16:54:47', 0, 0);
INSERT INTO `tb_shop_order` VALUES (120, 'happy', '黄瓜', '平阳', 2.00, 1, '黄瓜.png', '18358727103', 'qiujb', '2019-08-13 16:56:45', 0, 0);
INSERT INTO `tb_shop_order` VALUES (121, 'happy', '红西瓜', '平阳', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '18358727103', 'qiujb', '2019-08-13 17:01:30', 0, 0);
INSERT INTO `tb_shop_order` VALUES (122, 'happy', '红西瓜', '平阳', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '18358727103', 'qiujb', '2019-08-13 17:04:43', 0, 0);
INSERT INTO `tb_shop_order` VALUES (123, 'happy', '黄瓜', '平阳', 2.00, 1, '黄瓜.png', '18358727103', 'qiujb', '2019-08-13 17:04:49', 0, 0);
INSERT INTO `tb_shop_order` VALUES (124, 'happy', '海南芒果', '平阳', 20.00, 1, '海南芒果.png', '18358727103', 'qiujb', '2019-08-13 17:10:16', 0, 0);
INSERT INTO `tb_shop_order` VALUES (125, 'happy', '向日癸子', '平阳', 2.00, 1, '向日癸子.png', '18358727103', 'qiujb', '2019-08-13 17:10:34', 0, 0);
INSERT INTO `tb_shop_order` VALUES (126, 'happy', '梨子', '平阳', 4.00, 1, '梨子.png', '18358727103', 'qiujb', '2019-08-13 17:11:58', 0, 0);
INSERT INTO `tb_shop_order` VALUES (127, 'happy', '车厘子', '平阳', 15.00, 1, '车厘子.png', '18358727103', 'qiujb', '2019-08-13 17:12:11', 0, 0);
INSERT INTO `tb_shop_order` VALUES (128, 'happy', '梨子', '平阳', 4.00, 1, '梨子.png', '18358727103', 'qiujb', '2019-08-13 17:12:53', 0, 0);
INSERT INTO `tb_shop_order` VALUES (129, 'happy', '红西瓜', '平阳', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '18358727103', 'qiujb', '2019-08-13 17:17:03', 0, 0);
INSERT INTO `tb_shop_order` VALUES (130, 'happy', '葡萄', '平阳', 12.00, 1, '紫葡萄.png', '18358727103', 'qiujb', '2019-08-13 17:20:02', 0, 0);
INSERT INTO `tb_shop_order` VALUES (131, 'happy', '梨子', '平阳', 4.00, 1, '梨子.png', '18358727103', 'qiujb', '2019-08-13 17:21:59', 0, 0);
INSERT INTO `tb_shop_order` VALUES (132, 'happy', '车厘子', '平阳', 15.00, 1, '车厘子.png', '18358727103', 'qiujb', '2019-08-13 17:22:06', 0, 0);
INSERT INTO `tb_shop_order` VALUES (133, 'happy', '樱桃', '平阳', 10.00, 1, '樱桃.png', '18358727103', 'qiujb', '2019-08-13 17:22:12', 0, 0);
INSERT INTO `tb_shop_order` VALUES (134, 'happy', '车厘子', '平阳', 15.00, 1, '车厘子.png', '18358727103', 'qiujb', '2019-08-13 17:29:39', 0, 0);
INSERT INTO `tb_shop_order` VALUES (135, 'happy', '梨子', '平阳', 4.00, 1, '梨子.png', '18358727103', 'qiujb', '2019-08-13 17:29:45', 0, 0);
INSERT INTO `tb_shop_order` VALUES (136, 'happy', '樱桃', '平阳', 10.00, 1, '樱桃.png', '18358727103', 'qiujb', '2019-08-13 17:31:42', 0, 0);
INSERT INTO `tb_shop_order` VALUES (137, 'happy', '海南芒果', '平阳', 20.00, 1, '海南芒果.png', '18358727103', 'qiujb', '2019-08-13 17:31:53', 0, 0);
INSERT INTO `tb_shop_order` VALUES (138, 'happy', '梨子', '平阳', 4.00, 1, '梨子.png', '18358727103', 'wcc', '2019-08-13 17:35:27', 0, 0);
INSERT INTO `tb_shop_order` VALUES (139, 'happy', '向日癸子', '平阳', 2.00, 1, '向日癸子.png', '18358727103', 'qiujb', '2019-08-13 17:36:45', 0, 0);
INSERT INTO `tb_shop_order` VALUES (140, 'happy', '樱桃', '平阳', 10.00, 1, '樱桃.png', '18358727103', 'qiujb', '2019-08-13 17:37:19', 0, 0);
INSERT INTO `tb_shop_order` VALUES (141, 'happy', '梨子', '平阳', 4.00, 1, '梨子.png', '18358727103', 'qiujb', '2019-08-13 17:45:15', 0, 0);
INSERT INTO `tb_shop_order` VALUES (142, 'happy', '车厘子', '平阳', 15.00, 1, '车厘子.png', '18358727103', 'qiujb', '2019-08-13 17:45:22', 0, 0);
INSERT INTO `tb_shop_order` VALUES (143, 'happy', '向日癸子', '平阳', 2.00, 1, '向日癸子.png', '18358727103', 'qiujb', '2019-08-13 17:46:43', 0, 0);
INSERT INTO `tb_shop_order` VALUES (144, 'happy', '车厘子', '平阳', 15.00, 1, '车厘子.png', '18358727103', 'qiujb', '2019-08-13 17:46:51', 0, 0);
INSERT INTO `tb_shop_order` VALUES (145, 'happy', '黄瓜', '平阳', 2.00, 1, '黄瓜.png', '18358727103', 'qiujb', '2019-08-13 17:50:10', 0, 0);
INSERT INTO `tb_shop_order` VALUES (146, 'happy', '海南芒果', '平阳', 20.00, 1, '海南芒果.png', '18358727103', 'qiujb', '2019-08-13 17:50:15', 0, 0);
INSERT INTO `tb_shop_order` VALUES (147, 'happy', '红西瓜', '平阳', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '18358727103', 'qiujb', '2019-08-13 17:54:02', 0, 0);
INSERT INTO `tb_shop_order` VALUES (148, 'happy', '海南芒果', '平阳', 20.00, 1, '海南芒果.png', '18358727103', 'qiujb', '2019-08-13 17:54:07', 0, 0);
INSERT INTO `tb_shop_order` VALUES (149, 'happy', '向日癸子', '平阳', 2.00, 1, '向日癸子.png', '18358727103', 'qiujb', '2019-08-13 18:00:02', 0, 0);
INSERT INTO `tb_shop_order` VALUES (150, 'happy', '红西瓜', '平阳', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '18358727103', 'qiujb', '2019-08-13 18:03:08', 0, 0);
INSERT INTO `tb_shop_order` VALUES (151, 'happy', '樱桃', '平阳', 10.00, 1, '樱桃.png', '18358727103', 'qiujb', '2019-08-13 18:06:16', 0, 0);
INSERT INTO `tb_shop_order` VALUES (152, 'happy', '车厘子', '平阳', 15.00, 1, '车厘子.png', '18358727103', 'qiujb', '2019-08-13 18:06:22', 0, 0);
INSERT INTO `tb_shop_order` VALUES (153, 'happy', '梨子', '平阳', 4.00, 1, '梨子.png', '18358727103', 'qiujb', '2019-08-13 18:06:32', 0, 0);
INSERT INTO `tb_shop_order` VALUES (154, 'happy', '海南芒果', '平阳', 20.00, 1, '海南芒果.png', '18358727103', 'qiujb', '2019-08-13 18:06:37', 0, 0);
INSERT INTO `tb_shop_order` VALUES (155, 'happy', '向日癸子', '平阳', 2.00, 1, '向日癸子.png', '18358727103', 'qiujb', '2019-08-13 18:13:06', 0, 0);
INSERT INTO `tb_shop_order` VALUES (156, 'happy', '红西瓜', '平阳', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '18358727103', 'qiujb', '2019-08-13 18:15:57', 0, 0);
INSERT INTO `tb_shop_order` VALUES (157, 'happy', '樱桃', '平阳', 20.00, 2, '樱桃.png', '18358727103', 'qiujb', '2019-08-13 19:30:02', 0, 0);
INSERT INTO `tb_shop_order` VALUES (158, 'happy', '黄瓜', '平阳', 2.00, 1, '黄瓜.png', '18358727103', 'qiujb', '2019-08-13 19:40:20', 0, 0);
INSERT INTO `tb_shop_order` VALUES (159, 'happy', '黄瓜', '平阳', 2.00, 1, '黄瓜.png', '18358727103', 'qiujb', '2019-08-13 20:26:19', 0, 0);
INSERT INTO `tb_shop_order` VALUES (160, 'happy', '樱桃', '平阳', 10.00, 1, '樱桃.png', '18358727103', 'qiujb', '2019-08-13 20:31:44', 0, 0);
INSERT INTO `tb_shop_order` VALUES (161, 'happy', '车厘子', '平阳', 15.00, 1, '车厘子.png', '18358727103', 'qiujb', '2019-08-13 20:32:55', 0, 0);
INSERT INTO `tb_shop_order` VALUES (162, 'happy', '海南芒果', '平阳', 20.00, 1, '海南芒果.png', '18358727103', 'qiujb', '2019-08-13 20:35:42', 0, 0);
INSERT INTO `tb_shop_order` VALUES (163, 'happy', '车厘子', '平阳', 15.00, 1, '车厘子.png', '18358727103', 'qiujb', '2019-08-13 20:36:40', 0, 0);
INSERT INTO `tb_shop_order` VALUES (164, 'happy', '樱桃', '平阳', 10.00, 1, '樱桃.png', '18358727103', 'qiujb', '2019-08-13 20:37:50', 0, 0);
INSERT INTO `tb_shop_order` VALUES (165, 'happy', '梨子', '平阳', 4.00, 1, '梨子.png', '18358727103', 'qiujb', '2019-08-13 20:40:27', 0, 0);
INSERT INTO `tb_shop_order` VALUES (166, 'happy', '黄瓜', '平阳', 2.00, 1, '黄瓜.png', '18358727103', 'qiujb', '2019-08-13 20:40:46', 0, 0);
INSERT INTO `tb_shop_order` VALUES (167, 'happy', '红西瓜', '平阳', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '18358727103', 'qiujb', '2019-08-13 20:41:25', 0, 0);
INSERT INTO `tb_shop_order` VALUES (168, 'happy', '黄瓜', '平阳', 2.00, 1, '黄瓜.png', '18358727103', 'qiujb', '2019-08-13 20:42:23', 0, 0);
INSERT INTO `tb_shop_order` VALUES (169, 'happy', '海南芒果', '平阳', 20.00, 1, '海南芒果.png', '18358727103', 'qiujb', '2019-08-13 20:56:17', 0, 0);
INSERT INTO `tb_shop_order` VALUES (170, 'happy', '黄瓜', '平阳', 4.00, 2, '黄瓜.png', '18358727103', 'qiujb', '2019-08-14 11:18:35', 0, 0);
INSERT INTO `tb_shop_order` VALUES (171, 'happy', '蓝莓', '平阳', 23.00, 1, '蓝莓.png', '18358727103', 'qiujb', '2019-08-14 14:00:18', 0, 0);
INSERT INTO `tb_shop_order` VALUES (172, 'happy', '蓝莓', '平阳', 23.00, 1, '蓝莓.png', '18358727103', 'qiujb', '2019-08-14 15:22:14', 0, 0);
INSERT INTO `tb_shop_order` VALUES (173, 'happy', '蓝莓', '平阳', 23.00, 1, '蓝莓.png', '18358727103', 'qiujb', '2019-08-14 15:22:55', 0, 0);
INSERT INTO `tb_shop_order` VALUES (174, 'happy', '蓝莓', '平阳', 23.00, 1, '蓝莓.png', '18358727103', 'qiujb', '2019-08-14 15:27:54', 0, 0);
INSERT INTO `tb_shop_order` VALUES (175, 'fire', '黄西瓜', '平阳', 25.00, 1, '黄西瓜.png', '123', 'wcc', '2019-08-14 15:53:24', 0, 0);
INSERT INTO `tb_shop_order` VALUES (176, 'fire', '红西瓜', '平阳', 4.20, 2, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '123', 'wcc', '2019-08-16 09:44:57', 1, 1);
INSERT INTO `tb_shop_order` VALUES (177, 'fire', '车厘子', '平阳', 30.00, 2, '车厘子.png', '123', 'wcc', '2019-08-16 09:46:48', 1, 1);
INSERT INTO `tb_shop_order` VALUES (190, 'fire', '车厘子', NULL, 15.00, 1, '车厘子.png', NULL, NULL, '2019-08-16 11:23:39', 1, 1);
INSERT INTO `tb_shop_order` VALUES (191, 'fire', '红西瓜', NULL, 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', NULL, NULL, '2019-08-16 11:23:39', 1, 1);
INSERT INTO `tb_shop_order` VALUES (192, 'fire', '车厘子', NULL, 45.00, 3, '车厘子.png', NULL, NULL, '2019-08-16 11:30:12', 1, 1);
INSERT INTO `tb_shop_order` VALUES (193, 'fire', '车厘子', NULL, 15.00, 1, '车厘子.png', NULL, NULL, '2019-08-16 11:32:41', 0, 0);
INSERT INTO `tb_shop_order` VALUES (194, 'fire', '车厘子', '平阳', 15.00, 1, '车厘子.png', '123', 'wcc', '2019-08-16 13:32:16', 1, 1);
INSERT INTO `tb_shop_order` VALUES (195, 'fire', '红西瓜', NULL, 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', NULL, NULL, '2019-08-16 14:06:02', 1, 1);
INSERT INTO `tb_shop_order` VALUES (196, 'fire', '红西瓜', NULL, 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', NULL, NULL, '2019-08-16 14:16:23', 1, 1);
INSERT INTO `tb_shop_order` VALUES (197, 'fire', '红西瓜', NULL, 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', NULL, NULL, '2019-08-16 14:17:23', 1, 1);
INSERT INTO `tb_shop_order` VALUES (198, 'fire', '车厘子', NULL, 15.00, 1, '车厘子.png', NULL, NULL, '2019-08-16 14:20:30', 1, 1);
INSERT INTO `tb_shop_order` VALUES (199, 'fire', '梨子', NULL, 4.00, 1, '梨子.png', NULL, NULL, '2019-08-16 14:59:04', 1, 1);
INSERT INTO `tb_shop_order` VALUES (200, 'fire', '车厘子', NULL, 15.00, 1, '车厘子.png', NULL, NULL, '2019-08-16 14:59:04', 1, 1);
INSERT INTO `tb_shop_order` VALUES (201, 'fire', '蓝莓', NULL, 23.00, 1, '蓝莓.png', NULL, NULL, '2019-08-16 15:00:51', 1, 1);
INSERT INTO `tb_shop_order` VALUES (202, 'fire', '车厘子', NULL, 15.00, 1, '车厘子.png', NULL, NULL, '2019-08-16 15:01:21', 1, 1);
INSERT INTO `tb_shop_order` VALUES (203, 'fire', '黄西瓜', NULL, 25.00, 1, '黄西瓜.png', NULL, NULL, '2019-08-16 15:01:21', 1, 1);
INSERT INTO `tb_shop_order` VALUES (204, 'fire', '葡萄', NULL, 12.00, 1, '紫葡萄.png', NULL, NULL, '2019-08-16 15:02:51', 1, 1);
INSERT INTO `tb_shop_order` VALUES (205, 'fire', '樱桃', NULL, 10.00, 1, '樱桃.png', NULL, NULL, '2019-08-16 15:02:51', 1, 1);
INSERT INTO `tb_shop_order` VALUES (206, 'fire', '梨子', NULL, 4.00, 1, '梨子.png', NULL, NULL, '2019-08-16 15:06:28', 1, 1);
INSERT INTO `tb_shop_order` VALUES (207, 'fire', '蓝莓', NULL, 23.00, 1, '蓝莓.png', NULL, NULL, '2019-08-16 15:06:28', 1, 1);
INSERT INTO `tb_shop_order` VALUES (208, 'fire', '海南芒果', NULL, 20.00, 1, '海南芒果.png', NULL, NULL, '2019-08-16 15:07:24', 1, 1);
INSERT INTO `tb_shop_order` VALUES (209, 'fire', '樱桃', NULL, 10.00, 1, '樱桃.png', NULL, NULL, '2019-08-16 15:07:24', 1, 1);
INSERT INTO `tb_shop_order` VALUES (210, 'fire', '海南芒果', NULL, 20.00, 1, '海南芒果.png', NULL, NULL, '2019-08-16 15:09:28', 1, 1);
INSERT INTO `tb_shop_order` VALUES (211, 'fire', '车厘子', NULL, 15.00, 1, '车厘子.png', NULL, NULL, '2019-08-16 15:09:28', 1, 1);
INSERT INTO `tb_shop_order` VALUES (212, 'fire', '黄瓜', NULL, 2.00, 1, '黄瓜.png', NULL, NULL, '2019-08-16 15:17:16', 1, 1);
INSERT INTO `tb_shop_order` VALUES (213, 'fire', '蓝莓', NULL, 23.00, 1, '蓝莓.png', NULL, NULL, '2019-08-16 15:17:16', 1, 1);
INSERT INTO `tb_shop_order` VALUES (214, 'fire', '向日癸子', NULL, 2.00, 1, '向日癸子.png', NULL, NULL, '2019-08-16 15:17:47', 1, 1);
INSERT INTO `tb_shop_order` VALUES (215, 'fire', '梨子', NULL, 4.00, 1, '梨子.png', NULL, NULL, '2019-08-16 15:17:47', 1, 1);
INSERT INTO `tb_shop_order` VALUES (216, 'fire', '海南芒果', '平阳', 20.00, 1, '海南芒果.png', '123', 'wcc', '2019-08-16 15:56:26', 1, 1);
INSERT INTO `tb_shop_order` VALUES (217, 'fire', '黄瓜', '平阳', 2.00, 1, '黄瓜.png', '123', 'wcc', '2019-08-16 15:57:50', 1, 1);
INSERT INTO `tb_shop_order` VALUES (218, 'fire', '黄瓜', NULL, 2.00, 1, '黄瓜.png', NULL, NULL, '2019-08-16 16:12:59', 1, 1);
INSERT INTO `tb_shop_order` VALUES (219, 'fire', '车厘子', '', 15.00, 1, '车厘子.png', '', '', '2019-08-16 16:17:41', 1, 1);
INSERT INTO `tb_shop_order` VALUES (220, 'fire', '车厘子', '', 15.00, 1, '车厘子.png', '', '', '2019-08-16 16:17:41', 1, 1);
INSERT INTO `tb_shop_order` VALUES (221, 'fire', '樱桃', '', 10.00, 1, '樱桃.png', '', '', '2019-08-16 16:17:41', 1, 1);
INSERT INTO `tb_shop_order` VALUES (222, 'fire', '红西瓜', '平阳', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '123', 'wcc', '2019-08-16 16:23:26', 1, 1);
INSERT INTO `tb_shop_order` VALUES (223, 'fire', '海南芒果', '平阳', 20.00, 1, '海南芒果.png', '123', 'wcc', '2019-08-16 16:28:53', 1, 1);
INSERT INTO `tb_shop_order` VALUES (224, 'fire', '车厘子', '', 15.00, 1, '车厘子.png', '', '', '2019-08-16 16:32:20', 1, 1);
INSERT INTO `tb_shop_order` VALUES (225, 'fire', '黄瓜', '平阳', 2.00, 1, '黄瓜.png', '123', 'wcc', '2019-08-16 16:57:21', 1, 1);
INSERT INTO `tb_shop_order` VALUES (226, 'fire', '车厘子', '平阳', 15.00, 1, '车厘子.png', '123', 'wcc', '2019-08-16 16:57:21', 1, 1);
INSERT INTO `tb_shop_order` VALUES (227, 'fire', '海南芒果', '', 60.00, 3, '海南芒果.png', '', '', '2019-08-16 17:13:18', 1, 1);
INSERT INTO `tb_shop_order` VALUES (228, 'fire', '黄瓜', '', 2.00, 1, '黄瓜.png', '', '', '2019-08-16 17:14:15', 1, 1);
INSERT INTO `tb_shop_order` VALUES (229, 'fire', '黄瓜', '浙江省温州市平阳县昆阳镇', 2.00, 1, '黄瓜.png', '123', 'wcc', '2019-08-16 17:14:39', 1, 1);
INSERT INTO `tb_shop_order` VALUES (230, 'fire', '黄瓜', '浙江省温州市平阳县昆阳镇', 4.00, 2, '黄瓜.png', '123', 'wcc', '2019-08-16 17:14:52', 1, 1);
INSERT INTO `tb_shop_order` VALUES (231, 'fire', '红西瓜', '浙江省温州市平阳县昆阳镇', 4.20, 2, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '123', 'wcc', '2019-08-16 17:15:06', 1, 1);
INSERT INTO `tb_shop_order` VALUES (232, 'fire', '车厘子', '浙江省温州市平阳县昆阳镇', 30.00, 2, '车厘子.png', '123', 'wcc', '2019-08-16 17:15:24', 1, 1);
INSERT INTO `tb_shop_order` VALUES (233, 'fire', '蓝莓', '浙江省温州市平阳县昆阳镇', 46.00, 2, '蓝莓.png', '123', 'wcc', '2019-08-16 17:16:55', 1, 1);
INSERT INTO `tb_shop_order` VALUES (234, 'fire', '蓝莓', '浙江省温州市平阳县昆阳镇', 46.00, 2, '蓝莓.png', '123', 'wcc', '2019-08-16 17:23:05', 1, 1);
INSERT INTO `tb_shop_order` VALUES (235, 'fire', '蓝莓', '', 23.00, 1, '蓝莓.png', '', '', '2019-08-16 17:39:36', 1, 1);
INSERT INTO `tb_shop_order` VALUES (236, 'fire', '红西瓜', '浙江省温州市平阳县昆阳镇', 2.10, 1, '82129787-7592-4fe2-8ae5-ede28e308e93.png', '123', 'wcc', '2019-08-16 17:42:22', 1, 1);
INSERT INTO `tb_shop_order` VALUES (237, 'fire', '梨子', '', 4.00, 1, '梨子.png', '', '', '2019-08-16 18:29:04', 1, 1);
INSERT INTO `tb_shop_order` VALUES (238, 'fire', '黄瓜', '', 2.00, 1, '黄瓜.png', '', '', '2019-08-17 12:12:09', 1, 1);

-- ----------------------------
-- Table structure for tb_shop_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_shopcar`;
CREATE TABLE `tb_shop_shopcar`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopcarname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '这件商品放入购物车的名字',
  `shopcarprices` decimal(10, 2) DEFAULT NULL COMMENT '这件商品放入购物车的单价',
  `shopcarcount` int(11) DEFAULT NULL COMMENT '这件商品放入购物车的斤数',
  `needmoney` decimal(10, 2) DEFAULT NULL COMMENT '这个在购物车里的商品想要买下需要的钱',
  `shopcarimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '放入购物车商品的图片名',
  `putinshopcartime` timestamp(0) DEFAULT CURRENT_TIMESTAMP COMMENT '放入购物车的时间',
  `putter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '放入者',
  `stockcount` int(11) DEFAULT NULL COMMENT '库存',
  `sellcount` int(11) DEFAULT NULL COMMENT '销售量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `shopcarimg`(`shopcarimg`) USING BTREE,
  CONSTRAINT `tb_shop_shopcar_ibfk_1` FOREIGN KEY (`shopcarimg`) REFERENCES `tb_shop_item` (`forvpicture`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shop_shopcar
-- ----------------------------
INSERT INTO `tb_shop_shopcar` VALUES (51, '红富士', 3.00, 1, 3.00, 'e04f2013-914e-4da1-b952-f4bf2691f179.png', '2019-08-28 10:58:49', '<font style=\"vertical-align: inherit;\"><font style=\"vertical-align: inherit;\">秋君彬</font></font>', 4, 14);
INSERT INTO `tb_shop_shopcar` VALUES (52, '红富士', 3.00, 1, 3.00, 'e04f2013-914e-4da1-b952-f4bf2691f179.png', '2019-08-28 14:16:20', 'qiu', 4, 14);
INSERT INTO `tb_shop_shopcar` VALUES (53, '樱桃', 10.00, 1, 10.00, '樱桃.png', '2019-08-29 10:45:06', 'qiu', 80, 21);
INSERT INTO `tb_shop_shopcar` VALUES (54, '海南芒果', 20.00, 1, 20.00, '海南芒果.png', '2019-08-29 10:45:18', 'qiu', 71, 39);
INSERT INTO `tb_shop_shopcar` VALUES (55, '樱桃', 10.00, 1, 10.00, '樱桃.png', '2019-08-29 10:45:39', 'qiu', 80, 21);

-- ----------------------------
-- Table structure for tb_shopitem_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_shopitem_type`;
CREATE TABLE `tb_shopitem_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopitemtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品分类类别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shopitem_type
-- ----------------------------
INSERT INTO `tb_shopitem_type` VALUES (1, '水果');
INSERT INTO `tb_shopitem_type` VALUES (2, '蔬菜');
INSERT INTO `tb_shopitem_type` VALUES (3, '坚果');
INSERT INTO `tb_shopitem_type` VALUES (4, '调料');

-- ----------------------------
-- Table structure for tb_system_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_message`;
CREATE TABLE `tb_system_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '系统信息的内容',
  `sender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发送者',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发送信息的类型',
  `sendtime` timestamp(0) DEFAULT CURRENT_TIMESTAMP COMMENT '发送时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_system_message
-- ----------------------------
INSERT INTO `tb_system_message` VALUES (1, '打折了', 'henry', '警告通知', '2019-08-26 14:27:45');
INSERT INTO `tb_system_message` VALUES (2, '不可能打折的，愚人节提前快乐', 'henry', '警告通知', '2019-08-26 14:47:12');
INSERT INTO `tb_system_message` VALUES (3, '好吧，打折的，我又一次骗了你', 'henry', '打折通知', '2019-08-26 14:47:50');
INSERT INTO `tb_system_message` VALUES (5, '杨颜', 'henry', '警告通知', '2019-08-28 11:05:19');

-- ----------------------------
-- Table structure for tb_system_message_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_message_type`;
CREATE TABLE `tb_system_message_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `messagetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '消息类型',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'class头标',
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '边框颜色或者字体颜色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_system_message_type
-- ----------------------------
INSERT INTO `tb_system_message_type` VALUES (1, '警告通知', 'am-icon-warning', '#F37B1D');
INSERT INTO `tb_system_message_type` VALUES (2, '打折通知', 'am-icon-cut', 'green');
INSERT INTO `tb_system_message_type` VALUES (3, '休假通知', 'am-icon-unlink', '#337AC7');
INSERT INTO `tb_system_message_type` VALUES (4, '危险通知', 'am-icon-bug', 'red');

SET FOREIGN_KEY_CHECKS = 1;
