

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
	waivter varchar(20),
	prepay float,
	starttime smalldatetime,
	finishtime smalldatetime,
	desrc varchar(200),
	reserve varchar(100),
	permission int,
	PRIMARY KEY (ID)
);


CREATE TABLE db_goods
(
	ID int NOT NULL IDENTITY ,
	name varchar(20),
	sort varchar(20),
	supplyID int,
	barcode varchar(50),
	picaddr varchar(100),
	surplus int,
	desrc varchar(100),
	logo varchar(20),
	mprice float,
	bprice float,
	rate float,
	classname varchar(10),
	validity int,
	PRIMARY KEY (ID)
);


CREATE TABLE db_Dishes
(
	ID int NOT NULL IDENTITY ,
	name varchar(20),
	sort varchar(20),
	barcode varchar(50),
	picaddr varchar(100),
	desrc varchar(100),
	logo varchar(20),
	mprice float,
	bprice float,
	rate float,
	classname varchar(10),
	validity int,
	cost float,
	PRIMARY KEY (ID)
);


CREATE TABLE db_sales
(
	ID int NOT NULL IDENTITY ,
	salename varchar(100),
	bprice float,
	mprice float,
	quantity int,
	rmbsum float,
	waivter varchar(20),
	creattime smalldatetime,
	state varchar(20),
	SaleID varchar(100),
	PRIMARY KEY (ID)
);


CREATE TABLE db_account
(
	ID int NOT NULL IDENTITY ,
	SaleID varchar(50),
	paytype varchar(20),
	cmoney float,
	rmoney float,
	operation varchar(20),
	creattime smalldatetime,
	member int,
	PRIMARY KEY (ID)
);



