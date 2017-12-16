package com.camarasa.robin.nutritivecoach.Activities.Check;

/**
 * Created by robin on 12/11/17.
 */

public class CheckInscription2Class {
    public CheckInscription2Class() {}

    public boolean weight(String weight_string) {
        if(weight_string.length() == 0) {
            return false;
        }
        float weight = Float.valueOf(weight_string).floatValue();
        return ((weight > 35) && (weight < 150));
    }

    public boolean size(String size_string) {
        if(size_string.length() == 0) {
            return false;
        }
        float size = Float.valueOf(size_string).floatValue();
        return ((size > 1) && (size < 2.5));
    }

    public boolean age(String age_string) {
        if (age_string.length() == 0) {
            return false;
        }
        long age = Long.valueOf(age_string).longValue();
        return ((age >= 18) && (age < 120));
    }

    public boolean isok(String weight, String age, String size) {
        return (this.size(size) && this.age(age) && this.weight(weight));
    }
}
