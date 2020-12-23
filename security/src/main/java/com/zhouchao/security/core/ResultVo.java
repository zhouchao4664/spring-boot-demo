package com.zhouchao.security.core;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

@Data
@Slf4j
public class ResultVo<T> {

    private static final String SUCCESS_CODE = "0";
    private static final String SUCCESS_MSG = "success";

    private static final String ERROR_CODE = "40000";
    private static final String ERROR_MSG = "error";


    /**
     * code=0，代表成功
     */
    private String code;

    /**
     * 描述信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    // private String traceId = MDC.get("traceId");

    public ResultVo(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVo() {
    }

    /**
     * 成功
     *
     * @return
     */
    public static <T> ResultVo<T> success() {
        return handleRs(SUCCESS_CODE, SUCCESS_MSG, null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static <T> ResultVo<T> success(T data) {
        return handleRs(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    /**
     * 成功
     *
     * @param msg
     * @param data
     * @return
     */
    public static <T> ResultVo<T> success(String msg, T data) {
        return handleRs(SUCCESS_CODE, msg, data);
    }

    /**
     * 失败
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static <T> ResultVo<T> failure(String code, String msg, T data) {
        return handleRs(code, msg, data);
    }


    private static <T> ResultVo<T> handleRs(String code, String msg, T data) {
        return new ResultVo(code, msg, data);
    }


    /**
     * 调用远程接口异常时固定格式
     *
     * @param tClass
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> T remoteErrorRs(Class<T> tClass, String code, String msg, Object data) {
        try {
            Constructor<T> constructor = tClass.getConstructor(code.getClass(), msg.getClass(), Object.class);
            return constructor.newInstance(code, msg, data);
        } catch (Exception e) {
            log.error("调用远程接口异常", e);
        }
        return null;
    }

}
