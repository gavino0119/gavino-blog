package lut.software.gavinoblog.common.utils;

import java.io.Serializable;

/**
 * @author ywg
 * @version 1.0
 * @description 用于封装给用户的返回结果
 * @date 2020/3/7 16:28
 */
public class ResultResponse <T> implements Serializable {

    private static final String CODE_SUCCESS = "success";
    private static final String CODE_FAIL = "fail";

    private String code;
    private T data;
    private String msg;

    public ResultResponse() {

    }

    public ResultResponse(String code) {
        this.code = code;
    }

    public ResultResponse(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResultResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultResponse success() {
        return new ResultResponse(CODE_SUCCESS);
    }

    public static ResultResponse success(Object data) {
        return new ResultResponse(CODE_SUCCESS, data);
    }

    public static ResultResponse fail(String msg) {
        return new ResultResponse(CODE_FAIL,msg);
    }

    public static ResultResponse widthCode(String errorCode) {
        return new ResultResponse(errorCode);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
