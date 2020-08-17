package com.ahmedkhozam8085.thetask.model.profile

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Counts {
    @SerializedName("posts")
    @Expose
    var posts: Int? = null

    @SerializedName("followers")
    @Expose
    var followers: Int? = null

    @SerializedName("following")
    @Expose
    var following: Int? = null

}