package com.camarasa.robin.nutritivecoach.Activities.Check;

import android.content.Context;

import com.camarasa.robin.nutritivecoach.Activities.Activities.Inscription.Inscription_1_0_activity;
import com.camarasa.robin.nutritivecoach.Activities.Model.User;
import com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication.ConnectionToTheCoach;

/**
 * Created by robin on 12/11/17.
 */

public class CheckInscription1Class {

    public CheckInscription1Class(){}

    public boolean pseudo(String pseudo) {
        return pseudo.length() >= 4;
    }

    public boolean password(String password) {
        return password.length() >= 4;
    }

    public boolean match_password(String password, String confirmation) {
        return password.equalsIgnoreCase(confirmation);
    }

    public boolean isok(String pseudo, String password, String confirmation) {
        return (this.pseudo(pseudo) && this.password(password) && this.match_password(confirmation, password));
    }

    public boolean newpasswordok(String old, String newpassword, String confirmation) {
        return (match_password(newpassword,confirmation) && password(confirmation) && match_password(User.getPassword(),old));
    }
}
