package life.majiang.community.wx;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * 公共属性类
 * 
 * @author Q
 * @date 2020-03-24 18:56:22
 */

public class BaseMessage {
	
	/** 开发者微信号 */
	@XStreamAlias("ToUserName")
	private String toUserName; 
	
	/** 发送方帐号（一个OpenID） */
	@XStreamAlias("FromUserName")
	private String fromUserName; 
	
	/** 消息创建时间 （整型） */
	@XStreamAlias("CreateTime")
	private Long createTime; 
	
	/** 消息类型 */
	@XStreamAlias("MsgType")
	private String msgType;

	public BaseMessage(Map<String, String> requestMap){
		this.fromUserName=requestMap.get("ToUserName");
		this.toUserName=requestMap.get("FromUserName");
		this.createTime=System.currentTimeMillis()/1000;
	}
	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}


}
