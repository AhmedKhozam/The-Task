package com.ahmedkhozam8085.thetask.model.profile

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 public class Profile {
    @SerializedName("data")
    @Expose
  public  var data: DataProfile? = null

    @SerializedName("status")
    @Expose
   public var status: Boolean? = null

}