package com.android.mvcmcp.mvp.v;

import com.android.mvcmcp.mvc.m.MvcCacheBean;

/**
 * Created by wenjing.liu on 2021/1/29 in J1.
 *
 * @author wenjing.liu
 */
public interface IMvpViewInterface {

    void loginSuccess(MvcCacheBean cacheBean);

    void loginFailure(String error);
}
