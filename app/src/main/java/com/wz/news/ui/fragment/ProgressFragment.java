package com.wz.news.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wz.news.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wz on 17-5-31.
 */

public abstract class ProgressFragment extends Fragment {


    private FrameLayout mRootView;
    private View mProgressView;
    private FrameLayout mContentView;
    private View mEmptyView;
    private TextView mTextError;
    private Unbinder mBind;
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = (FrameLayout) inflater.inflate(R.layout.fragment_progress,container,false);
        mProgressView = mRootView.findViewById(R.id.view_progress);
        mContentView = (FrameLayout) mRootView.findViewById(R.id.view_content);
        mEmptyView = mRootView.findViewById(R.id.view_empty);
        mTextError = (TextView) mRootView.findViewById(R.id.text_tip);

        mTextError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEmptyViewClick();
            }
        });
        return mRootView;
    }

    private void onEmptyViewClick() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRealContentView();

        init();
        initData();
    }

    protected abstract void initData();

    private void setRealContentView() {
        View realContentView = LayoutInflater.from(getActivity()).inflate(setLayout(),mContentView,true);
        mBind = ButterKnife.bind(this, realContentView);
    }


    protected abstract void init();


    public void showProgress(){
        showView(R.id.view_progress);
    }

    public void showContentView(){
        showView(R.id.view_content);
    }

    public void showEmptyView(){
        showView(R.id.view_empty);
    }

    public void showEmptyView(int resID){
        showEmptyView();
        mTextError.setText(resID);
    }

    public void showEmptyView(String message){
        showEmptyView();
        mTextError.setText(message);
    }

    public void showView(int viewID){
        for (int i = 0; i < mRootView.getChildCount(); i++) {
            if ( mRootView.getChildAt(i).getId()==viewID){
                mRootView.getChildAt(i).setVisibility(View.VISIBLE);
            } else {
                mRootView.getChildAt(i).setVisibility(View.GONE);
            }
        }
    }

    public abstract int setLayout();


    @Override
    public void onDestroy() {
        if (mBind!= Unbinder.EMPTY){
            mBind.unbind();
        }
        super.onDestroy();
    }

}
