package com.david.dandroidutils.activity;
/*
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.david.dandroidlibrary.utils.view.ProgressDialogloadingView;
import com.david.dandroidutils.R;

/**
 * Created by david zheng on 2017/5/3.
 * loading等待提示框功能展示
 */
public class LoadingActivity extends Activity {
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    //由于library已经进行了非空等判断，所以，这里不用注释掉无用的loading。实际项目实际使用
                    dialogloading.dismissHiddenLoading();
                    ProgressDialogloadingView.dismissWeiboDialog(weiboDialog);
                    break;
            }
        }
    };
    private ProgressDialogloadingView dialogloading;
    private Dialog weiboDialog;

    private Button btn_one_loading;
    private Button btn_weibo_loading;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        initView();
        setOnclickListener();


    }

    private void setOnclickListener() {
        btn_one_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建对象 上下文，提示内容，是否可以按返回键取消
                dialogloading = new ProgressDialogloadingView(LoadingActivity.this, null, true);
                //调用显示的方法
                dialogloading.showLoading();
                mHandler.sendEmptyMessageDelayed(1, 3000);

            }
        });

        btn_weibo_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建对象 上下文，提示内容，是否可以按返回键取消
                weiboDialog = ProgressDialogloadingView.createWeiboLoadingDialog(LoadingActivity.this, null, true);
                //调用显示的方法
                weiboDialog.show();
                mHandler.sendEmptyMessageDelayed(1, 3000);


            }
        });

    }

    private void initView() {
        btn_one_loading = (Button) findViewById(R.id.btn_one_loading);
        btn_weibo_loading = (Button) findViewById(R.id.btn_weibo_loading);
    }
}
