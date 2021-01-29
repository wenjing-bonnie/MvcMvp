package com.android.mvcmcp.model;

/**
 * Created by wenjing.liu on 2021/1/28 in J1.
 * 用来处理Http处理之后的回调
 *
 * @author wenjing.liu
 */
public interface IHttpResult {
    void success(IViewCacheBean cacheBean);

    void failure(String error);
}
