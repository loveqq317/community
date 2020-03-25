package life.majiang.community.model;

import lombok.Data;

/**
 * @ClassName ClickButton
 * @Description TODO
 * @Author Q
 * @Date 2020/3/25 1:08 下午
 * @Version 1.0
 **/
@Data
public class ClickButton extends  AbstractButton{
    private String type="click";
    private String key;

    public ClickButton(String name, String key) {
        super(name);
        this.key = key;
    }
}
