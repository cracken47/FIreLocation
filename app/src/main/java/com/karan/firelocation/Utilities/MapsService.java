package com.karan.firelocation.Utilities;

import com.karan.firelocation.models.GoogleAddress;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MapsService {

        String MAPS_BASE_URL = "https://maps.googleapis.com/";

        @GET("maps/api/distancematrix/json")
        Call<GoogleAddress> getDistance(
            @Query("units") String units,
            @Query("origins") String origin,
            @Query("destinations") String destinations,
            @Query("key") String key
    );
    }


