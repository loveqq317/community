package life.majiang.community.exception;

/**
 * @ClassName CustomizeException
 * @Description TODO
 * @Author Q
 * @Date 2020/3/26 3:43 下午
 * @Version 1.0
 **/

public class CustomizeException extends  RuntimeException {
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code=errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode(){return code;}

}

