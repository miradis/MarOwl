package com.example.marowl.ui.home;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marowl.R;
import com.example.marowl.databinding.FragmentHomeBinding;
import com.example.marowl.model.ComicsModel;
import com.example.marowl.ui.favorite.ComicsAdapter;
import com.example.marowl.ui.favorite.FavoriteViewModel;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    ComicsAdapter comicsAdapter;
    ArrayList<ComicsModel> comicsList;
    HomeViewModel homeViewModel;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        homeViewModel =
                new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.
                        getInstance(getActivity().getApplication())).
                        get(HomeViewModel.class);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.home_grid_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        comicsAdapter=new ComicsAdapter(getContext());
        EditText searchComicEditText=view.findViewById(R.id.search_container);
        MaterialButton button=view.findViewById(R.id.random_btn);
        recyclerView.setAdapter(comicsAdapter);
        homeViewModel.getComicsListModel().observe(getViewLifecycleOwner(), new Observer<List<ComicsModel>>() {
            @Override
            public void onChanged(List<ComicsModel> comicsModels) {
                comicsList=(ArrayList<ComicsModel>) comicsModels;
                comicsAdapter.setData(comicsModels);
                comicsAdapter.notifyDataSetChanged();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        searchComicEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                filter(editable.toString());
            }
        });

    }
    private void filter(String text){
        ArrayList<ComicsModel> filteredList=new ArrayList<>();

        for (ComicsModel item: comicsList){
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        comicsAdapter.filterList(filteredList);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}