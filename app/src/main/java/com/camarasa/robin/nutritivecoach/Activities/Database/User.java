package com.camarasa.robin.nutritivecoach.Activities.Database;

/**
 * Created by robin on 12/12/17.
 */

public class User {
    private static Long id;
    private static String password;
    private static String pseudo;
    private static Long physical_data;

    public static void setId(Long id) {
        User.id = id;
    }

    public static Long getId() {
        return id;
    }

    public static String getPassword() {
        return password;
    }

    public static String getPseudo() {
        return pseudo;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static void setPseudo(String pseudo) {
        User.pseudo = pseudo;
    }

    public static String welcomeUser() {
        return ("Welcome " + User.pseudo);
    }

    public static String pseudoUser(){
        return ("Pseudo : " + User.getPseudo());
    }

    public static Long getPhysical_data() {
        return physical_data;
    }

    public static void setPhysical_data(Long physical_data) {
        User.physical_data = physical_data;
    }
}
