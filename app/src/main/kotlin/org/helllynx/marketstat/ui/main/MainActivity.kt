package org.helllynx.marketstat.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import org.helllynx.marketstat.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val navigation = findViewById<BottomNavigationView>(R.id.am_navigation)
        val navController = findNavController(R.id.am_nav_host_fragment)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        findNavController(R.id.am_nav_host_fragment).addOnDestinationChangedListener { _, destination, _ ->
            title = destination.label
        }

        //navigation.setOnNavigationItemSelectedListener { item ->
        //    when (item.itemId) {
        //        R.id.menu_home -> {
        //            navController.navigate(R.id.action_global_home)
        //            true
        //        }
        //        R.id.menu_transactions -> {
        //            navController.navigate(R.id.action_global_transactions)
        //            true
        //        }
        //        R.id.menu_settings -> {
        //            navController.navigate(R.id.action_global_settings)
        //            true
        //        }
        //        else -> false
        //    }
        //}
    }
}
