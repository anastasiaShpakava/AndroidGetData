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
    private static int TYPE_USER = 0;
    private static int TYPE_ADDRESS = 1;
    private static int TYPE_GEO = 2;
    private static int TYPE_COMPANY = 3;

    private LayoutInflater layoutInflater;
    private List<UserInfo> usersInfo;


    public ResultAdapter(Context context, List<UserInfo> userInfo) {
        this.usersInfo = userInfo;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        if (viewType == TYPE_ADDRESS) {
            return new AddressViewHolder(view);
        } else if (viewType == TYPE_USER) {
            return new UsersViewHolder(view);
        } else if (viewType == TYPE_GEO) {
            return new GeoViewHolder(view);
        } else
            return new CompanyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UserInfo user = usersInfo.get(position);
        if (holder instanceof UsersViewHolder) {

            ((UsersViewHolder) holder).id.setText(String.valueOf(user.getId()));
            ((UsersViewHolder) holder).name.setText(user.getName());
            ((UsersViewHolder) holder).userName.setText(user.getUsername());
            ((UsersViewHolder) holder).email.setText(user.getEmail());
            ((UsersViewHolder) holder).phone.setText(user.getPhone());
            ((UsersViewHolder) holder).website.setText(user.getWebsite());

        } else if (holder instanceof AddressViewHolder) {
            Address address = user.getAddress();
            ((AddressViewHolder) holder).street.setText(address.getStreet());
            ((AddressViewHolder) holder).suite.setText(address.getSuite());
            ((AddressViewHolder) holder).city.setText(address.getCity());
            ((AddressViewHolder) holder).zipcode.setText(address.getZipcode());
        } else if (holder instanceof CompanyViewHolder) {
            Company company = user.getCompany();
            ((CompanyViewHolder) holder).companyName.setText(company.getName());
            ((CompanyViewHolder) holder).catchPhrase.setText(company.getCatchPhrase());
            ((CompanyViewHolder) holder).bs.setText(company.getBs());
        } else if (holder instanceof GeoViewHolder) {
            Geo geo = user.getAddress().getGeo();
            ((GeoViewHolder) holder).lat.setText(geo.getLat());
            ((GeoViewHolder) holder).lng.setText(geo.getLng());
        }
    }

    @Override
    public int getItemCount() {
        return usersInfo.size();
    }


    @Override
    public int getItemViewType(int position) {
        UserInfo userInfos = usersInfo.get(position);
        if (userInfos instanceof User){
            return TYPE_USER;
        }else if (userInfos instanceof Address){
            return TYPE_ADDRESS;
        }else if(userInfos instanceof Geo){
            return TYPE_GEO;
        }else return TYPE_COMPANY;
    }

    public static class UsersViewHolder extends RecyclerView.ViewHolder {
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

    public static class AddressViewHolder extends RecyclerView.ViewHolder {
        final TextView street, suite, city, zipcode;

        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            street = itemView.findViewById(R.id.street);
            suite = itemView.findViewById(R.id.suite);
            city = itemView.findViewById(R.id.city);
            zipcode = itemView.findViewById(R.id.zipcode);
        }
    }


    public static class CompanyViewHolder extends RecyclerView.ViewHolder {
        final TextView companyName, catchPhrase, bs;

        public CompanyViewHolder(@NonNull View itemView) {
            super(itemView);
            companyName = itemView.findViewById(R.id.companyName);
            catchPhrase = itemView.findViewById(R.id.catchPhrase);
            bs = itemView.findViewById(R.id.bs);
        }
    }

    public static class GeoViewHolder extends RecyclerView.ViewHolder {
        final TextView lat, lng;

        public GeoViewHolder(@NonNull View itemView) {
            super(itemView);
            lat = itemView.findViewById(R.id.lat);
            lng = itemView.findViewById(R.id.lng);
        }
    }
}
