

/* Create Tables */

CREATE TABLE db_user
(
	ID int NOT NULL IDENTITY ,
	GroupID int,
	LoginName varchar(20),
	LoginPWD varchar(20),
	CreatTime smalldatetime,
	employID int,
	LoginIP varchar(20),
	LastTime smalldatetime,
	Status int,
	PRIMARY KEY (ID)
);



