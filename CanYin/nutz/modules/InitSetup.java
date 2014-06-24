package modules;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.Entity;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import db_beans.DbTable;
import tools.MyDao;
public class InitSetup implements Setup{
	@Override
	public void init(NutConfig nc) {
		// TODO Auto-generated method stub
		Ioc ioc = nc.getIoc();
		MyDao mydao = ioc.get(null,"dao");
		if(!mydao.exists(DbTable.class)){
			mydao.create(DbTable.class, false);
			DbTable tbean = new DbTable();
			tbean.setAlias("第一桌");
			tbean.setTablename("第一桌");
			tbean.setTabletype("大厅");
			mydao.insert(tbean);
			
			/**
			 * 通过文本配置文件，写数据
			 */			
		}
	
	}

	@Override
	public void destroy(NutConfig nc) {
		// TODO Auto-generated method stub
		
	}

}
