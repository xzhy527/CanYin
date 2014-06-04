package modules;

import java.util.Date;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.ioc.provider.ComboIocProvider;
import tools.MyDao;
@Modules(scanPackage=true)

//@SetupBy(value=modules.NutzSetup.class)

@IocBy(type=ComboIocProvider.class,args={	
"*org.nutz.ioc.loader.json.JsonLoader","/dao.js",
"*org.nutz.ioc.loader.annotation.AnnotationIocLoader","modules",
})

@IocBean
public class MainModules {	
	@Inject
	MyDao dao;
@At("test")
@Ok("json")
	public Object test_url(String paramstr){	 
		Date _t = null;
		if(Strings.isBlank(paramstr)){
			_t=new Date();
			paramstr=_t.toString();
		}
		return paramstr+1;
	}
	public Object getnow(){
		return new Date();
	}
}
