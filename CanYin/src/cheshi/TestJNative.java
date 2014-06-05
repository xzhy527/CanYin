package cheshi;

import java.io.UnsupportedEncodingException;
import org.xvolks.jnative.exceptions.NativeException;
import org.xvolks.jnative.misc.basicStructures.HWND;
import org.xvolks.jnative.util.User32;
public class TestJNative extends User32{	
//	public void GetActiveWindow() throws NativeException, IllegalAccessException{
//		JNative GetActiveWindow=new JNative(DLL_NAME, "GetActiveWindow");
//		GetActiveWindow.setRetVal(Type.INT);
//		
//		
//	}
//	
	
	public static void main(String[] args) throws NativeException, IllegalAccessException, InterruptedException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		//JNative jnative=new JNative("", )
		for(int i=0;i<100;i++){
			HWND hwnd=new HWND(67570);
			String text = new String(GetWindowText(hwnd).getBytes("utf-8"));
			System.out.println(text);
			Thread.sleep(1000);
		}
		System.out.println("这是成功的标识");
	} 

}
