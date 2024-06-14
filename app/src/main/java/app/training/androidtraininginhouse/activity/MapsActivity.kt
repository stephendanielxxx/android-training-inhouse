package app.training.androidtraininginhouse.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.training.androidtraininginhouse.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapsBinding
    private lateinit var maps: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.main)

        // to show maps
        val mapFragment = supportFragmentManager
            .findFragmentById(binding.maps.id) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        maps = map

        val bali = LatLng(-8.771222090216114, 115.22162301284928)
        maps.moveCamera(CameraUpdateFactory.newLatLngZoom(bali, 14f))

        val tanjungBenoa = LatLng(
            -8.753584989126962,
            115.21817401260033
        )
        maps.addMarker(MarkerOptions()
            .position(tanjungBenoa).title("Marker in TanjungBenoa"))

    }
}