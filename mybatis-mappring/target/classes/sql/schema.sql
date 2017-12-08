CREATE TABLE IF NOT EXISTS `t_card`(
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` CHAR(19) NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `t_users`(
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL ,
  `sex` CHAR(1) NOT NULL ,
  `age` INT(3) UNSIGNED NOT NULL ,
  `card_id` INT(10) NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS `t_student`(
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL ,
  `age` INT(3) NOT NULL ,
  `sex`CHAR(1) NOT NULL ,
  `clazz_id` INT(10) NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS `t_clazz`(
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` CHAR(20) NOT NULL ,
  `name` CHAR(20) NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

CREATE TABLE IF NOT EXISTS `t_blog`(
  `id` BIGINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(20) NOT NULL ,
  `content` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;