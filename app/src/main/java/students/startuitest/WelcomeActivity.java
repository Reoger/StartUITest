package students.startuitest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 24540 on 2016/11/3.
 */
public class WelcomeActivity extends AppCompatActivity {


    private boolean mIsFirstUse;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        SharedPreferences preferences = getSharedPreferences("mIsFirstUse",MODE_PRIVATE);
        mIsFirstUse = preferences.getBoolean("mIsFirstUse", true);
        if(mIsFirstUse){
            Intent intent = new Intent(this,GuideActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("mIsFirstUse",false);
        editor.commit();
    }
}
