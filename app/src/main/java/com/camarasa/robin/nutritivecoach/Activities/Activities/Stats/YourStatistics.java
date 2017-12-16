package com.camarasa.robin.nutritivecoach.Activities.Activities.Stats;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.WelcomeActivity;
import com.camarasa.robin.nutritivecoach.Activities.Database.User;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.ConnectionToTheCoach;
import com.camarasa.robin.nutritivecoach.R;

import java.util.List;

public class YourStatistics extends AppCompatActivity {

    private GLSurfaceView mGLView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_statistics);
        mGLView = new MyGLSurfaceView(this);
        ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
        connectionToTheCoach.getGraph(getApplicationContext(), User.getId(), this);
    }

    public void graph(List<Float> floats) {
        TextView textViewvalues = (TextView) findViewById(R.id.textViewvalues);
        textViewvalues.setText(floats.toString());
    }

    public void back(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }
}
