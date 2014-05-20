package debeans;

import org.nutz.mvc.View;
import org.nutz.mvc.view.UTF8JsonView;
import org.nutz.mvc.view.ViewWrapper;

public class AjaxJSON {
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNavTabId() {
		return navTabId;
	}
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getCallbackType() {
		return callbackType;
	}
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}
	public String getForwardUrl() {
		return forwardUrl;
	}
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}
	private String statusCode="200";
	private String message="操作成功";
	private String navTabId;
	private String rel;
	private String callbackType="closeCurrent";
	private String forwardUrl;
	
	
	public AjaxJSON(String message,String forwardUrl){
		this.message=message;
		this.forwardUrl=forwardUrl;
		
	}
	public AjaxJSON(String message){
		this.message=message;
		
	}
	public AjaxJSON(String meString,int status){
		
		this.message=meString;
		this.statusCode=String.valueOf(status);
	}
	public AjaxJSON(String mString,boolean isclose){
		this.message=mString;
		this.callbackType=isclose?"closeCurrent":"";
		
	}
	public static ViewWrapper AjaxJSON(String t_message,String t_url){	
		return new ViewWrapper(new UTF8JsonView(null), new AjaxJSON(t_message,t_url));
	}

	

}
