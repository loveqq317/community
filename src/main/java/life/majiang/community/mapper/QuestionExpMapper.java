package life.majiang.community.mapper;

import com.github.pagehelper.ISelect;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionExpMapper {
    int incView(@Param("record") Question record);
    int incCommentCount(@Param("record") Question record);
    List<Question> selectRelated(@Param("record") Question record);
}