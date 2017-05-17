package com.david.dandroidlibrary.utils.utils;


/*
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 *
 * 加载更多与下拉刷新完成的类
 */


import com.david.dandroidlibrary.utils.view.DAutoRefreshListView;

public class DAutoRefreshListviewCompleteUtils {
    /**
     * 加载更多与下拉刷新完成
     *
     * @param pullListView 变量
     */
    public static void pullListviewComplete(DAutoRefreshListView pullListView) {
        pullListView.refreshComplete();
        pullListView.getMoreComplete();
    }
}
