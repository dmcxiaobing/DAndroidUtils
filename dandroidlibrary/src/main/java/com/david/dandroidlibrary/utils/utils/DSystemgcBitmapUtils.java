package com.david.dandroidlibrary.utils.utils;

import android.graphics.Bitmap;

/**
 * @author ：程序员小冰
 *
 * @新浪微博 ：http://weibo.com/mcxiaobing
 *
 * @GitHub: https://github.com/QQ986945193
 *
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 *
 * 封装一个简单的 回收Bitmap工具类
 *
 */
public class DSystemgcBitmapUtils {
    /**
     * 回收bitmap
     * @param mbitmap 一个bitmap对象
     */
    public static void SystemGcBitmap(Bitmap mbitmap) {
        if (mbitmap != null && !mbitmap.isRecycled()) {
            // 回收并且置为null
            mbitmap.recycle();
            mbitmap = null;
        }
        System.gc();
    }
}
