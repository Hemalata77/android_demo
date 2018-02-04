package com.example.admin.facebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {
    TextView txtStatus;
    LoginButton login_button;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        intializeControls();
        loginWithFB();


    }
    private void intializeControls(){
        callbackManager = CallbackManager.Factory.create();
        txtStatus = (TextView)findViewById(R.id.txtStatus);
        login_button = (LoginButton)findViewById(R.id.login_button);

    }

    private void loginWithFB(){

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code

                        txtStatus.setText("Login Success"+loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {
                        // App code
                        txtStatus.setText("Login Cancle");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        txtStatus.setText("Login Error: ");

                    }
                });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
