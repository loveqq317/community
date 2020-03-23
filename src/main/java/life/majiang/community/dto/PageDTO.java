package life.majiang.community.dto;

import com.sun.javaws.IconUtil;
import life.majiang.community.model.Question;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PageDTO
 * @Description TODO
 * @Author Q
 * @Date 2020/3/22 4:55 下午
 * @Version 1.0
 **/
@Data
public class PageDTO {
    private List<QuestionDTO> list;
    private boolean showPrevious;//是否显示 跳转到上一页按钮<
    private boolean showFirstPage;//是否显示  跳转到首页按钮<<
    private boolean showNext;//是否显示 跳转到下一页按钮>
    private boolean showEndPage; //是否显示 跳转到末页按钮 >>
    private Integer page;//当前所选择的页数
    private List<Integer> pages=new ArrayList<>();//显示页数列表  <1 2 3 4 5> >>
    private Integer totalPage;//总页数
    /**
     * @Author juyahong
     * @Description //TODO
     * @Date 5:20 下午 2020/3/22
     * @Param [totalCount:总页数, page：当前页, size：每页多少条数据]
     * @return void
     **/
    public void setPagination(Integer totalCount,Integer page,Integer size){


        //Integer totalPage=0;//总页数
        if (totalCount % size == 0){
            totalPage=totalCount / size;
        }else{
            totalPage=totalCount / size +1;
        }
        if (page < 1){
            page=1;
        }
        if (page > totalPage){
            page=totalPage;
        }
        this.page=page;
        //是否展示跳转到上一页按钮 <  如果选第一页，就不显示
        if (page == 1){
            showPrevious=false;
        }else{
            showPrevious=true;
        }
        //是否展示跳转到下一页按钮 <  如果是最后一页，就不显示
        if (page == totalPage){
            showNext=false;
        }else{
            showNext=true;
        }

        pages.add(page);//先把当前页加入到pages里
        for(int i=1;i<=3;i++){
            if (page-i>0){
                pages.add(0,page-i);//往前面加
            }
            if (page + i <= totalPage){
                pages.add(page+i);//往后面加
            }
        }
        //是否展示第一页
        if(pages.contains(1)){
            showFirstPage=false;
        }else{
            showFirstPage=true;
        }
        //是否展示最后一页
        if (pages.contains(totalPage)){
            showEndPage=false;
        }else{
            showEndPage=true;
        }
    }

    public static void main(String[] args) {
        int numberA = 8;
        int numberB= 2;
//将结果转换为float
        float numberC = numberA - numberB;
//可以取到小数点后的正确数值，如果两个都是整形，那小数点后面就会清零
        float number = numberC / 5;
        int renewNum = (int)Math.ceil(number);
        System.out.println(number);
        System.out.println(renewNum);
    }

}
