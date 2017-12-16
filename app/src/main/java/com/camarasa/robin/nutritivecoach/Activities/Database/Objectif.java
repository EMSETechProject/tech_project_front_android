package com.camarasa.robin.nutritivecoach.Activities.Database;

/**
 * Created by robin on 12/12/17.
 */

public class Objectif {
    private static Long id;
    private static Float value;

    public Objectif() {
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        Objectif.id = id;
    }

    public static Float getValue() {
        return value;
    }

    public static void setValue(Float value) {
        Objectif.value = value;
    }

    public static String objectifWriter() {
        return ("Objectif : " + value + " kg");
    }
}
