package com.android.mvcmcp.model;

/**
 * Created by wenjing.liu on 2021/1/28 in J1.
 * 模拟用来像服务器请求数据
 *
 * @author wenjing.liu
 */
public class HttpManager {

    public static void get() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
