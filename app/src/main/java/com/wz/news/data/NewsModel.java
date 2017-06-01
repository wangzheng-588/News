package com.wz.news.data;

import com.wz.news.bean.BaseEntry;
import com.wz.news.bean.NewsInfoEntry;
import com.wz.news.bean.PageInfoEntry;
import com.wz.news.data.http.ApiService;
import com.wz.news.data.http.HttpManager;

import retrofit2.Callback;

/**
 * Created by wz on 17-6-1.
 */

public class NewsModel {


    public void getNews(Callback<BaseEntry<PageInfoEntry<NewsInfoEntry>>> callback){
        HttpManager manager = new HttpManager();
        ApiService apiService = manager.getRetrofit(manager.getOkhttpClient()).create(ApiService.class);
        apiService.getNews().enqueue(callback);
    }


}
