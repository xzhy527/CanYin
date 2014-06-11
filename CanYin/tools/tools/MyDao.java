package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.lang.Strings;

import db_beans.DbConfig;
import db_beans.DbPermission;
import db_beans.DbTable;

public class MyDao extends NutDao {
	
  public MyDao(DataSource dataSource) {
	  super(dataSource);
	// TODO Auto-generated constructor stub
}
  public List query(String sqltext){
	  Sql sql=Sqls.create(sqltext);
	  
	  
	  sql.setCallback(new SqlCallback() {
		
		@Override
		public Object invoke(Connection conn, ResultSet rs, Sql sql)
				throws SQLException {
			List<Record> re=new ArrayList<Record>();
			while(rs.next()){				
				re.add(Record.create(rs));				
			}
			
			
			return re;
		}
	});	  
	  this.execute(sql);
	  return (List)sql.getResult();
  }
  
  public int sql_int(String sqltext){
	  int re_t=0;
	  Sql sql=Sqls.create(sqltext);	  
	  sql.setCallback(new SqlCallback() {		
		@Override
		public Object invoke(Connection conn, ResultSet rs, Sql sql)throws SQLException {
			if(rs.next()){
				return rs.getInt(0);
			}else{
				return null;
			}
		}
	});	  
	  this.execute(sql);	  
	  return (Integer) sql.getResult();	  
  }
  public int getConfig(String name,String type){
	 Condition cond=null;
	 String sqltext="";
	 if(!Strings.isBlank(name)){
		 
		 sqltext+="name='"+name+"' and ";
	 }
	 if(!Strings.isBlank(type)){
		 sqltext+="type='"+type+"' and ";
	 }
	 
	 if(sqltext.length()>1){
		 sqltext=sqltext.substring(0, sqltext.length()-5);
		 cond=Cnd.wrap(sqltext);
	 }
	  DbConfig configbean = this.fetch(DbConfig.class,cond);
	  if(configbean==null){
		  return (Integer) null;
	  }
	  return configbean.getIntvalue();
 
  }
  public int getpermisson(int userID,String perName){
	  DbPermission pbean = this.fetch(DbPermission.class,Cnd.where("name","=",perName));
	  if(pbean==null){
		  return 0;
	  }
	 return  pbean.getPermValue();
  }

  
}
