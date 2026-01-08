-- ----------------------------
-- 审核管理模块数据库表
-- ----------------------------

-- ----------------------------
-- 1、审核项目表 dm_review_item
-- ----------------------------
DROP TABLE IF EXISTS `dm_review_item`;
CREATE TABLE `dm_review_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `table_name` varchar(100) NOT NULL COMMENT '业务表名',
  `pk_value` varchar(50) NOT NULL COMMENT '业务表主键值',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '所属部门ID',
  `status` varchar(50) NOT NULL DEFAULT 'DRAFT' COMMENT '审核状态: DRAFT-草稿, SUBMITTED-已提交, DEPT_APPROVED-部门通过, DEPT_REJECTED-部门驳回, SCHOOL_APPROVED-学校通过, SCHOOL_REJECTED-学校驳回',
  `version` bigint(20) DEFAULT 0 COMMENT '版本号',
  `data_hash` varchar(255) DEFAULT NULL COMMENT '数据摘要(MD5)',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_table_pk` (`table_name`, `pk_value`),
  KEY `idx_dept_id` (`dept_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='审核项目表';

-- ----------------------------
-- 2、审核任务表 dm_review_task
-- ----------------------------
DROP TABLE IF EXISTS `dm_review_task`;
CREATE TABLE `dm_review_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item_id` bigint(20) NOT NULL COMMENT '审核项ID(外键dm_review_item.id)',
  `assignee_role` varchar(50) NOT NULL COMMENT '审核人角色: DATA_COLLECTOR-数据采集员, DEPT_REVIEWER-部门审核员, SCHOOL_REVIEWER-学校审核员',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `status` varchar(50) NOT NULL DEFAULT 'OPEN' COMMENT '任务状态: OPEN-待处理, CLOSED-已关闭, CANCELED-已取消',
  `comment` text COMMENT '审核意见',
  `snapshot_json` longtext COMMENT '数据快照(JSON格式)',
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_item_id` (`item_id`),
  KEY `idx_assignee_role` (`assignee_role`),
  KEY `idx_dept_id` (`dept_id`),
  KEY `idx_status` (`status`),
  CONSTRAINT `fk_review_task_item` FOREIGN KEY (`item_id`) REFERENCES `dm_review_item` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='审核任务表';

-- ----------------------------
-- 3、审核历史表 dm_review_history
-- ----------------------------
DROP TABLE IF EXISTS `dm_review_history`;
CREATE TABLE `dm_review_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item_id` bigint(20) NOT NULL COMMENT '审核项ID(外键dm_review_item.id)',
  `action` varchar(50) NOT NULL COMMENT '操作类型: SUBMIT-提交, DEPT_APPROVE-部门通过, DEPT_REJECT-部门驳回, SCHOOL_APPROVE-学校通过, SCHOOL_REJECT-学校驳回',
  `actor_id` bigint(20) DEFAULT NULL COMMENT '操作者用户ID',
  `actor_role` varchar(50) DEFAULT NULL COMMENT '操作者角色',
  `comment` text COMMENT '操作意见',
  `snapshot_json` longtext COMMENT '数据快照(JSON格式)',
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`),
  KEY `idx_item_id` (`item_id`),
  KEY `idx_action` (`action`),
  KEY `idx_actor_id` (`actor_id`),
  KEY `idx_create_at` (`create_at`),
  CONSTRAINT `fk_review_history_item` FOREIGN KEY (`item_id`) REFERENCES `dm_review_item` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='审核历史表';

-- ----------------------------
-- 测试数据（可选）
-- ----------------------------
-- INSERT INTO dm_review_item (table_name, pk_value, dept_id, status, create_by) 
-- VALUES ('test_table', '1', 103, 'DRAFT', 'admin');
