package com.camarasa.robin.nutritivecoach.Activities.Model;

/**
 * Created by robin on 17/12/17.
 */

public class FoodCooking {
    private Food food;
    private Float quantity;

    public FoodCooking(Food food, Float quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }
}
