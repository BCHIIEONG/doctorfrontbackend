-- 创建体检管理系统数据库
CREATE DATABASE IF NOT EXISTS `tijian` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `tijian`;

-- 创建医生表
CREATE TABLE IF NOT EXISTS `doctor` (
  `doc_id` int(11) NOT NULL AUTO_INCREMENT,
  `doc_code` varchar(50) NOT NULL COMMENT '医生编码',
  `real_name` varchar(100) NOT NULL COMMENT '真实姓名',
  `password` varchar(255) NOT NULL COMMENT '登录密码',
  `sex` int(1) DEFAULT NULL COMMENT '性别 (1-男, 2-女)',
  `deptno` int(11) DEFAULT NULL COMMENT '科室编号',
  PRIMARY KEY (`doc_id`),
  UNIQUE KEY `uk_doc_code` (`doc_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='医生表';

-- 插入测试用的医生数据
INSERT INTO `doctor` (`doc_code`, `real_name`, `password`, `sex`, `deptno`) VALUES
('zzj', '张医生', '123', 1, 1),
('admin', '管理员', '123456', 1, 1),
('test', '测试医生', '123', 2, 2);

-- 创建其他可能需要的表结构（基于项目中的PO类）

-- 医院表
CREATE TABLE IF NOT EXISTS `hospital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '医院名称',
  `address` varchar(500) DEFAULT NULL COMMENT '医院地址',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='医院表';

-- 用户表
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `real_name` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 套餐表
CREATE TABLE IF NOT EXISTS `setmeal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `help_code` varchar(50) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `remark` text,
  `attention` text,
  `img` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='套餐表';

-- 检查项目表
CREATE TABLE IF NOT EXISTS `check_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` char(1) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `attention` text,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='检查项目表';

-- 订单表
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `order_type` varchar(20) DEFAULT NULL,
  `order_status` varchar(20) DEFAULT NULL,
  `setmeal_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='预约订单表';

-- 总体结果表
CREATE TABLE IF NOT EXISTS `overall_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `result` text,
  `suggestion` text,
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='总体检查结果表';

-- 检查报告表
CREATE TABLE IF NOT EXISTS `ci_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `check_item_id` int(11) NOT NULL,
  `result` text,
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='检查报告表';

-- 详细检查报告表
CREATE TABLE IF NOT EXISTS `ci_detailed_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ci_report_id` int(11) NOT NULL,
  `item_name` varchar(255) NOT NULL,
  `item_result` varchar(500) DEFAULT NULL,
  `reference_range` varchar(255) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='详细检查报告表';

COMMIT;