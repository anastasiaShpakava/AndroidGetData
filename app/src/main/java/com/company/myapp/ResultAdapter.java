package com.company.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int TYPE_ADDRESS= 1;
    private static int TYPE_USER = 5;

    private LayoutInflater layoutInflater;
    private Context context;
    private List<User> users;

    public ResultAdapter(Context context, List<User> users) {
        this.users = users;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_ADDRESS){
             view = layoutInflater.inflate(R.layout.list_item, parent, false);
             return  new AddressViewHolder(view);
        }else if (viewType ==TYPE_USER) {
            view = layoutInflater.inflate(R.layout.list_item, parent, false);
            return new UsersViewHolder(view);
        }else view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UsersViewHolder) {
            final User user = users.get(position);
            ((UsersViewHolder) holder).id.setText(String.valueOf(user.getId()));
            ((UsersViewHolder) holder).name.setText(user.getName());
            ((UsersViewHolder) holder).userName.setText(user.getUsername());
            ((UsersViewHolder) holder).email.setText(user.getEmail());
            ((UsersViewHolder) holder).phone.setText(user.getPhone());
            ((UsersViewHolder) holder).website.setText(user.getWebsite());
        } else if (holder instanceof AddressViewHolder) {
            Address address = new Address();
            ((AddressViewHolder) holder).street.setText(address.getStreet());
            ((AddressViewHolder) holder).suite.setText(address.getSuite());
            ((AddressViewHolder) holder).city.setText(address.getCity());
            ((AddressViewHolder) holder).zipcode.setText(address.getZipcode());
        }
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position <=4 )? TYPE_USER:TYPE_ADDRESS;
    }

public static class AddressViewHolder extends RecyclerView.ViewHolder{
final TextView street, suite, city, zipcode;
    public AddressViewHolder(@NonNull View itemView) {
        super(itemView);
        street = itemView.findViewById(R.id.street);
        suite = itemView.findViewById(R.id.suite);
        city = itemView.findViewById(R.id.city);
        zipcode = itemView.findViewById(R.id.zipcode);
    }
}

   public static class  UsersViewHolder extends RecyclerView.ViewHolder{
       final TextView id, name, userName, email, phone, website;
        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            userName = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
            website = itemView.findViewById(R.id.website);
        }
    }
}
