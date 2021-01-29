package com.android.mvcmcp.mvp;

import android.app.Activity;
import android.os.Bundle;

import com.android.mvcmcp.R;

public class MvpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
    }
}