package com.pilot.object;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Neeraj Rathi on 12/13/2015.
 */
public class LoginData implements Serializable {

    @SerializedName("userid")

    private String userid;

    @SerializedName("display_name")

    private String display_name;

    @SerializedName("token")

    private String token;

    @SerializedName("message")
    private String message;

    public LoginData() {
        this.userid = "";
        this.token = "";
        this.display_name = "";
    }

    public String getUserid() {
        return userid;
    }

    public String getToken() {
        return token;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getMessage() {
        return message;
    }
}
