package com.example.alex.stormy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.stormy.R;
import com.example.alex.stormy.weather.Day;

import org.w3c.dom.Text;

public class DayAdapter extends BaseAdapter {

    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days) {
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0; // Not used in this project. Tag items for easy reference
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            //brand new
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.imgTempCircle = (ImageView) convertView.findViewById(R.id.circleImageView);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.temperatureLabel);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Day day  = mDays[position];
        holder.iconImageView.setImageResource(day.getIconId());
        holder.imgTempCircle.setImageResource(R.drawable.bg_temperature);
        holder.temperatureLabel.setText(day.getTemperatureMax() + "");

        if(position == 0)
            holder.dayLabel.setText("Today");
        else
            holder.dayLabel.setText(day.getDayOfTheWeek());

        return convertView;
    }

    public static class ViewHolder {
        public ImageView iconImageView, imgTempCircle;
        public TextView temperatureLabel, dayLabel;
    }
}
