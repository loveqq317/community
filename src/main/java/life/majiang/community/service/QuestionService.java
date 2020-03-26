package life.majiang.community.service;

import life.majiang.community.dto.PageDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.exception.CustomizeErrorCode;import life.majiang.community.exception.CustomizeException;
import life.majiang.community.mapper.QuestionExpMapper;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.QuestionExample;
import life.majiang.community.model.User;
import org.apache.ibatis.session.RowBounds;
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
    @Autowired
    private QuestionExpMapper questionExpMapper;
    public PageDTO list(Integer page, Integer size){
        PageDTO pageDTO=new PageDTO();
        Integer totalPage;
        Integer totalCount=(int)questionMapper.countByExample(new QuestionExample());//数据总条数
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
        List<Question> questions=questionMapper.selectByExampleWithRowbounds(new QuestionExample(),new RowBounds(offset,size));
        List<QuestionDTO> list = new ArrayList<>();
        for(Question question:questions){
            User user=userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            list.add(questionDTO);
        }
        pageDTO.setList(list);

        return pageDTO;
    }
    public PageDTO list(Long id, Integer page, Integer size){
        PageDTO pageDTO=new PageDTO();
        Integer totalPage;
        QuestionExample example=new QuestionExample();
        example.createCriteria().andCreatorEqualTo(id);
        Integer totalCount=(int)questionMapper.countByExample(example);//数据总条数
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
        List<Question> questions=questionMapper.selectByExampleWithRowbounds(example,new RowBounds(offset,size));
        List<QuestionDTO> list = new ArrayList<>();
        for(Question question:questions){
            User user=userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            list.add(questionDTO);
        }
        pageDTO.setList(list);

        return pageDTO;
    }

    public QuestionDTO getById(Long id) {
       Question question= questionMapper.selectByPrimaryKey(id);
       if (question == null){
           throw  new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
       }
       User user=userMapper.selectByPrimaryKey(question.getCreator());
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
           // question.setGmtModified(question.getGmtCreate());
            Question updateQuestion= new Question();
            updateQuestion.setGmtModified(question.getGmtCreate());
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTag(question.getTag());
            QuestionExample example=new QuestionExample();
            example.createCriteria().andIdEqualTo(question.getId());
            int updatedState=questionMapper.updateByExampleSelective(updateQuestion,example);
            if (updatedState != 1){
                throw  new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
        }


    }

    public void incView(Long id) {
        Question record = new Question();
        record.setViewCount(1);
        record.setId(id);
        questionExpMapper.incView(record);
    }
}
