package com.siro.http;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mshcc
 */
@Data
@ApiModel(value = "com.siro.http.HttpResult" ,description = "通用接口返回对象")
public class HttpResult implements Serializable {
    @ApiModelProperty(required = true,notes = "状态码",example = "200")
    private int code=200;
    @ApiModelProperty(required = true,notes = "返回信息",example = "success")
    private String msg;
    @ApiModelProperty(required = true,notes = "返回数据",example = "{\"name\" : \"张三\"}")
    private Object data;
    public static HttpResult error(){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }
    public static HttpResult error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static HttpResult error(int code, String msg) {
        HttpResult r = new HttpResult();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(String msg) {
        HttpResult r = new HttpResult();
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(Object data) {
        HttpResult r = new HttpResult();
        r.setData(data);
        return r;
    }
    public static HttpResult ok(String message,Object data) {
        HttpResult r = new HttpResult();
        r.setMsg(message);
        r.setData(data);
        return r;
    }

    public static HttpResult ok() {
        return new HttpResult();
    }

}
