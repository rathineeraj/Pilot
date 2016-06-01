package com.pilot.API;

import com.pilot.object.AddLogEntry;
import com.pilot.object.AddMaterialOrder;
import com.pilot.object.AddPictureResponse;
import com.pilot.object.ApiResponse;
import com.pilot.object.ApprovedDoc;
import com.pilot.object.BluePrintInfo;
import com.pilot.object.CalenderSearchParams;
import com.pilot.object.ContractorInfo;
import com.pilot.object.CreateLog;
import com.pilot.object.CreateNewLog;
import com.pilot.object.FillDoc;
import com.pilot.object.GetCategories;
import com.pilot.object.GetLogUser;
import com.pilot.object.GetPositionsData;
import com.pilot.object.GetRoles;
import com.pilot.object.GetTasks;
import com.pilot.object.GetTools;
import com.pilot.object.LogDataByID;
import com.pilot.object.LogSignByMonths;
import com.pilot.object.LogSummary;
import com.pilot.object.LoginData;
import com.pilot.object.MaterialDataByID;
import com.pilot.object.NotificationDetail;
import com.pilot.object.OrderData;
import com.pilot.object.PrepareImage;
import com.pilot.object.QADocDetail;
import com.pilot.object.QADocList;
import com.pilot.object.RegisterData;
import com.pilot.object.ResponseMessage;
import com.pilot.object.SearchParams;
import com.pilot.object.SetParams;
import com.pilot.object.SetParams2;
import com.pilot.object.SetParams3;
import com.pilot.object.SupportReasons;
import com.pilot.object.ToolsInfo;
import com.pilot.object.UpdateLogUser;
import com.pilot.object.UpdateUser;
import com.pilot.object.UserLogs;
import com.pilot.object.UserProfileData;
import com.pilot.object.VendorsList;
import com.pilot.object.WorkersList;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;


public interface APIService {
    @POST("index.php/")
    Call<LoginData> login(@Body SetParams body);
    @POST("index.php/")
    Call<UserProfileData> forgetPassword(@Body UserProfileData body);

    @POST("index.php/")
    Call<RegisterData> register(@Body SetParams body);

    @POST("index.php/")
    Call<UserProfileData> updateUser(@Body UserProfileData body);

    @POST("index.php/")
    Call<UserProfileData> updateOtherUser(@Body UpdateUser body);

    @POST("index.php/")
    Call<UserProfileData> getUser(@Body SetParams body);

    @POST("index.php/")
    Call<GetPositionsData> getUserRoles(@Body SetParams body);

    @POST("index.php/")
    Call<GetTasks> getTasks(@Body SetParams body);

    @POST("index.php/")
    Call<GetRoles> getRoles(@Body SetParams body);

    @POST("index.php/")
    Call<CreateLog> createLog(@Body CreateNewLog body);

    @POST("index.php/")
    Call<CreateLog> createLog(@Body SetParams body);

    @POST("index.php/")
    Call<LoginData.LastUsedLog> getLog(@Body SetParams2 body);

    @POST("index.php/")
    Call<LoginData.LastUsedLog> getCalenderLog(@Body SearchParams body);

    @POST("index.php/")
    Call<UserLogs> getLogs(@Body SetParams2 body);

    @POST("index.php/")
    Call<LogDataByID> getLogEntryPicture(@Body SetParams body);


    @POST("index.php/")
    Call<AddPictureResponse> addLogEntryPicture(@Body AddLogEntry body);

    @POST("index.php/")
    Call<ApiResponse> addComment(@Body SetParams body);

    @POST("index.php/")
    Call<ApiResponse> deleteComment(@Body SetParams2 body);


    @POST("index.php/")
    Call<ApiResponse> updateComment(@Body SetParams2 body);

    @POST("index.php/")
    Call<PrepareImage> prepareImage(@Body SetParams2 body);


    @POST("index.php/")
    Call<GetLogUser> getLogUser(@Body SetParams2 body);

    @POST("index.php/")
    Call<ApiResponse> deleteLogEntry(@Body SetParams2 body);

    @POST("index.php/")
    Call<OrderData> getOrderList(@Body SetParams2 body);

    @POST("index.php/")
    Call<GetTasks> getUnitOfMeasure(@Body SetParams body);

    @POST("index.php/")
    Call<VendorsList> getVendorsList(@Body SetParams2 body);

    @POST("index.php/")
    Call<ResponseMessage> addMaterialOrder(@Body AddMaterialOrder body);

    @POST("index.php/")
    Call<WorkersList> getPeopleList(@Body SetParams2 body);

    @POST("index.php/")
    Call<ToolsInfo> getToolsList(@Body SetParams2 body);

    @POST("index.php/")
    Call<WorkersList> deleteWorkerById(@Body SetParams2 body);

    @POST("index.php/")
    Call<WorkersList> recordWorkerDailyEvent(@Body SetParams2 body);

    @POST("index.php/")
    Call<WorkersList> recordWorkerStartTime(@Body SetParams2 body);

    @POST("index.php/")
    Call<WorkersList> recordWorkerEndTime(@Body SetParams2 body);

    @POST("index.php/")
    Call<MaterialDataByID> getMaterialOrder(@Body SetParams2 body);


    @POST("index.php/")
    Call<BluePrintInfo> getLogBluePrints(@Body SetParams2 body);

    @POST("index.php/")
    Call<ContractorInfo> getLogContractors(@Body SetParams2 body);

    @POST("index.php/")
    Call<ContractorInfo> updateWorker(@Body SetParams2 body);

    @POST("index.php/")
    Call<ContractorInfo> addWorker(@Body SetParams2 body);

    @POST("index.php/")
    Call<ContractorInfo> addTools(@Body SetParams2 body);

    @POST("index.php/")
    Call<GetTools> getTools(@Body SetParams2 body);

    @POST("index.php/")
    Call<GetTasks> receiveConcreteOrder(@Body SetParams2 body);

    @POST("index.php/")
    Call<LoginData.LastUsedLog> getSearchLog(@Body SearchParams body);

    @POST("index.php/")
    Call<LoginData.LastUsedLog> getCalenderSearchLog(@Body CalenderSearchParams body);

    @POST("index.php/")
    Call<QADocList> getQaDocs(@Body SetParams2 body);

    @POST("index.php/")
    Call<QADocDetail> getQaDocDetail(@Body SetParams2 body);

    @POST("index.php/")
    Call<ApiResponse> fillQaDoc(@Body FillDoc body);

    @POST("index.php/")
    Call<GetCategories> getRoleCategory(@Body SetParams body);

    @POST("index.php/")
    Call<ApprovedDoc> getQaApprovedDocDetail(@Body SetParams2 body);

    @POST("index.php/")
    Call<LogSummary> getLogDailySummary(@Body SetParams2 body);

    @POST("index.php/")
    Call<NotificationDetail> getLogNotification(@Body SetParams2 body);

    @POST("index.php/")
    Call<PrepareImage> signLog(@Body SetParams2 body);

    @POST("index.php/")
    Call<LoginData> getUnregisteredUser(@Body SetParams body);

    @POST("index.php/")
    Call<LoginData> addUnregisteredUser(@Body SetParams body);

    @POST("index.php/")
    Call<LoginData> addLogUser(@Body SetParams body);

    @POST("index.php/")
    Call<SupportReasons> getSupportReasons(@Body SetParams body);

    @POST("index.php/")
    Call<ApiResponse> sendSupportEmail(@Body SetParams3 body);

    @POST("index.php/")
    Call<LogSignByMonths> sendLogEntryDates(@Body SetParams3 body);

    @POST("index.php/")
    Call<UserProfileData> updateLogUser(@Body UpdateLogUser body);
}
