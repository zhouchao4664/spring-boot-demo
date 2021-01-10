package com.zhouchao.security.core.exception;

/**
 * 全局错误码
 */

public enum GlobalErrorCode {
    SUCCESS("0", "OK"),

    BAD_REQUEST("400", "Bad Request"),
    UNAUTHORIZED("401", "Unauthorized"),
    FORBIDDEN("403", "Forbidden"),
    NOT_FOUND("404", "Not Found"),
    METHOD_NOT_ALLOWED("405", "Method Not Allowed"),
    SERVER_ERROR("500", "server_error"),
    BAD_CREDENTIALS("406", "bad_credentials"),


    SYSTEM_ERROR("400000", "系统错误"),
    SYSTEM_BUSY("400001", "系统繁忙"),
    HTTP_MASTER_REDIS_ERROR("400016", "主redis操作失败"),
    HTTP_WS_REQUEST_ERROR("400018", "请求ws失败"),
    HTTP_RESP_BODY_NULL("400019", "ws模块响应包体为空"),
    HTTP_CALL_WS_ERROR("400020", "通过ws模块获取信息失败"),
    HTTP_SMS_REQUEST_ERROR("400021", "请求sms失败"),
    HTTP_SEND_THREAD_FULL("400022", "发送线程池已满"),
    HTTP_ASYNC_THREAD_FULL("400023", "异步接收消息线程池已满"),
    HTTP_REPEAT_SUBMIT("400024", "重复提交"),

    /**
     * 账户类错误码
     */
    IP_AUTH_FAIL("401100", "请求IP不在白名单内"),
    ACCOUNT_NOT_EXIST("401101", "用户名不存在"),
    ACCOUNT_DISABLED("401102", "密码错误"),
    ACCOUNT_EMPTY("401103", "账号或者密码不能为空"),
    AUTH_ERROR("401104", "认证失败"),
    ACCESS_DENIED("401105","权限不足"),
    NOT_LOGIN("401106","用户未登录"),


    /**
     * 请求头类错误码
     */
    CONTENT_TYPE_IS_NULL("401200", "HTTP Content-Type为空"),
    CHUNKED_NOT_SUPPORT("401201", "HTTP Chunked 编码不支持"),
    CONTENT_LENGTH_IS_NULL("401202", "HTTP Content-Length为空"),
    AUTHORIZATION_IS_NULL("401203", "请求包头Authorization参数为空"),
    SIG_IS_NULL("401204", "请求地址Sig参数为空"),
    BASE64DECODE_ERROR("401205", "请求包头Authorization参数Base64解码失败"),
    AUTH_DECODE_FORMAT_ERROR("401206", "请求包头Authorization参数解码后格式有误"),
    AUTH_ACCOUNT_IS_NULL("401207", "请求包头Authorization参数解码后账户ID为空白"),
    AUTH_TIMESTAMP_IS_NULL("401208", "请求包头Authorization参数解码后时间戳为空白"),
    AUTH_TIMESTAMP_FORMAT_ERROR("401209", "请求包头Authorization参数中时间戳格式有误，请参考yyyyMMddHHmmss"),
    AUTH_TIME_EXPIRED("401210", "请求包头Authorization参数解码后时间戳过期"),
    AUTH_ACCOUNT_NOT_MATCH("401211", "请求包头Authorization参数中账户ID跟请求地址中的账户ID不一致"),

    /**
     * 数据库错误
     * @param code
     * @param message
     */
    DB_INSERT_ERROR("401300","增加数据失败"),
    DB_DELETE_ERROR("401301","删除数据失败"),
    DB_UPDATE_ERROR("401302","修改数据失败"),
    DB_SELECT_ERROR("401303","查询数据失败"),

    /**
     * 参数类错误码
     */
    PARAM_NOT_IN_LIST("501300", "参数非法"),
    PARAM_VALUE_ERROR("501301", "参数值异常"),
    PARAM_NOT_NULL("501302", "参数不能为空"),
    PARAM_REPETITION("501303", "重复添加"),
    PARAM_VALIDATION("501304", "参数验证异常"),


    /**
     * 通信
     */
    MAIL_SEND_ERROR("601400", "邮件发送失败"),
    MAIL_UPPER_LIMIT("601401", "邮件批量发送达到上限"),

    SMS_UPPER_LIMIT("601402", "短信批量发送达到上限"),
    SMS_PARAM_FORMAT_ERROR("601403", "短信参数格式异常"),


    /**
     * 交易类错误码
     */
    TRADE_CHANNLE_ERROR("701500", "渠道异常"),
    TRADE_BUSS_ERROR("701501", "业务异常"),
    TRADE_CHANNLE_DELAY_ERROR("701502", "需要稍后重新获取结果"),
    TRADE_TRADEID_NOT_EXIT("701503", "交易不存在"),


    /**
     * 用户登陆注册，找回密码的错误码
     *
     * @param code
     * @param message
     */
    USER_NOT_EXIST("10100", "用户不存在"),
    USER_EXIST("10101", "该帐户已存在"),
    EMAIL_EXIST("10102","该邮箱已存在"),
    LOGIN_TYPE_ERROR("10103","登录类型错误"),



    ADD_ERROR("801600","新增失败"),
    REPEAT_ERROR("801601","重复添加"),
    UPDATE_ERROR("801602","修改失败"),
    DELETE_ERROR("801603","删除失败"),
    NOT_ERROR("801604","不存在"),
    GET_ERROR("801605","获取失败"),


    ASSIGNEE_ERROR("801700","区域经理或者行业负责人不存在！"),


    INVALID_TRIAL_ERROR("801800","非法的试用状态");

    ;


    GlobalErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private final String code;
    private final String message;


    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
