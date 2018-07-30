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

 Date: 30/07/2018 10:01:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `originalFilename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('427de869939811e889f08cec4b59498a', 'QQ图片20180727124652.jpg', 'E:\\java\\ideaProjects\\myShiro\\target\\myShiro\\file\\1532914255753.jpg');
INSERT INTO `file` VALUES ('7058f57b939a11e889f08cec4b59498a', 'QQ图片20180727124652.jpg', 'E:\\java\\ideaProjects\\myShiro\\target\\myShiro\\file\\1532915191692.jpg');
INSERT INTO `file` VALUES ('80dee74b939a11e889f08cec4b59498a', 'QQ图片20180727124652.jpg', 'E:\\java\\ideaProjects\\myShiro\\target\\myShiro\\file\\1532915219412.jpg');
INSERT INTO `file` VALUES ('9abb423e939a11e889f08cec4b59498a', 'QQ图片20180727124652.jpg', 'E:\\java\\ideaProjects\\myShiro\\target\\myShiro\\file\\1532915262800.jpg');
INSERT INTO `file` VALUES ('a760b855939a11e889f08cec4b59498a', 'QQ图片20180727124652.jpg', 'E:\\java\\ideaProjects\\myShiro\\target\\myShiro\\file\\1532915284017.jpg');
INSERT INTO `file` VALUES ('ff36884e939911e889f08cec4b59498a', 'QQ图片20180727124652.jpg', 'E:\\java\\ideaProjects\\myShiro\\target\\myShiro\\file\\1532915001882.jpg');

SET FOREIGN_KEY_CHECKS = 1;
