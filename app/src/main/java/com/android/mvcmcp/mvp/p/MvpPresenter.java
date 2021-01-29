package com.android.mvcmcp.mvp.p;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.android.mvcmcp.mvc.m.IMvcModelInterface;
import com.android.mvcmcp.mvc.m.MvcCacheBean;
import com.android.mvcmcp.mvc.m.MvcModelImpl;
import com.android.mvcmcp.network.IHttpResult;
import com.android.mvcmcp.network.IViewCacheBean;
import com.android.mvcmcp.mvp.m.IMvpModelInterface;
import com.android.mvcmcp.mvp.m.MvpModelImpl;
import com.android.mvcmcp.mvp.v.IMvpViewInterface;
import com.android.mvcmcp.mvp.m.MvpCacheBean;

/**
 * Created by wenjing.liu on 2021/1/29 in J1.
 * 处理业务逻辑
 *
 * @author wenjing.liu
 */
public class MvpPresenter implements IMvpPresenterInterface {
    private IMvpViewInterface mvpViewInterface;
    private IMvcModelInterface model;
    private Context context;

    public MvpPresenter(IMvpViewInterface viewInterface) {
        this.mvpViewInterface = viewInterface;
        this.context = (Context) viewInterface;
        model = new MvcModelImpl();
    }

    @Override
    public void login(String account, String password) {
        //部分UI逻辑可以转移到MvpPresenter，来减轻Activity的负担
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            Toast.makeText(context, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        model.login(account, password, new IHttpResult() {
            @Override
            public void success(IViewCacheBean cacheBean) {
                mvpViewInterface.loginSuccess( (MvcCacheBean)cacheBean);
            }

            @Override
            public void failure(String error) {
                mvpViewInterface.loginFailure(error);
            }
        });
    }
}
