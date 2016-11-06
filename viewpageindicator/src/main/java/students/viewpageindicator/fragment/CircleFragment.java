package students.viewpageindicator.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import students.viewpageindicator.R;

/**
 * Created by 24540 on 2016/11/6.
 */
public class CircleFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle,container,false);
        return view;
    }

    //如果想参考如何设置延迟加载，请参考：http://blog.csdn.net/myatlantis/article/details/42643733
}
