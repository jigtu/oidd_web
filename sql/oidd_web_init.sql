/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : oidd_web

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-01-10 20:27:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for system_config
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config` (
  `project_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `page_directory` varchar(30) DEFAULT NULL COMMENT '页面目录',
  `menu_bar1_id` int(11) DEFAULT NULL COMMENT '菜单栏一id',
  `menu_bar2_id` int(11) DEFAULT NULL COMMENT '菜单栏二id',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_config
-- ----------------------------
INSERT INTO `system_config` VALUES ('策略数据服务平台', null, null, null, '1');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dept_name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级部门id',
  `dept_describe` varchar(255) DEFAULT NULL COMMENT '部门描述',
  `dept_code` varchar(255) DEFAULT NULL COMMENT '部门代码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '海口市', '0', '海口市', '000', '2019-01-04 07:45:47', '2019-01-07 17:15:24');
INSERT INTO `sys_dept` VALUES ('2', '海口市管局', '1', '海口市管局', '001', '2019-01-04 07:45:47', '2019-01-04 07:45:47');
INSERT INTO `sys_dept` VALUES ('3', '海口市公安局', '1', '海口市公安局', '002', '2019-01-04 07:45:47', '2019-01-04 07:45:47');

-- ----------------------------
-- Table structure for sys_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm` (
  `perm_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `perm_name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `perm_url` varchar(255) DEFAULT NULL COMMENT 'url',
  `parent_id` int(255) NOT NULL DEFAULT '0' COMMENT '父级权限id',
  `perm_icon` varchar(255) DEFAULT NULL COMMENT 'icon',
  `perm_type` int(1) NOT NULL DEFAULT '0' COMMENT '权限类型 0.菜单 1.按钮',
  `perm_state` int(1) NOT NULL DEFAULT '1' COMMENT '权限状态 1.可用 2.不可用',
  `perm_code` varchar(255) NOT NULL COMMENT '权限代码',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`perm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_perm
-- ----------------------------
INSERT INTO `sys_perm` VALUES ('31', '系统管理', '', '0', '&#xe857;', '0', '1', 'perm', '9', '2018-06-27 02:55:51', '2019-01-07 17:14:57');
INSERT INTO `sys_perm` VALUES ('32', '菜单管理', 'user/jurisdiction.html', '31', '&#xe620;', '0', '1', '', '2', '2018-06-27 02:56:17', '2018-08-20 17:14:35');
INSERT INTO `sys_perm` VALUES ('33', '角色管理', 'user/management.html', '31', '&#xe60b;', '0', '1', 'role', '3', '2018-06-27 02:56:48', '2018-08-20 16:12:05');
INSERT INTO `sys_perm` VALUES ('34', '用户管理', 'user/userList.html', '31', '&#xe66f;', '0', '1', '', '4', '2018-06-27 02:57:05', '2018-08-20 17:15:06');
INSERT INTO `sys_perm` VALUES ('35', '部门管理', 'user/department.html', '31', '&#xe770;', '0', '1', 'dept', '5', '2018-06-27 02:57:21', '2018-08-17 18:39:15');
INSERT INTO `sys_perm` VALUES ('36', '用户设置', '', '0', '&#xe628;', '0', '1', '', '10', '2018-08-15 14:24:56', '2018-09-12 14:07:50');
INSERT INTO `sys_perm` VALUES ('37', '个人中心', 'personalCenter/personInfor.html', '36', '&#xe665;', '0', '1', '', '1', '2018-08-15 14:26:24', '2018-08-15 14:29:44');
INSERT INTO `sys_perm` VALUES ('38', '修改密码', 'personalCenter/password.html', '36', '&#xe673;', '0', '1', '', '2', '2018-08-15 14:27:26', '2018-08-15 14:30:00');
INSERT INTO `sys_perm` VALUES ('39', '系统配置', 'personalCenter/systemConfiguration.html', '36', '&#xe614;', '0', '1', '', '3', '2018-08-15 14:27:54', '2018-08-15 14:30:13');
INSERT INTO `sys_perm` VALUES ('40', '策略管理', '', '0', '&#xe63c;', '0', '1', 'perm', '5', '2018-09-12 16:21:42', '2019-01-07 17:15:07');
INSERT INTO `sys_perm` VALUES ('41', '短信发送流量策略', '../policy/msgpolicy.html', '40', '&#xe621', '0', '1', 'perm', '1', '2018-09-12 16:23:47', '2019-01-04 08:05:29');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `role_state` int(1) NOT NULL DEFAULT '1' COMMENT '角色状态 1.可用 0.不可用',
  `role_code` varchar(255) DEFAULT NULL COMMENT '角色代码',
  `role_describe` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '1', null, null, '2018-08-02 09:58:22', '2019-01-04 07:45:24');
INSERT INTO `sys_role` VALUES ('2', '操作员', '1', null, null, '2018-11-15 15:26:01', '2019-01-04 07:45:15');

-- ----------------------------
-- Table structure for sys_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_perm`;
CREATE TABLE `sys_role_perm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perm_id` int(11) NOT NULL COMMENT '权限id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=387 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_perm
-- ----------------------------
INSERT INTO `sys_role_perm` VALUES ('1', '1', '31');
INSERT INTO `sys_role_perm` VALUES ('2', '1', '32');
INSERT INTO `sys_role_perm` VALUES ('3', '1', '33');
INSERT INTO `sys_role_perm` VALUES ('4', '1', '34');
INSERT INTO `sys_role_perm` VALUES ('5', '1', '35');
INSERT INTO `sys_role_perm` VALUES ('6', '1', '36');
INSERT INTO `sys_role_perm` VALUES ('7', '1', '37');
INSERT INTO `sys_role_perm` VALUES ('8', '1', '38');
INSERT INTO `sys_role_perm` VALUES ('9', '1', '39');
INSERT INTO `sys_role_perm` VALUES ('10', '1', '40');
INSERT INTO `sys_role_perm` VALUES ('11', '1', '41');
INSERT INTO `sys_role_perm` VALUES ('12', '2', '31');
INSERT INTO `sys_role_perm` VALUES ('13', '2', '32');
INSERT INTO `sys_role_perm` VALUES ('14', '2', '33');
INSERT INTO `sys_role_perm` VALUES ('15', '2', '34');
INSERT INTO `sys_role_perm` VALUES ('16', '2', '35');
INSERT INTO `sys_role_perm` VALUES ('17', '2', '36');
INSERT INTO `sys_role_perm` VALUES ('18', '2', '37');
INSERT INTO `sys_role_perm` VALUES ('19', '2', '38');
INSERT INTO `sys_role_perm` VALUES ('20', '2', '39');
INSERT INTO `sys_role_perm` VALUES ('21', '2', '40');
INSERT INTO `sys_role_perm` VALUES ('22', '2', '41');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user_id',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `status` int(1) unsigned zerofill NOT NULL DEFAULT '1' COMMENT '状态 1.可用 0.不可用',
  `last_login` varchar(255) DEFAULT NULL COMMENT '上次登录时间',
  `ip` varchar(255) DEFAULT NULL COMMENT '上次登录ip',
  `email` varchar(255) DEFAULT NULL COMMENT 'email',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '管局', '1', '2019-01-08 10:28:46', '0:0:0:0:0:0:0:1', 'admin@123.com', '15817767899', '启用', '2018-06-12 10:47:19', '2019-01-08 10:28:46');

-- ----------------------------
-- Table structure for sys_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_dept`;
CREATE TABLE `sys_user_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `dept_id` int(11) NOT NULL COMMENT '部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_perm`;
CREATE TABLE `sys_user_perm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `perm_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1853 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_perm
-- ----------------------------
INSERT INTO `sys_user_perm` VALUES ('1', '1', '31');
INSERT INTO `sys_user_perm` VALUES ('2', '1', '32');
INSERT INTO `sys_user_perm` VALUES ('3', '1', '33');
INSERT INTO `sys_user_perm` VALUES ('4', '1', '34');
INSERT INTO `sys_user_perm` VALUES ('5', '1', '35');
INSERT INTO `sys_user_perm` VALUES ('6', '1', '36');
INSERT INTO `sys_user_perm` VALUES ('7', '1', '37');
INSERT INTO `sys_user_perm` VALUES ('8', '1', '38');
INSERT INTO `sys_user_perm` VALUES ('9', '1', '39');
INSERT INTO `sys_user_perm` VALUES ('10', '1', '40');
INSERT INTO `sys_user_perm` VALUES ('11', '1', '41');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_msg_policy
-- ----------------------------
DROP TABLE IF EXISTS `t_msg_policy`;
CREATE TABLE `t_msg_policy` (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '自增主键',
  `domain` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '运营商 0:电信 1:移动 2:联通',
  `lac` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '基站编号',
  `lac_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '基站名称',
  `flow_rate` int(11) DEFAULT '30' COMMENT '流速值 单位 条/秒',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of t_msg_policy
-- ----------------------------

-- ----------------------------
-- Table structure for t_operatelog
-- ----------------------------
DROP TABLE IF EXISTS `t_operatelog`;
CREATE TABLE `t_operatelog` (
  `oplog_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `login_name` varchar(50) NOT NULL COMMENT '登录账号',
  `username` varchar(50) NOT NULL COMMENT '用户姓名',
  `op_ip` varchar(20) NOT NULL COMMENT '登录ip',
  `function_id` int(11) DEFAULT NULL COMMENT '功能权限id(function_id)',
  `operate_type` int(11) DEFAULT NULL COMMENT '操作id(function_id) 0下发1撤销2查询3推送4导出5添加6删除7上传8修改9判为诈骗录音',
  `operate_content` longtext NOT NULL COMMENT '操作内容',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号 web3.1.2t2版本云南需求',
  `resource_type` int(11) DEFAULT NULL,
  `resource_message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oplog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_operatelog
-- ----------------------------

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `perm_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_perm_id` int(11) NOT NULL COMMENT '父级id',
  `perm_name` varchar(192) NOT NULL COMMENT '权限名称',
  `perm_describe` varchar(600) DEFAULT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `rule` varchar(192) DEFAULT NULL COMMENT '规则',
  `perm_action` varchar(600) DEFAULT NULL COMMENT '路径',
  `icon` varchar(600) DEFAULT NULL COMMENT 'icon',
  `perm_status` tinyint(1) NOT NULL COMMENT '权限状态 0：禁用 1：启用',
  `perm_type` int(11) NOT NULL COMMENT '权限类型 0：菜单 1：按钮',
  `sort` double NOT NULL COMMENT '排序（优先级）',
  `perm_level` int(11) NOT NULL COMMENT '权限等级，一级、二级、三级..',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`perm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '0', '系统管理', '系统管理', '2019-01-04 15:41:02', 'system_setting', '/', '&#', '1', '0', '12', '1', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('2', '1', '用户', '用户', '2019-01-04 15:41:02', 'system_setting', '/', '&#', '1', '0', '12', '1', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('3', '1', '角色', '角色', '2019-01-04 15:41:02', 'basic_data', '/', '&#', '1', '0', '20', '1', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('4', '1', '菜单', '菜单', '2019-01-04 15:41:02', 'authority_manager', '/', '&#', '1', '0', '11', '1', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('5', '1', '部门', '部门', '2019-01-04 15:41:02', 'rules_deliver', '/', '&#', '1', '0', '2', '1', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('6', '1', '操作日志', '操作日志', '2019-01-04 15:41:02', 'strategy_manage', '/', '&#', '0', '0', '10', '1', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('7', '2', '用户添加', '用户添加', '2019-01-04 15:41:02', 'statReport', '/', '&#', '1', '0', '6', '1', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('8', '2', '用户删除', '用户删除', '2019-01-04 15:41:02', 'data_select', '/', '&#', '1', '0', '5', '1', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('9', '2', '用户修改', '用户修改', '2019-01-04 15:41:02', 'data_analysis', '/', '&#', '1', '0', '4', '1', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('10', '2', '添加用户权限', '添加用户权限', '2019-01-04 15:41:02', 'tjyhqx', '/', '&#', '1', '0', '0', '1', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('11', '2', '隐藏/显示', '隐藏/显示', '2019-01-04 15:41:02', null, null, '&#', '0', '0', '0', '0', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('12', '2', '个人信息修改', '个人信息修改', '2019-01-04 15:41:02', null, null, '&#', '0', '0', '0', '0', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('13', '2', '修改密码', '修改密码', '2019-01-04 15:41:02', null, null, '&#', '0', '0', '0', '0', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('14', '3', '角色添加', '角色添加', '2019-01-04 15:41:02', 'whitelist_push', '/', '&#', '1', '0', '9', '2', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('15', '3', '角色删除', '角色删除', '2019-01-04 15:41:02', 'calledwhitelist_push', '/', '&#', '1', '0', '11', '2', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('16', '3', '角色修改', '角色修改', '2019-01-04 15:41:02', 'calling_greylist_push', '/', '&#', '1', '0', '2', '2', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('17', '3', '添加角色权限', '添加角色权限', '2019-01-04 15:41:02', null, null, '&#', '0', '0', '0', '0', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('18', '4', '添加菜单', '添加菜单', '2019-01-04 15:41:02', 'calling_greylist_input', '/', '&#', '1', '0', '3', '2', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('19', '4', '删除菜单', '删除菜单', '2019-01-04 15:41:02', 'calling_blacklist_push', '/', '&#', '1', '0', '5', '2', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('20', '4', '修改菜单', '修改菜单', '2019-01-04 15:41:02', 'calling_whitelist_deliver', '/', '&#', '1', '0', '8', '2', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('21', '5', '添加部门', '添加部门', '2019-01-04 15:41:02', 'called_whitelist_deliver', '/', '&#', '1', '0', '10', '2', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('22', '5', '删除部门', '删除部门', '2019-01-04 15:41:02', 'calling_blacklist_deliver', '/', '&#', '1', '0', '4', '2', '2019-01-04 15:41:02');
INSERT INTO `t_permission` VALUES ('23', '5', '修改部门', '修改部门', '2019-01-04 15:41:02', 'calling_greylist_deliver', '/', '&#', '1', '0', '1', '2', '2019-01-04 15:41:02');
