package com.camarasa.robin.nutritivecoach.Activities.Model;

/**
 * Created by robin on 17/12/17.
 */

public class RecipeSelected {
    private static Long id;
    private static String name;

    public RecipeSelected() {
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        RecipeSelected.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        RecipeSelected.name = name;
    }
}
