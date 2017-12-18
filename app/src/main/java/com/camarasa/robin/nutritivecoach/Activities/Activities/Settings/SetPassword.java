package com.camarasa.robin.nutritivecoach.Activities.Activities.Settings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.WelcomeActivity;
import com.camarasa.robin.nutritivecoach.Activities.Check.CheckInscription1Class;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.ConnectionToTheCoach;
import com.camarasa.robin.nutritivecoach.R;

public class SetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
    }

    public void back(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void back2() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void settings(View view) {
        EditText editTextOld = (EditText) findViewById(R.id.editTextOld);
        EditText editTextNew = (EditText) findViewById(R.id.editTextConfirmation);
        EditText editTextConfirmation = (EditText) findViewById(R.id.editTextConfirmation);
        String old = editTextOld.getText().toString();
        String newPassword = editTextNew.getText().toString();
        String confirmation = editTextConfirmation.getText().toString();
        CheckInscription1Class ch = new CheckInscription1Class();
        if (ch.newpasswordok(old,newPassword,confirmation)) {
            ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
            connectionToTheCoach.changePassword(getApplicationContext(),newPassword,this);
        }
    }
}
