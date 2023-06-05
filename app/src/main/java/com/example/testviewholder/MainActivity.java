package com.example.testviewholder;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> user = new ArrayList<>();

    private MyAdapter adapter = new MyAdapter();

    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    Intent data = result.getData();
                    System.out.println(result.getResultCode());
                    if(result.getResultCode() == RESULT_OK) {
                        user.add(new User(String.valueOf(data.getStringExtra("nom")), String.valueOf(data.getStringExtra("email"))));
                        adapter.submitList(new ArrayList<>(user));
                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton btn1 = findViewById(R.id.floatingActionButton_add);
        btn1.setOnClickListener(v -> {
            Intent intent = new Intent( MainActivity.this, AjoutUserActivity.class);
            mGetContent.launch(intent);
        });

        user.add(new User("blablabla@email.com", "Jesuis Unelicorne"));
        user.add(new User("patate@email.com", "patate frite"));
        user.add(new User("bob@email.com", "bob ette"));
        user.add(new User("patente@email.com", "patente agosse"));
        user.add(new User("chose@email.com", "chose binouche"));
        user.add(new User("zut@email.com", "de flutte"));
        user.add(new User("mongol@email.com", "mongol fier"));
        user.add(new User("marais@email.com", "boueux etant"));
        user.add(new User("TV@email.com", "tele vision"));
        user.add(new User("planche@email.com", "planche adecouper"));
        user.add(new User("jepense@email.com", "jenai asser"));
        user.add(new User("undernier@email.com", "encore undernier"));



        RecyclerView recyclerView = findViewById(R.id.recyclerView_Users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.submitList(new ArrayList<>(user));
        adapter.callback = (User) -> {
            user.remove(User);
            adapter.submitList(new ArrayList<>(user));
        };
    }
}