package com.blqy.scheduledemo.adpt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.blqy.scheduledemo.Bean.ScheInfo;
import com.blqy.scheduledemo.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wjy on 2015/10/22.
 *
 */
public class ScheListAdapter extends BaseAdapter {

    private List<ScheInfo> list;
    private Context context;

    public ScheListAdapter(List<ScheInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_sche_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvTitle.setText(list.get(position).getTitle());
        viewHolder.tvStartTime.setText(list.get(position).getStartTime());

        return convertView;
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_sche_list.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_startTime)
        TextView tvStartTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
