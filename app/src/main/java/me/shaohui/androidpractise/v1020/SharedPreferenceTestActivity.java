package me.shaohui.androidpractise.v1020;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import me.shaohui.androidpractise.R;

public class SharedPreferenceTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_test);
    }

    private void newInstance() {
        SharedPreferences sp1 = getSharedPreferences(getPackageName() + "test", MODE_APPEND);
        SharedPreferences sp2 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences sp3 = getPreferences(MODE_PRIVATE);

        sp1.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {

            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

            }
        });
    }
}
