package com.camarasa.robin.nutritivecoach.Activities.Activities.Inscription;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.LogInActivity;
import com.camarasa.robin.nutritivecoach.Activities.Check.CheckInscription1Class;
import com.camarasa.robin.nutritivecoach.Activities.Database.User;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.ConnectionToTheCoach;
import com.camarasa.robin.nutritivecoach.R;

public class Inscription_1_0_activity extends AppCompatActivity {

    EditText editTextPseudo;
    EditText editTextPassword;
    EditText editTextConfirmation;

    public TextView textViewerror;
    public CheckInscription1Class check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription_1_0_activity);
    }

    public void next(View view) {
        editTextPseudo = (EditText) findViewById(R.id.editTextWeight);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextConfirmation = (EditText) findViewById(R.id.editTextConfirmation);
        String pseudo = editTextPseudo.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirmation = editTextConfirmation.getText().toString();
        Context context = getApplicationContext();
        textViewerror = (TextView) findViewById(R.id.textViewError);
        CheckInscription1Class ch = new CheckInscription1Class();
        if(ch.isok(pseudo,password,confirmation)) {
            User.setPseudo(pseudo);
            User.setPassword(password);
            ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
            connectionToTheCoach.available(getApplicationContext(),pseudo,this);
        } else {
            textViewerror.setText("Need a password of 4 letters and a 4 letters pseudo");
        }
    }

    public void previous(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

    public void add(Long id) {
        if(id == -1L) {
            Intent intent = new Intent(this, Inscription_2_0_activity.class);
            startActivity(intent);
        } else {
            textViewerror = (TextView) findViewById(R.id.textViewError);
            textViewerror.setText("Unavalaible name");
        }

    }

}
