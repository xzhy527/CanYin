package tools;

import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.junit.Test;
import org.nutz.lang.Strings;

import com.alibaba.druid.sql.visitor.functions.Left;

public class MyLong {
	public static String gen_SaleID(){
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		df.format(new Date());
		Random r = new Random();
		return df.format(new Date())+String.valueOf(r.nextInt(9))+String.valueOf(r.nextInt(9))+String.valueOf(r.nextInt(9));
	}
	public static String leftsub(String str,int len){
		str=str.substring(0, len);
    	return str;		
	}
	public static String leftless(String str,int len){
		str=str.substring(0, str.length()-len);
		return str;		
	}
	
	public static String sqltext(String oldsqltext,String sqlstr,String colmname,String sign){
		if(Strings.isBlank(sqlstr)){			
			oldsqltext+=colmname+sign+sqlstr;
		}		
		return oldsqltext;
	}	
	public static String sqltext(Map map){		
		String re_sqltextString="";		
        Set setMap = map.entrySet();       
        Iterator myItSet = setMap.iterator(); 
        while(myItSet.hasNext())
        {
            Entry entry = (Entry) myItSet.next();
            String key    = (String) entry.getKey();          
             Object value = entry.getValue();  
             if(value==null){
            	 continue;
             }
             if(key==null){
            	 continue;
             }
             String[] cols =key.split(":");              
             String cstr=cols[0];             
             String signstr=cols.length>1&&cols[1]!=null&&cols[1].length()>0?cols[1]:"=";
             String andor=cols.length>2&&cols[2]!=null&&cols[2].length()>0?cols[2]:"and";            
             if(value instanceof String){           	 
            	 re_sqltextString+=cstr+" "+signstr+" '"+value+"' "+andor+" ";
             }
             if(value instanceof Integer || value instanceof Float  || value instanceof Double){            	             	 
            	 re_sqltextString+=cstr + " "+signstr+" "+value+" "+andor+" ";          	 
             }
             if(value instanceof String[]){            	 
            	 re_sqltextString+=cstr +" in (";            	 
            	 for (String str : (String[])value) {           		 
            		 re_sqltextString+="'"+str+"',";
            	 }
            	 re_sqltextString=MyLong.leftless(re_sqltextString, 1)+") and ";            	   
             }
             if(value instanceof List){
            	 //System.out.println("List");  
             }
      
             
             
//            System.out.println("key:"+key+",value:"+value);
          
        }
       if( re_sqltextString.endsWith("and ")){
        	return MyLong.leftless(re_sqltextString, 5);
        }
        	
       if( re_sqltextString.endsWith("or ")){
    	   return MyLong.leftless(re_sqltextString, 4);
       }
       return re_sqltextString;
		  

	  }
	
}
