package com.example.ligang.menue;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(0,100,1,"start");
        menu.add(0,101,2,"set");
        menu.add(0,102,3,"exit");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id){
            case 100:
                Toast.makeText(this,"开始",Toast.LENGTH_SHORT).show();
                break;
            case 101:
                Toast.makeText(this,"设置",Toast.LENGTH_SHORT).show();
                break;
            case 102:
                Toast.makeText(this,"退出",Toast.LENGTH_SHORT).show();
                break;
            /*case R.id.set:
                Toast.makeText(this,"设置菜单",Toast.LENGTH_SHORT).show();
                break;

            case R.id.exit:
                Toast.makeText(this,"开始菜单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.start:
                Toast.makeText(this,"退出菜单",Toast.LENGTH_SHORT).show();
                break;*/
        }


        return super.onOptionsItemSelected(item);
    }
}
