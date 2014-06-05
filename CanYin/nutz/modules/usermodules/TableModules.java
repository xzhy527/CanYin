package modules.usermodules;

import java.util.Date;
import java.util.UUID;

import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.UTF8JsonView;
import org.nutz.mvc.view.ViewWrapper;

import db_beans.DbOptlog;
import db_beans.DbOrder;
import db_beans.DbTable;
import db_beans.DbUser;
import debeans.AjaxJSON;
import tools.MyDao;
import tools.MyLong;

@IocBean
public class TableModules {
	
	@Inject
	
	MyDao dao;
/**
 * 开台操作	
 * @param ID
 * @param waiter
 * @param persons
 * @param dataType
 * @return
 */

	
@Aop("canYinInterceptor")	
@At()
@Ok("json")
	public Object startTable(int waiter,int ID,int persons,String dataType){
		if(ID<1){
			return new AjaxJSON("ID不能为空",500);
		}
		if(waiter<1){
			return new AjaxJSON("服务员信息不足",500);
		}		
		//权限转移到AOP去处理

		if(dao.getpermisson(waiter,"KT")<1){
			return new AjaxJSON("对不起，您没有开台的权限",502);
		}
		DbTable tablebean = dao.fetch(DbTable.class, ID);
		String state = tablebean.getState();
		if(state.equals("空闲")){			
			Date c_time=new Date();			
			dao.update(DbOrder.class, Chain.make("State", -1), Cnd.where("HoldTime","<",c_time));			
			//Cnd.wrap("where TableID="+ID+"OrderTime>="+new Date()+" order by OrderTime asc");			
			DbOrder orderbean = dao.fetch(DbOrder.class,Cnd.where("TableID","=",ID).and("State",">",0).and("OrderTime",">=",c_time).asc("OrderTime"));
			
			//取全局配置项
			if((orderbean.getOrdertime().getTime() - c_time.getTime()) > dao.getConfig("MaxTime", "c_order")){				
				return new AjaxJSON("该桌台有预定",500);
			}
			tablebean.setState("使用中");
			tablebean.setStarttime(new java.sql.Date(new java.util.Date().getTime()));
			tablebean.setWaiter(waiter);
			tablebean.setAllow(persons);
			tablebean.setSalesid(MyLong.gen_SaleID());
			dao.update(tablebean);
			DbOptlog dblog = new DbOptlog();
			dblog.setType("开台操作");
			dblog.setTableid(ID);
			DbUser opter = dao.fetch(DbUser.class,waiter);
			dblog.setOperator(opter.getLoginname());
			dao.insert(dblog);
			return new AjaxJSON("开台成功");
			
		}else{			
			return new AjaxJSON("不能开台",203);
		}
	}
}
