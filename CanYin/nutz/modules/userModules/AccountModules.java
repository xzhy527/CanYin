package modules.userModules;

import java.util.Date;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import db_beans.DbAccount;
import db_beans.DbSales;
import db_beans.DbTable;
import tools.MyDao;

@IocBean
public class AccountModules {
	@Inject
	MyDao dao;
@At()
@Ok("json")

public Object paybill(int tableID,String waiter,float rmoney){
	
	DbTable tbean = dao.fetch(DbTable.class,tableID);
	
	tbean.setState("空闲");
     String saleid = tbean.getSalesid();
	List<DbSales> slist = dao.query(DbSales.class,Cnd.where("SaleID","=",saleid));
	
	float totals=0;
	
    for(DbSales sbean:slist){    	
    	totals+=sbean.getRmbsum();
    }
    
    DbAccount abean=new DbAccount(); 
	
    abean.setTableid(tableID);
    abean.setCmoney(totals);
    abean.setRmoney(rmoney);
    abean.setDescr("正常结算");
    abean.setIsnormal(1);
    abean.setOperation(waiter);
	
    dao.insert(abean);
    dao.update(tbean);
   
	return new Date();
}
	
}
