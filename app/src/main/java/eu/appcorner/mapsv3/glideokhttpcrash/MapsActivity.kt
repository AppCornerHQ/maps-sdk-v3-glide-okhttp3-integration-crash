package eu.appcorner.mapsv3.glideokhttpcrash

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.OnMapReadyCallback
import com.google.android.libraries.maps.SupportMapFragment
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // load a sample image
        val imageView = findViewById<ImageView>(R.id.image)
        Glide.with(this)
            .load("https://images-assets.nasa.gov/image/KSC-2014-3456/KSC-2014-3456~orig.jpg")
            .into(imageView)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap

        // Add a marker in Paris and move the camera
        val paris = LatLng(48.8583736, 2.2922926)
        googleMap.addMarker(MarkerOptions().position(paris).title("Marker in Paris"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(paris, 15.0f))
    }
}