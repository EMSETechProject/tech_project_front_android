package com.camarasa.robin.nutritivecoach.Activities.Activities.Meal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.WelcomeActivity;
import com.camarasa.robin.nutritivecoach.Activities.Model.Food;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.ConnectionToTheCoach;
import com.camarasa.robin.nutritivecoach.R;

import java.util.List;

public class FoodData extends AppCompatActivity {

    Spinner spinnercat;
    TextView textView;
    Spinner spinnerfoodcat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_data);
        spinnercat = (Spinner) findViewById(R.id.spinnercat);
        spinnerfoodcat = (Spinner) findViewById(R.id.spinnerfood);
        textView = (TextView) findViewById(R.id.textViewFoodData);
        spinnercat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
                connectionToTheCoach.getfoodcat(FoodData.this.getApplicationContext(),spinnercat.getSelectedItem().toString(),FoodData.this);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                textView.setText("");
            }
        });

        spinnerfoodcat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
                connectionToTheCoach.fooddata(FoodData.this.getApplicationContext(),spinnerfoodcat.getSelectedItem().toString(),FoodData.this);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ConnectionToTheCoach connectionToTheCoach = new ConnectionToTheCoach();
        connectionToTheCoach.getcat(getApplicationContext(),this);
    }

    public void setCatspinner(List<String> categories) {
        Spinner spin = (Spinner) findViewById(R.id.spinnercat);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, categories);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    public void back(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    public void loadfoad(List<String> food) {
        Spinner spin = (Spinner) findViewById(R.id.spinnerfood);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, food);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    public void display(Food food) {
        textView.setText(food.toString());
    }
}
