package com.david.dandroidutils.app;

import android.support.multidex.MultiDexApplication;

import com.david.dandroidutils.utils.OkHttpUtils;
/**
 * @author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @交流Qq ：986945193
 * @GitHub: https://github.com/QQ986945193
 */

/**
 * Application的配置 继承MultiDexApplication是为了使项目能够突破65535限制
 */
public class MyApplication extends MultiDexApplication {
    private static MyApplication app;
    private OkHttpUtils mOkHttpUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initOkHttpUtils();

    }


    /**
     * 初始化OkHttp
     */
    private void initOkHttpUtils() {
        mOkHttpUtils = OkHttpUtils.getInstance();

    }


    public static MyApplication getApp() {
        return app;
    }


    /**
     * @return
     * @GitHub: https://github.com/QQ986945193
     * @CSDN博客: http://blog.csdn.net/qq_21376985
     */
    public OkHttpUtils getOkHttpUtils() {
        return this.mOkHttpUtils;
    }


}
