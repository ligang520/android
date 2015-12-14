package com.example.ligang.linearlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 绑定事件的三种方法（1）在xml文件中设置一个点击事件，然后在MainActivity中实现点击的事件就ok
 *                （2）用内部内的方法实现事件的绑定，先在MainActivity声明一个按钮，再注册事件，
 *                    最后实现OnClickListener内部内中的OnClicker方法
 *                （3）实现View.OnClickListener接口中的onClik方法
 *                <--!加载图片作为按钮在xml文件中用 android:drawableLeft="@drawable/cat"属性，可以控制图片加载位于哪个位置-->
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button button4,button5,button6,button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button4=(Button)this.findViewById(R.id.button4);
        button5=(Button)this.findViewById(R.id.button5);
        button6=(Button)this.findViewById(R.id.button6);
        button7=(Button)this.findViewById(R.id.button7);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"button7",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void ViewText(View view){//单独显示文本
        Toast.makeText(this,"世界你好，世界晚安！",Toast.LENGTH_LONG).show();
    }

    public void  ViewImage(View view){//显示图像
        Toast toast=new Toast(this);
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(R.drawable.cat);
        toast.setView(imageView);
        toast.show();
    }

    public  void  txt(View view){//增加图文混合显示
        LinearLayout layout=new LinearLayout(this);
        ImageView imageView=new ImageView(this);
        Toast toast=new Toast(this);
        TextView textView=new TextView(this);
        textView.setText("草泥马，一群草泥马呼啸而过！！！！！！！！！！！！！");
        imageView.setImageResource(R.drawable.cat);
        layout.addView(imageView);
        layout.addView(textView);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 10, 20);
        toast.show();
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
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.button4:
                Toast.makeText(MainActivity.this,"button4",Toast.LENGTH_LONG).show();
                break;
            case R.id.button5:
                Toast.makeText(MainActivity.this,"button5",Toast.LENGTH_LONG).show();
                break;
            case R.id.button6:
                Toast.makeText(MainActivity.this,"button6",Toast.LENGTH_LONG).show();
                break;


        }


    }
}
