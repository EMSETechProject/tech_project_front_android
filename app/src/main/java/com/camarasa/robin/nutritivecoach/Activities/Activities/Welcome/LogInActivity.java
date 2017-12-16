package com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.camarasa.robin.nutritivecoach.Activities.Database.User;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.*;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Inscription.Inscription_1_0_activity;

import com.camarasa.robin.nutritivecoach.R;

public class LogInActivity extends AppCompatActivity {

    public TextView textViewtest;
    public EditText editTextPassword;
    public EditText editTextPseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void logIn(View view) {

        editTextPseudo = (EditText) findViewById(R.id.editTextWeight);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewtest = (TextView) findViewById(R.id.textViewtest);
        String password = editTextPassword.getText().toString();
        String pseudo = editTextPseudo.getText().toString();
        ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
        connectionToTheCoach.logIn(getApplicationContext(),pseudo,password,this);
    }

    public void listenConnect(String id) {
        TextView textViewtest = (TextView) findViewById(R.id.textViewtest);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        if (Long.valueOf(id) > 0L) {
            ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
            User.setPassword(editTextPassword.getText().toString());
            User.setPseudo(editTextPseudo.getText().toString());
            connect();
        } else {
            this.editTextPassword.setText("");
            this.textViewtest.setText("Incorrect pseudo or password");
        }
    }

    public void connect() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void subscribe(View view) {
        Intent intent = new Intent(this, Inscription_1_0_activity.class);
        startActivity(intent);
    }
}
