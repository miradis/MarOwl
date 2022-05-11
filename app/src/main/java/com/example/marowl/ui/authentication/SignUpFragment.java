package com.example.marowl.ui.authentication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.marowl.R;
import com.google.firebase.auth.FirebaseUser;

public class SignUpFragment extends Fragment {

    private EditText email;
    private EditText username;
    private EditText password;
    private EditText repeat_password;
    private Button SignUpBtn;
    private TextView SignInText;
    private AuthenticationVIewModel authenticationVIewModel;
    private NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authenticationVIewModel=new ViewModelProvider(this, (ViewModelProvider.Factory) new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(AuthenticationVIewModel.class);
//        authenticationVIewModel=new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory.
//                getInstance(getActivity().getApplication()).get(AuthenticationVIewModel.class);
        authenticationVIewModel.getUserData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser!=null){
//                    navController.navigate(R.id.action_signInFragment_to_navigation_home);
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        email=(EditText) view.findViewById(R.id.register_email);
        username=(EditText) view.findViewById(R.id.username);
        SignUpBtn=(Button) view.findViewById(R.id.login_btn);
        SignInText=(TextView) view.findViewById(R.id.signInText);
        password=(EditText) view.findViewById(R.id.register_password);
        repeat_password=(EditText) view.findViewById(R.id.repeat_password);
        navController= Navigation.findNavController(view);

        SignInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                navController.navigate(R.id.action_signUpFragment_to_signInFragment);
            }
        });
        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=username.getText().toString();
                String pass=password.getText().toString();
                String repeat_pass=repeat_password.getText().toString();
                if (email.isEmpty() || pass.isEmpty() || password==repeat_password){
                    authenticationVIewModel.signUp(email,pass);
                }
//                navController.navigate(R.id.action_signUpFragment_to_signInFragment);
            }
        });

    }
}
