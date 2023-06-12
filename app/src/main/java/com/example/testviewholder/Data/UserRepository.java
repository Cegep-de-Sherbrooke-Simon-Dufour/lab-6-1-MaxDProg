package com.example.testviewholder.Data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {

    private final UserDAO userDAO;
    private final LiveData<List<User>> userLiveData;
    @Inject
    public UserRepository(UserDataBase userDataBase){
        userDAO = userDataBase.getDAO();
        userLiveData = userDAO.getUser();
    }
    //private ArrayList<User> userList = new ArrayList<>();

    /*
    private final MutableLiveData<List<User>> userLiveData = new
            MutableLiveData<>(new ArrayList<>(userList));
    */

    public void addUser(User user){
        Executors.newSingleThreadExecutor().execute(() -> {
            userDAO.insert(user);
        });
        //userList.add(user);
        //userLiveData.setValue(new ArrayList<>(userList));
    }

    public void deleteUser(User user){
        Executors.newSingleThreadExecutor().execute(() -> {
            userDAO.delete(user);
        });
        //userList.remove(user);
        //userLiveData.setValue(new ArrayList<>(userList));
    }

    public LiveData<List<User>> getUser() {
        return userLiveData;
    }
}
