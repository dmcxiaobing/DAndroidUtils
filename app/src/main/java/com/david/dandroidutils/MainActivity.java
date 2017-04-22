package com.david.dandroidutils;

import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.david.dandroidlibrary.utils.ProgressDialogloading;


public class MainActivity extends AppCompatActivity {
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
//                    dialogloading.dismissHiddenLoading();
                    ProgressDialogloading.dismissWeiboDialog(weiboDialog);
                    break;
            }
        }
    };
    private ProgressDialogloading dialogloading;
    private Dialog weiboDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogloading = new ProgressDialogloading(this, null);
        weiboDialog = ProgressDialogloading.createWeiboLoadingDialog(this, null);

//        dialogloading.showLoading();
        weiboDialog.show();
        mHandler.sendEmptyMessageDelayed(1, 3000);
    }
}