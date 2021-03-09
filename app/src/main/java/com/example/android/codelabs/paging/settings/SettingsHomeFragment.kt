package com.example.android.codelabs.paging.settings

import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import com.example.android.codelabs.paging.R
import kotlinx.android.synthetic.main.fragment_settings_home.*


class SettingsHomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings_home, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        go_to_url.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_settingsHomeFragment_to_urlManipulationActivity)
        }

        goto_paging_activity.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_settingsHomeFragment_to_searchRepositoriesActivity)
        }

        go_to_viewpager.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_settingsHomeFragment_to_viewPagerActivity)
        }

        go_to_stateflow.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_settingsHomeFragment_to_stateFlowActivity)
        }

        settings_fab.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_settingsHomeFragment_to_settingsFragment)
        }

        loadSettings()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadSettings() {

        val sp = PreferenceManager.getDefaultSharedPreferences(context)

        val signature = sp.getString("signature", "")

        val reply = sp.getString("reply", "")

        val sync = sp.getBoolean("sync", true)

        val notification = sp.getBoolean("notifications", false)

        val volume = sp.getInt("volume_notifications", 0)

        tv_signature.text = "Signature: $signature"
        tv_default_value.text = "Defult reply: $reply"
        tv_sync.text = "Sync: $sync"
        tv_notifications.text = "Disable notifications: $notification"

        tv_volume.setProgress(volume, true)



    }

}