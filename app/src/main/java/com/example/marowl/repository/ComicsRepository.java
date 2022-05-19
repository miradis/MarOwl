package com.example.marowl.repository;

import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.marowl.model.ComicsModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class ComicsRepository {
    private onFirestoreTaskComplete onFirestoreTaskComplete;
    private FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
    private CollectionReference reference=firebaseFirestore.collection("Comic");

    public ComicsRepository(onFirestoreTaskComplete onFirestoreTaskComplete){
        this.onFirestoreTaskComplete=onFirestoreTaskComplete;
    }
    public void getComicsData(){
        reference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    onFirestoreTaskComplete.comicsDataLoaded(task.getResult().
                            toObjects(ComicsModel.class));
                }
                else{
                    onFirestoreTaskComplete.onError(task.getException());
                }
            }
        });
    }
    public interface  onFirestoreTaskComplete {
        void comicsDataLoaded(List<ComicsModel> comicsModelList);
        void onError(Exception e);
    }
}
