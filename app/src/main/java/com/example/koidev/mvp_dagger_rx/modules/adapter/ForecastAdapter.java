package com.example.koidev.mvp_dagger_rx.modules.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.koidev.mvp_dagger_rx.R;
import com.example.koidev.mvp_dagger_rx.mvp.model.Forecast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author KoiDev
 * @email DevSteelKoi@gmail.com
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.Holder> {

    private LayoutInflater mLayoutInflater;
    private List<Forecast> mForecastList = new ArrayList<>();

    public ForecastAdapter(LayoutInflater inflater) {
        mLayoutInflater = inflater;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.list_item_forecast_data, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind(mForecastList.get(position));
    }

    @Override
    public int getItemCount() {
        return mForecastList.size();
    }

    public void addForecast(List<Forecast> forecasts) {
        mForecastList.addAll(forecasts);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_forecast_timedate) TextView timedate;
        @BindView(R.id.txt_forecast_forecast) TextView forecastTxt;
        @BindView(R.id.txt_forecast_game) TextView game;
        @BindView(R.id.forecast_txt_about) TextView about;
        @BindView(R.id.cv_forecast) CardView cv_forecast;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Forecast forecast) {
            timedate.setText(forecast.getDate());
            game.setText(forecast.getCommand());
            forecastTxt.setText(forecast.getOdds());
            about.setVisibility(View.GONE);
            cv_forecast.setBackgroundResource(R.color.white);
        }
    }
}
