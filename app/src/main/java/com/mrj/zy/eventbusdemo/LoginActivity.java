package com.mrj.zy.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);//注册一个订阅者

    }

    @Subscribe          //订阅事件FirstEvent
    public  void onEventMainThread(LoginSucceedEvent event){

        LoginActivity.this.finish();//收到订阅事件之后关闭当前界面

    }

    @OnClick(R.id.button)
    public void onClick() {
        startActivity(new Intent(getApplicationContext(), RegistActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//取消订阅
    }
}
