package com.example.marowl.ui.account;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AccountViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public AccountViewModel() {
        mText=new MutableLiveData<>();
        mText.setValue("This is account fragment");
    }
    public LiveData<String> getText(){return mText;}
    public void onSignIn(){
    }
}
