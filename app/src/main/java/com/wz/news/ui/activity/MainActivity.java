package com.wz.news.ui.activity;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wz.news.ui.fragment.MeFragment;
import com.wz.news.R;
import com.wz.news.ui.fragment.VideoFragment;
import com.wz.news.ui.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.fl_main)
    FrameLayout mFlMain;
    @BindView(R.id.rb_home)
    RadioButton mRbHome;
    @BindView(R.id.rb_video)
    RadioButton mRbVideo;
    @BindView(R.id.rb_me)
    RadioButton mRbMe;
    @BindView(R.id.rg_main)
    RadioGroup mRgMain;
    private View mHeadView;
    private int position;
    private List<Fragment> mFragments;
    private Fragment preFragment;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_main;
    }


    @Override
    public void init() {
        initFragment();
        initDrawerLayout();
        mRgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId) {
                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_video:
                        position = 1;
                        break;
                    case R.id.rb_me:
                        position = 2;
                        break;
                }
                Fragment fragment = mFragments.get(position);
                changeFragment(fragment);
            }
        });

        mRgMain.check(R.id.rb_home);

    }


    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new VideoFragment());
        mFragments.add(new MeFragment());
    }


    private void changeFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (fragment != preFragment) {
            if (fragment.isAdded()) {
                if (preFragment != null) {
                    ft.hide(preFragment);
                }
                ft.show(fragment);
            } else {
                if (preFragment != null) {
                    ft.hide(preFragment);
                }
                ft.add(R.id.fl_main, fragment);
            }
        }
        preFragment = fragment;
        ft.commit();

    }


    private void initDrawerLayout() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mHeadView = mNavigationView.getHeaderView(0);
        mHeadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "head", Toast.LENGTH_SHORT).show();
            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.app_update:
                        Toast.makeText(MainActivity.this, "update", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.app_message:
                        Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.app_setting:
                        Toast.makeText(MainActivity.this, "setting", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        //mToolbar.inflateMenu(R.menu.toolbar_menu);
        ActionBarDrawerToggle barDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        barDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(barDrawerToggle);

    }

}
