package com.wz.news.ui.fragment;

import com.wz.news.bean.NewsInfoEntry;
import com.wz.news.presenter.contract.NewsContract;
import com.wz.news.presenter.contract.NewsPresenter;
import com.wz.news.ui.adapter.TemplateNewsAdapter;

import java.util.List;

/**
 * Created by wz on 17-5-11.
 */

public class NewsFragment extends RecyclerViewTempFragment implements NewsContract.View{
    @Override
    public void showLoading() {

    }

    @Override
    public void showLoadMoreing() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmptyData() {

    }

    @Override
    public void showResult(List<NewsInfoEntry> list) {
        mAdapter.setNewsInfoEntries(list);
    }

    @Override
    protected TemplateNewsAdapter setAdapter() {
        return new TemplateNewsAdapter(mContext);
    }

    @Override
    protected void initData() {
        NewsPresenter newsPresenter = new NewsPresenter(this);
        newsPresenter.requestDatas();
    }














  /*  @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private TemplateNewsAdapter mAdapter;

    @Override
    public int setLayout() {
        return R.layout.template_recycler_view;
    }

    @Override
    protected void init() {
        initRecyclerView();
        NewsPresenter presenter = new NewsPresenter(this);
        presenter.requestDatas();
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new MyDecoration(mContext,VERTICAL_LIST));
        mAdapter = new TemplateNewsAdapter(mContext);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showLoadMoreing() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmptyData() {

    }

    @Override
    public void showResult(List<NewsInfoEntry> list) {
        mAdapter.setNewsInfoEntries(list);
    }*/
}
