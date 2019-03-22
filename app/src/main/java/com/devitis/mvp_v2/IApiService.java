package com.devitis.mvp_v2;

import com.devitis.mvp_v2.model.LoginResponseModel;

import io.reactivex.Observable;

import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Diana on 22.03.2019.
 */

public interface IApiService {

    @POST("login")
    Observable<LoginResponseModel> getLoginResponse(
            @Query("username") String username,
            @Query("password") String password);

}
