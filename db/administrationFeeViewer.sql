CREATE DATABASE springapp;

GRANT ALL ON springapp.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser';
GRANT ALL ON springapp.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';

USE springapp;

CREATE TABLE accounts(
  accountID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
  balance decimal(15,2),
  anualAdminFee decimal(15,2),
  modality varchar(255),
  modalityFee decimal(15,2),
  feePeriod varchar(255)
);

CREATE TABLE administrationfees(
	administrationFeeID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
	anualAdminFee decimal(15,2),
	modality varchar(255),
	modalityFee decimal(15,2),
	feePeriod varchar(255)
);

CREATE INDEX account_ID ON accounts(accountID);
CREATE INDEX administrationFee_modality ON administrationfees(modality);
