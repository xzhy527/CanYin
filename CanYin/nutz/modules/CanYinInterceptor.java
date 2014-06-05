package modules;

import org.nutz.aop.InterceptorChain;
import org.nutz.aop.MethodInterceptor;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import tools.MyDao;
import db_beans.DbPermission;
import db_beans.DbUser;
import debeans.AjaxJSON;
@IocBean
public class CanYinInterceptor implements MethodInterceptor {
	@Inject
	MyDao dao;
	@Override
	public void filter(InterceptorChain chain) throws Throwable {
		Object[] obj = chain.getArgs();		
		int userid=(Integer)obj[0];
		if(userid<1){
			chain.setReturnValue(new AjaxJSON("无用户信息",502));
			return;
		}
		DbUser userbean = dao.fetch(DbUser.class,userid);		
		if(userbean==null) {
			chain.setReturnValue(new AjaxJSON("用户不存在",502));
			return;
		}
		int groupid=userbean.getGroupid();
		int re_count=dao.count(DbPermission.class,Cnd.where("name","=",(chain.getCallingMethod()).getName())
				.and("userid","=",userid).and("permValue","=",1));
		
		if(re_count<1){
			re_count=dao.count(DbPermission.class,Cnd.where("name","=",(chain.getCallingMethod()).getName())
					.and("groupid","=",groupid).and("permValue","=",1));
		}
		if(re_count<1)
		{
			chain.setReturnValue(new AjaxJSON("权限不足",502));
		}else{
			chain.doChain();
		}
	}
}
