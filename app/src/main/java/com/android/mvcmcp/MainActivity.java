package com.android.mvcmcp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.mvcmcp.mvc.MvcActivity;
import com.android.mvcmcp.mvp.MvpActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void mvcClick(View view) {
        Intent intent = new Intent(MainActivity.this, MvcActivity.class);
        startActivity(intent);
    }


    public void mvpClick(View view) {
        Intent intent = new Intent(MainActivity.this, MvpActivity.class);
        startActivity(intent);
    }
}