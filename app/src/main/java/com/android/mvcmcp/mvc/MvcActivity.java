package com.android.mvcmcp.mvc;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.mvcmcp.R;
import com.android.mvcmcp.model.IHttpResult;
import com.android.mvcmcp.model.IViewCacheBean;
import com.android.mvcmcp.model.User;

public class MvcActivity extends Activity {
    private IMvcModelInterface model;
    private TextView tvUserInfo;
    private EditText etAccount;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        //初始化View
        initWidget();
        //初始化Model
        model = new MvcModelImpl();
    }

    private void initWidget() {
        tvUserInfo = findViewById(R.id.tv_user_info);
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
    }

    public void btnLogin(View view) {
        tvUserInfo.setText("稍等1s之后就可以看到模拟的结果");
        tvUserInfo.setTextColor(Color.BLACK);
        String account = etAccount.getText().toString();
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            tvUserInfo.setText("账号和密码不能为空");
            return;
        }
        model.login(account, password, new IHttpResult() {
            @Override
            public void success(IViewCacheBean cacheBean) {
                MvcCacheBean mvcCacheBean = (MvcCacheBean) cacheBean;
                User user = mvcCacheBean.user;
                tvUserInfo.setText(String.format("用户登录成功\n用户名：%s\n性别：%s\n年龄：%s", user.name, user.sex, user.age));
                tvUserInfo.setTextColor(Color.GREEN);
            }

            @Override
            public void failure(String error) {
                tvUserInfo.setText(error);
                tvUserInfo.setTextColor(Color.RED);
            }
        });
    }
}