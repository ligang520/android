package com.example.ligang.popumeun;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) this.findViewById(R.id.select);
    }

    public void select(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_main,popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(this);

    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.l:
                Toast.makeText(this,"您选择了L号",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.m:
                Toast.makeText(this,"您选择了M号",Toast.LENGTH_SHORT).show();
                break;
            case R.id.s:
                Toast.makeText(this,"您选择了S号", Toast.LENGTH_SHORT).show();
                break;
        }
        return  true;
    }
}