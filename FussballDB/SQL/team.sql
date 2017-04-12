DROP TABLE IF EXISTS `fussballdb`.`verein`;
CREATE TABLE `fussballdb`.`verein` (
  `i_id` INTEGER UNSIGNED NOT NULL,
  `v_name` VARCHAR(45) NOT NULL default '',
  `d_gruendung` DATE NOT NULL default '0000-00-00',
  `v_trainer` VARCHAR(45) NOT NULL default '',
  `v_praesident` VARCHAR(45) NOT NULL default '',
  `v_ort` VARCHAR(45) NOT NULL default '',
  `v_logo` VARCHAR(200) NOT NULL default '',
  `i_stadion` INTEGER NOT NULL default -1,
  PRIMARY KEY (`id`)
)