package com.pilot.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Neeraj Rathi on 12/13/2015.
 */
public class LoginData implements Serializable {

    @SerializedName("rc")
    @Expose
    private Integer rc;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("userid")
    @Expose
    private String userid;
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
    @SerializedName("last_used_log")
    @Expose
    private LastUsedLog lastUsedLog;
    @SerializedName("logs")
    @Expose
    private ArrayList<Log> logs = new ArrayList<Log>();

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
     * The lastUsedLog
     */
    public LastUsedLog getLastUsedLog() {
        return lastUsedLog;
    }

    /**
     *
     * @param lastUsedLog
     * The last_used_log
     */
    public void setLastUsedLog(LastUsedLog lastUsedLog) {
        this.lastUsedLog = lastUsedLog;
    }

    /**
     *
     * @return
     * The logs
     */
    public ArrayList<Log> getLogs() {
        return logs;
    }

    /**
     *
     * @param logs
     * The logs
     */
    public void setLogs(ArrayList<Log> logs) {
        this.logs = logs;
    }

    public class LastUsedLog implements Serializable {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("created_by")
        @Expose
        private String createdBy;
        @SerializedName("created_by_name")
        @Expose
        private String createdByName;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("created_at_unixtime")
        @Expose
        private Integer createdAtUnixtime;
        @SerializedName("role_in_log")
        @Expose
        private Integer roleInLog;
        @SerializedName("next_entry")
        @Expose
        private Integer nextEntry;
        @SerializedName("entries")
        @Expose
        private ArrayList<Entry> entries = new ArrayList<Entry>();

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The address
         */
        public String getAddress() {
            return address;
        }

        /**
         *
         * @param address
         * The address
         */
        public void setAddress(String address) {
            this.address = address;
        }

        /**
         *
         * @return
         * The createdBy
         */
        public String getCreatedBy() {
            return createdBy;
        }

        /**
         *
         * @param createdBy
         * The created_by
         */
        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        /**
         *
         * @return
         * The createdByName
         */
        public String getCreatedByName() {
            return createdByName;
        }

        /**
         *
         * @param createdByName
         * The created_by_name
         */
        public void setCreatedByName(String createdByName) {
            this.createdByName = createdByName;
        }

        /**
         *
         * @return
         * The createdAt
         */
        public String getCreatedAt() {
            return createdAt;
        }

        /**
         *
         * @param createdAt
         * The created_at
         */
        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        /**
         *
         * @return
         * The createdAtUnixtime
         */
        public Integer getCreatedAtUnixtime() {
            return createdAtUnixtime;
        }

        /**
         *
         * @param createdAtUnixtime
         * The created_at_unixtime
         */
        public void setCreatedAtUnixtime(Integer createdAtUnixtime) {
            this.createdAtUnixtime = createdAtUnixtime;
        }

        /**
         *
         * @return
         * The roleInLog
         */
        public Integer getRoleInLog() {
            return roleInLog;
        }

        /**
         *
         * @param roleInLog
         * The role_in_log
         */
        public void setRoleInLog(Integer roleInLog) {
            this.roleInLog = roleInLog;
        }

        /**
         *
         * @return
         * The nextEntry
         */
        public Integer getNextEntry() {
            return nextEntry;
        }

        /**
         *
         * @param nextEntry
         * The next_entry
         */
        public void setNextEntry(Integer nextEntry) {
            this.nextEntry = nextEntry;
        }

        /**
         *
         * @return
         * The entries
         */
        public ArrayList<Entry> getEntries() {
            return entries;
        }

        /**
         *
         * @param entries
         * The entries
         */
        public void setEntries(ArrayList<Entry> entries) {
            this.entries = entries;
        }

    }

    public class Log implements Serializable  {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

    }

    public class Entry implements Serializable {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("daily_seq_id")
        @Expose
        private Integer dailySeqId;
        @SerializedName("type")
        @Expose
        private Integer type;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("create_at")
        @Expose
        private String createAt;
        @SerializedName("create_at_unixtime")
        @Expose
        private Integer createAtUnixtime;
        @SerializedName("created_by")
        @Expose
        private String createdBy;
        @SerializedName("created_by_name")
        @Expose
        private String createdByName;
        @SerializedName("task_completed_by_name")
        @Expose
        private String taskCompletedByName;
        @SerializedName("created_by_role")
        @Expose
        private Integer createdByRole;
        @SerializedName("created_by_role_name")
        @Expose
        private String createdByRoleName;
        @SerializedName("num_of_comments")
        @Expose
        private Integer numOfComments;
        @SerializedName("in_favorites")
        @Expose
        private String inFavorites;
        @SerializedName("image_id")
        @Expose
        private String imageId;
        @SerializedName("type_name")
        @Expose
        private String typeName;
        @SerializedName("contractor_name")
        @Expose
        private String contractorName;
        @SerializedName("contractor_role_name")
        @Expose
        private String contractorRoleName;
        @SerializedName("contractor_id")
        @Expose
        private String contractorId;
        @SerializedName("tools_count")
        @Expose
        private Integer toolsCount;
        @SerializedName("tools_reji_count")
        @Expose
        private Integer toolsRejiCount;
        @SerializedName("tools_start_time")
        @Expose
        private String toolsStartTime;
        @SerializedName("tools_end_time")
        @Expose
        private String toolsEndTime;
        @SerializedName("tool_name")
        @Expose
        private String toolName;
        @SerializedName("workers_count")
        @Expose
        private Integer workersCount;
        @SerializedName("workers_reji_count")
        @Expose
        private Integer workersRejiCount;
        @SerializedName("workers_start_time")
        @Expose
        private String workersStartTime;
        @SerializedName("workers_end_time")
        @Expose
        private String workersEndTime;

        @SerializedName("has_blueprint_location")
        @Expose
        private String hasBluePrintLocation;
        @SerializedName("reminder_date")
        @Expose
        private String reminderDate;
        @SerializedName("reminder_time")
        @Expose
        private String reminderTime;
        @SerializedName("reminder_time_unix")
        @Expose
        private Integer reminderTimeUnix;

        /**
         * @return The id
         */
        public int getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * @return The dailySeqId
         */
        public Integer getDailySeqId() {
            return dailySeqId;
        }

        /**
         * @param dailySeqId The daily_seq_id
         */
        public void setDailySeqId(Integer dailySeqId) {
            this.dailySeqId = dailySeqId;
        }

        /**
         * @return The type
         */
        public Integer getType() {
            return type;
        }

        /**
         * @param type The type
         */
        public void setType(Integer type) {
            this.type = type;
        }

        /**
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @param title The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * @return The text
         */
        public String getText() {
            return text;
        }

        /**
         * @param text The text
         */
        public void setText(String text) {
            this.text = text;
        }

        /**
         * @return The createAt
         */
        public String getCreateAt() {
            return createAt;
        }

        /**
         * @param createAt The create_at
         */
        public void setCreateAt(String createAt) {
            this.createAt = createAt;
        }

        /**
         * @return The createAtUnixtime
         */
        public Integer getCreateAtUnixtime() {
            return createAtUnixtime;
        }

        /**
         * @param createAtUnixtime The create_at_unixtime
         */
        public void setCreateAtUnixtime(Integer createAtUnixtime) {
            this.createAtUnixtime = createAtUnixtime;
        }

        /**
         * @return The createdBy
         */
        public String getCreatedBy() {
            return createdBy;
        }

        /**
         * @param createdBy The created_by
         */
        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        /**
         * @return The createdByName
         */
        public String getCreatedByName() {
            return createdByName;
        }

        /**
         * @param createdByName The created_by_name
         */
        public void setCreatedByName(String createdByName) {
            this.createdByName = createdByName;
        }

        /**
         * @return The taskCompletedByName
         */
        public String getTaskCompletedByName() {
            return taskCompletedByName;
        }

        /**
         * @param taskCompletedByName The task_completed_by_name
         */
        public void setTaskCompletedByName(String taskCompletedByName) {
            this.taskCompletedByName = taskCompletedByName;
        }

        /**
         * @return The createdByRole
         */
        public Integer getCreatedByRole() {
            return createdByRole;
        }

        /**
         * @param createdByRole The created_by_role
         */
        public void setCreatedByRole(Integer createdByRole) {
            this.createdByRole = createdByRole;
        }

        /**
         * @return The createdByRoleName
         */
        public String getCreatedByRoleName() {
            return createdByRoleName;
        }

        /**
         * @param createdByRoleName The created_by_role_name
         */
        public void setCreatedByRoleName(String createdByRoleName) {
            this.createdByRoleName = createdByRoleName;
        }

        /**
         * @return The numOfComments
         */
        public Integer getNumOfComments() {
            return numOfComments;
        }

        /**
         * @param numOfComments The num_of_comments
         */
        public void setNumOfComments(Integer numOfComments) {
            this.numOfComments = numOfComments;
        }

        /**
         * @return The inFavorites
         */
        public String getInFavorites() {
            return inFavorites;
        }

        /**
         * @param inFavorites The in_favorites
         */
        public void setInFavorites(String inFavorites) {
            this.inFavorites = inFavorites;
        }

        /**
         * @return The imageId
         */
        public String getImageId() {
            return imageId;
        }

        /**
         * @param imageId The image_id
         */
        public void setImageId(String imageId) {
            this.imageId = imageId;
        }

        /**
         * @return The typeName
         */
        public String getTypeName() {
            return typeName;
        }

        /**
         * @param typeName The type_name
         */
        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        /**
         * @return The contractorId
         */
        public String getContractorId() {
            return contractorId;
        }

        /**
         * @param contractorId The contractor_id
         */
        public void setContractorId(String contractorId) {
            this.contractorId = contractorId;
        }

        /**
         * @return The contractorId
         */
        public String getContractorName() {
            return contractorName;
        }

        /**
         * @param contractorName The contractorName
         */
        public void setContractorName(String contractorName) {
            this.contractorName = contractorName;
        }

        /**
         * @return The contractorId
         */
        public String getContractorRoleName() {
            return contractorRoleName;
        }

        /**
         * @param contractorRoleName The contractorRoleName
         */
        public void setContractorRoleName(String contractorRoleName) {
            this.contractorRoleName = contractorRoleName;
        }

        /**
         * @return The toolsCount
         */
        public Integer getToolsCount() {
            return toolsCount;
        }

        /**
         * @param toolsCount The tools_count
         */
        public void setToolsCount(Integer toolsCount) {
            this.toolsCount = toolsCount;
        }

        /**
         * @return The toolsRejiCount
         */
        public Integer getToolsRejiCount() {
            return toolsRejiCount;
        }

        /**
         * @param toolsRejiCount The tools_reji_count
         */
        public void setToolsRejiCount(Integer toolsRejiCount) {
            this.toolsRejiCount = toolsRejiCount;
        }

        /**
         * @return The toolsStartTime
         */
        public String getToolsStartTime() {
            return toolsStartTime;
        }

        /**
         * @param toolsStartTime The tools_start_time
         */
        public void setToolsStartTime(String toolsStartTime) {
            this.toolsStartTime = toolsStartTime;
        }

        /**
         * @return The toolsEndTime
         */
        public String getToolsEndTime() {
            return toolsEndTime;
        }

        /**
         * @param toolsEndTime The tools_end_time
         */
        public void setToolsEndTime(String toolsEndTime) {
            this.toolsEndTime = toolsEndTime;
        }

        /**
         * @return The toolName
         */
        public String getToolName() {
            return toolName;
        }

        /**
         * @param toolName The tool_name
         */
        public void setToolName(String toolName) {
            this.toolName = toolName;
        }

        /**
         * @return The workersCount
         */
        public Integer getWorkersCount() {
            return workersCount;
        }

        /**
         * @param workersCount The workers_count
         */
        public void setWorkersCount(Integer workersCount) {
            this.workersCount = workersCount;
        }

        /**
         * @return The workersRejiCount
         */
        public Integer getWorkersRejiCount() {
            return workersRejiCount;
        }

        /**
         * @param workersRejiCount The workers_reji_count
         */
        public void setWorkersRejiCount(Integer workersRejiCount) {
            this.workersRejiCount = workersRejiCount;
        }

        /**
         * @return The workersStartTime
         */
        public String getWorkersStartTime() {
            return workersStartTime;
        }

        /**
         * @param workersStartTime The workers_start_time
         */
        public void setWorkersStartTime(String workersStartTime) {
            this.workersStartTime = workersStartTime;
        }

        /**
         * @return The workersEndTime
         */
        public String getWorkersEndTime() {
            return workersEndTime;
        }

        /**
         * @param workersEndTime The workers_end_time
         */
        public void setWorkersEndTime(String workersEndTime) {
            this.workersEndTime = workersEndTime;
        }


        /**
         * @return The hasBluePrintLocation
         */
        public String hasBluePrintLocation() {
            return hasBluePrintLocation;
        }

        /**
         * @param bluePrintLocation The workers_end_time
         */
        public void setHasBluePrintLocation(String bluePrintLocation) {
            this.hasBluePrintLocation = bluePrintLocation;
        }


        /**
         *
         * @return
         * The reminderDate
         */
        public String getReminderDate() {
            return reminderDate;
        }

        /**
         *
         * @param reminderDate
         * The reminder_date
         */
        public void setReminderDate(String reminderDate) {
            this.reminderDate = reminderDate;
        }

        /**
         *
         * @return
         * The reminderTime
         */
        public String getReminderTime() {
            return reminderTime;
        }

        /**
         *
         * @param reminderTime
         * The reminder_time
         */
        public void setReminderTime(String reminderTime) {
            this.reminderTime = reminderTime;
        }

        /**
         *
         * @return
         * The reminderTimeUnix
         */
        public Integer getReminderTimeUnix() {
            return reminderTimeUnix;
        }

        /**
         *
         * @param reminderTimeUnix
         * The reminder_time_unix
         */
        public void setReminderTimeUnix(Integer reminderTimeUnix) {
            this.reminderTimeUnix = reminderTimeUnix;
        }

        @Override
        public boolean  equals (Object object) {
            boolean result = false;
            if (object == null || object.getClass() != getClass()) {
                result = false;
            } else {
                Entry entry = (Entry) object;
                if (this.id == entry.getId()) {
                    result = true;
                }
            }
            return result;
        }
    }
}
