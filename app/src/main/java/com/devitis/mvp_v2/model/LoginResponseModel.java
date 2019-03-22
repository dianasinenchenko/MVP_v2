package com.devitis.mvp_v2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana on 22.03.2019.
 */

public class LoginResponseModel {

    @SerializedName("status")
    @Expose
    public int status;

    @SerializedName("statusMsg")
    @Expose
    public String statusMsg;
}
