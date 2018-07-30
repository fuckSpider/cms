/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : shirostudy1

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 30/07/2018 10:01:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `visible` tinyint(1) NULL DEFAULT 1,
  `isparent` tinyint(1) NULL DEFAULT 1,
  `permission` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '常用页面', NULL, '0', NULL, 1, 1, 'normal:*');
INSERT INTO `menu` VALUES ('2', '文件上传', '/normal/fileupload', '1', NULL, 1, 0, 'normal:*');
INSERT INTO `menu` VALUES ('3', '文章列表', '#', '1', NULL, 1, 0, 'normal:*');
INSERT INTO `menu` VALUES ('4', '测试页面', NULL, '0', NULL, 1, 1, 'picture:*');
INSERT INTO `menu` VALUES ('5', '折线图', NULL, '4', NULL, 1, 0, 'picture:*');
INSERT INTO `menu` VALUES ('6', '柱状图', NULL, '4', NULL, 1, 0, 'picture:*');
INSERT INTO `menu` VALUES ('7', '系统管理', NULL, '0', NULL, 1, 1, 'system:*');
INSERT INTO `menu` VALUES ('8', '系统设置', NULL, '7', NULL, 1, 0, 'system:*');
INSERT INTO `menu` VALUES ('9', '系统日志', NULL, '7', NULL, 1, 0, 'system:*');

SET FOREIGN_KEY_CHECKS = 1;
