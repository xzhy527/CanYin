package modules.usermodules;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.POST;
import org.nutz.weixin.mvc.WxAbstractModule;
import org.nutz.weixin.util.Wxs;
import org.xml.sax.SAXException;
@IocBean(fields="wxHandler")
public class WeiXinModules extends WxAbstractModule{
	Logger logger = Logger.getLogger(WeiXinModules.class);
	
	public WeiXinModules(){
		//Wxs.enableDevMode();
	}	
	
@At()
@Ok("raw")
	public Object wxservice(String signature,String timestamp,String nonce,String echostr,String FromUserName) throws IOException, SAXException, ParserConfigurationException{		
			
			logger.info("Method:"+Mvcs.getReq().getMethod());
			logger.info("echostr:"+echostr);
			logger.info("echostr:"+signature);
			logger.info("FromUserName"+FromUserName);
			//Document dd = Xmls.xmls().parse((Mvcs.getReq()).getInputStream());		
			//Document xx = Xmls.xml((Mvcs.getReq()).getInputStream());			
			//logger.info(dd);
			return echostr;
	}
@At()
@Ok("raw")	
	public Object wx_adService(){
		return "这是最新推荐";
	}
@At()
@Ok("raw")
	public Object wx_dishesService(){
		return "这是餐饮服务";
	}
@At()
@Ok("raw")
	public Object wx_memberService(){
		
		return "这是会员中心";
	}

@POST()
	public Object wxtest(){
	return null;
}


}
