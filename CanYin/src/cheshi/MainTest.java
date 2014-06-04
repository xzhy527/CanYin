package cheshi;

import java.io.IOException;

import org.nutz.lang.Lang;

import websocket4j.server.WebServerSocket;
import websocket4j.server.WebSocket;

public class MainTest extends Thread{
	private WebSocket ws;
	
	public MainTest(WebSocket ws){
		this.ws=ws;
	}
	private void handleConnection(){
		try{
			while(true){
				String message=ws.getMessage();
				ws.sendMessage(message);
				System.out.println("Received:"+message);
				if(message.equals("exit")){
					break;
				}
			}
			
		}catch(IOException e){}
		finally{
			try{
				ws.close();
			}catch(IOException e){}
		}
	}
	@Override
	public void run() {
		handleConnection();
	}
	

	public static void sh1_test(){
		System.out.println(Lang.sha1("12345678"));
	}
	public static void main(String[] args) throws IOException {
		System.out.println("starting.......");
		WebServerSocket socket = new WebServerSocket(6666);		
		try {
			while(true){
				WebSocket ws=socket.accept();
				System.out.println("Get"+ws.getRequestUri());
				if(ws.getRequestUri().equals("/echo")){
					(new MainTest(ws)).start();
				}else{
					System.out.println("Unsupported Request-URI");
					try {
						ws.close();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("申请websocketserver失败");
		}
		finally{
			socket.close();
		}
		
	}

}
