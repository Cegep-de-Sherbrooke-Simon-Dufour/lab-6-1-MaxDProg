package com.example.testviewholder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {
    @Inject
    public UserRepository(){}
    private ArrayList<User> userList = new ArrayList<>();

    private final MutableLiveData<List<User>> userLiveData = new
            MutableLiveData<>(new ArrayList<>(userList));

    public void addUser(User user){
        userList.add(user);
        userLiveData.setValue(new ArrayList<>(userList));
    }

    public void deleteUser(User user){
        userList.remove(user);
        userLiveData.setValue(new ArrayList<>(userList));
    }

    public LiveData<List<User>> getUser() {
        return userLiveData;
    }
}
