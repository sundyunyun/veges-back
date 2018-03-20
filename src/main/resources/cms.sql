/*
 Navicat Premium Data Transfer

 Source Server         : root@myAliyun
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 120.79.12.253:3306
 Source Schema         : cms

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 01/02/2018 15:13:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for a
-- ----------------------------
DROP TABLE IF EXISTS `a`;
CREATE TABLE `a`  (
  `object_version_number` bigint(20) DEFAULT NULL,
  `creation_date` datetime(0) DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '-1',
  `last_update_date` datetime(0) DEFAULT NULL,
  `last_updated_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '-1'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_auth`;
CREATE TABLE `sys_auth`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '权限表主键',
  `auth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限',
  `auth_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限名称',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `object_version_number` bigint(20) DEFAULT NULL,
  `creation_date` datetime(0) DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '-1',
  `last_update_date` datetime(0) DEFAULT NULL,
  `last_updated_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '-1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `object_version_number` bigint(20) DEFAULT NULL,
  `creation_date` datetime(0) DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '-1',
  `last_update_date` datetime(0) DEFAULT NULL,
  `last_updated_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '-1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_auth`;
CREATE TABLE `sys_role_auth`  (
  `role_id` bigint(20) UNSIGNED NOT NULL COMMENT '角色ID',
  `auth_id` bigint(20) UNSIGNED NOT NULL COMMENT '权限ID',
  `object_version_number` bigint(20) DEFAULT NULL,
  `creation_date` datetime(0) DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '-1',
  `last_update_date` datetime(0) DEFAULT NULL,
  `last_updated_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '-1',
  PRIMARY KEY (`role_id`, `auth_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `role_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色ID',
  `dept_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '部门ID',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `is_expired` tinyint(1) DEFAULT 0 COMMENT '是否过期',
  `is_locked` tinyint(1) DEFAULT 0 COMMENT '是否锁定',
  `is_enabled` tinyint(1) DEFAULT 1 COMMENT '是否允许',
  `object_version_number` bigint(20) DEFAULT NULL,
  `creation_date` datetime(0) DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '-1',
  `last_update_date` datetime(0) DEFAULT NULL,
  `last_updated_by` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '-1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
