package com.wz.news.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.wz.news.R;
import com.wz.news.common.Consts;
import com.wz.news.ui.adapter.HomeNewsAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wz on 17-5-10.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.magic_indicator)
    MagicIndicator mMagicIndicator;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private List<Fragment> mFragments;

    @Override
    protected void init() {
        initMaginIndicator();

    }

    private void initMaginIndicator() {
        initFragment();
        mViewPager.setOffscreenPageLimit(mFragments.size());
        final CommonNavigator commonNavigator = new CommonNavigator(mContext);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return Consts.TITLE == null ? 0 : Consts.TITLE.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);

                clipPagerTitleView.setText(Consts.TITLE[index]);
                clipPagerTitleView.setTextColor(Color.parseColor("#f2c4c4"));
                clipPagerTitleView.setClipColor(Color.WHITE);

                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });

                return clipPagerTitleView;
            }


            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;    // 没有指示器，因为title的指示作用已经很明显了
            }
        });
        mMagicIndicator.setNavigator(commonNavigator);


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mMagicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                mMagicIndicator.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mMagicIndicator.onPageScrollStateChanged(state);
            }
        });

        mViewPager.setCurrentItem(1);

        HomeNewsAdapter adapter = new HomeNewsAdapter(this.getChildFragmentManager(), mFragments);
        mViewPager.setAdapter(adapter);
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new HeadlinesFragment());
        mFragments.add(new NewsFragment());
        mFragments.add(new EconomicFragment());
        mFragments.add(new SportFragment());
        mFragments.add(new RecreationFragment());
        mFragments.add(new WarFragment());
        mFragments.add(new EducationFragment());
        mFragments.add(new TechFragment());
        mFragments.add(new NBAFragment());
        mFragments.add(new StockFragment());
        mFragments.add(new ConstellationFragment());
        mFragments.add(new WomanFragment());
        mFragments.add(new HealthFragment());
        mFragments.add(new ChildFragment());
    }

    @Override
    protected int setLayoutResID() {
        return R.layout.fragment_home;
    }


}
