package com.wz.news.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wz on 17-5-14.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(setLayoutResID());
        mUnbinder = ButterKnife.bind(this);

        init();
    }

    public abstract int setLayoutResID() ;



    protected void startActivity(Class clazz){
        startActivity(new Intent(this,clazz));
    }

    public abstract void init();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder!=Unbinder.EMPTY){
            mUnbinder.unbind();
        }
    }
}
