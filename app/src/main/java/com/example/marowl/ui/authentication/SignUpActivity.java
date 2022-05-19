package com.example.marowl.ui.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.marowl.R;
import com.example.marowl.ui.home.HomeFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    public EditText EditTextEmail;
    public EditText EditTextUsername;
    public EditText EditTextPassword;
    public EditText EditTextRepeat_password;
    public Button SignUpBtn;
    public TextView TextSignInText;
    public FirebaseAuth auth;
    public AuthenticationVIewModel authenticationVIewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        authenticationVIewModel=new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory
                .getInstance(getApplication())).get(AuthenticationVIewModel.class);
        EditTextEmail=(EditText) findViewById(R.id.register_email);
        EditTextUsername=(EditText) findViewById(R.id.username);
        SignUpBtn=(Button) findViewById(R.id.register_btn);
        TextSignInText=(TextView) findViewById(R.id.signInText);
        EditTextPassword=(EditText) findViewById(R.id.register_password);
        auth =FirebaseAuth.getInstance();
        EditTextRepeat_password=(EditText) findViewById(R.id.repeat_password);
        TextSignInText.setOnClickListener(this);
        SignUpBtn.setOnClickListener(this);

        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (authenticationVIewModel.getCurrentUser()!=null){
                    goToActivity();
                }
                else{
                    goSignInActivity();
                }
            }
        },4000);
    }

    private void goSignInActivity() {
        startActivity(new Intent(this,SignInActivity.class));
    }

    private void goToActivity() {
        startActivity(new Intent(this,HomeFragment.class));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signInText:
                startActivity(new Intent(this, SignInActivity.class));
                break;

            case R.id.register_btn:
                registerUser();

                break;

        }

    }


    private void registerUser(){
        String email=EditTextEmail.getText().toString().trim();
        String password=EditTextPassword.getText().toString().trim();
        String repeat_pass=EditTextRepeat_password.getText().toString().trim();
        if(email.isEmpty()){
            EditTextEmail.setError("Email is required");
            EditTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            EditTextEmail.setError("Provide valid email");
            EditTextEmail.requestFocus();
        }
        if (password.isEmpty()){
            EditTextPassword.setError("Password is required");
            EditTextPassword.requestFocus();
            return;
        }
        if (repeat_pass.isEmpty()){
            EditTextPassword.setError("Repeat password is required");
            EditTextRepeat_password.requestFocus();
            return;
        }
        if(!password.matches(repeat_pass)){
            EditTextPassword.setError("Password doesn't match");
            EditTextPassword.requestFocus();
            return;
        }
        if (password.length()<6){
            EditTextPassword.setError("Minimum password length should be 6 character");
            EditTextPassword.requestFocus();
            return;
        }
        if ( repeat_pass.length()<6){
            EditTextPassword.setError("Minimum password length should be 6 character");
            EditTextPassword.requestFocus();
            return;
        }

        authenticationVIewModel.signUp(email,password);
        Toast.makeText(this,"Account was successfully created",Toast.LENGTH_SHORT).show();
        authenticationVIewModel.getUserData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser!=null){
                    goToSignActivity();
                }
            }
        });
    }

    private void goToSignActivity() {
        Intent intent=new Intent(this,SignInActivity.class);
        startActivity(intent);
    }

}
