package com.karan.firelocation.activities;

import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.karan.firelocation.R;
import com.karan.firelocation.Utilities.LocationFinder;
import com.karan.firelocation.Utilities.MapsService;
import com.karan.firelocation.directionapi.FetchURL;
import com.karan.firelocation.directionapi.TaskLoadedCallback;
import com.karan.firelocation.models.GoogleAddress;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, TaskLoadedCallback {
    Button getDirection;
    private GoogleMap mMap;
    private MarkerOptions place1, place2;
    private Polyline currentPolyline;
    private LocationManager locationManager;
    private LocationFinder finder;
    private double longitude = 0.0;
    private double latitude = 0.0;
    private double lat1 = 0.0;
    private double long1 = 0.0;
    private Location dest = new Location("pointA");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getDirection = findViewById(R.id.btnGetDirection);
        getDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FetchURL(MapsActivity.this).execute(getUrl(place1.getPosition(), place2.getPosition(), "driving"), "driving");
            }
        });
        //27.658143,85.3199503
        //27.667491,85.3208583
        finder = new LocationFinder(this);
        if (finder.canGetLocation()) {
            latitude = finder.getLatitude();
            longitude = finder.getLongitude();
            place1 = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Location 1");
        } else {
            finder.showSettingsAlert();
        }

        if (getIntent().hasExtra("tajmahal")) {
            lat1 = (double) getIntent().getExtras().get("lattitude");
            long1 = (double) getIntent().getExtras().get("longitude");
            dest.setLatitude(lat1);
            dest.setLongitude(long1);
            place2 = new MarkerOptions().position(new LatLng(lat1, long1)).title("Location 2");
        } else if (getIntent().hasExtra("guwahati")) {
            lat1 = (double) getIntent().getExtras().get("lattitude");
            long1 = (double) getIntent().getExtras().get("longitude");
            dest.setLatitude(lat1);
            dest.setLongitude(long1);
            place2 = new MarkerOptions().position(new LatLng(lat1, long1)).title("Location 2");
        } else if (getIntent().hasExtra("patna")) {
            lat1 = (double) getIntent().getExtras().get("lattitude");
            long1 = (double) getIntent().getExtras().get("longitude");
            dest.setLatitude(lat1);
            dest.setLongitude(long1);
            place2 = new MarkerOptions().position(new LatLng(lat1, long1)).title("Location 2");
        } else if (getIntent().hasExtra("kolkata")) {
            lat1 = (double) getIntent().getExtras().get("lattitude");
            long1 = (double) getIntent().getExtras().get("longitude");
            dest.setLatitude(lat1);
            dest.setLongitude(long1);
            place2 = new MarkerOptions().position(new LatLng(lat1, long1)).title("Location 2");
        } else if (getIntent().hasExtra("margao")) {
            lat1 = (double) getIntent().getExtras().get("lattitude");
            long1 = (double) getIntent().getExtras().get("longitude");
            dest.setLatitude(lat1);
            dest.setLongitude(long1);
            place2 = new MarkerOptions().position(new LatLng(lat1, long1)).title("Location 2");
        } else if (getIntent().hasExtra("srinagar")) {
            lat1 = (double) getIntent().getExtras().get("lattitude");
            long1 = (double) getIntent().getExtras().get("longitude");
            dest.setLatitude(lat1);
            dest.setLongitude(long1);
            place2 = new MarkerOptions().position(new LatLng(lat1, long1)).title("Location 2");
        } else if (getIntent().hasExtra("hyderabad")) {
            lat1 = (double) getIntent().getExtras().get("lattitude");
            long1 = (double) getIntent().getExtras().get("longitude");
            dest.setLatitude(lat1);
            dest.setLongitude(long1);
            place2 = new MarkerOptions().position(new LatLng(lat1, long1)).title("Location 2");
        } else if (getIntent().hasExtra("pondicherry")) {
            lat1 = (double) getIntent().getExtras().get("lattitude");
            long1 = (double) getIntent().getExtras().get("longitude");
            dest.setLatitude(lat1);
            dest.setLongitude(long1);
            place2 = new MarkerOptions().position(new LatLng(lat1, long1)).title("Location 2");
        } else if (getIntent().hasExtra("indiagate")) {
            lat1 = (double) getIntent().getExtras().get("lattitude");
            long1 = (double) getIntent().getExtras().get("longitude");
            dest.setLatitude(lat1);
            dest.setLongitude(long1);
            place2 = new MarkerOptions().position(new LatLng(lat1, long1)).title("Location 2");
        } else if (getIntent().hasExtra("gatewayofindia")) {
            lat1 = (double) getIntent().getExtras().get("lattitude");
            long1 = (double) getIntent().getExtras().get("longitude");
            dest.setLatitude(lat1);
            dest.setLongitude(long1);
            place2 = new MarkerOptions().position(new LatLng(lat1, long1)).title("Location 2");
        }
        Distance();

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapNearBy);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Log.d("mylog", "Added Markers");
        mMap.addMarker(place1);
        mMap.addMarker(place2);
        LatLng coordinate = new LatLng(latitude, longitude);
        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 5);
        mMap.animateCamera(yourLocation);
    }

    private String getUrl(LatLng origin, LatLng dest, String directionMode) {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        // Mode
        String mode = "mode=" + directionMode;
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + mode;
        // Output format
        String output = "json";
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_maps_key);
        return url;
    }

    @Override
    public void onTaskDone(Object... values) {
        if (currentPolyline != null)
            currentPolyline.remove();
        currentPolyline = mMap.addPolyline((PolylineOptions) values[0]);
    }

    public void Distance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MapsService.MAPS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MapsService mapservice = retrofit.create(MapsService.class);

        String origin = latitude + "," + longitude;
        String destination = lat1 + "," + long1;
        Call<GoogleAddress> call = mapservice.getDistance("imperial", origin, destination, getResources().getString(R.string.google_maps_key));
        call.enqueue(new Callback<GoogleAddress>() {
            @Override
            public void onResponse(Call<GoogleAddress> call, Response<GoogleAddress> response) {
                String distance = response.body().getRows().get(0).getElements().get(0).getDistance().getText();
                String originAddress = String.valueOf((response.body().getOriginAddresses()));
                getDirection.setText(getString(R.string.distance) + distance);


            }

            @Override
            public void onFailure(Call<GoogleAddress> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), Places.class));
    }
}