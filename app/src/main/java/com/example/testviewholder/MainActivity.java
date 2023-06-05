package com.example.testviewholder;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    UserViewModel viewModel;


    private MyAdapter adapter = new MyAdapter();

    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    Intent data = result.getData();
                    System.out.println(result.getResultCode());
                    if(result.getResultCode() == RESULT_OK) {
                        viewModel.addUser(new User(String.valueOf(data.getStringExtra("nom")), String.valueOf(data.getStringExtra("email"))));
                        adapter.submitList(new ArrayList<>(viewModel.getUser()));
                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        FloatingActionButton btn1 = findViewById(R.id.floatingActionButton_add);
        btn1.setOnClickListener(v -> {
            Intent intent = new Intent( MainActivity.this, AjoutUserActivity.class);
            mGetContent.launch(intent);
        });

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



        RecyclerView recyclerView = findViewById(R.id.recyclerView_Users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.submitList(new ArrayList<>(viewModel.getUser()));
        adapter.callback = (User) -> {
            viewModel.deleteUser(User);
            adapter.submitList(new ArrayList<>(viewModel.getUser()));
        };
    }
}