package com.example.marowl.ui.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.marowl.databinding.FragmentAccountBinding;

import org.jetbrains.annotations.NotNull;

import java.util.zip.Inflater;

public class accountFragment extends Fragment {

    private FragmentAccountBinding binding;

    public View onCreateView(@NotNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        AccountViewModel accountViewModel=new ViewModelProvider(this).get(AccountViewModel.class);
        binding=FragmentAccountBinding.inflate(inflater,container,false);

        View root=binding.getRoot();

        final TextView textView=binding.textAccount;
        accountViewModel.getText().observe(getViewLifecycleOwner(),textView::setText);
        return root;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}
