package students.startuitest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import students.startuitest.transormer.ZoomOutTransformer;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    private List<View> views = new ArrayList<>();
    private ViewPagerAdapter mAdapter;
    private View view1,view2,view3,view4;
    private Button mState;

    //底部小点图片
    private LinearLayout mPoint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guilde);
        initView();
        initData();
    }

    private void initData() {
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        mAdapter = new ViewPagerAdapter(views);
        viewPager.setOnPageChangeListener(this);
        addPoint();
        viewPager.setAdapter(mAdapter);
//        viewPager.setPageTransformer(true,new DepthTransformer());//设置翻页动画效果
        viewPager.setPageTransformer(true,new ZoomOutTransformer());//设置淡入淡出动画效果


        mState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mPoint = (LinearLayout) findViewById(R.id.llPoint);
        LayoutInflater inflater =LayoutInflater.from(this);
        view1 = inflater.inflate(R.layout.view_guide001,null);
        view2 = inflater.inflate(R.layout.view_guide002,null);
        view3 = inflater.inflate(R.layout.view_guide003,null);
        view4 = inflater.inflate(R.layout.view_guide004,null);
        mState = (Button) view4.findViewById(R.id.start_use);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("TAG",position+"pageSelected");
        monitorPoint(position);
//        showCurrentIndex(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class ViewPagerAdapter extends PagerAdapter{
     private  List<View> views;

        public ViewPagerAdapter(List<View> views) {
            this.views = views;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        //销毁postion位置的界面
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            (container).removeView(views.get(position));
        }
        /**
         *  初始化position位置的界面
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
           View view = views.get(position);
            container.addView(view);
            return view;
        }
        //判断是否由对象生成界面
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }

    /**
     * 添加小圆点
     */
    private  void addPoint(){
        for (int i = 0; i < views.size(); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if(i<1){
                params.setMargins(0,0,0,0);
            }else{
                params.setMargins(10,0,0,0);
            }
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(params);
            iv.setBackgroundResource(R.mipmap.select_select);
            mPoint.addView(iv);
        }
        mPoint.getChildAt(0).setBackgroundResource(R.mipmap.select);
    }

    /**
     * 标识当前查看进度
     * @param position
     */
    private void monitorPoint(int position){
        for (int i = 0; i <=views.size(); i++) {
            if(i==position){
                mPoint.getChildAt(position).setBackgroundResource(R.mipmap.select_select);
            }else{
                mPoint.getChildAt(position).setBackgroundResource(R.mipmap.select);
            }
        }

    }

    /**
     * 标识当前查看的是那个目录
     * @param position
     */
    private void showCurrentIndex(final int position){
        for (int i = 0; i < views.size(); i++) {
            if(i==position){
                mPoint.getChildAt(i).setBackgroundResource(R.mipmap.select);
            }else{
                mPoint.getChildAt(i).setBackgroundResource(R.mipmap.select_select);
            }
        }
    }

}
