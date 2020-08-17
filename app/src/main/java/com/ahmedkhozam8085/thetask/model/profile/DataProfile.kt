package com.ahmedkhozam8085.thetask.model.profile

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataProfile {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("full_name")
    @Expose
    var fullName: String? = null

    @SerializedName("profile_picture")
    @Expose
    var profilePicture: String? = null

    @SerializedName("bio")
    @Expose
    var bio: String? = null

    @SerializedName("location")
    @Expose
    var location: String? = null

    @SerializedName("counts")
    @Expose
    var counts: Counts? = null

}