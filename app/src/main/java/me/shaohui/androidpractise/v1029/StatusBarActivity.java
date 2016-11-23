package me.shaohui.androidpractise.v1029;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import me.shaohui.androidpractise.R;

public class StatusBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new Fragment())
                .commit();


        ViewGroup parent = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
        parent.addView(new TextView(this));

        getFragmentManager().beginTransaction()
                .add(android.R.id.content, new Fragment())
                .commit();
    }
}
