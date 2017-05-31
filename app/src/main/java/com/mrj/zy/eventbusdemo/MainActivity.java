package com.mrj.zy.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.button3)
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        EventBus.getDefault().register(this);//注册一个订阅者

    }

    @Subscribe//订阅事件
    public void onEventMainThread(LoginSucceedEvent msg) {//收到订阅事件更新界面

        if ("已经注册成功".equals(msg.getMsg())) {
            tv.setText(msg.getMsg());
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//取消订阅
    }

    @OnClick(R.id.button3)
    public void onClick() {//打开登录界面
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}
