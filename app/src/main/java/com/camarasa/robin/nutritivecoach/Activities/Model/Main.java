package com.camarasa.robin.nutritivecoach.Activities.Model;

import java.util.List;

/**
 * Created by robin on 17/12/17.
 */

public class Main {
    private static Long id;
    private static String name;
    private static List<FoodCooking> foodCookings;
    private static Float Energie;

    public Main() {
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        Main.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Main.name = name;
    }

    public static List<FoodCooking> getFoodCookings() {
        return foodCookings;
    }

    public static void setFoodCookings(List<FoodCooking> foodCookings) {
        Main.foodCookings = foodCookings;
        Main.Energie = 0f;
        for (FoodCooking foodCooking : foodCookings) {
            Main.Energie = Main.Energie + (foodCooking.getQuantity()/100f) * foodCooking.getFood().getEnergie();
        }
    }
}
