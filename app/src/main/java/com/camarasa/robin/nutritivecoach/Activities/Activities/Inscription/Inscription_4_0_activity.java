package com.camarasa.robin.nutritivecoach.Activities.Activities.Inscription;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.LogInActivity;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.WelcomeActivity;
import com.camarasa.robin.nutritivecoach.Activities.Check.CheckInscription3Class;
import com.camarasa.robin.nutritivecoach.Activities.Check.CheckInscription4Class;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.ConnectionToTheCoach;
import com.camarasa.robin.nutritivecoach.R;

public class Inscription_4_0_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_4_0);
    }

    public void next(View view) {
        EditText editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        String value_string = editTextWeight.getText().toString();
        CheckInscription4Class ch = new CheckInscription4Class();
        if(ch.isok(value_string)) {
            Float value = Float.parseFloat(value_string);
            ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
            connectionToTheCoach.addObjectif(getApplicationContext(),value,this);
        } else {
            TextView textViewError = (TextView) findViewById(R.id.textViewError);
            textViewError.setText("Abnormal weight");
        }
    }

    public void objectifadded() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void previous(View view) {
        Intent intent = new Intent(this, Inscription_3_0_activity.class);
        startActivity(intent);
    }
}
