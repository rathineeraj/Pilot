package com.pilot.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neeraj Rathi on 12/16/2015.
 */

public class GetRoleData implements Serializable {

    @SerializedName("rc")
    @Expose
    private Integer rc;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("he")
    @Expose
    private List<He> he = new ArrayList<>();

    @SerializedName("en")
    @Expose
    private List<He> en = new ArrayList<>();

    public List<He> getEn() {
        return en;
    }

    public void setEn(List<He> en) {
        this.en = en;
    }

    /**
     * @return The rc
     */
    public Integer getRc() {
        return rc;
    }

    /**
     * @param rc The rc
     */
    public void setRc(Integer rc) {
        this.rc = rc;
    }

    /**
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The he
     */
    public List<He> getHe() {
        return he;
    }

    /**
     * @param he The he
     */
    public void setHe(List<He> he) {
        this.he = he;
    }

    public class He {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("type")
        @Expose
        private Integer type;

        public Integer getType() {
            return type;
        }

        /**
         * @return The name
         */
        public String getName() {
            return name;
        }
    }
}