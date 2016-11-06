package students.viewpageindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import students.viewpageindicator.adapter.MyFragmentAdapter;
import students.viewpageindicator.fragment.CircleFragment;
import students.viewpageindicator.fragment.HomeFragment;
import students.viewpageindicator.fragment.UserFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Fragment> mViews;
    private ViewPager mViewPage;
    private MyFragmentAdapter mAdapter;
    private LinearLayout mTabHome;
    private LinearLayout mCircle;
    private LinearLayout mUser;
    private ImageButton mHomeImg;
    private ImageButton mCicleImg;
    private ImageButton mUserImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViews = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        CircleFragment circleFragment = new CircleFragment();
        UserFragment userFragment = new UserFragment();

        mViews.add(homeFragment);
        mViews.add(circleFragment);
        mViews.add(userFragment);

        mTabHome = (LinearLayout) findViewById(R.id.main_bottom_home);
        mCircle = (LinearLayout) findViewById(R.id.main_bottom_dynamic);
        mUser = (LinearLayout) findViewById(R.id.main_bottom_user);
        mHomeImg = (ImageButton) findViewById(R.id.main_bottom_home_img);
        mCicleImg = (ImageButton) findViewById(R.id.main_bottom_dynamic_img);
        mUserImg = (ImageButton) findViewById(R.id.main_bottom_user_img);

        mViewPage = (ViewPager) findViewById(R.id.viewPager);

        mAdapter = new MyFragmentAdapter(getSupportFragmentManager(), mViews);
        mViewPage.setAdapter(mAdapter);
        mHomeImg.setImageResource(R.mipmap.home_sel);
        mViewPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPage.getCurrentItem();
                resetImg();
                switch (currentItem) {
                    case 0:
                        mHomeImg.setImageResource(R.mipmap.home_sel);
                        break;
                    case 1:
                        mCicleImg.setImageResource(R.mipmap.circle_sel);
                        break;
                    case 2:
                        mUserImg.setImageResource(R.mipmap.my_sel);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabHome.setOnClickListener(this);
        mCircle.setOnClickListener(this);
        mUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_bottom_home:
                mViewPage.setCurrentItem(0);
                break;
            case R.id.main_bottom_dynamic:
                mViewPage.setCurrentItem(1);
                break;
            case R.id.main_bottom_user:
                mViewPage.setCurrentItem(2);
                break;
        }
    }

    private void resetImg() {
        mHomeImg.setImageResource(R.mipmap.home);
        mCicleImg.setImageResource(R.mipmap.circle);
        mUserImg.setImageResource(R.mipmap.my);
    }
}
