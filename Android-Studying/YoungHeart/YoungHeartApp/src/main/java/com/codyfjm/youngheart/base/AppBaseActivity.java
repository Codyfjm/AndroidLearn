package com.codyfjm.youngheart.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.widget.ProgressBar;

import com.codyfjm.androidlib.activity.BaseActivity;
import com.codyfjm.androidlib.net.RequestCallback;

/**
 * author：codyfjm on 18/3/28
 * email：CodyFeng@lansion.cn
 * company:MIDONG TECHENOLOGY
 * Copyright © 2018 MIDONG TECHENOLOGY All rights reserved.
 */
public abstract class AppBaseActivity extends BaseActivity {

    protected ProgressDialog dlg;

    public abstract class  AbstractRequestCallback implements RequestCallback{
        public abstract void onSuccess(String content);

        public void onFail(String errorMessage){
            dlg.dismiss();
            
            new AlertDialog.Builder(AppBaseActivity.this)
                    .setTitle("出错了").setMessage(errorMessage)
                    .setPositiveButton("确定",null).show();
        }
    }

}
