package com.example.fragmenttp.ui.map;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fragmenttp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mapbox.maps.CameraOptions;
import com.mapbox.maps.MapView;
import com.mapbox.maps.MapboxMap;

public class MapFragment extends Fragment {

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    private MapViewModel mViewModel;
    MapView mapView;
    FloatingActionButton floatingActionButton;

    private  final ActivityResultLauncher<String> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(),new ActivityResultCallback<Boolean>(){
        @Override
        public void onActivityResult(Boolean result) {
            if(result){
                Toast.makeText(getContext(),"Permission granted",Toast.LENGTH_SHORT).show();
                mapView.getMapboxMap().setCamera(new CameraOptions.Builder().center(mViewModel.getUserLocation()).zoom(10.0).build());
            }else {
                Toast.makeText(getContext(),"Permission denied",Toast.LENGTH_SHORT).show();
            }
            // update the viewmodel
            mViewModel.setPermissionGranted(result);

        }
    });

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MapViewModel.class);
        // TODO: Use the ViewModel
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        mapView = view.findViewById(R.id.mapView1);
        floatingActionButton = view.findViewById(R.id.myLocationButton);
        mapView.getMapboxMap();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityResultLauncher.launch("android.permission.ACCESS_FINE_LOCATION");
            }
        });

        // change the camera position to the user's location
        mapView.getMapboxMap().setCamera(new CameraOptions.Builder().center(mViewModel.getUserLocation()).zoom(14.0).build());
        return view;
    }

}