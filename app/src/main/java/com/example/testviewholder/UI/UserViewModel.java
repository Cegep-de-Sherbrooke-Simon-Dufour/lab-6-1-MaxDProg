package com.example.testviewholder.UI;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.testviewholder.Data.User;
import com.example.testviewholder.Data.UserRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UserViewModel extends ViewModel {
    private final UserRepository userRepository;

    @Inject
    public UserViewModel(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        userRepository.addUser(user);
    }

    public void deleteUser(User user){
        userRepository.deleteUser(user);
    }

    public LiveData<List<User>> getUser(){
        return userRepository.getUser();
    }

    public static class UserDAO {
    }
}
