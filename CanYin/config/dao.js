var ioc={
	dataSource :{
		type:"com.alibaba.druid.pool.DruidDataSource",
		      
		fields:{
			driverClassName:"com.microsoft.sqlserver.jdbc.SQLServerDriver",
			url:"jdbc:sqlserver://192.198.168.102:1433;DatabaseName=DB_CY",
			username:"sa",
			password:"xiaozhaoyang831210"	
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
