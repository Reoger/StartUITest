package students.viewpageindicator.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 24540 on 2016/11/6.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter{
    private List<Fragment>  mViews;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> mViews) {
        super(fm);
        this.mViews = mViews;
    }

    @Override
    public Fragment getItem(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    //Fragment只需要重写两个方法就能实现适配。
}
