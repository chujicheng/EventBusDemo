package com.mrj.zy.eventbusdemo;

/**
 * Created by ZY on 2017/4/11.
 */

public class LoginSucceedEvent {

    private String msg;

    public LoginSucceedEvent(String msg) {//确定事件的参数
        this.msg = msg;
    }


    public String getMsg() {//获取事件的内容
        return msg;
    }

    public void setMsg(String msg) {//设置事件的内容
        this.msg = msg;
    }
}
