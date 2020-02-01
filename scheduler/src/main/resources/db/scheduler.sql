CREATE database spring-test;

CREATE TABLE `sys_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_name` varchar(512) NOT NULL COMMENT '任务名称',
  `job_group` varchar(512) NOT NULL COMMENT '任务组名',
  `job_cron` varchar(512) NOT NULL COMMENT '时间表达式',
  `job_class_path` varchar(1024) NOT NULL COMMENT '类路径',
  `job_data_map` varchar(1024) DEFAULT NULL COMMENT 'map参数',
  `job_status` int(2) NOT NULL COMMENT '状态，1：启用，0：停用',
  `job_describe` varchar(1024) DEFAULT NULL COMMENT '任务功能描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `spring-test`.`sys_job` (`job_name`, `job_group`, `job_cron`, `job_class_path`, `job_data_map`, `job_status`, `job_describe`) VALUES ('task1', 'test', '0/5 * * * * ?', 'scheduler.config.MyJob1', '', '1', '测试专用');
