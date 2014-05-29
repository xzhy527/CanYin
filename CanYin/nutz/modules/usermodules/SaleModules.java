package modules.usermodules;

import java.util.Date;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import db_beans.DbDishes;
import db_beans.DbGoods;
import db_beans.DbSales;
import db_beans.DbTable;
import debeans.AjaxJSON;
import tools.MyDao;




@IocBean
public class SaleModules {
	
	
	@Inject
	MyDao dao;
@At()
@Ok("json")
	public Object insert_sale(int tableid,String classname,int ID,String waiter,int count){
		
		if(tableid<1){
			return new AjaxJSON("桌台号信息不全",500);
		}
		if(Strings.isBlank(classname)){
			return new AjaxJSON("分类信息不全",500);
		}
		
		DbTable tbean = dao.fetch(DbTable.class,tableid);
		
		tbean.getSalesid();
		 if(classname.equals("1")){
			 DbGoods gbean = dao.fetch(DbGoods.class,ID);
			 
			 DbSales salebean=new DbSales();
			 salebean.setBprice(gbean.getBprice());
			 salebean.setQuantity(count);
			 salebean.setRmbsum(gbean.getBprice()*count);
			 gbean.setSurplus(gbean.getSurplus()-count);			 
			 dao.update(gbean);
			 dao.insert(salebean);
			 return new AjaxJSON("添加成功");
			 
		 }else{
			 
			 
			 dao.fetch(DbDishes.class,ID);
			 
			 
			 DbSales salebean=new DbSales();
		 }

		return new Date();
	}

}
