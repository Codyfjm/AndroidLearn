package com.codyfjm.androidlib.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * author：codyfjm on 18/3/5
 * email：CodyFeng@lansion.cn
 * company:MIDONG TECHENOLOGY
 * Copyright © 2018 MIDONG TECHENOLOGY All rights reserved.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVariables();
        initViews(savedInstanceState);
        loadData();
    }

    protected abstract void initVariables();
    protected abstract void initViews(Bundle savedInstanceState);
    protected abstract void loadData();
}
