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

    @SerializedName("position_id")
    @Expose
    public int position_id;
    @SerializedName("first_name")
    @Expose
    public String first_name;
    @SerializedName("last_name")
    @Expose
    public String last_name;
    @SerializedName("locale")
    @Expose
    public String locale;
    @SerializedName("phone2")
    @Expose
    public String phone2;
    @SerializedName("phone1")
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

    @SerializedName("entry_id")
    @Expose
    public int entry_id;

    @SerializedName("token")
    @Expose
    public String token;

    @SerializedName("userid")
    @Expose
    public String userid;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("address")
    @Expose
    public String address;

    @SerializedName("log_id")
    @Expose
    public String logId;

    @SerializedName("user_id_to_add")
    @Expose
    public String userIdToAdd;

    @SerializedName("role_id")
    @Expose
    public Integer roleID;

    @SerializedName("permission")
    @Expose
    public int permission;

    @SerializedName("creator_role")
    @Expose
    public int creator_role;

    @SerializedName("log_date")
    @Expose
    public String log_date;

    @SerializedName("text")
    @Expose
    public String comment_text;

    public SetParams(String email, String password, String request, int role, String first_name, String last_name, String locale, String phone1, String phone2, String phone3, String phone4, String phone5, String fax, String company) {
        this.email = email;
        this.password = password;
        this.request = request;
        this.position_id = role;
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

    public SetParams(String user_id, String token, String email, String request, String e1, String e2) {
        this.user_id = user_id;
        this.token = token;
        this.email = email;
        this.request = request;
    }

    public SetParams(String user_id, String token, String locale, String request, String extra) {
        this.user_id = user_id;
        this.token = token;
        this.locale = locale;
        this.request = request;
    }

    public SetParams(int entry_id, String token, String userid, String request) {
        this.entry_id = entry_id;
        this.token = token;
        this.user_id = userid;
        this.request = request;
    }

    public SetParams(String request, String locale) {
        this.locale = locale;
        this.request = request;
    }

    public SetParams(String request, String locale, Integer roleType) {
        this.locale = locale;
        this.request = request;
        this.roleID = roleType;
    }

    public SetParams(String request, String user_id, String user_token, String address, String title, String date, int role) {
        this.request = request;
        this.user_id = user_id;
        this.token = user_token;
        this.address = address;
        this.title = title;
        this.log_date = date;
        this.creator_role = role;

    }

    public SetParams(String text, int entry_id, String token, String user_id, String request) {
        this.comment_text = text;
        this.entry_id = entry_id;
        this.token = token;
        this.user_id = user_id;
        this.request = request;
    }

    public SetParams(String token, String logid, String user_id, String userIdToAdd, int roleID, int permission, String request) {
        this.user_id = user_id;
        this.token = token;
        this.logId = logid;
        this.userIdToAdd = userIdToAdd;
        this.roleID = roleID;
        this.permission = permission;
        this.request = request;
    }

    public SetParams(String user_id, String token, String email, String request, String first_name, String last_name, String phone1, String fax, String company) {
        this.user_id = user_id;
        this.token = token;
        this.email = email;
        this.request = request;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone1 = phone1;
        this.fax = fax;
        this.company = company;
    }
}
