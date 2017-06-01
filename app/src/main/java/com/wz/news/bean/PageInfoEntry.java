package com.wz.news.bean;

import java.util.List;

/**
 * Created by wz on 17-6-1.
 */

public class PageInfoEntry<T> {

    private String channel;
    private int num;
    private List<T> list;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
