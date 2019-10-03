package com.supermavster.reciclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.util.Log
import android.view.MenuItem
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.supermavster.reciclerview.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, ItemFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Init Process (All Actions in the tab MAIN)
        Config.context=this;
        initProcess()
    }

    private fun initProcess() {
        // Init
        Log.i("Info", "Init Process")
    }

    override fun onSupportNavigateUp() =
        NavHostFragment.findNavController(nav_host_fragment).navigateUp()


    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        val bundle = Bundle()
        bundle.putStringArrayList("data", item!!.details)
        //Log.d("currentFocus", currentFocus.toString());

        Navigation.findNavController(findViewById(R.id.list)).navigate(R.id.showData, bundle)

    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        Log.e("data",p0.toString());
        return true;
    }


}
