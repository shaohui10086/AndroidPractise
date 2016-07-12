package me.shaohui.androidpractise.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import me.shaohui.androidpractise.widget.gestureDetector.MoveGestureDetector;
import me.shaohui.androidpractise.widget.gestureDetector.RotateGestureDetector;

/**
 * Created by shaohui on 16/7/13.
 */
public class GestureView extends ImageView {

    private ScaleGestureDetector scaleGesture;
    private MoveGestureDetector moveGesture;
    private RotateGestureDetector rotateGesture;

    public GestureView(Context context) {
        this(context, null);
    }

    public GestureView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GestureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        scaleGesture = new ScaleGestureDetector(getContext(), new ScaleListener());
        moveGesture = new MoveGestureDetector(getContext(), new MovingListener());
        rotateGesture = new RotateGestureDetector(getContext(), new RotateListener());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        scaleGesture.onTouchEvent(event);
        moveGesture.onTouchEvent(event);
        rotateGesture.onTouchEvent(event);

        return true;
    }


    private class ScaleListener implements ScaleGestureDetector.OnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            setScaleX(detector.getScaleFactor() * getScaleX());
            setScaleY(detector.getScaleFactor() * getScaleY());

            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {

        }
    }

    private class MovingListener extends MoveGestureDetector.SimpleOnMoveGestureListener {
        @Override
        public boolean onMove(MoveGestureDetector detector) {

            setTranslationX(getTranslationX() + detector.getFocusDelta().x);
            setTranslationY(getTranslationY() + detector.getFocusDelta().y);

            return true;
        }
    }

    private class RotateListener extends RotateGestureDetector.SimpleOnRotateGestureListener {
        @Override
        public boolean onRotate(RotateGestureDetector detector) {

            setRotation(getRotation() - detector.getRotationDegreesDelta());

            return true;
        }
    }


}
