package com.android.mvcmcp.mvp.m;

import com.android.mvcmcp.model.IHttpResult;

/**
 * Created by wenjing.liu on 2021/1/28 in J1.
 *
 * @author wenjing.liu
 */
public interface IMvpModelInterface {
    /**
     * 登录
     *
     * @param account
     * @param password
     * @param result   服务器处理完数据返回的结果
     */
    void login(String account, String password, IHttpResult result);
}
