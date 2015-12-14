package com.example.ligang.spinner;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner_city;
    private AutoCompleteTextView autoCompleteTextView;
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) this.findViewById(R.id.button);
        textView=(TextView)this.findViewById(R.id.textView);

        spinner_city=(Spinner)this.findViewById(R.id.spinner_city);
        autoCompleteTextView= (AutoCompleteTextView) this.findViewById(R.id.autoCompleteTextView);
        //定义一个适配器来autoCompleteTextView做和City_1之间的数据转换
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,R.array.city,android.R.layout.simple_dropdown_item_1line);
       autoCompleteTextView.setAdapter(adapter1);
        //定义一个适配器来做list和spinner_city之间的数据转换
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,android.R.id.text1,getDateResources());
        spinner_city.setAdapter(adapter);
    }

    public void setTimeValue(int hour,int minute){
       textView.setText(hour+":"+minute);

    }
    /**
     * 设置时间对话框
     */
    public void show_5(View v){
        DialogFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.show(getFragmentManager(),"timePicker");
    }

    /**
     * 自定义对话框
     */

    public void show_4(View v){
        AlertDialog.Builder dialog2=new AlertDialog.Builder(this);
        dialog2.setTitle("用户登录");
        final View view=getLayoutInflater().inflate(R.layout.layout2,null);//将xml文件绑定到view视图中
        dialog2.setView(view);//将view视图加载到dialog2对话框中
       // dialog2.setView(R.layout.layout2);

        dialog2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               EditText edit_users= (EditText) view.findViewById(R.id.edit_user);
               EditText edit_password= (EditText) view.findViewById(R.id.edit_password);
               Toast.makeText(MainActivity.this,edit_users.getText().toString()+"----"+edit_password.getText().toString(),Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }

        });
        dialog2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog2.show();

    }
    /**
     * 自定义多选框
     */

    public  void show_3 (View v){
        AlertDialog.Builder dialog2=new AlertDialog.Builder(this);
        final String[] items = {"java", "IOS", "Android", "C++", "C#"};
        final List<String>list=new ArrayList<String>();
        dialog2.setTitle("开发语言");
        dialog2.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    list.add(items[which]);
                } else list.remove(items[which]);
            }
        });
        dialog2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, list.toString(), Toast.LENGTH_LONG).show();
                dialog.dismiss();
                list.clear();

            }

        });
        dialog2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog2.show();

    }
    /**
     * 自定义列表对话框
     */
    public void show_2(View v1){
        AlertDialog.Builder dialog2=new AlertDialog.Builder(this);
        dialog2.setTitle("开发语言");

        final String items[]={"java","IOS","Android","C++","C#"};
       dialog2.setItems(items, new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               Toast.makeText(MainActivity.this,items[which]+"非常好",Toast.LENGTH_LONG).show();
           }
       });
        dialog2.show();


    }
    /**
     * 设置自定义对话框
     * @param v
     */
    public void show_1(View v){
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("用户注册");
        dialog.setMessage("你注册了账户么？？");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setPositiveButton("注册了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "欢迎使用", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("没有注册", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "请注册", Toast.LENGTH_LONG).show();
            }
        });
            dialog.show();

    }
    /*
    设置进度条
     */
    public void showDialog(View v){

        ProgressDialog pd=new ProgressDialog(this);
        pd.setTitle("下载进度条");//设置进度条的标题
        pd.setMessage("loading......");//设置进度条的内容
        pd.setSecondaryProgress(50);//设置第二进度条
        pd.setCancelable(false);//设置是否能被取消，，默认是能被取消的
       // pd.setIndeterminate(false);
        pd.setMax(100);//设置进度条的最大值
        pd.setProgress(25);//设置进度条的步长值
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//设置进度条的样式
        pd.show();

    }
    /**
     * 定义一个list集合用来装下拉列表中所要用到的数据
     * @return
     */
    public List<String> getDateResources(){
        List<String>list=new ArrayList<String>();
        list.add("QQ.com");
        list.add("163.com");
        list.add("10086.com");
        list.add("wangyi.com");
        list.add("ali.com");
        list.add("ligang.com");
        return  list;

    }
    public  List<String> Datesource(){
        List<String>list=new ArrayList<String>();
        list.add("android");
        list.add("IOS");
        list.add("java");
        list.add("pythn");
        list.add("c++");
        list.add("c#");
        return list;



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
