package students.viewpageindicator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import students.viewpageindicator.adapter.MyFragmentAdapter;
import students.viewpageindicator.fragment.CircleFragment;
import students.viewpageindicator.fragment.HomeFragment;
import students.viewpageindicator.fragment.UserFragment;
import students.viewpageindicator.tool.ViewPagerIndicator;

/**
 * Created by 24540 on 2016/11/6.
 */
public class InficatorActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<Fragment> mViews;
    private List<String> mDatas = Arrays.asList("推荐", "视屏","图片","文字","更多");
    private ViewPagerIndicator mIndicator;
    private MyFragmentAdapter mAdapter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewadapter);

        initData();
        initView();
    }

    private void initData() {
        mViews = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        CircleFragment circleFragment = new CircleFragment();
        UserFragment userFragment = new UserFragment();
        mViews.add(homeFragment);
        mViews.add(circleFragment);
        mViews.add(userFragment);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_vp);
        mIndicator = (ViewPagerIndicator) findViewById(R.id.id_indicator);
        mAdapter = new MyFragmentAdapter(getSupportFragmentManager(),mViews);
        //设置Tab上的标题
        mIndicator.setTabItemTitles(mDatas);
        mViewPager.setAdapter(mAdapter);
        //设置关联的ViewPager
        mIndicator.setViewPager(mViewPager,0);
    }
}
