DROP TABLE IF EXISTS `fussballdb`.`t_team`;
CREATE TABLE `fussballdb`.`t_team` (
  `id` INTEGER UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `C_icon` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)