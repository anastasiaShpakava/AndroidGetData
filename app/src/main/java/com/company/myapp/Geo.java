
package com.company.myapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geo extends UserInfo{

    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;

    public Geo(Integer id, String name, String username, String email, Address address, String phone, String website, Company company) {
        super(id, name, username, email, address, phone, website, company);
    }


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

}
