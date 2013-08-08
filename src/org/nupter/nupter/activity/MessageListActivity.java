package org.nupter.nupter.activity;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import org.json.JSONObject;
import org.nupter.nupter.R;
import org.nupter.nupter.data.MessageRecord;
import org.nupter.nupter.utils.Log;

import java.util.List;


public class MessageListActivity extends ListActivity {


    List<MessageRecord> messageRecordList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        String s = getIntent().getStringExtra("com.parse.Data");
        try {
            Log.d(s);
            JSONObject json = new JSONObject(s);
            MessageRecord record = new MessageRecord(this, "我是标题"  , json.getString("alert"));
            record.save();
        }catch (Exception e){

        }
        messageRecordList = MessageRecord.listAll(MessageRecord.class);
        setListAdapter(new MyAdapter(this));


    }


    //    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        String[] strs = {"学校化粪池沼气爆炸","装空调的梦泡汤啦","下学期学费上涨400%","南京明天最高气温50度，创历史新高","教务系统发现漏洞，所有学生成绩被清空"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strs);
//        setListAdapter(adapter);
//    }


    public final class ViewHolder{
        public TextView title;
        public TextView content;
    }


    public class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;


        public MyAdapter(Context context){
            this.mInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return messageRecordList.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return messageRecordList.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            if (convertView == null) {

                holder=new ViewHolder();

                convertView = mInflater.inflate(R.layout.item_message, null);
                holder.title = (TextView)convertView.findViewById(R.id.message_content);
                holder.content = (TextView)convertView.findViewById(R.id.message_content);
                convertView.setTag(holder);

            }else {

                holder = (ViewHolder)convertView.getTag();
            }

            holder.title.setText(messageRecordList.get(position).title);
            holder.content.setText(messageRecordList.get(position).content);



            return convertView;
        }

    }
}
