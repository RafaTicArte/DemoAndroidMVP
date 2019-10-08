package com.ticarte.rafa.demoandroidmvp.model;

import android.util.Log;

public class PeopleModel {

    private String TAG = "PeopleModel";

    public PeopleModel () {
    }

    public boolean checkLogin(String user, String pass) {
        Log.d(TAG, "Entrando en checkLogin()...");
        Log.d(TAG, "Usuario: " + user);
        Log.d(TAG, "Contraseña: " + pass);

        if (user.equals(new String("mvp")) && pass.equals(new String("mvp"))) {
            Log.d(TAG, "Login true");
            return true;
        } else {
            Log.d(TAG, "Login false");
            return false;
        }
    }

    public Person getPerson(String user) {
        Log.d(TAG, "Entrando en getPerson()...");
        return new Person(user, "mvp", "Model View Presenter");
    }
}
