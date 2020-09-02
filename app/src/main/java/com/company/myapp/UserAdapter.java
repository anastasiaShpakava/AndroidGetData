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
    private List<Address> addresses;
    private Context context;

    public UserAdapter(Context context, List<User> users, List<Address> addresses) {
        this.users = users;
        this.addresses = addresses;
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
        final Address address = addresses.get (position);
        holder.id.setText(String.valueOf(user.getId()));
        holder.name.setText(user.getName());
        holder.username.setText(user.getUsername());
        holder.email.setText(user.getEmail());
        holder.phone.setText(user.getPhone());
        holder.website.setText(user.getWebsite());
        holder.street.setText(address.getStreet());
        holder.suite.setText(address.getSuite());
        holder.city.setText(address.getCity());
        holder.zipcode.setText(address.getZipcode());


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name, username, email, phone, website,id, street, suite, city,zipcode ;


        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            username = view.findViewById(R.id.username);
            email = view.findViewById(R.id.email);
            phone = view.findViewById(R.id.phone);
            website = view.findViewById(R.id.website);
            id = view.findViewById(R.id.id);
            street = view.findViewById(R.id.street);
            suite = view.findViewById(R.id.suite);
            city = view.findViewById(R.id.city);
            zipcode = view.findViewById(R.id.zipcode);
        }
    }
}
