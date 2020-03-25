package life.majiang.community.wx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

/**
 * 回复文本消息
 * 
 * @author wulongwei
 * @date 2018年7月30日
 */
@XStreamAlias("xml")
public class TextMessageRequest extends BaseMessage {
	
	/**
	 * 文本消息内容
	 */
	@XStreamAlias("Content")
	private String content;


	public TextMessageRequest(Map<String, String> requestMap, String content) {
		super(requestMap);
		this.setMsgType("text");
		this.content=content;
	}
}
