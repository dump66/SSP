DROP TABLE IF EXISTS `fussballdb`.`verein`;
CREATE TABLE `fussballdb`.`verein` (
  `id` INTEGER UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL default '',
  `gruendung` DATE NOT NULL default '0000-00-00',
  `trainer` VARCHAR(45) NOT NULL default '',
  `praesident` VARCHAR(45) NOT NULL default '',
  `ort` VARCHAR(45) NOT NULL default '',
  `logo` VARCHAR(200) NOT NULL default '',
  `stadion` INTEGER NOT NULL default -1,
  PRIMARY KEY (`id`)
)