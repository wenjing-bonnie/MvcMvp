package com.android.mvcmcp.mvp.v;

import com.android.mvcmcp.mvc.m.MvcCacheBean;

/**
 * Created by wenjing.liu on 2021/1/29 in J1.
 *
 * @author wenjing.liu
 */
public interface IMvpViewInterface {
    /**
     * 接口登录成功回调
     * @param cacheBean
     */
    void loginSuccess(MvcCacheBean cacheBean);

    /**
     * 接口登录失败的回调
     * @param error
     */
    void loginFailure(String error);
}
