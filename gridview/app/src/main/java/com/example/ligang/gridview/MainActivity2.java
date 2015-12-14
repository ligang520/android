package com.example.ligang.gridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        gridView=(GridView)this.findViewById(R.id.gridView2);
        gridView.setAdapter(new Lg1Adapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {//设置一个按钮的监听事件，从而获取到每个按钮的反应
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView=(TextView)view.findViewById(R.id.textView);
                Toast.makeText(MainActivity2.this,"我是"+textView.getText(),Toast.LENGTH_LONG).show();
            }
        });

    }
    static  class Lg1Adapter extends BaseAdapter{
        private  String[] names={"游戏","商城","购物","娱乐","KTV","餐厅","外卖","消息","帮助"};
        private int [] images={R.mipmap.ic_launcher,R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher};

        public Context context;

        public Lg1Adapter(Context context){
            this.context=context;
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=LayoutInflater.from(context);
            View view=inflater.inflate(R.layout.items,null);
            ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
            TextView textView=(TextView)view.findViewById(R.id.textView);
            imageView.setImageResource(images[position]);
            textView.setText(names[position]);
            return view;
        }
    }
}
