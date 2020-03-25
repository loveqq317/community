package life.majiang.community.wx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;

/**
 * 图片消息
 * <p>Title:ReplyImage</p>
 * @author Q
 * @date 2020-03-24 18:56:44
 */
@XStreamAlias("xml") 
public class ImageMessageRequest extends BaseMessage{

	@XStreamAlias("Image")
	private Image image;
	public ImageMessageRequest(Map<String, String> requestMap, Image image) {
		super(requestMap);
		this.setMsgType("image");
		this.image=image;
	}
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public static class Image{
		
	
	/**通过素材管理中的接口上传多媒体文件，得到的id。*/
	@XStreamAlias("MediaId")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	}
	

}
