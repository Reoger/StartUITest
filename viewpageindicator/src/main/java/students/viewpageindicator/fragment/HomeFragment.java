package students.viewpageindicator.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import students.viewpageindicator.InficatorActivity;
import students.viewpageindicator.R;

/**
 * Created by 24540 on 2016/11/6.
 */
public class HomeFragment extends Fragment {


    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        //在这里添加相关的初始化界面的代码
        initView();
        return mView;
    }

    private void initView() {
        //在这里对页面的元素进行初始化，例如 进行findViewById的操作，
        Button bu1 = (Button) mView.findViewById(R.id.but_test);
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "测试按钮", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), InficatorActivity.class));
            }
        });
        //记住，这里的findviewbyid操作不用使用getActivity来进行查找，直接使用mView来查找是没错的，如例子
        // 如果有多个fragment使用这种方式查找，就会有fragment找不到相应的控件，从而获得null值，
        // 后续的代码就会直接出错。（曾今被坑过）
    }

}
