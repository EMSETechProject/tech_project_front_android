package com.camarasa.robin.nutritivecoach.Activities.Activities.Stats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.WelcomeActivity;
import com.camarasa.robin.nutritivecoach.R;

public class StatsOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_options);
    }

    public void back(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void yourStatistics(View view) {
        Intent intent = new Intent(this, YourStatistics.class);
        startActivity(intent);
    }

    public void enterWeight(View view) {
        Intent intent = new Intent(this, EnterWeight.class);
        startActivity(intent);
    }
}
