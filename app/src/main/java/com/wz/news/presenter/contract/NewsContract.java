package com.wz.news.presenter.contract;

import com.wz.news.bean.NewsInfoEntry;
import com.wz.news.presenter.BasePresenter;
import com.wz.news.ui.BaseView;

import java.util.List;

/**
 * Created by wz on 17-6-1.
 */

public interface NewsContract  {

    interface View extends BaseView{

        void showResult(List<NewsInfoEntry> list);
    }

    interface Presenter extends BasePresenter{

    }

}
