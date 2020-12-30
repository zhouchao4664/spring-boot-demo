package com.zhouchao.security.core.exception;

public class AuthException extends IllegalArgumentException {

    /**
     * serialVersionUID:TODO(用一句话描述这个变量表示什么).
     * @since JDK 1.8
     */
    private static final long serialVersionUID = 521707773001584847L;
    private GlobalErrorCode errorCode;

    public AuthException(GlobalErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public AuthException(GlobalErrorCode errorCode, String msg){
        super(msg);
        this.errorCode = errorCode;
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
