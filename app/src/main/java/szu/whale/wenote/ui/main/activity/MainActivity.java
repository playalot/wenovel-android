package szu.whale.wenote.ui.main.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import szu.whale.wenote.R;
import szu.whale.wenote.base.RxManager;

public class MainActivity extends AppCompatActivity {

    private RxManager rxManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rxManager = new RxManager();
        rxManager.post();
    }
}
