package com.example.testviewholder;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class UserListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       UserViewModel viewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_Users);
        FloatingActionButton button = view.findViewById(R.id.floatingActionButton_add);

        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel.getUser().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.submitList(users);
            }
        });

        button.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_userListFragment_to_ajoutUserFragment);
        });

        adapter.callback = (User) -> {
            viewModel.deleteUser(User);
        };
    }
}