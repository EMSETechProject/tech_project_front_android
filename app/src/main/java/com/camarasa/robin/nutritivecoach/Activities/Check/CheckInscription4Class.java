package com.camarasa.robin.nutritivecoach.Activities.Check;

/**
 * Created by robin on 12/11/17.
 */

public class CheckInscription4Class {

    public CheckInscription4Class(){}

    public boolean notEmpty(String value_string) {
        return !(value_string.equalsIgnoreCase(""));
    }

    public boolean correct(String value_string) {
        Float value = Float.parseFloat(value_string);
        return ((value > 0) && (value < 150));
    }

    public boolean isok(String value_string) {
        return (notEmpty(value_string) && correct(value_string));
    }
}
