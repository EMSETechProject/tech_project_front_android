package com.camarasa.robin.nutritivecoach.Activities.Activities.Inscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.camarasa.robin.nutritivecoach.Activities.Check.CheckInscription2Class;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.ConnectionToTheCoach;
import com.camarasa.robin.nutritivecoach.R;


public class Inscription_2_0_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_2_0_activity);
    }

    public void next(View view) {
        EditText editTextAge = (EditText) findViewById(R.id.editTextAge);
        EditText editTextWeigth = (EditText)findViewById(R.id.editTextOld);
        EditText editTextSize = (EditText) findViewById(R.id.editTextSize);
        String weight_string = editTextWeigth.getText().toString();
        String age_string = editTextAge.getText().toString();
        String size_string = editTextSize.getText().toString();
        Float weight = Float.parseFloat(weight_string);
        Float size = Float.parseFloat(size_string);
        Long age = Long.parseLong(age_string);
        CheckInscription2Class ch = new CheckInscription2Class();
        if(ch.isok(weight_string,age_string,size_string)) {
            ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
            connectionToTheCoach.addPD(getApplicationContext(),weight,age,size,this);
        }
    }

    public void previous(View view) {
        Intent intent = new Intent(this, Inscription_1_0_activity.class);
        startActivity(intent);
    }

    public void added( ) {
        Intent intent = new Intent(this, Inscription_4_0_activity.class);
        startActivity(intent);
    }
}
