package modules.usermodules;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.ViewWrapper;




import tools.MyDao;
import tools.MyLong;
import db_beans.DbOptlog;
import db_beans.DbUser;
import debeans.AjaxJSON;
@IocBean
public class UserModules {
	@Inject	
	MyDao dao;	
@At()
public View login_Base(String loginName,String loginPWD,HttpSession session){		
	if(Strings.isBlank(loginName)||Strings.isBlank(loginPWD))
		return AjaxJSON.AjaxJSON("登陆信息不符合规则", null);
	
	DbUser ub =(DbUser) dao.query(DbUser.class,Cnd.where("loginName","=",loginName));
	
	//DbUser ub = dao.fetch(DbUser.class,loginName);
	if(ub==null){
		return AjaxJSON.AjaxJSON("用户名不存在", null);
	}
	if(!loginPWD.equals(ub.getLoginpwd())){
	
		return AjaxJSON.AjaxJSON("密码错误！！", null);
	}
	if(ub.getStatus()<1){
		return AjaxJSON.AjaxJSON("用户禁止进入系统", null);
	}	
	session.setAttribute("loginuser",ub);
	System.out.println("fsadfas");
	return new ViewWrapper(new JspView("/index.jsp"), ub);
}

@At("wxlogin")
@Ok("json")
public Object wxlogin(String loginname,String loginpassword,HttpSession session,String topage){
	if(Strings.isBlank(loginname)){
		return new AjaxJSON("用户名不能为空");
	}	
	if(Strings.isBlank(loginpassword)){
		return new AjaxJSON("密码不能为空");
	}
	
	DbUser ubean = dao.fetch(DbUser.class,Cnd.where("LoginName","=",loginname));
	if(ubean==null){
		return new AjaxJSON("用户名不存在");
	}
	if(loginpassword.equals(ubean.getLoginpwd())){
		session.setAttribute("loginuser", ubean);		
		DbOptlog dblog = new DbOptlog();		
		dblog.setType("微信登陆");		
		dblog.setOperator(loginname);
		dao.insert(dblog);		
		return new AjaxJSON("登陆成功");
	}else{
		return new AjaxJSON("密码错误，请重试！");
	}
	
}
@At()
@Ok("json")
public Object getuserList(String userType[],String groupid){
	HashMap<String, Object> sqlmapMap=new HashMap<String, Object>();	
	sqlmapMap.put("UserType", userType);
	sqlmapMap.put("GroupID", groupid);
	Condition cond = Cnd.wrap(MyLong.sqltext(sqlmapMap));
	return dao.query(DbUser.class, cond);
	
	
}



}
