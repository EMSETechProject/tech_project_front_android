package com.camarasa.robin.nutritivecoach.Activities.Model;

import java.util.List;

/**
 * Created by robin on 17/12/17.
 */

public class Dessert {
    private static Long id;
    private static String name;
    private static List<FoodCooking> foodCookings;
    private static Float Energie;

    public Dessert() {
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        Dessert.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Dessert.name = name;
    }

    public static List<FoodCooking> getFoodCookings() {
        return foodCookings;
    }

    public static void setFoodCookings(List<FoodCooking> foodCookings) {
        Dessert.foodCookings = foodCookings;
        Dessert.Energie = 0f;
        for (FoodCooking foodCooking : foodCookings) {
            Dessert.Energie = Dessert.Energie + (foodCooking.getQuantity()/100f) * foodCooking.getFood().getEnergie();
        }
    }
}
