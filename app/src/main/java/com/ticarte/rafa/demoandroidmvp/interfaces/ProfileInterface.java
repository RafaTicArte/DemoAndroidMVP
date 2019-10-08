package com.ticarte.rafa.demoandroidmvp.interfaces;

import com.ticarte.rafa.demoandroidmvp.model.Person;

public interface ProfileInterface {

    public interface View {
        void loadDataUser(Person person);
    }

    public interface Presenter {
        void getDataUser(String user);
    }
}

