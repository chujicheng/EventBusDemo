package com.mrj.zy.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RegistActivity extends AppCompatActivity {


    @BindView(R.id.button2)
    Button button2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button2)
    public void onClick() {//发布事件
        EventBus.getDefault().post(new LoginSucceedEvent("已经注册成功"));
        finish();
    }


}
