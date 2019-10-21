package com.ticarte.rafa.demoandroidmvp.views;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ticarte.rafa.demoandroidmvp.R;
import com.ticarte.rafa.demoandroidmvp.interfaces.ProfileInterface;
import com.ticarte.rafa.demoandroidmvp.models.Person;
import com.ticarte.rafa.demoandroidmvp.presenters.ProfilePresenter;

public class ProfileActivity extends AppCompatActivity implements ProfileInterface.View {

    String TAG = "ProfileActivity";
    Context myContext;
    ProfilePresenter presenter;
    String user;
    TextView userTextView;
    TextView passTextView;
    TextView fullnameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Entrando en onCreate()...");
        super.onCreate(savedInstanceState);

        // Carga el layout
        setContentView(R.layout.activity_profile);

        // Carga la barra de tareas
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Modifica el título de la barra de tareas
        getSupportActionBar().setTitle(getResources().getString(R.string.profile));

        // Habilita Up Button en la barra de tareas y su acción
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Asignar la acción necesaria. En este caso "volver atrás"
                onBackPressed();
            }
        });

        myContext = this;

        presenter = new ProfilePresenter(this);

        Log.d(TAG, "Recuperando nombre de usuario...");
        Bundle b = getIntent().getExtras();
        if (b != null) {
            user = getIntent().getStringExtra("user");
            Log.d(TAG, "Usuario: " + user);
        }

        Log.d(TAG, "Llamando al presentador para cargar datos usuario...");
        presenter.getDataUser(user);
    }

    @Override
    public void loadDataUser(Person person) {
        Log.d(TAG, "Entrando en loadDataUser()...");
        userTextView = (TextView) findViewById(R.id.userTextView);
        userTextView.setText(person.getUser());
        passTextView = (TextView) findViewById(R.id.passTextView);
        passTextView.setText(person.getPass());
        fullnameTextView = (TextView) findViewById(R.id.fullnameTextView);
        fullnameTextView.setText(person.getFullname());
    }
}
