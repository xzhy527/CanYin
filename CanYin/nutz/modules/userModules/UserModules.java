package modules.userModules;

import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.ViewWrapper;
import tools.MyDao;
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
	
	DbUser ub = dao.fetch(DbUser.class, loginName);
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
}
