/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : EMS

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 10/01/2023 22:19:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for academy
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `a_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `a_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`a_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of academy
-- ----------------------------
BEGIN;
INSERT INTO `academy` (`a_id`, `a_name`) VALUES ('a_001', '数学与大数据学院');
INSERT INTO `academy` (`a_id`, `a_name`) VALUES ('a_002', '经济管理学院');
INSERT INTO `academy` (`a_id`, `a_name`) VALUES ('a_003', '社会管理学院');
INSERT INTO `academy` (`a_id`, `a_name`) VALUES ('a_004', '马克思主义学院');
INSERT INTO `academy` (`a_id`, `a_name`) VALUES ('a_005', '法学与社会学学院');
INSERT INTO `academy` (`a_id`, `a_name`) VALUES ('a_006', '计算机科学学院');
INSERT INTO `academy` (`a_id`, `a_name`) VALUES ('a_007', '工业设计和陶瓷学院');
INSERT INTO `academy` (`a_id`, `a_name`) VALUES ('a_008', '计算机信息学院');
INSERT INTO `academy` (`a_id`, `a_name`) VALUES ('a_009', '生命科学学院');
INSERT INTO `academy` (`a_id`, `a_name`) VALUES ('a_010', '艺术和设计学院');
INSERT INTO `academy` (`a_id`, `a_name`) VALUES ('a_011', '人文科学学院');
COMMIT;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `c_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `c_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `c_num` int DEFAULT NULL,
  `d_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE,
  KEY `d.id` (`d_id`),
  CONSTRAINT `d.id` FOREIGN KEY (`d_id`) REFERENCES `department` (`d_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of class
-- ----------------------------
BEGIN;
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c101', '数创1', 30, 'd_01');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c102', '数传2', 30, 'd_01');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c103', '数创2', 30, 'd_01');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c104', '大数据技术1', 30, 'd_02');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c105', '大数据技术2', 30, 'd_02');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c106', '数师1', 30, 'd_03');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c107', '数师2', 30, 'd_03');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c108', '会计2', 30, 'd_04');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c109', '会计2', 30, 'd_04');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c110', '法学1', 30, 'd_05');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c111', '计科1', 30, 'd_06');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c112', '计科2', 30, 'd_06');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c113', '工业设计1', 30, 'd_07');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c114', '工业设计2', 30, 'd_07');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c115', '马哲1', 30, 'd_08');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c116', '马应1', 30, 'd_09');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c117', '法应1', 30, 'd_10');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c118', '律政1', 30, 'd_11');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c119', '计创2', 30, 'd_12');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c120', '计应1', 30, 'd_13');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c121', '工应1', 30, 'd_14');
INSERT INTO `class` (`c_id`, `c_name`, `c_num`, `d_id`) VALUES ('c122', '数媒1', 30, 'd_15');
COMMIT;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `curse_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `course_type` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `course_credit` int DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` (`course_id`, `curse_name`, `course_type`, `course_credit`) VALUES ('c001', '高等数学', '必修', 4);
INSERT INTO `course` (`course_id`, `curse_name`, `course_type`, `course_credit`) VALUES ('c002', '大学英语', '必修', 4);
INSERT INTO `course` (`course_id`, `curse_name`, `course_type`, `course_credit`) VALUES ('c003', '数据结构', '必修', 3);
INSERT INTO `course` (`course_id`, `curse_name`, `course_type`, `course_credit`) VALUES ('c004', '代数方程', '必修', 2);
INSERT INTO `course` (`course_id`, `curse_name`, `course_type`, `course_credit`) VALUES ('c005', '线性代数', '必修', 3);
INSERT INTO `course` (`course_id`, `curse_name`, `course_type`, `course_credit`) VALUES ('c006', 'Java web', '必修', 2);
INSERT INTO `course` (`course_id`, `curse_name`, `course_type`, `course_credit`) VALUES ('c007', 'Python', '必修', 2);
INSERT INTO `course` (`course_id`, `curse_name`, `course_type`, `course_credit`) VALUES ('c008', 'C/C++', '必修', 2);
COMMIT;

-- ----------------------------
-- Table structure for course_plan
-- ----------------------------
DROP TABLE IF EXISTS `course_plan`;
CREATE TABLE `course_plan` (
  `cp_year` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cp_class` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cp_week` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`cp_year`,`cp_class`,`course_id`) USING BTREE,
  KEY `course.id` (`course_id`),
  CONSTRAINT `course.id` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of course_plan
-- ----------------------------
BEGIN;
INSERT INTO `course_plan` (`cp_year`, `cp_class`, `course_id`, `cp_week`) VALUES ('2020-2021上', '10', 'c001', '18');
INSERT INTO `course_plan` (`cp_year`, `cp_class`, `course_id`, `cp_week`) VALUES ('2020-2021上', '10', 'c002', '8');
INSERT INTO `course_plan` (`cp_year`, `cp_class`, `course_id`, `cp_week`) VALUES ('2020-2021上', '10', 'c003', '18');
INSERT INTO `course_plan` (`cp_year`, `cp_class`, `course_id`, `cp_week`) VALUES ('2020-2021上', '10', 'c004', '9');
INSERT INTO `course_plan` (`cp_year`, `cp_class`, `course_id`, `cp_week`) VALUES ('2020-2021上', '10', 'c005', '10');
INSERT INTO `course_plan` (`cp_year`, `cp_class`, `course_id`, `cp_week`) VALUES ('2020-2021下', '10', 'c001', '8');
INSERT INTO `course_plan` (`cp_year`, `cp_class`, `course_id`, `cp_week`) VALUES ('2020-2021下', '10', 'c006', '12');
INSERT INTO `course_plan` (`cp_year`, `cp_class`, `course_id`, `cp_week`) VALUES ('2020-2021下', '10', 'c007', '12');
INSERT INTO `course_plan` (`cp_year`, `cp_class`, `course_id`, `cp_week`) VALUES ('2020-2021下', '10', 'c008', '8');
COMMIT;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `d_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `d_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `a_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`d_id`) USING BTREE,
  KEY `a.id` (`a_id`),
  CONSTRAINT `a.id` FOREIGN KEY (`a_id`) REFERENCES `academy` (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_01', '数学与应用数学', 'a_001');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_02', '大数据技术', 'a_001');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_03', '数学师范', 'a_001');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_04', '会计', 'a_002');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_05', '人力资源管理', 'a_002');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_06', '社会人文', 'a_003');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_07', '社会学', 'a_003');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_08', '马克思主义哲学', 'a_004');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_09', '马克思主义应用学', 'a_004');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_10', '法学应用', 'a_005');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_11', '律政', 'a_005');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_12', '计算机科学', 'a_006');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_13', '计算机应用', 'a_006');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_14', '工业设计', 'a_007');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_15', '数字媒体', 'a_007');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_16', '人工智能', 'a_008');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_17', '信息技术应用', 'a_008');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_18', '网络安全', 'a_008');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_19', '生命研究学', 'a_009');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_20', '生命科学', 'a_009');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_21', '艺画应用', 'a_010');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_22', '艺术学', 'a_010');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_23', '人文教育', 'a_011');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_24', '教育学', 'a_011');
INSERT INTO `department` (`d_id`, `d_name`, `a_id`) VALUES ('d_25', '社会政治学', 'a_011');
COMMIT;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `tc_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `s_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `g_ordinary` float DEFAULT NULL,
  `g_exam` float DEFAULT NULL,
  `g_final` float DEFAULT NULL,
  PRIMARY KEY (`tc_id`,`s_id`) USING BTREE,
  KEY `s.id_s` (`s_id`),
  CONSTRAINT `s.id_s` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`),
  CONSTRAINT `tc.id_tc` FOREIGN KEY (`tc_id`) REFERENCES `teaching_class` (`tc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of grade
-- ----------------------------
BEGIN;
INSERT INTO `grade` (`tc_id`, `s_id`, `g_ordinary`, `g_exam`, `g_final`) VALUES ('tc1001', '20220101', 42, 40, 82);
INSERT INTO `grade` (`tc_id`, `s_id`, `g_ordinary`, `g_exam`, `g_final`) VALUES ('tc1002', '20220115', 45, 50, 95);
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生学号',
  `s_name` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `s_sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `c_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`s_id`) USING BTREE,
  KEY `c.id` (`c_id`),
  CONSTRAINT `c.id` FOREIGN KEY (`c_id`) REFERENCES `class` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220101', '邓伟振', '男', 'c101');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220102', '伍六七', '男', 'c101');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220103', '王法', '男', 'c101');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220104', '上官晴', '女', 'c102');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220105', '王琪', '女', 'c103');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220106', '张天赐', '男', 'c104');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220107', '张三', '男', 'c105');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220108', '李四', '男', 'c102');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220109', '诸葛慈', '女', 'c110');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220110', '练剑黄', '男', 'c111');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220111', '欧阳蓉儿', '女', 'c109');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220112', '唐三彩', '男', 'c116');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220113', '张艺得', '男', 'c113');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220114', '德古拉', '女', 'c102');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220115', '瑞克桑切斯', '男', 'c101');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220116', '莫蒂', '男', 'c101');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220117', '桑美', '女', 'c111');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220118', '杰瑞', '男', 'c122');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220119', '西米', '女', 'c111');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220120', '肖九', '男', 'c106');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220121', '六儿', '女', 'c107');
INSERT INTO `student` (`s_id`, `s_name`, `s_sex`, `c_id`) VALUES ('20220122', '李一', '男', 'c108');
COMMIT;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '老师账号',
  `t_name` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `t_sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101011', '东方芯源', '女');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101012', '小蝴蝶', '女');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101013', '天一案', '女');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101014', '麦克', '男');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101015', '闷油瓶', '男');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101016', '吴邪', '男');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101017', '风清扬', '男');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101018', '剑韭黄', '男');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101019', '黑棋', '女');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101020', 'Aniya', '女');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101021', '柒', '男');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101022', '小白', '女');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101023', '小黑', '女');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101024', '柯南', '男');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101025', '毛利小五郎', '男');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101026', '天下霸唱', '男');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101027', '黄大仙', '女');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101028', '狐仙儿', '女');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101029', '八重', '女');
INSERT INTO `teacher` (`t_id`, `t_name`, `t_sex`) VALUES ('101101030', '惊爆点', '男');
COMMIT;

-- ----------------------------
-- Table structure for teacher_techering_class
-- ----------------------------
DROP TABLE IF EXISTS `teacher_techering_class`;
CREATE TABLE `teacher_techering_class` (
  `t_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tc_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`t_id`,`tc_id`) USING BTREE,
  KEY `tc.id` (`tc_id`),
  CONSTRAINT `t.id_t` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`),
  CONSTRAINT `tc.id_tclass` FOREIGN KEY (`tc_id`) REFERENCES `teaching_class` (`tc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of teacher_techering_class
-- ----------------------------
BEGIN;
INSERT INTO `teacher_techering_class` (`t_id`, `tc_id`) VALUES ('101101020', 'tc1002');
INSERT INTO `teacher_techering_class` (`t_id`, `tc_id`) VALUES ('101101030', 'tc1003');
INSERT INTO `teacher_techering_class` (`t_id`, `tc_id`) VALUES ('101101011', 'tc1004');
INSERT INTO `teacher_techering_class` (`t_id`, `tc_id`) VALUES ('101101011', 'tc1005');
INSERT INTO `teacher_techering_class` (`t_id`, `tc_id`) VALUES ('101101023', 'tc1007');
INSERT INTO `teacher_techering_class` (`t_id`, `tc_id`) VALUES ('101101017', 'tc1010');
COMMIT;

-- ----------------------------
-- Table structure for teaching_class
-- ----------------------------
DROP TABLE IF EXISTS `teaching_class`;
CREATE TABLE `teaching_class` (
  `tc_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tc_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tc_num` int DEFAULT NULL,
  `tc_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tc_point` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`tc_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of teaching_class
-- ----------------------------
BEGIN;
INSERT INTO `teaching_class` (`tc_id`, `tc_name`, `tc_num`, `tc_time`, `tc_point`) VALUES ('tc1001', '高数1班', 30, '1-2 ', 'A栋101');
INSERT INTO `teaching_class` (`tc_id`, `tc_name`, `tc_num`, `tc_time`, `tc_point`) VALUES ('tc1002', '大英1班', 30, '2-3', 'B栋102');
INSERT INTO `teaching_class` (`tc_id`, `tc_name`, `tc_num`, `tc_time`, `tc_point`) VALUES ('tc1003', ' Java web1班', 30, '1-3', 'C栋102');
INSERT INTO `teaching_class` (`tc_id`, `tc_name`, `tc_num`, `tc_time`, `tc_point`) VALUES ('tc1004', 'Python1班', 30, '2-3', 'B栋001');
INSERT INTO `teaching_class` (`tc_id`, `tc_name`, `tc_num`, `tc_time`, `tc_point`) VALUES ('tc1005', 'C1班', 30, '2-3', 'A栋102');
INSERT INTO `teaching_class` (`tc_id`, `tc_name`, `tc_num`, `tc_time`, `tc_point`) VALUES ('tc1006', '线性代数1班', 30, '2-3', 'C栋102');
INSERT INTO `teaching_class` (`tc_id`, `tc_name`, `tc_num`, `tc_time`, `tc_point`) VALUES ('tc1007', '代数1班', 30, '2-3', 'D栋122');
INSERT INTO `teaching_class` (`tc_id`, `tc_name`, `tc_num`, `tc_time`, `tc_point`) VALUES ('tc1008', '大英2班', 30, '1-2', 'B栋012');
INSERT INTO `teaching_class` (`tc_id`, `tc_name`, `tc_num`, `tc_time`, `tc_point`) VALUES ('tc1009', '大英3班', 30, '3-4', 'B栋100');
INSERT INTO `teaching_class` (`tc_id`, `tc_name`, `tc_num`, `tc_time`, `tc_point`) VALUES ('tc1010', '高数2班', 30, '3-5', 'A栋111');
COMMIT;

-- ----------------------------
-- Table structure for teaching_programme
-- ----------------------------
DROP TABLE IF EXISTS `teaching_programme`;
CREATE TABLE `teaching_programme` (
  `cp_year` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cp_class` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tc_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `course_id` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`cp_year`,`cp_class`,`tc_id`) USING BTREE,
  KEY `course.id_cp` (`course_id`),
  KEY `quote_course.plan` (`cp_year`,`cp_class`,`course_id`),
  KEY `quote_tc.id` (`tc_id`),
  CONSTRAINT `quote_course.plan` FOREIGN KEY (`cp_year`, `cp_class`, `course_id`) REFERENCES `course_plan` (`cp_year`, `cp_class`, `course_id`),
  CONSTRAINT `quote_tc.id` FOREIGN KEY (`tc_id`) REFERENCES `teaching_class` (`tc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of teaching_programme
-- ----------------------------
BEGIN;
INSERT INTO `teaching_programme` (`cp_year`, `cp_class`, `tc_id`, `course_id`) VALUES ('2020-2021上', '10', 'tc1001', 'c001');
INSERT INTO `teaching_programme` (`cp_year`, `cp_class`, `tc_id`, `course_id`) VALUES ('2020-2021下', '10', 'tc1010', 'c001');
INSERT INTO `teaching_programme` (`cp_year`, `cp_class`, `tc_id`, `course_id`) VALUES ('2020-2021上', '10', 'tc1002', 'c002');
INSERT INTO `teaching_programme` (`cp_year`, `cp_class`, `tc_id`, `course_id`) VALUES ('2020-2021下', '10', 'tc1003', 'c006');
INSERT INTO `teaching_programme` (`cp_year`, `cp_class`, `tc_id`, `course_id`) VALUES ('2020-2021下', '10', 'tc1005', 'c008');
COMMIT;

-- ----------------------------
-- Table structure for thing
-- ----------------------------
DROP TABLE IF EXISTS `thing`;
CREATE TABLE `thing` (
  `thingtxt` text,
  `tine` datetime DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of thing
-- ----------------------------
BEGIN;
INSERT INTO `thing` (`thingtxt`, `tine`, `id`) VALUES ('2023年2月20正式开学', '2023-01-10 11:33:29', 1);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `u_pwd` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `u_status` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`u_id`, `u_pwd`, `u_status`) VALUES ('101101011', '000000', '老师');
INSERT INTO `user` (`u_id`, `u_pwd`, `u_status`) VALUES ('20220101', '123456', '学生');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
