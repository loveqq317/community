package life.majiang.community.model;

/**
 * @ClassName ViewButton
 * @Description TODO
 * @Author Q
 * @Date 2020/3/25 1:12 下午
 * @Version 1.0
 **/
public class ViewButton extends AbstractButton{
    private String type="view";
    private String url;

    public ViewButton(String name,String url) {
        super(name);
        this.url = url;
    }
}
