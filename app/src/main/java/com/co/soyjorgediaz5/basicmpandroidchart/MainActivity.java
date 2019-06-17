package com.co.soyjorgediaz5.basicmpandroidchart;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PieChart pieChart;
    private List<PieEntry> yValues;
    private PieDataSet dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setPieChart();
        setValues();
        setDataSet();
        setPieData();
        setChartDescription();
    }

    private void setChartDescription() {
        Description description = new Description();
        description.setText("Algunos participantes del torneo");
        description.setTextSize(15);
        pieChart.setDescription(description);
    }

    private void setPieData() {
        PieData pieData = new PieData(dataSet);
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(Color.BLACK);
        pieChart.setData(pieData);
    }

    private void setDataSet() {
        dataSet = new PieDataSet(yValues, "");
        dataSet.setValueFormatter(new PercentFormatter(pieChart));
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
    }

    private void setValues() {
        yValues = new ArrayList<>();
        yValues.add(new PieEntry(44.5f, "Colombia"));
        yValues.add(new PieEntry(15f, "Argentina"));
        yValues.add(new PieEntry(20.5f, "Chile"));
        yValues.add(new PieEntry(7.5f, "Perú"));
        yValues.add(new PieEntry(12.5f, "Venezuela"));
    }

    private void setPieChart() {
        pieChart = findViewById(R.id.pie_chart);
        pieChart.setUsePercentValues(true);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.15f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.animateY(1000, Easing.EaseInOutCubic);
        pieChart.setEntryLabelColor(Color.BLACK);
    }
}
