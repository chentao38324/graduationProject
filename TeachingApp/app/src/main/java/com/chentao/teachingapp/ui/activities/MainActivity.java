package com.chentao.teachingapp.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.chentao.teachingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.rong.imkit.RongIM;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.bt2)
    Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.d("++", "__");
    }

    @OnClick(R.id.bt2)
    public void onViewClicked() {
        if (RongIM.getInstance() != null)
            RongIM.getInstance().startPrivateChat(MainActivity.this, "26594", "title");
    }
}
