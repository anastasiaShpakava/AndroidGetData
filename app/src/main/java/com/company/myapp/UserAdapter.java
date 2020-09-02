package com.company.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<User> users;
    private Context context;

    public UserAdapter(Context context, List<User> users) {
        this.users = users;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, final int position) {
        final User user = users.get(position);
        holder.name.setText(user.getName());
        holder.username.setText(user.getUsername());
        holder.email.setText(user.getEmail());
        holder.phone.setText(user.getPhone());
        holder.website.setText(user.getWebsite());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name, username, email, phone, website;


        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            username = view.findViewById(R.id.username);
            email = view.findViewById(R.id.email);
            phone = view.findViewById(R.id.phone);
            website = view.findViewById(R.id.website);
        }
    }
}
