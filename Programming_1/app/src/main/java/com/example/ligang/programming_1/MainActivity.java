package com.example.ligang.programming_1;
/**
注册登录界面
*/
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button login;
    private EditText password;
    private AutoCompleteTextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)this.findViewById(R.id.button);
        user=(AutoCompleteTextView)this.findViewById(R.id.editText);
        password=(EditText)this.findViewById(R.id.editText2);
        /**
         * 这两种设置适配器的方式都可以，用xml文件时如果是数字要加""
         */
        String[] yonghu={"111255","185222","135875","1125487"};
        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.yonghu,android.R.layout.simple_dropdown_item_1line);
        //ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,yonghu);
        user.setAdapter(adapter);

    }

    /**
     * 下面是那几个事件
     * @param view
     */
    public void Jizhu(View view){

        Toast.makeText(this,"记住密码",Toast.LENGTH_LONG).show();
    }
    public void Find(View view){
        Toast.makeText(this,"找回密码",Toast.LENGTH_LONG).show();

    }
    public void Reg(View view){
        ProgressDialog pd=new ProgressDialog(this);
        pd.setMax(100);
        pd.setProgress(50);
        pd.setTitle("注册");
        pd.setMessage("loading......");
        pd.show();
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
        pd.dismiss();


    }
    public void Zidong(View view){

        Toast.makeText(this,"以后就自动登录了",Toast.LENGTH_LONG).show();
    }

    public void Login(View view){
        Editable userText= (Editable) user.getText();//EditText中的值要用Editable类型来接收
        Editable passText= (Editable) password.getText();
        String user1=userText.toString();
        String pass1=passText.toString();
            if(user1.isEmpty()||pass1.isEmpty()) {//判断用户名与密码是否为空
                Toast.makeText(this, "请输入账户名或密码", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this, "用户名：" + user1 + "\n" + "密码：" + pass1+"登录成功", Toast.LENGTH_LONG).show();
            }


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
