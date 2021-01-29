package com.android.mvcmcp.mvp.m;

import com.android.mvcmcp.model.IViewCacheBean;
import com.android.mvcmcp.model.User;

/**
 * Created by wenjing.liu on 2021/1/28 in J1.
 * 用来封装页面渲染需要的数据。
 * 主要接收服务器返回的数据以及返回给UI层数据
 *
 * @author wenjing.liu
 */
public class MvpCacheBean implements IViewCacheBean {
    public User user;
}
