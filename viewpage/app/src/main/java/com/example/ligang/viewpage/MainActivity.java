package com.example.ligang.viewpage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;
    private String title[]={"春","夏","秋","冬"};
    private ArrayList <View>views=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) this.findViewById(R.id.viewpager);
        pagerTabStrip= (PagerTabStrip) this.findViewById(R.id.pagertab);
        intitviews();
        viewPager.setAdapter(new LgPagerADapter());

    }

    private void intitviews(){
        views.add(getLayoutInflater().inflate(R.layout.layout1,null));
        views.add(getLayoutInflater().inflate(R.layout.layou2, null));
        views.add(getLayoutInflater().inflate(R.layout.layout3,null));
        views.add(getLayoutInflater().inflate(R.layout.layout4,null));


    }
    class  LgPagerADapter extends PagerAdapter{
        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));//删除选项卡
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v=views.get(position);//实例化选项卡
            container.addView(v);
            return v;
        }

        @Override
        public CharSequence getPageTitle(int position) {//获取标题
            return title[position];
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
