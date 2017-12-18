package com.camarasa.robin.nutritivecoach.Activities.Model;

import java.util.List;

/**
 * Created by robin on 17/12/17.
 */

public class Course {
    private static Long id;
    private static String name;
    private static List<FoodCooking> foodCookings;
    private static Float Energie;

    public Course() {
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        Course.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Course.name = name;
    }

    public static List<FoodCooking> getFoodCookings() {
        return foodCookings;
    }

    public static void setFoodCookings(List<FoodCooking> foodCookings) {
        Course.foodCookings = foodCookings;
        Course.Energie = 0f;
        for (FoodCooking foodCooking : foodCookings) {
            Course.Energie = Course.Energie + (foodCooking.getQuantity()/100f) * foodCooking.getFood().getEnergie();
        }
    }

    public static Float getEnergie() {
        return Energie;
    }

    public static void setEnergie(Float energie) {
        Energie = energie;
    }

    public static String ingredients() {
        String result = name + " :\n\n";
        for (FoodCooking foodCooking : Course.getFoodCookings()) {
            result = result.concat("- ")
                    .concat(foodCooking.getQuantity().toString())
                    .concat(" g de ").concat(foodCooking.getFood().getIntitule())
                    .concat("\n");
        }
        return result;
    }
}
