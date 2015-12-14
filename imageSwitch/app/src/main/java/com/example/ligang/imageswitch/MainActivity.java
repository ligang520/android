package com.example.ligang.imageswitch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
/**
 * 设置图片分页效果
 */
public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory,View.OnTouchListener{
    private ImageSwitcher imageSwitcher;
    private int imgs[]={R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,R.mipmap.e};
    private int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher= (ImageSwitcher) this.findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(this);
        imageSwitcher.setOnTouchListener(this);
    }

    @Override
    public View makeView() {
        ImageView imageView=new ImageView(this);
       imageView.setImageResource(imgs[0]);//设置图片

        return imageView;
    }
    //触屏事件

    float startx=0.0f;
    float ednx=0.0f;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action=event.getAction();//获取当前动作
        if(action==MotionEvent.ACTION_DOWN) {//获取当前触摸屏的位置
            startx = event.getX();
            return true;
        }
        if(action==MotionEvent.ACTION_UP){//获取离开的位置
            ednx=event.getX();
            if(startx-ednx>20){
                index=index+1<imgs.length?++index:0;
                imageSwitcher.setInAnimation(this,android.R.anim.fade_in);
                imageSwitcher.setOutAnimation(this, android.R.anim.fade_out);
            }else if(startx-ednx<20) {
                index = index -1 >= 0 ? --index : imgs.length-1;
                imageSwitcher.setInAnimation(this,android.R.anim.fade_out);
                imageSwitcher.setOutAnimation(this,android.R.anim.fade_in);
            }
            imageSwitcher.setImageResource(imgs[index]);

        }
        return true;
    }
}
