package com.camarasa.robin.nutritivecoach.Activities.Activities.Meal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.WelcomeActivity;
import com.camarasa.robin.nutritivecoach.Activities.Model.Dessert;
import com.camarasa.robin.nutritivecoach.Activities.Model.Entrance;
import com.camarasa.robin.nutritivecoach.Activities.Model.Generate;
import com.camarasa.robin.nutritivecoach.Activities.Model.Main;
import com.camarasa.robin.nutritivecoach.Activities.Model.RecipeSelected;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.ConnectionToTheCoach;
import com.camarasa.robin.nutritivecoach.R;

import java.util.List;

public class MealIdea extends AppCompatActivity {

    public Button buttonEntrance;
    public Button buttonMain;
    public Button buttonDessert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_idea);
        buttonEntrance = (Button) findViewById(R.id.buttonEntrance);
        buttonMain = (Button) findViewById(R.id.buttonMain);
        buttonDessert = (Button) findViewById(R.id.buttondessert);
        if(Generate.isReload()) {
            ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
            connectionToTheCoach.getRecipes(getApplicationContext(),this);
        } else {
            buttonEntrance.setText(Entrance.getName());
            buttonMain.setText(Main.getName());
            buttonDessert.setText(Dessert.getName());
        }
    }

    public void back(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void updatebuttons(List<String> names, List<String> ids) {
        if(names.size() == ids.size() && names.size() == 3) {
            Entrance.setId(Long.parseLong(ids.get(0)));
            Entrance.setName(names.get(0));
            Main.setId(Long.parseLong(ids.get(1)));
            Main.setName(names.get(1));
            Dessert.setId(Long.parseLong(ids.get(2)));
            Dessert.setName(names.get(2));
            buttonEntrance.setText(Entrance.getName());
            buttonMain.setText(Main.getName());
            buttonDessert.setText(Dessert.getName());
        }
    }

    public void entrance(View view) {
        RecipeSelected.setId(Entrance.getId());
        RecipeSelected.setName(Entrance.getName());
        Intent intent = new Intent(this, MealValuation.class);
        startActivity(intent);
    }
    public void main(View view) {
        RecipeSelected.setId(Main.getId());
        RecipeSelected.setName(Main.getName());
        Intent intent = new Intent(this, MealValuation.class);
        startActivity(intent);
    }
    public void dessert(View view) {
        RecipeSelected.setId(Dessert.getId());
        RecipeSelected.setName(Dessert.getName());
        Intent intent = new Intent(this, MealValuation.class);
        startActivity(intent);
    }
}
