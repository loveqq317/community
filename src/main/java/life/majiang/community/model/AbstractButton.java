package life.majiang.community.model;

import lombok.Data;
import org.springframework.scheduling.support.SimpleTriggerContext;

/**
 * @ClassName AbstractButton
 * @Description TODO
 * @Author Q
 * @Date 2020/3/25 1:05 下午
 * @Version 1.0
 **/
@Data
public abstract class AbstractButton {
    private String name;

    public AbstractButton(String name) {
        this.name = name;
    }
}
