package modules;

import java.beans.Beans;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.nutz.castor.castor.Object2Map;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.weixin.bean.WxArticle;
import org.nutz.weixin.bean.WxInMsg;
import org.nutz.weixin.bean.WxOutMsg;
import org.nutz.weixin.impl.BasicWxHandler;
import org.nutz.weixin.util.Wxs;

import db_beans.DbInMsg;
import db_beans.DbUser;
import tools.MyDao;
@IocBean(name="wxHandler", args={"smartmenu"})
public class WXService extends BasicWxHandler {
	
	@Inject
	MyDao dao;

	public WXService(String token) {
		super(token);
	}
	@Override
	public WxOutMsg handle(WxInMsg in) {
		Map<String, Object> dd;
		dd=Lang.obj2map(in);		
		DbInMsg msg =Lang.map2Object(dd, DbInMsg.class);				 		
		dao.insert(msg);
		return super.handle(in);
	}
	public WxOutMsg text(WxInMsg msg) {
		String msgstr=msg.getContent();
		if ("kt".equals(msg.getContent())){
			
			DbUser ubean = dao.fetch(DbUser.class,Cnd.where("WxID","=",msg.getFromUserName()));
			if(ubean==null){
				return Wxs.respNews(null, new WxArticle("请进行开台操作","欢迎开台","http://yf.ngrok.com/images/kt3.png","http://yf.ngrok.com/userlogin.html"));
			}else{
				return Wxs.respNews(null, new WxArticle("请进行开台操作","欢迎开台","http://yf.ngrok.com/images/kt3.png","http://yf.ngrok.com/kt.html"));
			}		
		}
		if("dl".equals(msgstr)){
			return Wxs.respNews(null, new WxArticle("请进行开台操作","欢迎开台","http://yf.ngrok.com/images/kt3.png","http://yf.ngrok.com/userlogin.html"));
		}
		return defaultMsg(msg);
	}
	public WxOutMsg image(WxInMsg msg) {
		return Wxs.respNews(null, new WxArticle("你好", "zhen d ma ", null, "yf.ngrok.com"));
	}
}
