package com.example.nutrimeter.common.custom_view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;

import androidx.core.content.res.ResourcesCompat;

import com.example.nutrimeter.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PieChartFoodDetails extends PieChart {

    public PieChartFoodDetails(Context context) {
        super(context);
    }

    public PieChartFoodDetails(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PieChartFoodDetails(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @SuppressLint("ResourceType")
    public void configurePieChart(float calories, float proteins, float carbs, float fats) {
        ArrayList<PieEntry> entries = new ArrayList<>();
        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.

        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.CEILING);

        float caloriesFromProteins = proteins * 4;
        float caloriesFromCarbs = carbs * 4;
        float caloriesFromFats = fats * 9;

        float totalCalFromMacros = (caloriesFromProteins + caloriesFromCarbs + caloriesFromFats);

        //        binding.pieChart.configurePieChart(266, 11, 33 mov, 10); - 44 132 90
        entries.add(new PieEntry(caloriesFromFats/totalCalFromMacros,    df.format(fats) + " g fats ",  7      ));
        entries.add(new PieEntry(caloriesFromCarbs/totalCalFromMacros,  df.format(carbs) + " g carbs ",    3      ));
        entries.add(new PieEntry(caloriesFromProteins/totalCalFromMacros, df.format(proteins) + " g proteins ",     3      ));

        getLegend().setEnabled(false);
        getDescription().setEnabled(false);
        setRotationEnabled(true);
        setUsePercentValues(true);

        // entry label styling
        setEntryLabelColor(Color.WHITE);
        setEntryLabelTypeface(ResourcesCompat.getFont(getContext(), R.font.roboto_medium));
        setEntryLabelTextSize(16f);
        setDrawEntryLabels(false);

        setHoleRadius(70f);
        setHoleColor(getResources().getInteger(R.color.white));
        setTransparentCircleRadius(82f);
        setTransparentCircleColor(getResources().getInteger(R.color.white));
        setTransparentCircleAlpha(255);


        setCenterText(generateCenterText(df.format(calories)));
        setCenterTextColor(getResources().getInteger(R.color.colorTextLight));
        setCenterTextSize(18);
        setCenterTextTypeface(ResourcesCompat.getFont(getContext(), R.font.roboto_medium));

        setRotationAngle(0); //TODO

        PieDataSet dataSet = new PieDataSet(entries, "Macros");
        dataSet.setDrawIcons(false);
        dataSet.setDrawValues(false);

        dataSet.setSliceSpace(10f);
        dataSet.setSelectionShift(10f);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(getResources().getInteger(R.color.colorPrimary));
        colors.add(getResources().getInteger(R.color.colorAccent));
        colors.add(getResources().getInteger(R.color.Secondary));

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        //data.setValueFormatter(new PercentFormatter(this));
        //data.setValueTextSize(20f);
        //data.setValueTextColor(R.color.colorTextLight);
        //data.setValueTypeface(tfLight);
        this.setData(data);

    }

    @SuppressLint("ResourceType")
    private SpannableString generateCenterText(String calories) {
        SpannableString s = new SpannableString(calories + " Kcal\nEnergy");
        s.setSpan(new RelativeSizeSpan(2.3f), 0, calories.length(), 0);
        s.setSpan(new ForegroundColorSpan(getResources().getInteger(R.color.colorTextLight)), 3, s.length(), 0);
        s.setSpan(new CustomTypefaceSpan("", ResourcesCompat.getFont(getContext(), R.font.roboto_medium)), 3, s.length(), 0);
        s.setSpan(new CustomTypefaceSpan("", ResourcesCompat.getFont(getContext(), R.font.roboto_medium)), 0, calories.length(), 0);
        return s;
    }
}
