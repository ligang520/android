package com.example.ligang.programming_1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Spinner add;
    private DatePicker datePicker;
    private EditText editText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        datePicker=(DatePicker)this.findViewById(R.id.datePicker);
        editText=(EditText)this.findViewById(R.id.bird);
        add =(Spinner)this.findViewById(R.id.add);
        String address[]={"北京","上海","广东","深圳","长沙","成都","武汉","重庆"};
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,address);
        add.setAdapter(adapter);
    }


    public void time(View view){
        int year=datePicker.getYear();
        int month=datePicker.getMonth();
        int day=datePicker.getDayOfMonth();
        editText.setText(year+"年"+(month+1)+"月"+day+"日");
    }
    public void reg(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
        builder.setTitle("提示");
        builder.setMessage("确定注册么？");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(RegisterActivity.this, "亲，你不注册了么", Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(RegisterActivity.this, "亲，恭喜您注册^_^!!", Toast.LENGTH_LONG).show();

            }
        });
        builder.show();
    }

}
