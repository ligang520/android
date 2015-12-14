package com.example.ligang.imageswitch;

import android.app.ActionBar;
import android.app.usage.UsageEvents;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity3 extends ActionBarActivity {
    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        viewFlipper=(ViewFlipper)this.findViewById(R.id.viewFlipper);

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
