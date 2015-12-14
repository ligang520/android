package com.example.ligang.viewflipper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper= (ViewFlipper) this.findViewById(R.id.viewFlipper);

    }
    float startx=0,endx=0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action =event.getAction();
        if(action==event.ACTION_DOWN){
            startx=event.getX();
        }else if(action==event.ACTION_UP){
            if(startx>endx){
                viewFlipper.setInAnimation(this,android.R.anim.fade_in);
                viewFlipper.setInAnimation(this,android.R.anim.fade_out);
                viewFlipper.showNext();
            }else if(endx>startx){
                viewFlipper.setInAnimation(this,android.R.anim.fade_out);
                viewFlipper.setInAnimation(this,android.R.anim.fade_in);
                viewFlipper.showPrevious();
            }
        }
        return super.onTouchEvent(event);
    }
}
