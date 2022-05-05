package com.example.greenhouses.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.greenhouses.App;
import com.example.greenhouses.R;
import com.example.greenhouses.adapter.TemperatureMainAdapter;
import com.example.greenhouses.data.Data;
import com.example.greenhouses.data.Temperature;

import java.util.ArrayList;
import java.util.List;

public class TemperatureFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tempruture, container, false);

        root.findViewById(R.id.back)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().onBackPressed();
                    }
                });

        List<List<Temperature>> lists = new ArrayList<>();


        List<Temperature> temUp = new ArrayList<>();
        List<Temperature> temDown = new ArrayList<>();
        List<Temperature> temGround = new ArrayList<>();
        List<Temperature> temStreet = new ArrayList<>();

        List<Data> dataList = App.getInstance().getDataBase().dataDao().getAll();
        for (Data data : dataList) {
            temUp.add(new Temperature(data.getIdDB(),data.getTempUpsta(),data.getDate(),data.getTime()));
            temDown.add(new Temperature(data.getIdDB(),data.getTempDowns(),data.getDate(),data.getTime()));
            temGround.add(new Temperature(data.getIdDB(),data.getTempGround(),data.getDate(),data.getTime()));
            temStreet.add(new Temperature(data.getIdDB(),data.getTempStreet(),data.getDate(),data.getTime()));
        }

        lists.add(temUp);
        lists.add(temDown);
        lists.add(temGround);
        lists.add(temStreet);

//        for (int i = 0; i < 5; ++i) {
//            List<Temperature> temps = new ArrayList<>();
//            for (int j = 0; j < 10; ++j) {
//                temps.add(new Temperature());
//            }
//            lists.add(temps);
//        }

        TemperatureMainAdapter adapter = new TemperatureMainAdapter(lists, getContext());

        RecyclerView recyclerView = root.findViewById(R.id.recTemp);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        /*
        CombinedChart chart = root.findViewById(R.id.chart);

        ArrayList<BarEntry> visitors = new ArrayList<>();
        visitors.add(new BarEntry(2014, 420));
        visitors.add(new BarEntry(2015, 240));
        visitors.add(new BarEntry(2016, 520));
        visitors.add(new BarEntry(2017, 520));
        visitors.add(new BarEntry(2018, 250));
        visitors.add(new BarEntry(2019, 320));
        visitors.add(new BarEntry(2020, 240));

        BarEntry barEntry = new BarEntry(2020, 240);

        BarDataSet barDataSet = new BarDataSet(visitors, "Vissitiors");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
//
        BarData barData = new BarData(barDataSet);
//        chart.setFitBars(true);
//        chart.setData(barData);
//        chart.getDescription().setText("Bar Chart Example");
//        chart.animateY(2000);

        ArrayList<Entry> arrayList = new ArrayList<>();
        for (int i=0; i< 10; i++) {

            Entry entry = new Entry(i, (float) (Math.random() * 30));
            arrayList.add(entry);
        }

        LineDataSet lineDataSet = new LineDataSet(arrayList,"temperatura");
        lineDataSet.setCircleColors(ColorTemplate.MATERIAL_COLORS);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(16f);
        lineDataSet.setDrawFilled(true);
        Drawable drawable = ContextCompat.getDrawable(getContext(),R.drawable.chart_fill);
        lineDataSet.setFillDrawable(drawable);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
////            lineDataSet.setFillDrawable(getResources().getDrawable(R.drawable.chart_fill));
//        }
//        lineDataSet.setFillColor(Color.YELLOW);
//
//        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
//        lineDataSet.setColor(ColorTemplate.getHoloBlue());
//        lineDataSet.setCircleColor(Color.WHITE);
//        lineDataSet.setLineWidth(2f);
//        lineDataSet.setCircleRadius(3f);
//        lineDataSet.setFillAlpha(65);
//        lineDataSet.setFillColor(ColorTemplate.getHoloBlue());
//        lineDataSet.setHighLightColor(Color.rgb(244, 117, 117));
//        lineDataSet.setDrawCircleHole(false);


        LineData lineData = new LineData(lineDataSet);

        CombinedData combinedData = new CombinedData();
        combinedData.setData(lineData);
//        combinedData.setData(barData);

        chart.setData(combinedData);
        chart.getDescription().setText("Temperature");
        chart.animateY(2000);
//        chart.setDrawGridBackground(false);
//        chart.setBackgroundColor(Color.YELLOW);
//        chart.setDragDecelerationFrictionCoef(0.9f);
//        chart.setDragEnabled(true);
//        chart.setScaleEnabled(true);
//        chart.setDrawGridBackground(false);
//        chart.setHighlightPerDragEnabled(true);

//        seekBarX.setProgress(20);
//        seekBarY.setProgress(30);
//        chart.animateX(1500);

        // get the legend (only possible after setting data)
//        Legend l = chart.getLegend();

        // modify the legend ...
//        l.setForm(Legend.LegendForm.LINE);
////        l.setTypeface(tfLight);
//        l.setTextSize(11f);
//        l.setTextColor(Color.WHITE);
//        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
//        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
//        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
//        l.setDrawInside(false);
////        l.setYOffset(11f);
//
//        XAxis xAxis = chart.getXAxis();
////        xAxis.setTypeface(tfLight);
//        xAxis.setTextSize(11f);
//        xAxis.setTextColor(Color.WHITE);
//        xAxis.setDrawGridLines(false);
//        xAxis.setDrawAxisLine(false);
//
//        YAxis leftAxis = chart.getAxisLeft();
////        leftAxis.setTypeface(tfLight);
//        leftAxis.setTextColor(ColorTemplate.getHoloBlue());
//        leftAxis.setAxisMaximum(200f);
//        leftAxis.setAxisMinimum(0f);
//        leftAxis.setDrawGridLines(true);
//        leftAxis.setGranularityEnabled(true);
//
//        YAxis rightAxis = chart.getAxisRight();
////        rightAxis.setTypeface(tfLight);
//        rightAxis.setTextColor(Color.RED);
//        rightAxis.setAxisMaximum(900);
//        rightAxis.setAxisMinimum(-200);
//        rightAxis.setDrawGridLines(false);
//        rightAxis.setDrawZeroLine(false);
//        rightAxis.setGranularityEnabled(false);

         */

        return root;
    }

}
