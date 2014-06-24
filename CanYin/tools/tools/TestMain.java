package tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sun.org.apache.bcel.internal.generic.NEW;

import db_beans.DbUser;

public class TestMain {
	public static String gen_SaleID(){
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		df.format(new Date());
		Random r = new Random();
		return df.format(new Date())+String.valueOf(r.nextInt(9))+String.valueOf(r.nextInt(9))+String.valueOf(r.nextInt(9));
	}
	
	public static void main(String[] args) {		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("name:like:or", "zhangsan");
		map.put("age:<:or", 89);
		map.put("uu:or", 44);
		map.put("likes::or",new String[]{"token","timestamp","nonce"});
		String ssString=MyLong.sqltext(map);
		System.out.println(ssString);	
	}

}

