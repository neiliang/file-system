
/*
Navicat MySQL Data Transfer

Source Server         : 192.168.115.129
Source Server Version : 50718
Source Host           : 192.168.115.129:3306
Source Database       : fastdfs

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2020-04-18 11:16:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------

DROP TABLE IF EXISTS `file_record`;
CREATE TABLE `file_record` (
  `id` varchar(64) NOT null,
  `group_name` varchar(64) default null comment '文件在FastDFS中的组名',
  `file_name` varchar(255) default null comment '文件在FastDFS中路径+文件名',
  `file_size` bigint(20) default null comment '文件大小用于下载时显示下载进度的',
  `file_type` varchar(20) default null comment '文件类型 jpg,txt,png,css,word...',
  `old_file_name` varchar(255) default null comment '文件上传前的名字用于下载时显示默认文件用的',
  `alias` varchar(128) default null comment '文件别名',
  `user_id` int(20) default null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB default CHARSET=utf8;

-- ----------------------------
-- Records of creditor_file
-- ----------------------------

-- ----------------------------
-- Table structure for `creditor_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT null AUTO_INCREMENT comment '主键',
  `real_name` varchar(35) default null comment '用户姓名',
  `id_card` varchar(20) default null comment '用户身份证号',
  `address` varchar(150) default null comment '用户地址',
  `sex` int(1) default null comment '1-男; 0-女',
  `phone` varchar(11) default null comment '用户电话',
  `money` decimal(10,2) default null comment '用户借款金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB default CHARSET=utf8;



