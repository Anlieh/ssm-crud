package com.crud.bean;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

public class Msg {

    // 状态码 200-成功 444-失败
    private int code;

    // 提示信息
    private String msg;

    // 服务器返回给客户端的数据
    private Map<String, Object> extend = new HashMap<>();

    public Msg() {

    }

    public static Msg success() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("处理成功");
        return result;
    }

    public static Msg failure() {
        Msg result = new Msg();
        result.setCode(444);
        result.setMsg("处理失败");
        return result;
    }

    public Msg add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }


}
