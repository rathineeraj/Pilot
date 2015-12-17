package com.pilot.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Neeraj Rathi on 12/13/2015.
 */
public class SetParams implements Serializable {

    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("password")
    @Expose
    public String password;
    @SerializedName("request")
    @Expose
    public String request;

    public SetParams(String request, String email, String password) {
        this.email = email;
        this.request = request;
        this.password = password;
    }
    @SerializedName("role")
    @Expose
    public String role;
    @SerializedName("first_name")
    @Expose
    public String first_name;
    @SerializedName("last_name")
    @Expose
    public String last_name;
    @SerializedName("locale")
    @Expose
    public String locale;
    @SerializedName("phone1")
    @Expose
    public String phone2;
    @SerializedName("phone2")
    @Expose
    public String phone1;
    @SerializedName("phone3")
    @Expose
    public String phone3;
    @SerializedName("phone4")
    @Expose
    public String phone4;
    @SerializedName("phone5")
    @Expose
    public String phone5;
    @SerializedName("fax")
    @Expose
    public String fax;

    @SerializedName("company")
    @Expose
    public String company;


    @SerializedName("user_id")
    @Expose
    public String user_id;

    @SerializedName("token")
    @Expose
    public String token;

    @SerializedName("userid")
    @Expose
    public String userid;

    public SetParams(String email, String password, String request, String role, String first_name, String last_name, String locale, String phone1, String phone2, String phone3, String phone4, String phone5, String fax, String company) {
        this.email = email;
        this.password = password;
        this.request = request;
        this.role = role;
        this.first_name = first_name;
        this.last_name = last_name;
        this.locale = locale;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.phone4 = phone4;
        this.phone5 = phone5;
        this.fax = fax;
        this.company = company;
    }

    public SetParams(String user_id, String token, String userid, String request) {
        this.user_id = user_id;
        this.token = token;
        this.userid = userid;
        this.request = request;
    }

    public SetParams(String request, String locale) {
        this.locale = locale;
        this.request = request;
    }
}
