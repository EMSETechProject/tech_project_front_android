package com.camarasa.robin.nutritivecoach.Activities.Activities.Inscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.LogInActivity;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.WelcomeActivity;
import com.camarasa.robin.nutritivecoach.Activities.Check.CheckInscription3Class;
import com.camarasa.robin.nutritivecoach.R;


public class Inscription_3_0_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_3_0_activity);
        Spinner spinner = (Spinner) findViewById(R.id.spinnerObjectif);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.objectif_array,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    public void next(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerObjectif);
        String objectif = spinner.getSelectedItem().toString();
        CheckInscription3Class ch = new CheckInscription3Class();
        if(ch.objectif(objectif) < 3) {
            Intent intent = new Intent(this, Inscription_4_0_activity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        }
    }

    public void previous(View view) {
        Intent intent = new Intent(this, Inscription_2_0_activity.class);
        startActivity(intent);
    }
}
