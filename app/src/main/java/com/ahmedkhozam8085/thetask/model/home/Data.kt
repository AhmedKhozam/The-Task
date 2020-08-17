package com.ahmedkhozam8085.thetask.model.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public class Data {
    @SerializedName("data")
    @Expose
  public  var data: List<DataItem?>? = null

    @SerializedName("status")
    @Expose
    var status: Boolean? = null

}