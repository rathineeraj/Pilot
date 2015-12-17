package com.pilot.object;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Neeraj Rathi on 12/15/2015.
 */

public class RegisterData implements Serializable {

    @SerializedName("userid")

    private String userid;

    @SerializedName("token")

    private String token;

    @SerializedName("message")
    private String message;

    public RegisterData() {
        this.userid = "";
        this.token = "";
    }

    public String getUserid() {
        return userid;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
}
