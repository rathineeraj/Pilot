package com.pilot.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Neeraj Rathi on 12/15/2015.
 */
public class UserProfileData implements Serializable {

    @SerializedName("request")
    @Expose
    private String request;
    @SerializedName("rc")
    @Expose
    private Integer rc;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("phone1")
    @Expose
    private String phone1;
    @SerializedName("phone2")
    @Expose
    private String phone2;
    @SerializedName("phone3")
    @Expose
    private String phone3;
    @SerializedName("phone4")
    @Expose
    private String phone4;
    @SerializedName("phone5")
    @Expose
    private String phone5;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("mute_notifications")
    @Expose
    private int muteNotifications;

    public UserProfileData(String request, String userid, String token, String displayName, String locale, String company, String phone1, String phone2, String phone3, String phone4, String phone5, String fax, String email, int muteNotifications) {
        this.request = request;
        this.userId = userid;
        this.token = token;
        this.displayName = displayName;
        this.locale = locale;
        this.company = company;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.phone4 = phone4;
        this.phone5 = phone5;
        this.fax = fax;
        this.email = email;
        this.muteNotifications = muteNotifications;
    }

    public UserProfileData(String request, String email) {
        this.request = request;
        this.email = email;
    }

    /**
     *
     * @return
     * The request
     */
    public String getRequest() {
        return request;
    }

    /**
     *
     * @param request
     * The request
     */
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     *
     * @return
     * The rc
     */
    public Integer getRc() {
        return rc;
    }

    /**
     *
     * @param rc
     * The rc
     */
    public void setRc(Integer rc) {
        this.rc = rc;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     *
     * @param userid
     * The userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }


    /**
     *
     * @return
     * The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The token
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     * The token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     *
     * @return
     * The type
     */
    public Integer getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     *
     * @param displayName
     * The display_name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     *
     * @return
     * The locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     *
     * @param locale
     * The locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     *
     * @return
     * The company
     */
    public String getCompany() {
        return company;
    }

    /**
     *
     * @param company
     * The company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     *
     * @return
     * The phone1
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     *
     * @param phone1
     * The phone1
     */
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    /**
     *
     * @return
     * The phone2
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     *
     * @param phone2
     * The phone2
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    /**
     *
     * @return
     * The phone3
     */
    public String getPhone3() {
        return phone3;
    }

    /**
     *
     * @param phone3
     * The phone3
     */
    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    /**
     *
     * @return
     * The phone4
     */
    public String getPhone4() {
        return phone4;
    }

    /**
     *
     * @param phone4
     * The phone4
     */
    public void setPhone4(String phone4) {
        this.phone4 = phone4;
    }

    /**
     *
     * @return
     * The phone5
     */
    public String getPhone5() {
        return phone5;
    }

    /**
     *
     * @param phone5
     * The phone5
     */
    public void setPhone5(String phone5) {
        this.phone5 = phone5;
    }

    /**
     *
     * @return
     * The fax
     */
    public String getFax() {
        return fax;
    }

    /**
     *
     * @param fax
     * The fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     * The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     * The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     * The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     * The muteNotifications
     */
    public Integer getMuteNotifications() {
        return muteNotifications;
    }

    /**
     *
     * @param muteNotifications
     * The mute_notifications
     */
    public void setMuteNotifications(Integer muteNotifications) {
        this.muteNotifications = muteNotifications;
    }

}
