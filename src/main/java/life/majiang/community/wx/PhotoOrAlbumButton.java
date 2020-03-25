package life.majiang.community.wx;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PhotoOrAlbumButton
 * @Description TODO
 * @Author Q
 * @Date 2020/3/25 1:34 下午
 * @Version 1.0
 **/
@Data
public class PhotoOrAlbumButton extends AbstractButton {
    private String type="pic_photo_or_album";
    private String key;
    private List<AbstractButton> sub_button=new ArrayList<>();

    public PhotoOrAlbumButton(String name, String key) {
       super(name);
        this.key = key;
    }
}
