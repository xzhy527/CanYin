package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Record;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;

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
}
