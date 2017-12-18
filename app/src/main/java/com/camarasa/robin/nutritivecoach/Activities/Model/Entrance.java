package com.camarasa.robin.nutritivecoach.Activities.Model;

import java.util.List;

/**
 * Created by robin on 17/12/17.
 */

public class Entrance {
    private static Long id;
    private static String name;
    private static List<FoodCooking> foodCookings;
    private static Float Energie;

    public Entrance() {
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        Entrance.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Entrance.name = name;
    }

    public static List<FoodCooking> getFoodCookings() {
        return foodCookings;
    }

    public static void setFoodCookings(List<FoodCooking> foodCookings) {
        Entrance.foodCookings = foodCookings;
        Entrance.Energie = 0f;
        for (FoodCooking foodCooking : foodCookings) {
            Entrance.Energie = Entrance.Energie + (foodCooking.getQuantity()/100f) * foodCooking.getFood().getEnergie();
        }
    }
}
