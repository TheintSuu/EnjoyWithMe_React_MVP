package com.theintsuhtwe.enjoywithme.activites

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.fragments.MainFragment
import com.theintsuhtwe.enjoywithme.utils.FRAGMENT_MAIN
import kotlinx.android.synthetic.main.toolbar_view_pod.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpToolbar()


        setFragment()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu!!.clear()

        //set action mode search
        menuInflater.inflate(R.menu.action_menu, menu)

        return true
    }


    //Create Tool bar
    @SuppressLint("ResourceAsColor")
    private fun setUpToolbar(){

        setSupportActionBar(findViewById(R.id.toolbar))
        with(toolbar) {
            setNavigationIcon(R.drawable.ic_baseline_menu_24)
            setSupportActionBar(toolbar)
            setTitle(R.string.app_name)
            titleColor = R.color.colorTitleToolbar
            setTitleTextColor(R.color.colorTitleToolbar)
            setNavigationOnClickListener {
              //  drawerLayout.openDrawer(GravityCompat.START)
            }
        }
    }


    //Replace with Main Fragment
    private fun setFragment(){
        this.supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                MainFragment(), FRAGMENT_MAIN
            )
            .addToBackStack(FRAGMENT_MAIN)
            .commit()
    }

}