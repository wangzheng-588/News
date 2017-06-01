package com.wz.news.ui.fragment;

import android.util.Log;

import com.wz.news.R;

/**
 * Created by wz on 17-5-11.
 * 头条
 */

public class HeadlinesFragment extends BaseFragment {

    @Override
    protected void init() {

    }

    @Override
    protected int setLayoutResID() {
        return R.layout.fragment_headlines;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("TAG", "HeadlinesFragment: "+isVisibleToUser);
    }



    @Override
    protected void onFragmentFirstVisible() {
        Log.e("TAG", "onFragmentFirstVisible: HeadlinesFragment");
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        Log.e("TAG", "onFragmentVisibleChange: HeadlinesFragment");
    }
}
