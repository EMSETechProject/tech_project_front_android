package com.camarasa.robin.nutritivecoach.Activities.Activities.Stats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.WelcomeActivity;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.ConnectionToTheCoach;
import com.camarasa.robin.nutritivecoach.R;

public class EnterWeight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_weight);
    }

    public void back(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void add(View view) {
        EditText editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        String weight_string = editTextWeight.getText().toString();
        Float weight = Float.parseFloat(weight_string);
        ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
        connectionToTheCoach.addWeight(getApplicationContext(),weight,this);

    }

    public void addWeight() {

        Intent intent = new Intent(this, StatsOptions.class);
        startActivity(intent);
    }

}
