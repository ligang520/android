package com.example.ligang.helloworld;

import android.graphics.LinearGradient;
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

public class MainActivity extends AppCompatActivity {
private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public  void ViewText(View view){
        Toast toast1=new Toast(this);
        TextView textView=new TextView(this);
        textView.setText("世界那么大我想去看看");
        toast1.setView(textView);
        toast1.setDuration(Toast.LENGTH_LONG);
        toast1.setGravity(Gravity.TOP, 20, 15);
        toast1.show();
        //Toast.makeText(getApplicationContext(),"世界那么大我想去看看！！",Toast.LENGTH_LONG).show();

    }
    public  void ViewImage(View view){
        Toast toast=new Toast(this);
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(R.drawable.cat);
        toast.setView(imageView);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 10, 10);
        toast.show();

    }
    public void txt(View view){
        Toast toast=new Toast(this);
        TextView textView=new TextView(this);
        textView.setText("世界你好");
        ImageView imageView= new ImageView(this);
        imageView.setImageResource(R.drawable.cat);
        LinearLayout layout= new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER);
        layout.addView(imageView);
        layout.addView(textView);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
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
}
