package cheshi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class SqlBean {
	Connection con;
	PreparedStatement pre;
	ResultSet rs;
	public SqlBean(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try {					       
				con=DriverManager.getConnection("jdbc:sqlserver://192.198.168.102:1433;DatabaseName=DB_CY","sa","xiaozhaoyang831210");				
				System.out.print("数据库连接成功");						
			} catch (SQLException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
	}
	

}