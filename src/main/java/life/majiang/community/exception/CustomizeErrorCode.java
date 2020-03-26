package life.majiang.community.exception;

public enum CustomizeErrorCode implements  ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"你找的问题不在了，要不要换个试试？"),
    TARGET_PARM_NOT_FOUND(2002,"未选中任何问题或评论进行回复！"),
    NO_LOGIN(2003,"未登录不能进行评论，请先登录"),
    SYS_ERROR(2004,"系统错误！"),
    TYPE_PARM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_EXIST(2006,"你回复的评论已不存在，评论别的试试");





    private Integer code;
    private String message;
    CustomizeErrorCode(Integer code,String message) {
        this.code=code;
        this. message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
