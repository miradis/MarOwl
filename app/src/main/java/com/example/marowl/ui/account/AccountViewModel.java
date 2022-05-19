package com.example.marowl.ui.account;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.marowl.repository.AuthenticationRepository;
import com.google.firebase.auth.FirebaseUser;

public class AccountViewModel extends ViewModel {
    private AuthenticationRepository repository;
    private MutableLiveData<FirebaseUser>userData;
    private MutableLiveData<Boolean>loggedStatus;
    private FirebaseUser currentUser;
    private final MutableLiveData<String> mText;

    public AccountViewModel() {
        mText=new MutableLiveData<>();
        mText.setValue("This is account fragment");
    }
    public LiveData<String> getText(){return mText;}
    public void onSignIn(){
    }
}
