package life.majiang.community.wx;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubButton
 * @Description TODO
 * @Author Q
 * @Date 2020/3/25 1:15 下午
 * @Version 1.0
 **/
@Data
public class SubButton extends  AbstractButton {
    private List<AbstractButton> sub_button=new ArrayList<>();

    public SubButton(String name) {
        super(name);
    }
}
