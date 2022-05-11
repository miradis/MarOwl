package com.example.marowl.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.marowl.R;
import com.example.marowl.databinding.FragmentAccountBinding;
import com.example.marowl.ui.authentication.SignInActivity;
import com.example.marowl.ui.authentication.SignInFragment;
import com.example.marowl.ui.authentication.k;

import org.jetbrains.annotations.NotNull;

public class AccountFragment extends Fragment {

    private FragmentAccountBinding binding;
    private NavController navController;

    public View onCreateView(@NotNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        binding=FragmentAccountBinding.inflate(inflater,container,false);

        View root=binding.getRoot();

        final TextView textView=binding.textAccount;
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final View view1=binding.accountSection;

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_account_to_signInActivity);
            }
        });
//        text.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Navigation.findNavController(view).navigate(R.id.login_page);
//            }
//        });


    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}
