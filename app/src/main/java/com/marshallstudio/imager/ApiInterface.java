package com.marshallstudio.imager;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/api/?key=13095942-0e49e235eab21f1cd5f68a111&per_page=200")
    Call<ImageData> getImagesData();

    @GET("/api/?key=13095942-0e49e235eab21f1cd5f68a111&per_page=200")
    Call<ImageData> getImagesData(@Query("q") String searchQuery);
}
