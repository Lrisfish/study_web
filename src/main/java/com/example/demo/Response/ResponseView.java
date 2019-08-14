package com.example.demo.Response;


import lombok.Data;
import static javax.security.auth.callback.ConfirmationCallback.OK;

//该注解需要lombok插件，可以自动生成get set方法
@Data
public class ResponseView {

    public final static int ERROR_CODE = 1;
    public final static String ERROR_MESSAGE = "服务器异常";

    private int code = OK;
    private String message = "ok";
    private Object result;

    public ResponseView(){
        this.code = OK;
        this.message = "ok";
    }

    public ResponseView(int code, String msg){
        this.code = code;
        this.message = msg;
    }

}
