package modules.userModules;

import java.util.Date;
import java.util.UUID;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.UTF8JsonView;
import org.nutz.mvc.view.ViewWrapper;

import db_beans.DbTable;
import debeans.AjaxJSON;
import tools.MyDao;
import tools.MyLong;

@IocBean
public class TableModules {
	
	@Inject
	
	MyDao dao;
/**
 * 暂时测试用	
 * @param ID
 * @param waiter
 * @param persons
 * @param dataType
 * @return
 */
	
@At()
@Ok("json")
	public Object startTable(int ID,int waiter,int persons,String dataType){
	
		if(ID<1){
			return new AjaxJSON("ID不能为空",500);
		}
		if(waiter<1){
			return new AjaxJSON("服务员信息不足",500);
		}
		
		DbTable tablebean = dao.fetch(DbTable.class, ID);
		String state = tablebean.getState();
		if(state.equals("空闲")){
			tablebean.setState("使用中");
			tablebean.setStarttime(new java.sql.Date(new java.util.Date().getTime()));
			tablebean.setWaiter(waiter);
			tablebean.setAllow(persons);
			tablebean.setSalesid(MyLong.gen_SaleID());
			dao.update(tablebean);
			return new AjaxJSON("开台成功");
			
		}else{
			
			return new AjaxJSON("不能开台",203);
			
		}
	}
}
