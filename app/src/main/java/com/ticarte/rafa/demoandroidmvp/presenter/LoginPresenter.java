package com.ticarte.rafa.demoandroidmvp.presenter;

import android.app.Activity;
import android.util.Log;

import com.ticarte.rafa.demoandroidmvp.interfaces.LoginInterface;
import com.ticarte.rafa.demoandroidmvp.model.PeopleModel;

public class LoginPresenter implements LoginInterface.Presenter {

    private String TAG = "LoginPresenter";
    private LoginInterface.View view;
    private PeopleModel people;

    public LoginPresenter (LoginInterface.View view) {
        this.view = view;
        people = new PeopleModel();
    }

    @Override
    public void onClickLogin(String user, String pass) {
        Log.d(TAG, "Entrando en onClickLogin()...");
        Log.d(TAG, "Usuario: " + user);
        Log.d(TAG, "Contraseña: " + pass);

        view.hideError();

        if (people.checkLogin(user, pass)) {
            Log.d(TAG, "Llamando a la vista para navegar al perfil...");
            view.navigateToProfile(user);
        } else {
            Log.d(TAG, "Mostrando error de datos incorrectos...");
            view.showError("Usuario y/o contraseña incorrectos");
        }
    }
}
