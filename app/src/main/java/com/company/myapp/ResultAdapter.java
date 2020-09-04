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
    private static int TYPE_ADDRESS = 1;
    private static int TYPE_USER = 2;

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
        if (viewType == TYPE_ADDRESS){
            return new AddressViewHolder (layoutInflater.inflate(R.layout.list_item, parent, false));
        }else if(viewType == TYPE_USER){
            return new UsersViewHolder(layoutInflater.inflate(R.layout.list_item, parent, false));
        }else return new AddressViewHolder(layoutInflater.inflate(R.layout.list_item, parent, false));
//        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
//        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
if (holder instanceof AddressViewHolder){
Address address = new Address();
((AddressViewHolder) holder).city.setText(address.getCity());
} else if (holder instanceof UsersViewHolder){
UsersViewHolder usersViewHolder = (UsersViewHolder) holder;
    final User user = users.get(position);
    ((UsersViewHolder) holder).name.setText(user.getName());

}
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public int getItemViewType(int position) {
      if (position==1){
          return TYPE_ADDRESS;
      }else
          return TYPE_USER;
    }

public static class AddressViewHolder extends RecyclerView.ViewHolder{
final TextView city;
    public AddressViewHolder(@NonNull View itemView) {
        super(itemView);
        city = itemView.findViewById(R.id.city);
    }
}

   public static class  UsersViewHolder extends RecyclerView.ViewHolder{
       final TextView name;
        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);

        }
    }
}
