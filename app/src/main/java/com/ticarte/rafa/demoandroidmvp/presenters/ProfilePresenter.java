package com.ticarte.rafa.demoandroidmvp.presenters;

import android.util.Log;

import com.ticarte.rafa.demoandroidmvp.interfaces.ProfileInterface;
import com.ticarte.rafa.demoandroidmvp.models.PeopleModel;
import com.ticarte.rafa.demoandroidmvp.models.Person;

public class ProfilePresenter implements ProfileInterface.Presenter {

    private String TAG = "ProfilePresenter";
    private ProfileInterface.View view;
    private PeopleModel people;

    public ProfilePresenter (ProfileInterface.View view) {
        this.view = view;
        people = new PeopleModel();
    }

    @Override
    public void getDataUser(String user) {
        Log.d(TAG, "Llamando al modelo para recoger los datos de usuario...");
        Person person = people.getPerson(user);
        Log.d(TAG, "Llamando a la vista para cargar los datos de usuario...");
        view.loadDataUser(person);
    }
}
