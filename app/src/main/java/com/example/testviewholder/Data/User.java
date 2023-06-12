package com.example.testviewholder.Data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;
    private String email;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return email.equals(user.email) && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name);
    }
}
