package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.jdbc.ValueAdaptor;
import org.nutz.dao.sql.Pojo;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.dao.util.cri.SqlExpression;
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
  
  /**
   * 取全局配置项
   * @param name
   * @param type
   * @param intvalue
   * @param charvalue
   * @param columnstr
   * @return
   */
  
  
  
  
  public Object getConfig(String name,String type,Integer intvalue,String charvalue,String columnstr){
	  Map<String,Object> map = new HashMap<String,Object>();	  
	  map.put("name", name);
	  map.put("type", type);
	  map.put("intvalue", intvalue);
	  map.put("charvalue", charvalue);
	  String sqlTextString=MyLong.sqltext(map);
	  if(sqlTextString!=null)
		  sqlTextString=" where "+sqlTextString;
	  List re_t = this.query("select "+columnstr+" from db_config "+sqlTextString);
	  if(re_t==null)
		  return null;
	  if(re_t.size()==1){
		  //type=<Record>
		  if("*".equals(columnstr)){
			  return re_t.get(0);
		  }else{
			  Record record = (Record) re_t.get(0);
			  return record.getString(columnstr);
		  } 		  
	  }else{
		  return re_t;
	  }
  }
  public int getpermisson(int userID,String perName){
	  DbPermission pbean = this.fetch(DbPermission.class,Cnd.where("name","=",perName));
	  if(pbean==null){
		  return 0;
	  }
	 
	 return  pbean.getPermValue();
  }



}
