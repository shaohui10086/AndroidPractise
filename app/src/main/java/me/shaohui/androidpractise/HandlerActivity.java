package me.shaohui.androidpractise;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                return false;
            }
        });

        Message message = Message.obtain(handler);

        message.getCallback();
        message.sendToTarget();

        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });

        handler.sendMessage(message);
        handler.sendEmptyMessage(0);


        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Handler handler = new Handler();
                Looper.loop();
                Looper.getMainLooper().quit();

            }
        }).start();
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }
}
