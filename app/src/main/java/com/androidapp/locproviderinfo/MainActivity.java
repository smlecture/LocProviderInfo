package com.androidapp.locproviderinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;
    TextView txtInfo;
    String s;
    List<String> locProviderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInfo = findViewById(R.id.txtInfo);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        locProviderList = locationManager.getAllProviders();
        txtInfo.setText("");
        for(String locProvider : locProviderList){
            txtInfo.append("Loc. Provider: " + locProvider + "\n");
            txtInfo.append("Enabled: " + locationManager.isProviderEnabled(locProvider) + "\n\n");
        }
    }
}