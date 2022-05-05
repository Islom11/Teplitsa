package com.example.greenhouses.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.greenhouses.R;

public class InfoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        /*
        LineChart chartTemperature = root.findViewById(R.id.temperatureChart);

        ArrayList<Entry> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            Entry entry = new Entry(i, (float) (Math.random() * 30));
            arrayList.add(entry);
        }

        LineDataSet lineDataSet = new LineDataSet(arrayList, "");
        lineDataSet.setCircleColors(ColorTemplate.MATERIAL_COLORS);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(16f);
        lineDataSet.setDrawFilled(true);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.chart_fill);
        lineDataSet.setFillDrawable(drawable);


        LineData lineData = new LineData(lineDataSet);
        chartTemperature.setData(lineData);
        chartTemperature.getDescription().setText("Temperature");
        chartTemperature.animateY(2000);

        ArrayList<BarEntry> visitors = new ArrayList<>();
        visitors.add(new BarEntry(1, 56));
        visitors.add(new BarEntry(2, 78));
        visitors.add(new BarEntry(3, 45));
        visitors.add(new BarEntry(4, 67));
        visitors.add(new BarEntry(5, 56));
        visitors.add(new BarEntry(6, 76));
        visitors.add(new BarEntry(7, 98));

        BarDataSet barDataSet = new BarDataSet(visitors, "");
//        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
//
        BarData barData = new BarData(barDataSet);
        BarChart chartHumdity = root.findViewById(R.id.humdtyChart);
        chartHumdity.setData(barData);
        chartHumdity.getDescription().setText("Humdty");
        chartHumdity.animateX(1500);

        root.findViewById(R.id.temperatureInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new DataFragment(getTemperature(), getString(R.string.tempurature));
                openFragment(fragment);
            }
        });


        root.findViewById(R.id.humdtyInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new DataFragment(getHumdty(),getString(R.string.humdty));
                openFragment(fragment);
            }
        });

        root.findViewById(R.id.cameraInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] cameras = {R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5};
                Fragment fragment = new DataFragment(cameras,getString(R.string.camera));
                openFragment(fragment);
            }
        });

        AnyChartView anyChartView = root.findViewById(R.id.anychart);

        Cartesian areaChart = AnyChart.area();
        areaChart.setAnimation(true);

        Crosshair crosshair = areaChart.getCrosshair();
        crosshair.setEnabled(true);
        crosshair.setYStroke((Stroke) null,null,null,null,null)
                .setXStroke((Stroke) null,null,null,null,null)
                .setZIndex(39d);
        crosshair.setYLabel(false).setEnabled(true);
        areaChart.getYScale().setStackMode(ScaleStackMode.VALUE);
        areaChart.setTitle("Temperature");

        List<DataEntry> seriesDAta = new ArrayList<>();
//        for (int i = 0; i < 10; ++i) {
//            CustomDataEntry dataEntry = new CustomDataEntry("14:05:00",17.14219341);
////            dataEntry.setValue("14:05:00",17.14219341);
//            seriesDAta.add(dataEntry);
//        }
        seriesDAta.add(new CustomDataEntry("14:05:00",17.14219341));
        seriesDAta.add(new CustomDataEntry("14:10:00",16.84280586));
        seriesDAta.add(new CustomDataEntry("14:05:00",17.14219341));
        seriesDAta.add(new CustomDataEntry("14:15:00",	16.5611692));
        seriesDAta.add(new CustomDataEntry("14:20:00",	16.29886691));
        seriesDAta.add(new CustomDataEntry("14:25:00",	16.05737373));
        seriesDAta.add(new CustomDataEntry("14:30:00",	15.83804743));
        seriesDAta.add(new CustomDataEntry("14:35:00",	15.64212114));
        seriesDAta.add(new CustomDataEntry("14:40:00",	15.47069643));
        Set set = new Set();
        areaChart.setData(seriesDAta);
        anyChartView.setChart(areaChart);


         */
        return root;
    }

    /*
    private List<CombinedData> getTemperature() {
        List<CombinedData> combinedData = new ArrayList<>();
        for (int j = 0; j < 5; ++j) {
            ArrayList<Entry> arrayList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Entry entry = new Entry(i, (float) (Math.random() * 30));
                arrayList.add(entry);
            }

            Entry entry3 = new Entry(10.00f, 20.37464854f);
            arrayList.add(entry3);
            Entry entry2 = new Entry(10.05f, 20.74719066f);
            arrayList.add(entry2);
            LineDataSet lineDataSet = new LineDataSet(arrayList, "");
            lineDataSet.setCircleColors(ColorTemplate.MATERIAL_COLORS);
            lineDataSet.setValueTextColor(Color.BLACK);
            lineDataSet.setValueTextSize(16f);
            lineDataSet.setDrawFilled(true);
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.chart_fill);
            lineDataSet.setFillDrawable(drawable);

            LineData lineData = new LineData(lineDataSet);
            CombinedData data = new CombinedData();
            data.setData(lineData);
            combinedData.add(data);
        }
        return combinedData;
    }
    private List<CombinedData> getHumdty() {
        List<CombinedData> combinedData = new ArrayList<>();
        for (int j = 0; j < 5; ++j) {
            ArrayList<BarEntry> arrayList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                BarEntry entry = new BarEntry(i, (float) (Math.random() * 100));
                arrayList.add(entry);
            }

            BarDataSet barDataSet = new BarDataSet(arrayList, "");
            barDataSet.setValueTextColor(Color.BLACK);
            barDataSet.setValueTextSize(16f);
//
            BarData barData = new BarData(barDataSet);
            CombinedData data = new CombinedData();
            data.setData(barData);
            combinedData.add(data);
        }
        return combinedData;
    }

    void openFragment(Fragment fragment){
        assert getActivity() != null;
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, fragment)
                .addToBackStack("InfoFragment")
                .commit();
    }

    private class CustomDataEntry extends ValueDataEntry{

        public CustomDataEntry(String x, Double value) {
            super(x, value);
        }
    }

     */
}
