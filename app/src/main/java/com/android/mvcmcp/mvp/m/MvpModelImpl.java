package com.android.mvcmcp.mvp.m;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

import com.android.mvcmcp.network.IHttpResult;
import com.android.mvcmcp.network.User;

/**
 * Created by wenjing.liu on 2021/1/28 in J1.
 * 用来实现具体的业务逻辑
 *
 * @author wenjing.liu
 */
public class MvpModelImpl implements IMvpModelInterface {
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    //仅仅简单的做个逻辑判断，只是用来返回成功和失败的回调
                    int arg1 = msg.arg1;
                    IHttpResult result = (IHttpResult) msg.obj;
                    if (arg1 == 1) {
                        User user = new User();
                        user.name = "小刘";
                        user.sex = "女";
                        user.age = "34";
                        MvpCacheBean cacheBean = new MvpCacheBean();
                        cacheBean.user = user;
                        result.success(cacheBean);
                    } else {
                        result.failure("登录失败\n账号输入数字即可验证成功的逻辑");
                    }
                    break;
            }
        }
    };

    @Override
    public void login(String account, String password, IHttpResult result) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.what = 1;
                msg.obj = result;
                msg.arg1 = TextUtils.isDigitsOnly(account) ? 1 : 2;
                handler.sendMessage(msg);

            }
        }).start();
    }
}
