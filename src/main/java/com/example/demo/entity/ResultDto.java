package com.example.demo.entity;


import com.example.demo.enums.ResultCodeEnum;

import java.io.Serializable;


public class ResultDto<T> implements Serializable {
    /**
     * 状态
     */
    private int code;

    /**
     * 提示
     */
    private String message;

    /**
     * 结果
     */
    private T data;

    /**
     * 错误信息
     */
    private String errors;

    public ResultDto() {
        this(ResultCodeEnum.SUCCESS);
    }

    public ResultDto(ResultCodeEnum code) {
        this.code = code.getCode();
        this.message = code.getDescription();
    }

    public ResultDto(final ResultCodeEnum resultCodeEnum, final T data) {
        this(resultCodeEnum);
        this.data = data;
    }

    public ResultDto(final ResultCodeEnum resultCodeEnum, final String message,
                     final T data) {
        this.code = resultCodeEnum.getCode();
        this.message = message;
        this.data = data;
    }

    public ResultDto<T> resultCode(final ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        return this;
    }

    public ResultDto<T> message(final String message) {
        this.message = message;
        return this;
    }

    public ResultDto<T> result(final T result) {
        this.data = result;
        return this;
    }

    public ResultDto<T> errors(final String errors) {
        this.errors = errors;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", errors=" + errors +
                '}';
    }
}
