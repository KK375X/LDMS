/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : ldms

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 07/08/2022 11:12:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for deviceinfo
-- ----------------------------
DROP TABLE IF EXISTS `deviceinfo`;
CREATE TABLE `deviceinfo`  (
  `deviceId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备ID',
  `type` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备类型',
  `deviceName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `teacherId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备负责人ID',
  `state` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备状态',
  `laboratoryId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备所属实验室ID',
  `createDate` datetime NULL DEFAULT NULL COMMENT '创建设备时间',
  PRIMARY KEY (`deviceId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of deviceinfo
-- ----------------------------
INSERT INTO `deviceinfo` VALUES ('10001', '计算机', '电脑A00001', '003', '维修中', 'X203', '2021-12-08 21:56:37');
INSERT INTO `deviceinfo` VALUES ('10002', '计算机', '电脑A00002', '001', '使用中', 'X203', '2021-12-08 21:57:05');
INSERT INTO `deviceinfo` VALUES ('10003', '计算机', '电脑A00003', '001', '使用中', 'X203', '2021-12-08 21:56:37');
INSERT INTO `deviceinfo` VALUES ('10004', '计算机', '电脑A00004', '001', '闲置中', 'X203', '2021-12-08 21:57:05');
INSERT INTO `deviceinfo` VALUES ('10005', '计算机', '电脑A00005', '001', '闲置中', 'X203', '2021-12-08 21:56:37');
INSERT INTO `deviceinfo` VALUES ('10006', '计算机', '电脑A00006', '001', '使用中', 'X203', '2021-12-08 21:57:05');
INSERT INTO `deviceinfo` VALUES ('10007', '电表箱', '电表箱A00007', '001', '维修中', 'X203', '2021-12-08 21:56:37');
INSERT INTO `deviceinfo` VALUES ('10008', '计算机', '电脑A00008', '001', '使用中', 'X203', '2021-12-08 21:57:05');
INSERT INTO `deviceinfo` VALUES ('10009', '计算机', '电脑A00009', '001', '使用中', 'X203', '2021-12-08 21:56:37');
INSERT INTO `deviceinfo` VALUES ('10011', '计算机', '电脑A00030', '211003', '使用中', 'X401', '2022-03-26 19:50:03');
INSERT INTO `deviceinfo` VALUES ('10012', '电表箱', '电表箱A00012', '005', '闲置中', 'X202', '2021-12-08 21:57:05');
INSERT INTO `deviceinfo` VALUES ('10013', '计算机', '电脑A00013', '005', '使用中', 'X202', '2021-12-08 21:56:37');
INSERT INTO `deviceinfo` VALUES ('10014', '计算机', '电脑A00014', '005', '维修中', 'X202', '2021-12-08 21:56:37');
INSERT INTO `deviceinfo` VALUES ('10015', '计算机', '电脑A00015', '005', '使用中', 'X202', '2021-12-08 21:56:37');
INSERT INTO `deviceinfo` VALUES ('10016', '计算机', '电脑A00016', '005', '使用中', 'X202', '2021-12-08 21:57:05');
INSERT INTO `deviceinfo` VALUES ('10017', '计算机', '电脑A00017', '005', '使用中', 'X202', '2021-12-08 21:56:37');
INSERT INTO `deviceinfo` VALUES ('10018', '计算机', '电脑A00018', '005', '使用中', 'X202', '2021-12-08 21:57:05');
INSERT INTO `deviceinfo` VALUES ('10019', '电表箱', '电表箱A00019', '005', '维修中', 'X202', '2021-12-08 21:56:37');
INSERT INTO `deviceinfo` VALUES ('10022', '电表箱', '电表箱A00022', '005', '使用中', 'x402', '2021-12-08 21:57:05');
INSERT INTO `deviceinfo` VALUES ('A0002', '电脑', '电脑A0002', '001', '使用中', 'X402', '2022-03-26 18:45:16');

-- ----------------------------
-- Table structure for deviceuseinfo
-- ----------------------------
DROP TABLE IF EXISTS `deviceuseinfo`;
CREATE TABLE `deviceuseinfo`  (
  `deviceId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备ID',
  `userId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '使用者ID',
  `useDate` date NOT NULL,
  `beginTime` datetime NULL DEFAULT NULL,
  `endTime` datetime NULL DEFAULT NULL,
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用状态',
  PRIMARY KEY (`deviceId`, `userId`, `useDate`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deviceuseinfo
-- ----------------------------
INSERT INTO `deviceuseinfo` VALUES ('D0001', '1', '2021-10-10', '2021-10-10 08:00:00', '2021-10-10 10:00:00', '同意');
INSERT INTO `deviceuseinfo` VALUES ('D0002', '1', '2021-10-10', '2021-10-10 08:00:00', '2021-10-10 10:00:00', '否决');
INSERT INTO `deviceuseinfo` VALUES ('D10002', '211001', '2022-03-26', '2022-03-26 08:00:00', '2022-03-26 10:00:00', '同意');
INSERT INTO `deviceuseinfo` VALUES ('D10011', '211001', '2022-03-26', '2022-03-26 08:00:00', '2022-03-26 10:00:00', '同意');

-- ----------------------------
-- Table structure for laboratoryinfo
-- ----------------------------
DROP TABLE IF EXISTS `laboratoryinfo`;
CREATE TABLE `laboratoryinfo`  (
  `laboratoryId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实验室ID',
  `laboratoryName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实验室名称',
  `teacherId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实验室负责人ID',
  `state` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实验室地址',
  `createDate` datetime NULL DEFAULT NULL COMMENT '创建实验室时间',
  PRIMARY KEY (`laboratoryId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laboratoryinfo
-- ----------------------------
INSERT INTO `laboratoryinfo` VALUES ('X201', '物联网实验室', '005', '使用中', '信息楼X201', '2021-12-08 21:58:02');
INSERT INTO `laboratoryinfo` VALUES ('X202', '软件实验室', '002', '使用中', '信息楼X202', '2021-12-08 21:58:05');
INSERT INTO `laboratoryinfo` VALUES ('X203', '计科实验室', '001', '闲置中', '信息楼X203', '2021-12-08 21:58:02');
INSERT INTO `laboratoryinfo` VALUES ('X204', '计科实验室', '001', '使用中', '信息楼X204', '2021-12-08 21:58:05');
INSERT INTO `laboratoryinfo` VALUES ('X205', '网工实验室', '003', '闲置中', '信息楼X205', '2021-12-08 21:58:02');
INSERT INTO `laboratoryinfo` VALUES ('X206', '计科实验室', '001', '使用中', '信息楼X206', '2021-12-08 21:58:05');
INSERT INTO `laboratoryinfo` VALUES ('X401', '软件实验室', '002', '闲置中', '信息楼X401', '2021-12-08 21:58:02');
INSERT INTO `laboratoryinfo` VALUES ('X402', '网工实验室', '003', '使用中', '信息楼X402', '2021-12-08 21:58:05');
INSERT INTO `laboratoryinfo` VALUES ('X403', '软件实验室', '002', '闲置中', '信息楼X403', '2021-12-08 21:58:02');
INSERT INTO `laboratoryinfo` VALUES ('X404', '计科实验室', '001', '使用中', '信息楼X404', '2021-12-08 21:58:05');
INSERT INTO `laboratoryinfo` VALUES ('X405', '物联网实验室', '005', '闲置中', '信息楼X405', '2021-12-08 21:58:02');
INSERT INTO `laboratoryinfo` VALUES ('X406', '网工实验室', '003', '使用中', '信息楼X406', '2021-12-08 21:58:02');
INSERT INTO `laboratoryinfo` VALUES ('X501', '计科实验室', '001', '闲置中', '信息楼X501', '2021-12-08 21:58:05');
INSERT INTO `laboratoryinfo` VALUES ('X502', '物联网实验室', '005', '闲置中', '信息楼X502', '2021-12-08 21:58:02');
INSERT INTO `laboratoryinfo` VALUES ('X503', '网工实验室', '003', '闲置中', '信息楼X503', '2021-12-08 21:58:02');
INSERT INTO `laboratoryinfo` VALUES ('X504', '软件实验室', '002', '闲置中', '信息楼X504', '2021-12-08 21:58:05');
INSERT INTO `laboratoryinfo` VALUES ('X505', '物联网实验室', '005', '使用中', '信息楼X505', '2021-12-08 21:58:02');
INSERT INTO `laboratoryinfo` VALUES ('YF3501', '计算机实验室', '004', '闲置中', '逸夫楼3501', '2021-12-08 21:58:05');
INSERT INTO `laboratoryinfo` VALUES ('YF3502', '计算机实验室', '004', '使用中', '逸夫楼3502', '2021-12-08 21:58:02');
INSERT INTO `laboratoryinfo` VALUES ('YF3503', '计算机实验室', '004', '闲置中', '逸夫楼3503', '2021-12-08 21:58:05');
INSERT INTO `laboratoryinfo` VALUES ('YF3504', '计算机实验室', '004', '使用中', '逸夫楼3504', '2021-12-08 21:58:02');
INSERT INTO `laboratoryinfo` VALUES ('YF3505', '计算机实验室', '004', '闲置中', '逸夫楼3505', '2021-12-08 21:58:05');

-- ----------------------------
-- Table structure for laboratoryuseinfo
-- ----------------------------
DROP TABLE IF EXISTS `laboratoryuseinfo`;
CREATE TABLE `laboratoryuseinfo`  (
  `laboratoryId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实验室ID',
  `teacherId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师ID',
  `useDate` date NULL DEFAULT NULL COMMENT '使用日期',
  `beginTime` datetime NULL DEFAULT NULL COMMENT '使用开始时间',
  `endTime` datetime NULL DEFAULT NULL COMMENT '使用结束时间',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否同意申请',
  PRIMARY KEY (`laboratoryId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laboratoryuseinfo
-- ----------------------------
INSERT INTO `laboratoryuseinfo` VALUES ('X101', '1', '2021-10-10', '2021-10-10 08:00:00', '2021-10-10 10:00:00', '同意');
INSERT INTO `laboratoryuseinfo` VALUES ('X102', '1', '2021-10-10', '2021-10-10 08:00:00', '2021-10-10 10:00:00', '否决');
INSERT INTO `laboratoryuseinfo` VALUES ('X201', '2', '2022-01-10', '2022-01-10 22:33:27', '2022-01-10 23:33:31', '同意');
INSERT INTO `laboratoryuseinfo` VALUES ('X202', '2', '2022-01-18', '2022-01-18 21:39:11', '2022-01-18 21:39:16', '同意');
INSERT INTO `laboratoryuseinfo` VALUES ('X345', '2', '2022-01-25', '2022-01-18 21:39:11', '2022-01-18 21:39:16', '同意');

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createDate` datetime NULL DEFAULT NULL COMMENT '创建用户时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('admin', 'admin', '123456', '15112345678', '2022-01-06 20:49:13');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用于登录的ID',
  `studentId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacherId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '辅导员ID',
  `classes` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属班级',
  `college` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属学院',
  `createDate` datetime NULL DEFAULT NULL COMMENT '创建用户时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2019211001', '2019211001', '小王', '123456', '21', '男', '19856919987', '211001', '计科', '信息学院', '2022-03-26 19:47:38');
INSERT INTO `t_student` VALUES ('2019211002', '2019211002', '小朋', '123456', '20', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:06');
INSERT INTO `t_student` VALUES ('2019211003', '2019211003', '小红', '123456', '21', '女', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:09');
INSERT INTO `t_student` VALUES ('2019211004', '2019211004', '小梦', '123456', '21', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:13');
INSERT INTO `t_student` VALUES ('2019211005', '2019211005', '小花', '123456', '21', '女', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:16');
INSERT INTO `t_student` VALUES ('2019211006', '2019211006', '小王', '123456', '21', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:02');
INSERT INTO `t_student` VALUES ('2019211007', '2019211007', '小谢', '123456', '21', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:06');
INSERT INTO `t_student` VALUES ('2019211008', '2019211008', '小张', '123456', '21', '女', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:09');
INSERT INTO `t_student` VALUES ('2019211009', '2019211009', '小雨', '123456', '21', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:13');
INSERT INTO `t_student` VALUES ('2019211010', '2019211010', '小华', '123456', '20', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:16');
INSERT INTO `t_student` VALUES ('2019211011', '2019211011', '小米', '123456', '21', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:02');
INSERT INTO `t_student` VALUES ('2019211012', '2019211012', '小风', '123456', '21', '女', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:06');
INSERT INTO `t_student` VALUES ('2019211013', '2019211013', '小腾', '123456', '21', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:09');
INSERT INTO `t_student` VALUES ('2019211014', '2019211014', '小奥', '123456', '21', '女', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:13');
INSERT INTO `t_student` VALUES ('2019211015', '2019211015', '小白', '123456', '20', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:16');
INSERT INTO `t_student` VALUES ('2019211016', '2019211016', '小黑', '123456', '21', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:02');
INSERT INTO `t_student` VALUES ('2019211017', '2019211017', '小天', '123456', '21', '女', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:02');
INSERT INTO `t_student` VALUES ('2019211018', '2019211018', '小小', '123456', '21', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:06');
INSERT INTO `t_student` VALUES ('2019211019', '2019211019', '小赵', '123456', '21', '女', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:09');
INSERT INTO `t_student` VALUES ('2019211020', '2019211020', '小钱', '123456', '21', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:13');
INSERT INTO `t_student` VALUES ('2019211021', '2019211021', '小唐', '123456', '21', '男', '15156781234', '021', '计科192', '信息学院', '2021-12-08 21:55:16');
INSERT INTO `t_student` VALUES ('2019211022', '2019211022', '小罗', '123456', '22', '女', '15156758480', '021', '计科192', '信息学院', '2022-01-05 19:47:37');
INSERT INTO `t_student` VALUES ('2019211636', '2019211636', '小学', '123456', '1', '女', '15941565225', '', '', '信息学院', '2022-03-26 20:21:09');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用于登录的ID',
  `teacherId` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属学院',
  `position` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `createDate` datetime NULL DEFAULT NULL COMMENT '创建用户时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('211001', '001', '王老师', '123456', '33', '男', '信息学院', '教授', '15112345678', '2021-12-08 21:54:01');
INSERT INTO `t_teacher` VALUES ('211002', '002', '张老师', '654321', '29', '女', '数学学院', '教授', '1511234567', '2021-12-08 21:54:05');
INSERT INTO `t_teacher` VALUES ('211003', '003', '李老师', '123456', '26', '男', '体育学院', '讲师', '1511234567', '2021-12-08 21:54:08');
INSERT INTO `t_teacher` VALUES ('211004', '004', '赵老师', '123456', '25', '男', '机电学院', '辅导员', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211005', '005', '钱老师', '123456', '29', '男', '信息学院', '实验室负责人', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211006', '006', '孙老师', '123456', '40', '女', '机电学院', '实验室负责人', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211007', '007', '周老师', '123456', '29', '女', '数学学院', '讲师', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211008', '008', '吴老师', '123456', '32', '女', '土木学院', '外教', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211009', '009', '冯老师', '123456', '42', '女', '地信学院', '实验室负责人', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211010', '010', '唐老师', '123456', '37', '女', '美术学院', '副教授', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211011', '011', '洪老师', '123456', '42', '男', '音乐学院', '副教授', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211012', '012', '杨老师', '123456', '30', '男', '教育学院', '教授', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211013', '013', '戈老师', '123456', '38', '女', '外语学院', '实验室负责人', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211014', '014', '葛老师', '123456', '34', '男', '土木学院', '教授', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211015', '015', '陈老师', '123456', '37', '女', '信息学院', '讲师', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211016', '016', '孔老师', '123456', '51', '男', '地信学院', '实验室负责人', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211017', '017', '魏老师', '123456', '32', '男', '信息学院', '辅导员', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211018', '018', '薛老师', '123456', '34', '男', '信息学院', '教授', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211019', '019', '陶老师', '123456', '33', '女', '数学学院', '讲师', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211020', '020', '曹老师', '123456', '38', '女', '教育学院', '实验室负责人', '1511234567', '2021-12-08 21:54:11');
INSERT INTO `t_teacher` VALUES ('211021', '021', '方老师', '123456', '30', '男', '信息学院', '辅导员', '1511234567', '2021-12-08 21:54:11');

SET FOREIGN_KEY_CHECKS = 1;
