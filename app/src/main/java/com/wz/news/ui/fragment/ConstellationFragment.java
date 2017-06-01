package com.wz.news.ui.fragment;

import android.util.Log;

import com.wz.news.R;

/**
 * Created by wz on 17-5-11.
 */

public class ConstellationFragment extends BaseFragment {
   @Override
    protected void onFragmentFirstVisible() {
        Log.e("TAG", "onFragmentFirstVisible: ConstellationFragment");
    }

    @Override
    protected void init() {

    }

    @Override
    protected int setLayoutResID() {
        return R.layout.fragment_constellation;
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        Log.e("TAG", "onFragmentVisibleChange: ConstellationFragment");
    }
}
