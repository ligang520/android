package com.example.ligang.imageswitch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * 设置文本分页效果
 */
public class MainActivity2 extends AppCompatActivity implements ViewSwitcher.ViewFactory,View.OnTouchListener{
    private TextSwitcher switcher;
    private String str[]={"命运何其艰难，唯有昂首向上","坚持往往可以改变许多东西","尽力而为与竭尽全力的区别"};
    private int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        switcher= (TextSwitcher) this.findViewById(R.id.textSwitcher);
        switcher.setOnTouchListener(this);//注册触摸事件
        switcher.setFactory(this);//注册工厂事件

    }

    @Override
    public View makeView() {
        TextView textView=new TextView(this);
        textView.setText(str[index]);
        textView.setTextSize(20);
        textView.setPadding(100,400,35,80);
        return textView;
    }
    float startx=0.0f;
    float endx=0.0f;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action =event.getAction();
        if(action==MotionEvent.ACTION_DOWN){
            startx=event.getX();
            return  true;
        }
        if(action==MotionEvent.ACTION_UP){
            if(startx-endx>20){
                index=index+1<str.length?++index:0;
                switcher.setInAnimation(this,android.R.anim.fade_in);
                switcher.setOutAnimation(this,android.R.anim.fade_out);
            }else if(startx-endx<20){
                index=index-1>=0?--index:str.length-1;
                switcher.setInAnimation(this,android.R.anim.fade_out);
                switcher.setOutAnimation(this,android.R.anim.fade_in);
            }
                switcher.setText(str[index]);

        }


        return true;
    }
}
