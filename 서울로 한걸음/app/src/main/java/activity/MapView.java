package activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.seoullo_one.R;

import model.Cultural;

import static android.Manifest.permission;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

/**
 * Created by S on 2017-10-18.
 */

public class MapView extends BaseActivity implements LocationListener, OnMapReadyCallback {

    GoogleMap googleMap;
    Geocoder coder;
    private Cultural cultural;
    private CameraPosition cameraPosition;
    MapFragment map_f;
    LocationManager lm;
    Marker marker;
    boolean permissionCK = false;
    double lat, lng;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        Intent intent = getIntent();
        cultural = (Cultural) intent.getSerializableExtra("cultural");
        lat = intent.getExtras().getDouble("lat");
        lng = intent.getExtras().getDouble("lng");


        coder = new Geocoder(this);
        map_f = (MapFragment) getFragmentManager().findFragmentById(R.id.map_f);
        map_f.getMapAsync(this);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        permissionCheck();

        MapsInitializer.initialize(getApplicationContext());


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

    }

    public void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION,
                        permission.ACCESS_COARSE_LOCATION}, 100);
            }
        } else {
            permissionCK = true;
        }
    }

    public void readyMap() {
        String provider = lm.getBestProvider(new Criteria(), true);

        if (provider == null) {
            Toast.makeText(this, "위치정보를 사용 가능한 상태가 아닙니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = lm.getLastKnownLocation(provider);

        if(location!=null){
            onLocationChanged(location);
        }

        lm.requestLocationUpdates(provider, 1000, 1, this);


    }

    @Override
    protected void onPause() {
        super.onPause();
        lm.removeUpdates(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        readyMap();
    }

    @Override
    public void onLocationChanged(Location location) {
        //double lat = location.getLatitude();
        double lat = this.lat;
        //double lng = location.getLongitude();
        double lng = this.lng;

        LatLng position = new LatLng(lat, lng); //my position

        if(marker == null) {
            MarkerOptions options = new MarkerOptions();
            options.position(position);
            options.icon(BitmapDescriptorFactory.fromResource(R.mipmap.pin));
            marker = googleMap.addMarker(options);


        } else {
            marker.setPosition(position);
        }
        CameraUpdate camera = CameraUpdateFactory.newLatLngZoom(position, 15); //값이 커질수록 확대
        googleMap.moveCamera(camera);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        if(permissionCK)
            readyMap();

        double lat = this.lat;
        //double lng = location.getLongitude();
        double lng = this.lng;

        LatLng position = new LatLng(lat, lng); //my position

        if(marker == null) {
            MarkerOptions options = new MarkerOptions();
            options.position(position);
            options.icon(BitmapDescriptorFactory.fromResource(R.mipmap.pin));
            marker = googleMap.addMarker(options);


        } else {
            marker.setPosition(position);
        }
        CameraUpdate camera = CameraUpdateFactory.newLatLngZoom(position, 15); //값이 커질수록 확대
        googleMap.moveCamera(camera);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        googleMap.clear();
    }
}
