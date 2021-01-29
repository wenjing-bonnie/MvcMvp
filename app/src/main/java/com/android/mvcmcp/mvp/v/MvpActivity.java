package com.android.mvcmcp.mvp.v;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.mvcmcp.R;
import com.android.mvcmcp.model.User;
import com.android.mvcmcp.mvp.m.MvpCacheBean;
import com.android.mvcmcp.mvp.p.MvpPresenter;

public class MvpActivity extends Activity implements IMvpViewInterface {
    private MvpPresenter presenter;

    private TextView tvUserInfo;
    private EditText etAccount;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        //初始化View
        initWidget();
        //初始化Presenter
        presenter = new MvpPresenter(MvpActivity.this);
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
        presenter.login(account, password);
    }

    @Override
    public void loginSuccess(MvpCacheBean cacheBean) {
        MvpCacheBean mvpCacheBean = (MvpCacheBean) cacheBean;
        User user = mvpCacheBean.user;
        tvUserInfo.setText(String.format("用户登录成功\n用户名：%s\n性别：%s\n年龄：%s", user.name, user.sex, user.age));
        tvUserInfo.setTextColor(Color.GREEN);
    }

    @Override
    public void loginFailure(String error) {
        tvUserInfo.setText(error);
        tvUserInfo.setTextColor(Color.RED);
    }
}