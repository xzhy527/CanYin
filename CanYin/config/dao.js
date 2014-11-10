var ioc={
	dataSource :{
		type:"com.alibaba.druid.pool.DruidDataSource",
		      
		fields:{
			//driverClassName:"com.microsoft.sqlserver.jdbc.SQLServerDriver",
			driverClassName:"com.mysql.jdbc.Driver",
//			url:"jdbc:sqlserver://192.198.168.102:1433;DatabaseName=DB_CY",
//			username:"sa",
//			password:"xiaozhaoyang831210"
			url : 'jdbc:mysql://xzhy527.gotoftp4.com/xzhy527',
			username:"xzhy527",
			password:"xzhy831210"
		},
		events:{
			depose:"close"
		}
	},
	dao:{
		type:"tools.MyDao",
		args:[{
			refer:"dataSource"
		}]
	}	
};
