package com.pilot.API;

import com.pilot.object.Base;
import com.pilot.object.GetRoleData;
import com.pilot.object.LoginData;
import com.pilot.object.RegisterData;
import com.pilot.object.SetParams;
import com.pilot.object.UserProfileData;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;


public interface APIService {
    @POST("index.php/")
    Call<LoginData> login(@Body SetParams body);

    @POST("index.php/")
    Call<RegisterData> register(@Body SetParams body);

    @POST("index.php/")
    Call<UserProfileData> getUser(@Body SetParams body);

    @POST("index.php/")
    Call<GetRoleData> getUserRoles(@Body SetParams body);
}
