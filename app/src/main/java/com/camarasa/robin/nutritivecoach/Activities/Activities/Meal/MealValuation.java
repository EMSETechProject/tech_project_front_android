package com.camarasa.robin.nutritivecoach.Activities.Activities.Meal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.camarasa.robin.nutritivecoach.Activities.Model.Course;
import com.camarasa.robin.nutritivecoach.Activities.Model.Generate;
import com.camarasa.robin.nutritivecoach.Activities.Model.RecipeSelected;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.ConnectionToTheCoach;
import com.camarasa.robin.nutritivecoach.R;

public class MealValuation extends AppCompatActivity {

    TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_valuation);
        textViewInfo = (TextView) findViewById(R.id.textViewInfo);
        textViewInfo.setText(RecipeSelected.getName());
        textViewInfo.setMovementMethod(new ScrollingMovementMethod());
        ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
        connectionToTheCoach.getRecipeData(getApplicationContext(),this);
    }

    public void display() {
        textViewInfo.setText(Course.ingredients());
    }

    public void rate(View view) {
        Generate.setReload(false);
        Intent intent = new Intent(this,MealIdea.class);
        startActivity(intent);
    }
}
