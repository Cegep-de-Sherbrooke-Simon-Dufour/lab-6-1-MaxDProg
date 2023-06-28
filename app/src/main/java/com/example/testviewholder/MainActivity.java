package com.example.testviewholder;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.toolbar));

        UserViewModel viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        viewModel.addUser(new User("blablabla@email.com", "Jesuis Unelicorne"));
        viewModel.addUser(new User("patate@email.com", "patate frite"));
        viewModel.addUser(new User("bob@email.com", "bob ette"));
        viewModel.addUser(new User("chose@email.com", "chose binouche"));
        viewModel.addUser(new User("zut@email.com", "de flutte"));
        viewModel.addUser(new User("patente@email.com", "patente agosse"));
        viewModel.addUser(new User("mongol@email.com", "mongol fier"));
        viewModel.addUser(new User("marais@email.com", "boueux etant"));
        viewModel.addUser(new User("TV@email.com", "tele vision"));
        viewModel.addUser(new User("planche@email.com", "planche adecouper"));
        viewModel.addUser(new User("jepense@email.com", "jenai asser"));
        viewModel.addUser(new User("undernier@email.com", "encore undernier"));

        NavHostFragment navHostFragment = (NavHostFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
            NavigationUI.setupActionBarWithNavController(this, navController);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }
}