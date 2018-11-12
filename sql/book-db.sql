CREATE DATABASE /*!32312 IF NOT EXISTS*/`book-user` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `book-user`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `email` varchar(50) NOT NULL COMMENT 'email',
  `deleted` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '删除标志，默认0不删除，1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`id`,`user_name`,`password`,`email`,`deleted`,`create_time`,`update_time`) values (1,'admin','admin','bobo0218bo@126.com',0,'2016-02-02 12:56:31','2016-02-02 14:47:25');




CREATE DATABASE /*!32312 IF NOT EXISTS*/`book-order` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book-order`;

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `product_id` int(10) NOT NULL DEFAULT '0' COMMENT '产品ID',
  `price` int(10) DEFAULT '0' COMMENT '价格',
  `user_id` int(10) DEFAULT '0' COMMENT '用户账号ID',
  `trade_id` int(10) DEFAULT '0' COMMENT '交易号ID',
  `trade_status` tinyint(1) DEFAULT '0' COMMENT '支付状态 0=未支付 1=已支付',
  `deleted` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '删除标志，默认0不删除，1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



CREATE DATABASE /*!32312 IF NOT EXISTS*/`book-product` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book-product`;

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '产品名称',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '产品状态：0待审，1上架，2下架，3停售，4测试',
  `price` int(10) NOT NULL COMMENT '产品价格 单位分',
  `detail` text COMMENT '产品详情',
  `deleted` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '删除标志，默认0不删除，1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='产品信息';

/*Data for the table `product` */

INSERT INTO `product` VALUES (1, '漫谈spring cloud与spring boot基础架构（微服务基础篇）', 1, 299, '漫谈spring cloud与spring boot基础架构（微服务基础篇）', 0, '2018-4-10 10:08:10', '2018-4-10 10:08:33');
INSERT INTO `product` VALUES (2, '漫谈spring cloud分布式服务架构（微服务进阶篇）', 1, 399, '漫谈spring cloud分布式服务架构（微服务进阶篇）', 0, '2018-4-10 10:08:10', '2018-4-10 10:08:29');
INSERT INTO `product` VALUES (3, '漫谈spring cloud 与docker架构部署（微服务高级篇）', 1, 399, '漫谈spring cloud 与docker架构部署（微服务高级篇）', 0, '2018-4-10 10:08:10', '2018-4-10 10:08:19');


CREATE DATABASE /*!32312 IF NOT EXISTS*/`book-trade` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book-trade`;

DROP TABLE IF EXISTS `trade`;

CREATE TABLE `trade` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'IID',
  `order_id` int(10) NOT NULL COMMENT '订单ID',
  `user_id` int(10) NOT NULL COMMENT '用户ID',
  `price` int(10) NOT NULL COMMENT '支付价',
  `pay_status` tinyint(4) NOT NULL COMMENT '1 未付款 2 付款中 3 付款失败 4 付款完成',
  `pay_type` tinyint(4) NOT NULL COMMENT '支付类型:1-支付宝支付，2-网银在线，3-银联，4-微信支付',
  `gateway_pay_num` varchar(30) DEFAULT NULL COMMENT '网关支付流水号',
  `gateway_pay_time` datetime DEFAULT NULL COMMENT '网关支付时间',
  `gateway_pay_price` int(10) NOT NULL DEFAULT '0' COMMENT '网关实际支付金额',
  `deleted` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '删除标志，默认0不删除，1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='交易';


