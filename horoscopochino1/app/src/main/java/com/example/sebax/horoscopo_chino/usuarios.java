package com.example.sebax.horoscopo_chino;

import android.widget.EditText;

import java.io.Serializable;

/**
 * Created by joaqu on 07-11-2017.
 */

public class usuarios implements Serializable {
    public String user;
    public String pass;

    public usuarios(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
