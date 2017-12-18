package com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Meal.MealOption;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Settings.Settings;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Stats.StatsOptions;
import com.camarasa.robin.nutritivecoach.Activities.Model.User;
import com.camarasa.robin.nutritivecoach.R;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView textViewWelcome = (TextView) findViewById(R.id.textViewWelcomeMessage);
        textViewWelcome.setText(User.welcomeUser());
    }

    public void logout(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

    public void stats(View view) {
        Intent intent = new Intent(this, StatsOptions.class);
        startActivity(intent);
    }

    public void meal(View view) {
        Intent intent = new Intent(this, MealOption.class);
        startActivity(intent);
    }

    public void settings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}
