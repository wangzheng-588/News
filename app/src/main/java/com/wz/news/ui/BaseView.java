package com.wz.news.ui;

/**
 * Created by wz on 17-6-1.
 */

public interface BaseView {

    void showLoading();
    void showLoadMoreing();
    void dismissLoading();
    void showError();
    void showEmptyData();

}
