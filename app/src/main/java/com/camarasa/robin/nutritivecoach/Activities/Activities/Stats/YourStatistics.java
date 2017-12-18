package com.camarasa.robin.nutritivecoach.Activities.Activities.Stats;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.WelcomeActivity;
import com.camarasa.robin.nutritivecoach.Activities.Model.Objectif;
import com.camarasa.robin.nutritivecoach.Activities.Model.User;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.ConnectionToTheCoach;
import com.camarasa.robin.nutritivecoach.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.renderer.XAxisRenderer;

import java.util.ArrayList;
import java.util.List;

public class YourStatistics extends AppCompatActivity {

    public LineChart line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_statistics);

        ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
        connectionToTheCoach.getGraph(getApplicationContext(), User.getId(), this);

    }

    public void graph(List<Float> floats) {

        List<Entry> t = new ArrayList<>();
        List<Entry> weightcurve = new ArrayList<>();
        List<Entry> objectif = new ArrayList<>();
        float min = floats.get(0).floatValue();
        float max = floats.get(0).floatValue();
        for (int i = 0 ; i < floats.size() ; i++) {
            t.add(new Entry(i,i));
            weightcurve.add(new Entry(i,floats.get(i).floatValue()));
            objectif.add(new Entry(i, Objectif.getValue().floatValue()));
            if (floats.get(i).floatValue() > max) {
                max = floats.get(i).floatValue();
            }
            if (floats.get(i).floatValue() < min) {
                min = floats.get(i).floatValue();
            }
        }
        List<ILineDataSet> lineDataSets = new ArrayList<>();

        LineDataSet lineDataSet1 = new LineDataSet(weightcurve,"weight");
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColor(Color.BLUE);

        lineDataSets.add(lineDataSet1);


        LineChart lineChart = (LineChart) findViewById(R.id.lineChart);
        XAxis xaxis = lineChart.getXAxis();
        xaxis.setAxisMinimum(0f);
        xaxis.setAxisMaximum(floats.size() - 1f);
        xaxis.setTextSize(50f);
        xaxis.setDrawLabels(false);
        LimitLine l1 = new LimitLine(Objectif.getValue().floatValue(), "Objectif");
        YAxis leftaxis = lineChart.getAxisLeft();
        leftaxis.setAxisMinimum(Math.min(Objectif.getValue().floatValue() - 2, min));
        leftaxis.setAxisMaximum(Math.max(Objectif.getValue().floatValue() + 2, max));
        l1.setLineColor(Color.RED);
        l1.setTextColor(Color.RED);
        leftaxis.addLimitLine(l1);
        lineChart.setDrawGridBackground(false);
        lineChart.setData(new LineData(lineDataSets));
        lineChart.setVisibleXRangeMaximum(5f);
        lineChart.invalidate();

    }

    public void back(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }
}
