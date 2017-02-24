USE ms ;

CREATE TABLE seckill (
  `seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  `s_name` VARCHAR (120) NOT NULL COMMENT '商品名称',
  `s_number` INT NOT NULL COMMENT '库存数量',
  `start_time` TIMESTAMP NOT NULL COMMENT '秒杀开启时间',
  `end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time (start_time),
  KEY idx_end_time (end_time),
  KEY idx_create_time (create_time)
) ENGINE = INNODB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8 COMMENT '秒杀库存表' ;

INSERT INTO seckill (
  s_name, s_number, start_time, end_time
) 
VALUES
  (
    '1000元秒杀iphone4', 10, '2015-11-01 00:00:00', '2015-11-01 00:00:00'
  ) ;


INSERT INTO seckill (
  s_name, s_number, start_time, end_time
) 
VALUES
  (
    '1000元秒杀ipdad2', 10, '2015-11-01 00:00:00', '2015-11-01 00:00:00'
  ) ;


INSERT INTO seckill (
  s_name, s_number, start_time, end_time
) 
VALUES
  (
    '1000元秒杀小米5', 10, '2015-11-01 00:00:00', '2015-11-01 00:00:00'
  ) ;


INSERT INTO seckill (
  s_name, s_number, start_time, end_time
) 
VALUES
  (
    '1000元秒杀锤子m1', 10, '2015-11-01 00:00:00', '2015-11-01 00:00:00'
  )) ;

-- 秒杀成功明细表
-- 用户登录认证相关信息
CREATE TABLE success_killed (
  seckill_id BIGINT NOT NULL COMMENT '秒杀商品id',
  user_phone BIGINT NOT NULL COMMENT '用户电话',
  state TINYINT NOT NULL DEFAULT - 1 COMMENT '-1：无效，0 成功 1 已付款',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (seckill_id,user_phone),
  KEY idx_create_time (create_time)
  
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '秒杀成功明细表' 
