package com.wz.news.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wz.news.R;
import com.wz.news.bean.NewsInfoEntry;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wz on 17-6-1.
 */

public class TemplateNewsAdapter extends RecyclerView.Adapter<TemplateNewsAdapter.ViewHolder> {

    private final Context mContext;
    private List<NewsInfoEntry> mNewsInfoEntries;

    public TemplateNewsAdapter(Context context) {
        mContext = context;
    }

    public void setNewsInfoEntries(List<NewsInfoEntry> newsInfoEntries) {
        mNewsInfoEntries = newsInfoEntries;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(mContext, R.layout.template_newsinfo, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsInfoEntry news = mNewsInfoEntries.get(position);
        String content = news.getContent().trim();
        //content = SubStringUtil.subString(content, ">", "<");
        holder.mTvContent.setText(Html.fromHtml(content));
        holder.mTvTitle.setText(news.getTitle());
        holder.mTvCreateTime.setText(news.getTime());
        holder.mTvFrom.setText(news.getCategory());
    }

    @Override
    public int getItemCount() {
        return mNewsInfoEntries == null ? 0 : mNewsInfoEntries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_icon)
        ImageView mIvIcon;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_content)
        TextView mTvContent;
        @BindView(R.id.tv_from)
        TextView mTvFrom;
        @BindView(R.id.tv_create_time)
        TextView mTvCreateTime;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
