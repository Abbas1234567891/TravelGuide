package com.tcs.travelguidefinalcode;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1256088 on 6/29/2016.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    List<WeatherReport> weatherReports=new ArrayList<>();

    public DataAdapter(List<WeatherReport> weatherReports) {
        this.weatherReports = weatherReports;
    }





    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.mName.setText(weatherReports.get(position).getName());
        holder.mTemp.setText(String.valueOf(weatherReports.get(position).getTemperature()));
        holder.mUpdate.setText(weatherReports.get(position).getUpdatedOn());
        holder.mIcon.setImageResource(R.drawable.raining);
        

    }

    @Override
    public int getItemCount() {
        return weatherReports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mName;
        private TextView mTemp;
        private TextView mUpdate;
        private ImageView mIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.textView);
            mTemp = (TextView) itemView.findViewById(R.id.textView2);
            mUpdate = (TextView) itemView.findViewById(R.id.textView3);

            mIcon = (ImageView) itemView.findViewById(R.id.imageButton);


        }
    }
}
