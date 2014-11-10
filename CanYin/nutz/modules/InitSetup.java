package modules;
import java.io.File;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Chain;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.ioc.Ioc;
import org.nutz.json.Json;
import org.nutz.lang.Files;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

import db_beans.DbTable;
import db_beans.DbUser;
import tools.MyDao;
public class InitSetup implements Setup{
	@Override
	public void init(NutConfig nc) {
		Ioc ioc = nc.getIoc();
		MyDao mydao = ioc.get(null,"dao");
		File file = Files.findFile("db_beans/testdata.js");
		Map initData=null;
		if(file!=null)initData= Json.fromJsonFile(Map.class,file);
		for(Class<?> klass : Scans.me().scanPackage("db_beans")){
			Table tAn = klass.getAnnotation(Table.class);
			if(null != tAn){
				System.out.println("表名:"+tAn.value());
				if(!mydao.exists(klass)){
					mydao.create(klass, false);
					if(initData==null)continue;
					List tabledatalist=(List) initData.get(tAn.value());
					if(tabledatalist==null)continue;
					for (Object object : tabledatalist) {
						mydao.insert(klass, Chain.from(object));				
					}
				}
				
			}
		}
	}

	@Override
	public void destroy(NutConfig nc) {
		// TODO Auto-generated method stub
		
	}

}
