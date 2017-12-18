package com.camarasa.robin.nutritivecoach.Activities.Activities.Settings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.WelcomeActivity;
import com.camarasa.robin.nutritivecoach.Activities.Model.Objectif;
import com.camarasa.robin.nutritivecoach.Activities.Model.User;
import com.camarasa.robin.nutritivecoach.R;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        TextView textViewPseudo = (TextView) findViewById(R.id.textViewPseudo);
        textViewPseudo.setText(User.pseudoUser());
        TextView textViewObjectif = (TextView) findViewById(R.id.textViewObjectif);
        textViewObjectif.setText(Objectif.objectifWriter());
    }

    public void back(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void changePassword(View view) {
        Intent intent = new Intent(this, SetPassword.class);
        startActivity(intent);
    }

    public void changeObjectif(View view) {
        Intent intent = new Intent(this, SetObjectif.class);
        startActivity(intent);
    }
}
