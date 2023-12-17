package com.example.fragmenttp.ui.map;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mapbox.geojson.Point;

public class MapViewModel extends ViewModel {
    public  MapViewModel(){
        super();
    }
    public boolean isPermissionGranted() {
        return permissionGranted;
    }
    private boolean permissionGranted = false;

    public void setPermissionGranted(boolean permissionGranted) {
        this.permissionGranted = permissionGranted;
    }

    // TODO: Implement the ViewModel
    // let us assume that we have a method that returns the user's location
    public Point getUserLocation(){
        return Point.fromLngLat(6.563333,36.243177 );
    }

    public LiveData userLocationLiveData(){
        return null;
    }

}