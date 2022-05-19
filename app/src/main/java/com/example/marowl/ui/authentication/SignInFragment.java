package com.example.marowl.ui.authentication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class SignInFragment extends Fragment {

    private EditText username;
    private EditText password;
    private Button loginBtn;
    private TextView signUp;
    private TextView forgotPass;
    private AuthenticationVIewModel authenticationVIewModel;
    private NavController navController;
    private String TAG="SignInFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authenticationVIewModel=new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(AuthenticationVIewModel.class);
        authenticationVIewModel.getUserData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser!=null){
//                    navController.navigate(R.id.action_signInFragment_to_navigation_home);
                }
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        username=(EditText) view.findViewById(R.id.login);
        password=(EditText) view.findViewById(R.id.password);
        loginBtn=(Button) view.findViewById(R.id.login_btn);
        signUp=(TextView) view.findViewById(R.id.registerLogin);
        forgotPass=(TextView) view.findViewById(R.id.forgotPass);
        navController=Navigation.findNavController(view);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                navController.navigate(R.id.action_signInFragment_to_signUpFragment);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=username.getText().toString();
                String pass=password.getText().toString();
                if (email.isEmpty() || pass.isEmpty()){
                    authenticationVIewModel.signIn(email,pass);
                    Toast.makeText(getContext(),authenticationVIewModel.getRepository().getApplication().toString(),Toast.LENGTH_SHORT).show();
                }
//                navController.navigate(R.id.action_signInFragment_to_navigation_home);
            }
        });

    }
}
