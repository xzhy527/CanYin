package modules.usermodules;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import tools.MyDao;
import tools.MyLong;
@IocBean
public class CommonMoudlues{
	@Inject
	MyDao dao;
	
@At()
@Ok("json")
public Object caiconng(){
	
	System.out.println(new Date());
	return null;
}
	
	
@At()
@Ok("json")
public List getwaiters(Integer GroupID,String UserType){	
	Map map=new HashMap();
	map.put("GroupID", GroupID);
	map.put("UserType", UserType);
	String sqltextString=MyLong.sqltext(map);
	if(sqltextString!=null){
		sqltextString=" where "+sqltextString;
	}	
	return dao.query("select ShowName from db_user "+sqltextString);
}
@At()
@Ok("json")
public Object getwaiters(String GroupName,String UserType){
	Integer groupid=null;
	if(!Strings.isBlank(GroupName)){		
		char[] chars=GroupName.toCharArray();
		boolean isnuumber=true;
		for (char c : chars) {
			if(Character.getType(c) == Character.OTHER_LETTER){
				isnuumber=false;
				break;
			}
			if(Character.isLetter(c)){
				isnuumber=false;
				break;
			}	
		}
		if(isnuumber){
			return getwaiters(Integer.valueOf(GroupName),UserType);
		}
		String ddObject=(String) dao.getConfig("员工分组", null, null, GroupName, "intvalue");	
		groupid=Integer.valueOf(ddObject);
		return getwaiters(groupid,UserType);
	}else{		
		getwaiters(groupid,UserType);
	}
	return null;
}
	
	
	
	
	
	
}
