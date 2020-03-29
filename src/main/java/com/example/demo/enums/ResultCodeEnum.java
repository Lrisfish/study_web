package com.example.demo.enums;

/**
 * @program: venom
 * @description: 结果状态枚举
 * @author: shihuiyong
 * @create: 2019-05-10 14:46
 **/
public enum ResultCodeEnum {
    SUCCESS(0, "成功"),

    PARAM_ERROR(4001, "参数校验失败"),

    SERVER_ERROR(4002, "程序异常"),

    BUSINESS_ERROR(4003, "业务异常"),

    UNAUTHORIZED(4004, "未授权"),

    SESSION_TIMEOUT(4005, "登陆超时"),

    NO_AUTHENTICATION(4006, "未认证");

    private ResultCodeEnum(final int code, final String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 简码
     */
    private int code;

    /**
     * 描述
     */
    private String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultCodeEnum{");
        sb.append("code='").append(code).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
