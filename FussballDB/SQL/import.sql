CREATE TABLE `fussballdb`.`verein` (
  `i_id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `v_name` VARCHAR(200),
  `v_gruendung` DATE ,
  `v_trainer` VARCHAR(200),
  `v_praesident` VARCHAR(200),
  `v_ort` VARCHAR(200),
  `v_logo` VARCHAR(255),
  `fk_stadion` INTEGER NOT NULL default -1,
  PRIMARY KEY (`i_id`)
);

CREATE TABLE `fussballdb`.`spiel` (
  `i_id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `i_saison` INTEGER UNSIGNED,
  `v_datum` DATE,
  `i_zuschauer` INTEGER,
  `v_schiri` VARCHAR(200),
  `fk_stadion` INTEGER NOT NULL DEFAULT '-1',
  `v_endergebnis` VARCHAR(5),
  `v_hzergebnis` VARCHAR(5),
  `i_punkteHeim` INTEGER,
  `i_punkteGast` INTEGER,
  `fk_heimVerein` INTEGER NOT NULL DEFAULT '-1',
  `fk_gastVerein` INTEGER NOT NULL DEFAULT '-1',
  PRIMARY KEY (`i_id`)
);

CREATE TABLE `fussballdb`.`spieler` (
  `i_id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `v_name` VARCHAR(200),
  `v_position` VARCHAR(200),
  `v_geburtsdatum` DATE,
  `v_nation` VARCHAR(200),
  `v_bild` VARCHAR(255),
  `fk_verein` INTEGER NOT NULL DEFAULT '-1',
  PRIMARY KEY (`i_id`)
);

CREATE TABLE `fussballdb`.`stadion` (
  `i_id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `v_name` VARCHAR(200),
  `v_gps` VARCHAR(200),
  `v_adresse` VARCHAR(200),
  `v_bild` VARCHAR(255),
  `i_kapazitaet` INTEGER UNSIGNED,
  PRIMARY KEY (`i_id`)
);

CREATE TABLE `fussballdb`.`tor` (
  `i_id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `i_torHeim` INTEGER UNSIGNED NOT NULL,
  `i_torGast` INTEGER UNSIGNED NOT NULL,
  `i_minute` INTEGER UNSIGNED NOT NULL,
  `fk_spieler` INTEGER NOT NULL default -1,
  `fk_spiel` INTEGER NOT NULL default -1,
  PRIMARY KEY (`i_id`)
);


