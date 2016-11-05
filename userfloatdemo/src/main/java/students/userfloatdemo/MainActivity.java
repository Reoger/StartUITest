package students.userfloatdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

public class MainActivity extends AppCompatActivity {

    private TourGuide mTourGuideHandler1;
    private TourGuide mTourGuideHandler2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initFisrtButton();


    }

    //第二个按钮的
    private void initSecondeButton() {
        Pointer  pointer = new
                Pointer().setColor(Color.RED)//设置指示器的颜色
                .setGravity(Gravity.BOTTOM);//设置指示器对于父容器的位置

        Overlay overlay = new Overlay()
                .setBackgroundColor(Color.parseColor("#AAFF0000"))//设置覆盖层的颜色
                .disableClick(true)//设置不可以点击
                .setStyle(Overlay.Style.Rectangle);//设置覆盖的风格

        Button bu2 = (Button) findViewById(R.id.second_but);
            mTourGuideHandler2 = TourGuide.init(this).with(TourGuide.Technique.Click)
                    .setPointer(pointer)
                    .setToolTip(new ToolTip().setTitle("点击他").setDescription("我们继续往下走..."))
                    .setOverlay(overlay)
                    .playOn(bu2);
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTourGuideHandler2.cleanUp();
            }
        });
    }

    private void initFisrtButton() {
        Button button = (Button) findViewById(R.id.id_but);


        //设置文本的动画效果
        Animation animation = new TranslateAnimation(0f, 0f, 200f, 0f);//转化动画
        animation.setDuration(1000);//时间间隔
        animation.setFillAfter(true);//设置停留在动画完成后的位置
        animation.setInterpolator(new BounceInterpolator());//设置动画变化的速率

        ToolTip toolTip = new ToolTip()//设置文字提示的风格
                .setTitle("欢迎使用")//设置标题
                .setDescription("下面来介绍怎么使用把..")//设置内容提示
                .setTextColor(Color.parseColor("#bdc3c7"))//设置字体颜色
                .setBackgroundColor(Color.parseColor("#e74c3c"))//设置背景色
                .setShadow(true)//设置是否有阴影效果
                .setGravity(Gravity.CENTER)//设置相对于父布局位置
                .setEnterAnimation(animation);//设置动画效果

        mTourGuideHandler1 = TourGuide.init(this).with(TourGuide.Technique.Click)
                .setPointer(new Pointer())//提示指向的按钮
                .setToolTip(toolTip)//设置提示的内容
                .setOverlay(new Overlay())//设置覆盖效果
                .playOn(button);//设置绑定的控件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTourGuideHandler1.cleanUp();//关闭引导界面
                initSecondeButton();
            }
        });

    }


}
