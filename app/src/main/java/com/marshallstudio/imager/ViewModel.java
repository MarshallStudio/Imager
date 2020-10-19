package com.marshallstudio.imager;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private MutableLiveData<List<Hits>> liveImagesData;

    public MutableLiveData<Boolean> getLiveDataIsServerReachable() {
        return isServerReachable;
    }

    private MutableLiveData<Boolean> isServerReachable;

    public ViewModel() {
        liveImagesData =new MutableLiveData<>();
        isServerReachable=new MutableLiveData<>();
        isServerReachable.setValue(true);
    }

    public void getImagesData() {
        if (liveImagesData.getValue()!=null){
            return;
        }

        ApiInterface apiInterface= RetrofitClient.getRetrofitClient().create(ApiInterface.class);
        Call<ImageData> call=apiInterface.getImagesData();
        call.enqueue(new Callback<ImageData>() {
            @Override
            public void onResponse(Call<ImageData> call, Response<ImageData> response) {
                isServerReachable.setValue(true);
                liveImagesData.setValue(Arrays.asList(response.body().getHits()));
            }

            @Override
            public void onFailure(Call<ImageData> call, Throwable t) {
                Log.e("Failed:",t.getLocalizedMessage());
                isServerReachable.setValue(false);
            }
        });
    }

    public void getImagesData(String searchQuery) {


        ApiInterface apiInterface= RetrofitClient.getRetrofitClient().create(ApiInterface.class);
        Call<ImageData> call=apiInterface.getImagesData(searchQuery);
        call.enqueue(new Callback<ImageData>() {
            @Override
            public void onResponse(Call<ImageData> call, Response<ImageData> response) {
                isServerReachable.setValue(true);
                liveImagesData.setValue(Arrays.asList(response.body().getHits()));
            }

            @Override
            public void onFailure(Call<ImageData> call, Throwable t) {
                Log.e("Failed:",t.getLocalizedMessage());
                isServerReachable.setValue(false);
            }
        });
    }



    public MutableLiveData<List<Hits>> getLiveData(){
        return liveImagesData;
    }
}
