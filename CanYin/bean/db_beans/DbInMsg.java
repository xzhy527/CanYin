package db_beans;

import java.sql.Date;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.weixin.bean.WxInMsg;


@Table("db_WxInMsg")
public class DbInMsg extends WxInMsg implements Cloneable{	
	private Date intime;	
	private String adminmanage;
	private String reserve;
	
	public DbInMsg(){
		
	}
	
	public DbInMsg(WxInMsg inmsg){
		intime=new Date(this.getCreateTime());
		super.setContent(inmsg.getContent());
		super.setCreateTime(inmsg.getCreateTime());
		super.setDescription(inmsg.getDescription());
		super.setEvent(inmsg.getEvent());
		super.setEventKey(inmsg.getEventKey());
		super.setFormat(inmsg.getFormat());
		super.setFromUserName(inmsg.getFromUserName());
		super.setLabel(inmsg.getLabel());
		super.setLocation_X(inmsg.getLocation_X());
		super.setLocation_Y(inmsg.getLocation_Y());
		super.setMediaId(inmsg.getMediaId());
		super.setMsgId(inmsg.getMsgId());
		super.setMsgType(inmsg.getMsgType());
		super.setPicUrl(inmsg.getPicUrl());
		super.setScale(inmsg.getScale());
		super.setThumbMediaId(inmsg.getThumbMediaId());
		super.setTitle(inmsg.getTitle());
		super.setToUserName(inmsg.getToUserName());
		super.setUrl(inmsg.getUrl());
		
	}
	public Date getIntime() {
		return intime;
	}
	public void setIntime(Date intime) {
		this.intime = intime;
	}
	public String getAdminmanage() {
		return adminmanage;
	}
	public void setAdminmanage(String adminmanage) {
		this.adminmanage = adminmanage;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
}
