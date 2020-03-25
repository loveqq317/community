package life.majiang.community.wx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

/**
 * 语音消息
 * @author wulongwei
 * @date 2018年7月30日
 */
@XStreamAlias("xml") 
public class VoiceMessageRequest extends BaseMessage{
	@XStreamAlias("Voice") 
	private Voice voice;

	public VoiceMessageRequest(Map<String, String> requestMap, Voice voice) {
		super(requestMap);
		this.setMsgType("voice");
		this.voice = voice;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	
	
	

}
