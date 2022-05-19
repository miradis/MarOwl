package com.example.marowl.ui.favorite;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.marowl.model.ComicsModel;
import com.example.marowl.repository.ComicsRepository;

import java.util.List;

public class FavoriteViewModel extends ViewModel implements ComicsRepository.onFirestoreTaskComplete {

    private MutableLiveData<List<ComicsModel>> comicsListModel;
    private ComicsRepository comicsRepository;

    public FavoriteViewModel(){
        comicsListModel=new MutableLiveData<>();
        comicsRepository=new ComicsRepository(this);
        comicsRepository.getComicsData();
    }

    @Override
    public void comicsDataLoaded(List<ComicsModel> comicsModelList) {
        comicsListModel.setValue(comicsModelList);
    }

    @Override
    public void onError(Exception e) {
        Log.d("ComicsERROR ", "onError: "+e.getMessage());
    }

    public MutableLiveData<List<ComicsModel>> getComicsListModel() {
        return comicsListModel;
    }
}