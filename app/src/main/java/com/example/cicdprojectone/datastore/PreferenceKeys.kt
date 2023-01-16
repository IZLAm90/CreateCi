package com.example.cicdprojectone.datastore

import androidx.datastore.preferences.core.stringPreferencesKey

object PreferenceKeys {
    val UserName= stringPreferencesKey("name")
    val UserTitle= stringPreferencesKey("title")

}