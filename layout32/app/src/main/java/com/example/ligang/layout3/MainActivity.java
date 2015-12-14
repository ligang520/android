package com.example.ligang.layout3;

import android.media.Rating;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity  implements CompoundButton.OnCheckedChangeListener{
    private CheckBox checkBox1,checkBox2,checkBox3;
    private RadioButton radioButton1,radioButton2;
    private ToggleButton toggleButton;
    private Switch aSwitch;
    private RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox1=(CheckBox)this.findViewById(R.id.checkBox1);
        checkBox2=(CheckBox)this.findViewById(R.id.checkBox2);
        checkBox3=(CheckBox)this.findViewById(R.id.checkBox3);
        radioButton1=(RadioButton)this.findViewById(R.id.radioButton);
        radioButton2=(RadioButton)this.findViewById(R.id.radioButton2);
        toggleButton=(ToggleButton)this.findViewById(R.id.toggleButton);
        ratingBar=(RatingBar)this.findViewById(R.id.ratingBar);
        aSwitch=(Switch)this.findViewById(R.id.switch1);
        //Switch和ToggleButton按钮用CompoundButton.onCheckedChangeListener()
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,"开关闭",Toast.LENGTH_LONG).show();
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,"off/on",Toast.LENGTH_LONG).show();
            }
        });
        //RatingBar按钮用RatingBar.OnRatingBarChangeListener()
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    if(fromUser){
                        Toast.makeText(MainActivity.this,"rating="+rating,Toast.LENGTH_LONG).show();
                    }
                }
            });
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        /**
         * 复选/单选按钮的点击事件用CompoundButton.onCheckedChangeListener()
         * 复选按钮的点击事件用CompoundButton.onCheckedChangeListener()
         * 复选按钮的点击事件用CompoundButton.onCheckedChangeListener()
         */
        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,"男人",Toast.LENGTH_LONG).show();

            }
        });
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,"女人",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.checkBox1:
                Toast.makeText(this,"1号复选框",Toast.LENGTH_LONG).show();
                break;
            case R.id.checkBox2:
                Toast.makeText(this,"2号复选框",Toast.LENGTH_LONG).show();
                break;
            case R.id.checkBox3:
                Toast.makeText(this,"3号复选框",Toast.LENGTH_LONG).show();
                break;
        }

    }
}
