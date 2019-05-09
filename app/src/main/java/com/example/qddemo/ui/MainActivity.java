package com.example.qddemo.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.qd_base.BaseActivity;
import com.example.qddemo.R;
import com.example.qddemo.ui.main.home.HomeFragment;
import com.example.qddemo.ui.main.study.StudyFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;
    @BindView(R.id.navigation)
    NavigationView navigation;

    private Fragment currentFragment;

    private HomeFragment homeFragment;
    private StudyFragment studyFragment;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        tool_bar.setTitle("奇德");
        setSupportActionBar(tool_bar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_layout, tool_bar, R.string.open, R.string.close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        navigation.setNavigationItemSelectedListener(this);
        navigation.setCheckedItem(R.id.menu_home);
        if (homeFragment == null)
            homeFragment = HomeFragment.newInstance();
        changeFm(homeFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_home:
                if (homeFragment == null)
                    homeFragment = HomeFragment.newInstance();
                changeFm(homeFragment);
                break;
            case R.id.menu_study:
                if (studyFragment == null)
                    studyFragment = StudyFragment.newInstance();
                changeFm(studyFragment);
                break;
        }
        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * 切换fragment
     *
     * @param fragment
     */
    private void changeFm(Fragment fragment) {
        if (fragment == currentFragment)
            return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }
        if (!fragment.isAdded()) {
            transaction.add(R.id.frame_layout, fragment);
        } else {
            transaction.show(fragment);
        }
        transaction.commit();
        currentFragment = fragment;
    }
}
