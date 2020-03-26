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

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }
    public CustomizeException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }}
