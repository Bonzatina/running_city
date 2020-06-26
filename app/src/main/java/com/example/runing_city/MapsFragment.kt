package com.example.runing_city

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.runing_city.ui.mapPoint.MapPoint
import com.example.runing_city.ui.mapPoint.PointViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class MapsFragment : Fragment(), GoogleMap.OnInfoWindowClickListener {
    private lateinit var pointViewModel: PointViewModel
    private  val currentPoint: Int = 0
    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val budapest = LatLng(47.496692, 19.056064)
        pointViewModel.listOfPoints.map() {
            googleMap.addMarker(MarkerOptions().position(LatLng(it.lat, it.lng)).title(it.title).snippet(it.description)).tag = it
        }
        googleMap.setInfoWindowAdapter(object : InfoWindowAdapter {
            override fun getInfoWindow(arg0: Marker): View? {
                return null
            }

            override fun getInfoContents(marker: Marker): View {
                val info = LinearLayout(context)
                info.orientation = LinearLayout.VERTICAL
                val title = TextView(context)
                title.setTextColor(Color.BLACK)
                title.gravity = Gravity.CENTER
                title.textAlignment = View.TEXT_ALIGNMENT_CENTER
                title.setTypeface(null, Typeface.BOLD)
                title.text = marker.title
                val snippet = TextView(context)
                snippet.setTextColor(Color.GRAY)
                snippet.text = marker.snippet
                snippet.textAlignment = View.TEXT_ALIGNMENT_CENTER
                info.addView(title)
                info.addView(snippet)
                return info
            }
        })
        googleMap.setOnInfoWindowClickListener(this)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(budapest, 14f))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pointViewModel =
            ViewModelProviders.of(requireActivity()).get(PointViewModel::class.java)
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    override fun onInfoWindowClick(p0: Marker?) {
        val zz: MapPoint = p0?.tag as MapPoint
        Toast.makeText(context, zz.pointId.toString(),
            Toast.LENGTH_SHORT).show();
        view?.findNavController()?.navigate(MapsFragmentDirections.actionNavMapToNavSlideshow( zz.pointId))
    }
}