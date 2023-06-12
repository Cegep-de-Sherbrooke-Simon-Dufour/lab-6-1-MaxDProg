package com.example.testviewholder.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.testviewholder.Data.User;
import com.example.testviewholder.R;

public class AjoutUserFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ajout_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UserViewModel viewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        Button button1 = view.findViewById(R.id.button_ajouter);
        Button button2 = view.findViewById(R.id.button_annuler);

        EditText nom = view.findViewById(R.id.editTextText_name);
        EditText email = view.findViewById(R.id.editTextText_email);


        button1.setOnClickListener(v -> {
            viewModel.addUser(new User(email.getText().toString(),nom.getText().toString()));
            Navigation.findNavController(view).navigateUp();
        });

        button2.setOnClickListener(v -> {
            Navigation.findNavController(view).navigateUp();
        });
    }
}