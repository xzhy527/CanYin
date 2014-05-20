package tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class MyLong {
	public static String gen_SaleID(){
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		df.format(new Date());
		Random r = new Random();
		return df.format(new Date())+String.valueOf(r.nextInt(9))+String.valueOf(r.nextInt(9))+String.valueOf(r.nextInt(9));
	}
	
	
}
