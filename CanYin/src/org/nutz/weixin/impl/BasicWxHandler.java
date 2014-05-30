package org.nutz.weixin.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.nutz.weixin.bean.WxInMsg;
import org.nutz.weixin.bean.WxOutMsg;
import org.nutz.weixin.spi.WxHandler;
import org.nutz.weixin.util.Wxs;

public class BasicWxHandler implements WxHandler {
	
	protected String token;
	
	public BasicWxHandler(String token) {
		this.token = token;
	}

	public boolean check(String signature, String timestamp, String nonce) {
		return Wxs.check(token, signature, timestamp, nonce);
	}

	public WxOutMsg text(WxInMsg msg) {
		return defaultMsg(msg);
	}

	public WxOutMsg image(WxInMsg msg) {
		return defaultMsg(msg);
	}

	public WxOutMsg voice(WxInMsg msg) {
		return defaultMsg(msg);
	}

	public WxOutMsg video(WxInMsg msg) {
		return defaultMsg(msg);
	}

	public WxOutMsg location(WxInMsg msg) {
		return defaultMsg(msg);
	}

	public WxOutMsg link(WxInMsg msg) {
		return defaultMsg(msg);
	}

	public WxOutMsg eventSubscribe(WxInMsg msg) {
		return defaultMsg(msg);
	}

	public WxOutMsg eventScan(WxInMsg msg) {
		return defaultMsg(msg);
	}

	public WxOutMsg eventLocation(WxInMsg msg) {
		return defaultMsg(msg);
	}

	public WxOutMsg eventClick(WxInMsg msg) {
		return defaultMsg(msg);
	}

	public WxOutMsg eventView(WxInMsg msg) {
		return defaultMsg(msg);
	}

	public WxOutMsg defaultMsg(WxInMsg msg) {
		String datastr = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date());
		return Wxs.respText(null, "驿枫: 我已经收到您的信息\n匹配失败,机器人Stoped\n时间:" + datastr+"\n");
	}
	
	public WxOutMsg handle(WxInMsg in) {
		return Wxs.handle(in, this);
	}
}
