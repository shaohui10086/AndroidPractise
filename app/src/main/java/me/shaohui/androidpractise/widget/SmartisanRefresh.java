package me.shaohui.androidpractise.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shaohui on 16/7/1.
 */
public class SmartisanRefresh extends View {
    
    public SmartisanRefresh(Context context) {
        this(context, null);
    }

    public SmartisanRefresh(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmartisanRefresh(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        
        init();
    }

    private void init() {
    }
}
