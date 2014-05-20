

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


CREATE TABLE db_table
(
	ID int NOT NULL IDENTITY ,
	alias varchar(20),
	tablename varchar(20),
	type varchar(20),
	position varchar(20),
	limit float,
	allow int,
	state varchar(20),
	isorder int,
	SalesID int,
	Water int,
	prepay float,
	starttime smalldatetime,
	finishtime smalldatetime,
	desrc varchar(200),
	reserve varchar(100),
	permission int,
	PRIMARY KEY (ID)
);



