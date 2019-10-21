package com.ticarte.rafa.demoandroidmvp.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ticarte.rafa.demoandroidmvp.R;
import com.ticarte.rafa.demoandroidmvp.interfaces.LoginInterface;
import com.ticarte.rafa.demoandroidmvp.presenters.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginInterface.View {

    private String TAG = "LoginActivity";
    private Context myContext;
    private LoginInterface.Presenter presenter;
    private EditText userEditText;
    private EditText passEditText;
    private Button loginButton;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Entrando en onCreate()...");
        super.onCreate(savedInstanceState);

        // Carga el layout
        setContentView(R.layout.activity_login);

        // Carga la barra de tareaso
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myContext = this;

        presenter = new LoginPresenter(this);

        userEditText = (EditText)findViewById(R.id.userEditText);
        passEditText = (EditText)findViewById(R.id.passEditText);

        loginButton = (Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Llamando al presentador al pulsar botón login...");
                presenter.onClickLogin(userEditText.getText().toString(), passEditText.getText().toString());
            }
        });

    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "Entrando en showError()...");
        Log.d(TAG, "Error: " + error);

        Log.d(TAG, "Mostrando error...");
        errorTextView = (TextView)findViewById(R.id.errorTextView);
        errorTextView.setText(error);
        errorTextView.setVisibility(View.VISIBLE);

        Log.d(TAG, "Ocultando teclado...");
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(errorTextView.getWindowToken(), 0);
    }

    @Override
    public void hideError() {
        Log.d(TAG, "Entrando en hideError()...");

        Log.d(TAG, "Ocultando error...");
        errorTextView = (TextView)findViewById(R.id.errorTextView);
        errorTextView.setVisibility(View.GONE);
    }

    @Override
    public void navigateToProfile(String user) {
        Log.d(TAG, "Entrando en navigateToProfile()...");

        Log.d(TAG, "Lanzando actividad...");
        Intent profileIntent= new Intent(LoginActivity.this, ProfileActivity.class);
        Bundle b = new Bundle();
        b.putString("user", user.toString());
        profileIntent.putExtras(b);
        startActivity(profileIntent);
    }
}
