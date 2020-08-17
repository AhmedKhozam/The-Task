package com.ahmedkhozam8085.thetask.retrofit

import com.ahmedkhozam8085.thetask.model.home.Data
import com.ahmedkhozam8085.thetask.model.profile.Profile
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {
    @get:GET("home")
    val allData: Observable<Data?>?

    @get:GET("profile")
    val profileData: Observable<Profile?>?
}