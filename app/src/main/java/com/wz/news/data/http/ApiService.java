package com.wz.news.data.http;

import com.wz.news.bean.BaseEntry;
import com.wz.news.bean.NewsInfoEntry;
import com.wz.news.bean.PageInfoEntry;

import retrofit2.http.GET;

/**
 * Created by wz on 17-6-1.
 */

public interface ApiService {


    @GET("get?channel=%E5%A4%B4%E6%9D%A1&start=0&num=10&appkey=2fde31de42431d6e")
    retrofit2.Call<BaseEntry<PageInfoEntry<NewsInfoEntry>>> getNews();

}
