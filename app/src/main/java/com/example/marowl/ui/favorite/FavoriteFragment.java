package com.example.marowl.ui.favorite;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.marowl.R;
import com.example.marowl.data.Comics.Comic;
import com.example.marowl.databinding.FragmentFavoriteBinding;
import com.example.marowl.ui.comic.ComicActivity;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment {

    private FragmentFavoriteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FavoriteViewModel dashboardViewModel =
                new ViewModelProvider(this).get(FavoriteViewModel.class);

        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ArrayList<Comic> comics = new ArrayList<>();
        comics.add(new Comic("Iron man", R.drawable.iron_man,"First detail"));
        comics.add(new Comic("Venom", R.drawable.iron_man,"Second detail"));
        comics.add(new Comic("Spider man", R.drawable.iron_man,"Third detail"));
        comics.add(new Comic("Spider man", R.drawable.iron_man,"Fourth detail"));
        comics.add(new Comic("Spider man", R.drawable.iron_man,"Fourth detail"));
        comics.add(new Comic("Spider man", R.drawable.iron_man,"Fourth detail"));


        GridView gridView=(GridView) view.findViewById(R.id.comic_grid_view);
        RecycleAdapter adapter=new RecycleAdapter(getContext(),R.layout.card_layout,comics);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
           startActivity(new Intent(getActivity(),ComicActivity.class));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}