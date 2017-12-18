package com.camarasa.robin.nutritivecoach.Activities.Activities.Meal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Stats.EnterWeight;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.WelcomeActivity;
import com.camarasa.robin.nutritivecoach.Activities.Model.Generate;
import com.camarasa.robin.nutritivecoach.R;

public class MealOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_option);
    }

    public void back(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void foodData(View view) {
        Intent intent = new Intent(this, FoodData.class);
        startActivity(intent);
    }

    public void mealIdea(View view) {
        Generate generate = new Generate();
        Intent intent = new Intent(this, MealIdea.class);
        startActivity(intent);
    }
}
