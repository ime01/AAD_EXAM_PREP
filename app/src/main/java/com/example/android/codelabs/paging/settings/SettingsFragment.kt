package com.example.android.codelabs.paging.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.android.codelabs.paging.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}