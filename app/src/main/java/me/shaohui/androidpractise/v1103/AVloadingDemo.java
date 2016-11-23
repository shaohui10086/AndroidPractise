package me.shaohui.androidpractise.v1103;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.wang.avi.AVLoadingIndicatorView;
import me.shaohui.androidpractise.R;

public class AVloadingDemo extends AppCompatActivity {

    private AVLoadingIndicatorView mAVLoadingIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avloading_demo);

        mAVLoadingIndicatorView = (AVLoadingIndicatorView) findViewById(R.id.av_loading);


        findViewById(R.id.action_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAVLoadingIndicatorView.show();
            }
        });
        findViewById(R.id.action_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAVLoadingIndicatorView.hide();
            }
        });
    }
}
