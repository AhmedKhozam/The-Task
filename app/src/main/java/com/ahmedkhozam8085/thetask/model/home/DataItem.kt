package com.ahmedkhozam8085.thetask.model.home

import android.os.Parcel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataItem {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(id)
        dest.writeValue(title)
        dest.writeValue(image)
    }

    fun describeContents(): Int {
        return 0
    }
}