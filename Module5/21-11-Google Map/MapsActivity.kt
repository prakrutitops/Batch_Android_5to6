package tops.tech.myapplication

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.GPS_PROVIDER
import android.location.LocationManager.NETWORK_PROVIDER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import tops.tech.myapplication.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback
{

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    lateinit var locationManager: LocationManager
    lateinit var location: Location
    var lat=0.00
    var lon=0.00


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION), 1)
        }

        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        if(!locationManager.isProviderEnabled(GPS_PROVIDER))
        {
           Toast.makeText(applicationContext,"GPS is not working",Toast.LENGTH_LONG).show()
        }
        else if(!locationManager.isProviderEnabled(NETWORK_PROVIDER))
        {
            Toast.makeText(applicationContext,"Network is not working",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(applicationContext,"Fetching Location",Toast.LENGTH_LONG).show()
        }
         var locationListener: LocationListener =object :LocationListener
         {
             override fun onLocationChanged(p0: Location)
             {

                 lat = p0.getLatitude()
                 lon = p0.getLongitude()
             }
         }

        if (locationManager.isProviderEnabled(NETWORK_PROVIDER))
        {
            locationManager.requestLocationUpdates(NETWORK_PROVIDER,0,0.0F,locationListener)
        }
        location = locationManager.getLastKnownLocation(NETWORK_PROVIDER)!!

        if(location!=null)
        {
            lat = location.getLatitude()
            lon = location.getLongitude()
            Toast.makeText(applicationContext, ""+location.getLatitude(), Toast.LENGTH_SHORT).show()
        }






    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap)
    {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(lat, lon)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker at your place"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}