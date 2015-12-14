package com.example.ligang.date;

import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private TimePicker timePicker;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)this.findViewById(R.id.textView);
        timePicker=(TimePicker)this.findViewById(R.id.timePicker);

    }
   public void setTime(View view){
        int hour=timePicker.getCurrentHour();
        int minute=timePicker.getCurrentMinute();
        Toast.makeText(this,hour+":"+minute,Toast.LENGTH_LONG).show();

    }
      public void onDate(View view){
          DialogFragment dialogFragment=new DateFragmentPicker();
          dialogFragment.show(getFragmentManager(),"date");
      }
   public void setDate(int year,int month,int day){
      textView.setText(year+"年"+(month+1)+"月"+day+"日");
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
