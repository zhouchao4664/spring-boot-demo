package com.zhouchao.security.core.exception;

/**
 * Authorization 异常
 */
public class HttpException extends IllegalArgumentException {

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.8
     */
    private static final long serialVersionUID = 521707773001584847L;
    private GlobalErrorCode errorCode;

    public HttpException(GlobalErrorCode errorCode){
        super(formatMsg(errorCode));
        this.errorCode = errorCode;
    }

    public HttpException(GlobalErrorCode errorCode, String msg){
        super(msg);
        this.errorCode = errorCode;
    }


    private static String formatMsg(GlobalErrorCode errorCode) {
        return String.format("%s:%s", errorCode.getCode(), errorCode.getMessage());
    }

    public GlobalErrorCode getErrorCode(){
        return errorCode;
    }

    public String code(){
        return errorCode.getCode();
    }

    public String message(){
        return errorCode.getMessage();
    }
}
