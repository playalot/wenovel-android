package szu.whale.wenote.ui.main.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import szu.whale.wenote.R;

public class MainActivity extends AppCompatActivity {
    private String mString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mString = "hellow world";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
