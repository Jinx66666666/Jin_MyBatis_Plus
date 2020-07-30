package com.jin.sys.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @Description: Result
 * @author: HuangJing
 * @create: 2020-07-30 11:54
 * @version: V1.0
 */
@Data
public class Result<T> implements Serializable {

    private boolean success;

    private int code;

    private String msg;

    private T data;

    private Result() {
    }

    public Result(boolean success, String msg, T data) {
        this(success, 0, msg, data);
    }

    public Result(boolean success, int code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <R> Result<R> ok(String msg, R data) {
        return new Result<>(true, msg == null ? "操作成功" : msg, data);
    }

    public static <R> Result<R> ok(String msg) {
        return new Result<>(true, msg, null);
    }

    public static <R> Result<R> ok() {
        return Result.ok("操作成功", null);
    }

    public static <R> Result<R> error(HttpStatus httpStatus, String message, R data) {
        return new Result<>(false, httpStatus.value(), StringUtils.defaultString(message, "操作失败"), data);
    }
    public static <R> Result<R> error(int code, String msg, R data) {
        return new Result<>(false, code, msg == null ? "操作失败" : msg, data);
    }

    public static <R> Result<R> error(String msg, R data) {
        return Result.error( msg, data);
    }

    public static <R> Result<R> error(String msg) {
        return Result.error(msg, null);
    }

    public static <R> Result<R> error() {
        return Result.error("操作失败");
    }


}
