package com.camarasa.robin.nutritivecoach.Activities.Check;

/**
 * Created by robin on 12/11/17.
 */

public class CheckInscription3Class {

    public CheckInscription3Class(){}
    public int objectif(String objectif) {
        if (objectif.equalsIgnoreCase("Slimming")) {
            return 0;
        }

        if (objectif.equalsIgnoreCase("Taking weight")) {
            return 1;
        }
        if (objectif.equalsIgnoreCase("Keeping my weight")) {
            return 2;
        }
        if (objectif.equalsIgnoreCase("Eating healthier")) {
            return 3;
        }
        return -1;
    }
}
