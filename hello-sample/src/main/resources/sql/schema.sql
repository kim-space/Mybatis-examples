CREATE TABLE IF NOT EXISTS `t_role` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(10) NOT NULL,
  `note` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_role (roleName, note) VALUES ("user","普通用户"),("admin","管理员");


CREATE TABLE IF NOT EXISTS `t_user`(
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(15) NOT NULL ,
  `cnname` VARCHAR(15) NOT NULL ,
  `birthday` DATE,
  `sex` INT,
  `email` VARCHAR(25),
  `mobile` INT(9),
  `note` VARCHAR(50),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

