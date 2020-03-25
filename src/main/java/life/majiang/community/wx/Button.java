package life.majiang.community.wx;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Button
 * @Description TODO
 * @Author Q
 * @Date 2020/3/25 1:04 下午
 * @Version 1.0
 **/
@Data
public class Button {
    private List<AbstractButton> button =new ArrayList<>();
}
