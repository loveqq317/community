package life.majiang.community.service;

import life.majiang.community.dto.PageDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName QuestionService
 * @Description 问题 服务
 * @Author Q
 * @Date 2020/3/22 1:59 下午
 * @Version 1.0
 **/
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    public PageDTO list(Integer page, Integer size){
        PageDTO pageDTO=new PageDTO();
        Integer totalPage;
        Integer totalCount=questionMapper.count();//数据总条数
        if (totalCount % size == 0){
            totalPage=totalCount / size;
        }else{
            totalPage=totalCount / size +1;
        }
        if (page < 1){
            page=1;
        }
        if (page > totalPage) {
            page =totalPage;
        }
        pageDTO.setPagination(totalPage,page);//分页专属数据赋值

        //size * (page-1)
        Integer offset=size*(page-1);
        List<Question> questions=questionMapper.list(offset,size);
        List<QuestionDTO> list = new ArrayList<>();
        for(Question question:questions){
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            list.add(questionDTO);
        }
        pageDTO.setList(list);

        return pageDTO;
    }
    public PageDTO list(Integer id,Integer page,Integer size){
        PageDTO pageDTO=new PageDTO();
        Integer totalPage;
        Integer totalCount=questionMapper.countByUserId(id);//数据总条数
        if (totalCount % size == 0){
            totalPage=totalCount / size;
        }else{
            totalPage=totalCount / size +1;
        }
        if (page < 1){
            page=1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        pageDTO.setPagination(totalPage,page);//分页专属数据赋值

        //size * (page-1)
        Integer offset=size*(page-1);
        List<Question> questions=questionMapper.listByUserId(id,offset,size);
        List<QuestionDTO> list = new ArrayList<>();
        for(Question question:questions){
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            list.add(questionDTO);
        }
        pageDTO.setList(list);

        return pageDTO;
    }

    public QuestionDTO getById(Integer id) {
       Question question= questionMapper.getById(id);
       User user=userMapper.findById(question.getCreator());
       QuestionDTO questionDTO=new QuestionDTO();
       questionDTO.setUser(user);
       BeanUtils.copyProperties(question,questionDTO);
       return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if (question.getId() == null) {
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
           questionMapper.insert(question);
        }else{
            //更新
            question.setGmtModified(question.getGmtCreate());
            questionMapper.update(question);
        }


    }
}
