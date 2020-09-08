
package com.company.myapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company extends UserInfo{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("catchPhrase")
    @Expose
    private String catchPhrase;
    @SerializedName("bs")
    @Expose
    private String bs;

    public Company(Integer id, String name, String username, String email, Address address, String phone, String website, Company company) {
        super(id, name, username, email, address, phone, website, company);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

}
