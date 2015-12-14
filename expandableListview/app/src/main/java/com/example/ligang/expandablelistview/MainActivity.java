package com.example.ligang.expandablelistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private ExpandableListView listview;
    private String[] group_title={"帅哥","美女"};
    private String[][] child_title={{"小明1号","小明2号","小明3号"},{"小红1号","小红2号","小红3号"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview= (ExpandableListView) this.findViewById(R.id.expandableListView_group);
        listview.setAdapter(new LgAdapetr(this));
        listview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this,child_title[groupPosition][childPosition].toString(),Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    static class  LgAdapetr extends BaseExpandableListAdapter{//实现二级分组的滑动
        private String[] group_title={"帅哥","美女"};
        private String[][] child_title={{"小明1号","小明2号","小明3号"},{"小红1号","小红2号","小红3号"}};
        private Context context;
        public LgAdapetr (Context context){
            this.context=context;
        }

        @Override
        public int getGroupCount() {
            return group_title.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return child_title[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return group_title[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return child_title[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            viewHold vh_1;
            if(convertView==null){
                LayoutInflater inflater=LayoutInflater.from(context);
                convertView=inflater.inflate(R.layout.layout_items_group,null);
                vh_1=new viewHold();
                vh_1.vh= (ImageView) convertView.findViewById(R.id.image);
                vh_1.th= (TextView) convertView.findViewById(R.id.title);
                convertView.setTag(vh_1);
            }else{
                vh_1=(viewHold)convertView.getTag();
            }
            vh_1.th.setText(group_title[groupPosition]);


            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
           viewHold vh_2;
            if(convertView==null){
                LayoutInflater inflater=LayoutInflater.from(context);
                          convertView=inflater.inflate(R.layout.layout_items_child,null);
                            vh_2=new viewHold();
                            vh_2.vh= (ImageView) convertView.findViewById(R.id.image_child);
                            vh_2.th= (TextView) convertView.findViewById(R.id.title_child);
                            convertView.setTag(vh_2);
                        }else{
                            vh_2=(viewHold)convertView.getTag();
                            }
                    vh_2.th.setText(child_title[groupPosition][childPosition]);


            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {

            return true;
        }


        static  class  viewHold{
            ImageView vh;
            TextView th;
        }
    }

}
