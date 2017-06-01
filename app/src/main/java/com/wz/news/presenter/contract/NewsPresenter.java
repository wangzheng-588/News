package com.wz.news.presenter.contract;

import com.wz.news.bean.BaseEntry;
import com.wz.news.bean.NewsInfoEntry;
import com.wz.news.bean.PageInfoEntry;
import com.wz.news.data.NewsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wz on 17-6-1.
 */

public class NewsPresenter implements NewsContract.Presenter {

    private NewsModel mModel;

    private  NewsContract.View mView;

    public NewsPresenter(NewsContract.View view){
        mView = view;
        mModel = new NewsModel();
    }


    @Override
    public void requestDatas() {
      mModel.getNews(new Callback<BaseEntry<PageInfoEntry<NewsInfoEntry>>>() {
          @Override
          public void onResponse(Call<BaseEntry<PageInfoEntry<NewsInfoEntry>>> call, Response<BaseEntry<PageInfoEntry<NewsInfoEntry>>> response) {
              mView.showResult(response.body().getResult().getList());
          }

          @Override
          public void onFailure(Call<BaseEntry<PageInfoEntry<NewsInfoEntry>>> call, Throwable t) {
              mView.showError();
          }
      });
    }
}
