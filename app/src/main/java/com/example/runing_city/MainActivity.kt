package com.example.runing_city

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.example.runing_city.ui.mapPoint.PointViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var pointViewModel: PointViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

//        pointViewModel =
//            ViewModelProviders.of(this).get(PointViewModel::class.java)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

//        val menu = navView.menu
//        val submenu: Menu = menu.addSubMenu("Points")
////        submenu.add("Super Item1");
////        submenu.add("Super Item2");
//        slideshowViewModel.ListOfPoints.map { submenu.add(R.id.nav_slideshow, R.id.nav_slideshow, it.pointId, it.title); }
//        val ind = slideshowViewModel.getPoint(1)
//        menu.add(R.id.nav_slideshow, R.id.nav_map, ind.pointId, ind.title)
////        menu.add(0, R.id.nav_slideshow, 0, "Option1");
////        submenu.add("Super Item3").setOnMenuItemClickListener {  };
//        setSupportActionBar(toolbar)
//
//        navView.invalidate();
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_map), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        return when (item.itemId) {
//            R.id.nav_map -> {
//                Toast.makeText(this, "NumCorrect: ${item.order}", Toast.LENGTH_LONG).show()
////                Toast.makeText(this, "NumCorrect: ${item.groupId}", Toast.LENGTH_LONG).show()
////                val action =
//                val slideLayout: DrawerLayout = findViewById(R.id.nav_home)
////                slideLayout.findNavController().navigate
//                this.nav_view.findNavController().navigate(HomeFragmentDirections.actionNavHomeToNavSlideshow2(item.order))
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}
