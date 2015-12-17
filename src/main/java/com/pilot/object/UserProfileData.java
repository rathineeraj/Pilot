package com.pilot.object;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Neeraj Rathi on 12/15/2015.
 */
public class UserProfileData implements Serializable {

    @SerializedName("phone1")

    private String phone1;

    @SerializedName("phone2")

    private String phone2;

    @SerializedName("phone3")
    private String phone3;

    @SerializedName("phone4")
    private String phone4;

    @SerializedName("phone5")
    private String phone5;

    @SerializedName("locale")
    private String locale;

    @SerializedName("company")
    private String company;

    @SerializedName("message")
    private String message;

    @SerializedName("fax")
    private String fax;

    public String getPhone1() {
        return phone1;
    }

    public String getFax() {
        return fax;
    }

    public String getCompany() {
        return company;
    }

    public String getLocale() {
        return locale;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public String getPhone4() {
        return phone4;
    }

    public String getPhone5() {
        return phone5;
    }

    public String getMessage() {
        return message;
    }
}
