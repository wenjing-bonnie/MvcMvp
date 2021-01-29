package com.android.mvcmcp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.mvcmcp.mvc.MvcActivity;
import com.android.mvcmcp.mvp.MvpActivity;

/**
 * 用来模拟一个用户输入账号和密码，完成登陆的过程。登录成功之后显示用户的基本信息
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void mvcClick(View view) {
        Intent intent = new Intent(MainActivity.this, MvcActivity.class);
        startActivity(intent);
    }


    public void mvpClick(View view) {
        Intent intent = new Intent(MainActivity.this, MvpActivity.class);
        startActivity(intent);
    }
}