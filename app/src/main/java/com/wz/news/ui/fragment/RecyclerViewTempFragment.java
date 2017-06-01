package com.wz.news.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wz.news.R;
import com.wz.news.ui.adapter.TemplateNewsAdapter;
import com.wz.news.ui.widget.MyDecoration;

import butterknife.BindView;

import static com.wz.news.ui.widget.MyDecoration.VERTICAL_LIST;

/**
 * Created by wz on 17-6-1.
 */

public abstract class RecyclerViewTempFragment extends ProgressFragment {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    protected TemplateNewsAdapter mAdapter;


    @Override
    public int setLayout() {
        return R.layout.template_recycler_view;
    }

    @Override
    protected void init() {
        initRecyclerView();
    }



    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new MyDecoration(mContext,VERTICAL_LIST));
        mAdapter = setAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    protected abstract TemplateNewsAdapter setAdapter();
}
