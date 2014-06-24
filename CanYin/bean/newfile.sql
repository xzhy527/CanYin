

/* Create Tables */

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
	waiter varchar(20),
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
	MemberID int,
	ID int,
	tableID int,
	isnormal int,
	PRIMARY KEY (ID)
);


CREATE TABLE db_optlog
(
	ID int,
	Type varchar(20),
	Name varchar(50),
	Descr varchar(300),
	CreateTime smalldatetime,
	TableID int,
	InWay varchar(10),
	Operator varchar(100)
);


CREATE TABLE db_order
(
	ID int NOT NULL IDENTITY ,
	MemberID int,
	OrderType varchar(10),
	TableID int,
	OrderName varchar(20),
	OrderPhone varchar(50),
	People int,
	OrderTime smalldatetime,
	HoldTime smalldatetime,
	OrderLevel int,
	Operater varchar(20),
	Prepay float,
	CreateTime smalldatetime,
	State int,
	PRIMARY KEY (ID)
);


CREATE TABLE db_permission
(
	ID int NOT NULL IDENTITY ,
	-- 组权限
	-- 用户权限
	Type varchar(10),
	-- 权限名称
	Perm_Name varchar(20),
	-- 权限值
	Perm_Value int,
	State int,
	UserID int,
	GroupID int,
	PRIMARY KEY (ID)
);


CREATE TABLE db_Config
(
	ID int NOT NULL IDENTITY ,
	Type varchar(20),
	Name varchar(20),
	CharValue varchar(100),
	IntValue int,
	Descr varchar(100),
	Reserved varchar(200),
	PRIMARY KEY (ID)
);


CREATE TABLE db_table
(
	ID int NOT NULL IDENTITY ,
	-- 别名
	Alias varchar(20),
	TableName varchar(20),
	TableType varchar(20),
	Position varchar(20),
	Limit float,
	AllowPeople int,
	State varchar(20),
	IsOrder int,
	SalesID varchar(100),
	waiter varchar(20),
	Prepay float,
	StartTime smalldatetime,
	FinishTime smalldatetime,
	Desrc varchar(200),
	Reserve varchar(100),
	Permission int,
	UserID int,
	PRIMARY KEY (ID)
);


CREATE TABLE db_user
(
	ID int NOT NULL IDENTITY ,
	GroupID int,
	LoginName varchar(20),
	LoginPWD varchar(20),
	ShowName varchar(50),
	LoginIP varchar(20),
	LastTime smalldatetime,
	Status int,
	WxID varchar(100),
	-- 联系方式
	ContactInfo varchar(200),
	CreatTime smalldatetime,
	CardID varchar(100),
	UserType varchar(50),
	PRIMARY KEY (ID)
);



