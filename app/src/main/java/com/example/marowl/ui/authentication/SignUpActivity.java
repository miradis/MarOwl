package com.example.marowl.ui.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.marowl.R;
import com.example.marowl.entities.User;
import com.example.marowl.repository.AuthenticationRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

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
        authenticationVIewModel.signUp(email,password);
        Intent intent=new Intent(this,SignInActivity.class);
        startActivity(intent);
//        if(email.isEmpty()){
//            EditTextPassword.setError("Email is required");
//            EditTextEmail.requestFocus();
//            return;
//        }
//        if (password.isEmpty()){
//            EditTextPassword.setError("Password is required");
//            EditTextPassword.requestFocus();
//            return;
//        }
////        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
////            EditTextEmail.setError("Provide valid email");
////            EditTextEmail.requestFocus();
////        }
//        if (repeat_pass.isEmpty()){
//            EditTextPassword.setError("Repeat password is required");
//            EditTextRepeat_password.requestFocus();
//            return;
//        }
////        if(password.matches(repeat_pass)){
////            EditTextPassword.setError("Password doesn't match");
////            EditTextPassword.requestFocus();
////            return;
////        }
//        if (password.length()<6){
//            EditTextPassword.setError("Minimum password length should be 6 character");
//            EditTextPassword.requestFocus();
//            return;
//        }
//        if ( repeat_pass.length()<6){
//            EditTextPassword.setError("Minimum password length should be 6 character");
//            EditTextPassword.requestFocus();
//            return;
//        }
//        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()){
//                    FirebaseUser firebaseUser=auth.getCurrentUser();
//                    User user=new User(email,password);
//
//                    FirebaseDatabase.getInstance().getReference("Users").
//                            child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if (task.isSuccessful()){
//                                Toast.makeText(SignUpActivity.this,"User has been created",Toast.LENGTH_SHORT).show();
//                            }
//                            else{
//                                Toast.makeText(SignUpActivity.this,"Failed to register",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//                }
//                else{
//                    Toast.makeText(SignUpActivity.this,"Oops",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

}
