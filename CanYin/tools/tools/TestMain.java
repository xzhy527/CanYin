package tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TestMain {
	public static String gen_SaleID(){
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		df.format(new Date());
		Random r = new Random();
		return df.format(new Date())+String.valueOf(r.nextInt(9))+String.valueOf(r.nextInt(9))+String.valueOf(r.nextInt(9));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gen_SaleID());
	}

}
