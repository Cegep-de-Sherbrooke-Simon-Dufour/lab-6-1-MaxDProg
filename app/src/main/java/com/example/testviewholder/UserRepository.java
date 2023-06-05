package com.example.testviewholder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {
    @Inject
    public UserRepository(){}
    private ArrayList<User> userList = new ArrayList<>();

    public void addUser(User user){
        userList.add(user);
    }

    public void deleteUser(User user){
        userList.remove(user);
    }

    public List<User> getUser() {
        return userList;
    }
}
