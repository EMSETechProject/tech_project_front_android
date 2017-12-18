package com.camarasa.robin.nutritivecoach.Activities.Model;

/**
 * Created by robin on 17/12/17.
 */

public class Generate {
    private static boolean reload = true;
    public Generate() {
        reload = true;
    }

    public static boolean isReload() {
        return reload;
    }

    public static void setReload(boolean reload) {
        Generate.reload = reload;
    }
}
