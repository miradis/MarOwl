package com.example.marowl.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marowl.R;

import java.util.ArrayList;
import java.util.List;

public class ComicsPreviewFragment extends Fragment {

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    public static final String TAG="ComicsPreviewFragment";

    private List<Integer> mImageIds;
    private int mListIndex;

    public ComicsPreviewFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState!=null){
        mImageIds=savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
        mListIndex=savedInstanceState.getInt(LIST_INDEX);
        }

        //Inflate the comics fragment layout

        View rootView=inflater.inflate(R.layout.comics_fragment,container,false);

        final ImageView imageComics=rootView.findViewById(R.id.comics_preview);
        final TextView title=rootView.findViewById(R.id.comics_title);
        final TextView description=rootView.findViewById(R.id.comics_description);




        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX,mListIndex);
    }


    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

}
