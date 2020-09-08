package com.company.myapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class UserInfo {
    @SerializedName("idI")
    @Expose
    private Integer id;
    @SerializedName("nameI")
    @Expose
    private String name;
    @SerializedName("usernameI")
    @Expose
    private String username;
    @SerializedName("emailI")
    @Expose
    private String email;
    @SerializedName("addressI")
    @Expose
    private Address address;
    @SerializedName("phoneI")
    @Expose
    private String phone;
    @SerializedName("websiteI")
    @Expose
    private String website;
    @SerializedName("companyI")
    @Expose
    private Company company;

    public UserInfo(Integer id, String name, String username, String email,
                    Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public UserInfo() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
