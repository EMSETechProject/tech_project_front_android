package com.camarasa.robin.nutritivecoach.Activities.Activities.Settings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.WelcomeActivity;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.ConnectionToTheCoach;
import com.camarasa.robin.nutritivecoach.R;

public class SetObjectif extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_objectif);
    }

    public void back(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void back2() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void changeObjectif(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextOld);
        String weight_string = editText.getText().toString();
        if((!weight_string.equalsIgnoreCase("")) && Float.parseFloat(weight_string) > 0 && Float.parseFloat(weight_string) < 150) {
            ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
            connectionToTheCoach.changeObjectif(getApplicationContext(),Float.parseFloat(weight_string),this);
        }
    }
}
