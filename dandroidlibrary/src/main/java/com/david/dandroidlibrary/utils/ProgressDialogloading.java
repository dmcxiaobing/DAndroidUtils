package com.david.dandroidlibrary.utils;
/*
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.david.dandroidlibrary.R;
import com.david.dandroidlibrary.utils.constants.Constant;


/**
 * loading等待的提示框。
 */
public class ProgressDialogloading {
    public static ProgressDialog mProgressDialog;
    public Context mContext;

    public ProgressDialogloading(Context context, String message) {
        this.mContext = context;
        // 提示正在加载
        mProgressDialog = new ProgressDialog(mContext);
        if ((message == null) || message.equals("")) {
            mProgressDialog.setMessage(Constant.LOADING_DATA);
        } else {
            mProgressDialog.setMessage(message);
        }
        mProgressDialog.setCancelable(false);
    }


    /**
     * 隐藏正在加载
     */
    public static void dismissHiddenLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }

    }

    /**
     * 显示正在加载
     */
    public static void showLoading() {
        if (mProgressDialog != null && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    /**
     * 仿微博的dialogloading
     */

    public static Dialog createWeiboLoadingDialog(Context context, String msg) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialog_loading, null);// 得到加载view
        LinearLayout layout = (LinearLayout) v
                .findViewById(R.id.dialog_loading_view);// 加载布局
        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
        if ((msg == null) || msg.equals("")) {
            tipTextView.setText(Constant.LOADING_DATA);// 设置加载信息
        } else {
            tipTextView.setText(msg);// 设置加载信息

        }
        Dialog loadingDialog = new Dialog(context, R.style.WeiboDialogStyle);// 创建自定义样式dialog
        loadingDialog.setCancelable(true); // 是否可以按“返回键”消失
        loadingDialog.setCanceledOnTouchOutside(false); // 点击加载框以外的区域
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
        /**
         *将显示Dialog的方法封装在这里面
         */
        Window window = loadingDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setGravity(Gravity.CENTER);
        window.setAttributes(lp);
        window.setWindowAnimations(R.style.PopWindowAnimStyle);
        loadingDialog.show();

        return loadingDialog;
    }

    /**
     * 隐藏仿微博dialog
     */
    public static void dismissWeiboDialog(Dialog mDialogUtils) {
        if (mDialogUtils != null && mDialogUtils.isShowing()) {
            mDialogUtils.dismiss();
        }
    }
}
