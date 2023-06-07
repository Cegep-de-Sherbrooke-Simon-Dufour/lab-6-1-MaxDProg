package com.example.testviewholder;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends ListAdapter<User, MyAdapter.ViewHolder> {

    public RecyclerViewCallBack<User> callback = (u) -> {};

    public MyAdapter() {
        super(new DiffUtil.ItemCallback<User>() {
            @Override
            public boolean areItemsTheSame(User oldUser, User newUser) {

                return oldUser == newUser;
            }
            @Override
            public boolean areContentsTheSame(User oldUser, User newUser) {

                return oldUser.equals(newUser);
            }
        });

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setText(getItem(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView_email;
        private final TextView textView_name;

        public ViewHolder(View view) {
            super(view);

            textView_email = view.findViewById(R.id.textView_email);
            textView_name = view.findViewById(R.id.textView_name);
            view.setOnClickListener(v->{
                callback.returnValue(getItem(getAdapterPosition()));
            });
        }

        public void setText(User user) {
            textView_email.setText(user.getEmail());
            textView_name.setText(user.getName());
        }
    }


}
