package com.example.chemlleijoseph.myapplication;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.chemlleijoseph.myapplication.BaseActivity;
import com.example.chemlleijoseph.myapplication.R;
import com.example.chemlleijoseph.myapplication.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GestureActivity extends BaseActivity implements View.OnTouchListener{

    @BindView(R.id.activity_gesture_tv)
    TextView tv;
    private GestureDetector gestureDetector;
    private int sumX=0;
    private int sumY=0;
    private boolean isToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        ButterKnife.bind(this);
        gestureDetector = new GestureDetector(this,new simpleGestureListener());
        tv.setOnTouchListener(this);
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
    private  class simpleGestureListener extends
            GestureDetector.SimpleOnGestureListener{
        /***** onDown->onShowPress->onLongPress*****/
        boolean isToast = false;
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            UtilLog.d("Gesture","onSingleTapUp");
            return super.onSingleTapUp(e);
        }
        @Override
        public void onLongPress(MotionEvent e) {
            UtilLog.d("Gesture","onLongPress");
            super.onLongPress(e);
        }
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            UtilLog.d("Gesture","onScroll");
//            UtilLog.d("Gesture","distanceX:"+distanceX);
//            UtilLog.d("Gesture","distanceY:"+distanceY);
            sumX+=distanceX;
            sumY+=distanceY;
            if(!isToast){
                if(sumX<0){
                    if(Math.abs(sumX)>1000){
                        isToast = true;
                        shortToast("You scroll from left to right");
                    }
                }
                if(sumX>0){
                    if(Math.abs(sumX)>1000){
                        isToast = true;
                        shortToast("You scroll from right to left");
                    }
                }

                if(sumY<0){
                    if(Math.abs(sumY)>1000){
                        isToast = true;
                        shortToast("You scroll from top to bottom");
                    }
                }
                if(sumY>0){
                    if(Math.abs(sumY)>1000){
                        isToast = true;
                        shortToast("You scroll from bottom to top");
                    }
                }
            }


            return super.onScroll(e1, e2, distanceX, distanceY);
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            UtilLog.d("Gesture","onFling");

            return super.onFling(e1, e2, velocityX, velocityY);
        }
        @Override
        public void onShowPress(MotionEvent e) {
            UtilLog.d("Gesture","onShowPress");
            super.onShowPress(e);
        }
        @Override
        public boolean onDown(MotionEvent e) {
            UtilLog.d("Gesture","onDown");
            isToast=false;
            sumX=0;
            sumY=0;
            return super.onDown(e);
        }
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            UtilLog.d("Gesture","onDoubleTap");
            return super.onDoubleTap(e);
        }
        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            UtilLog.d("Gesture","onDoubleTapEvent");
            return super.onDoubleTapEvent(e);
        }
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            UtilLog.d("Gesture","onSingleTapConfirmed");
            return super.onSingleTapConfirmed(e);
        }
    }

}
