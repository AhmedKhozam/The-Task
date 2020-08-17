package com.ahmedkhozam8085.thetask.view.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ahmedkhozam8085.thetask.model.home.Data;
import com.ahmedkhozam8085.thetask.model.profile.Profile;
import com.ahmedkhozam8085.thetask.retrofit.ApiInterface;
import com.ahmedkhozam8085.thetask.retrofit.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainActivityViewModel extends ViewModel {
    MutableLiveData<Profile> profileMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Data> allDataMutableLiveData = new MutableLiveData<>();
    public void getProfileDatafromjson() {
        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance();
        Observable<Profile> profileData = apiInterface.getProfileData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        profileData.subscribe(o -> profileMutableLiveData.setValue(o));
    }
    public void getAllDatafromjson() {
        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance();
        Observable<Data> data = apiInterface.getAllData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        data.subscribe(o -> allDataMutableLiveData.setValue(o));
    }
}

