package com.example.marowl.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.marowl.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class AuthenticationRepository{
    String ACCOUNT_TAG="Firebase: ";
    private Application application;
    private MutableLiveData<FirebaseUser>firebaseUserMutableLiveData;
    private FirebaseAuth auth;
    private MutableLiveData<Boolean> userLoggedMutableLiveData;

    public AuthenticationRepository(Application application){
        this.application=application;
        firebaseUserMutableLiveData=new MutableLiveData<>();
        auth= FirebaseAuth.getInstance();
        userLoggedMutableLiveData=new MutableLiveData<Boolean>();
        if (auth.getCurrentUser()!=null){
            firebaseUserMutableLiveData.postValue(auth.getCurrentUser());
        }
    }
    public void SignUp(String email, String password){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    firebaseUserMutableLiveData.postValue(auth.getCurrentUser());
                    userLoggedMutableLiveData.postValue(true);
                    User user=new User(email,password);
                    Log.v(ACCOUNT_TAG,"Account was created");
                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(application, "Logged",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(application,"Failed to register",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                Log.v(ACCOUNT_TAG, "Account signed in");
                }
                else{
                    Toast.makeText(application,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public void SignIn(String email, String password){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    firebaseUserMutableLiveData.postValue(auth.getCurrentUser());
                    Log.v(ACCOUNT_TAG,"Logged");
                }
                else{
                    Toast.makeText(application,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void SignOut(){
        auth.signOut();
        userLoggedMutableLiveData.postValue(true);
    }
//    public User showProfile(){
//        reference=FirebaseDatabase.getInstance().getReference("Users");
//        String userID=auth.getUid();
//        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                User userProfile=snapshot.getValue(User.class);
//
//                if (userProfile!=null){
//                    return userProfile;
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//        return null;
//    }


    public Application getApplication() {
        return application;
    }

    public MutableLiveData<FirebaseUser> getFirebaseUserMutableLiveData() {
        return firebaseUserMutableLiveData;
    }

    public FirebaseAuth getAuth() {
        return auth;
    }

    public MutableLiveData<Boolean> getUserLoggedMutableLiveData() {
        return userLoggedMutableLiveData;
    }

    public FirebaseUser getCurrentUser() {
        return auth.getCurrentUser();
    }
}
