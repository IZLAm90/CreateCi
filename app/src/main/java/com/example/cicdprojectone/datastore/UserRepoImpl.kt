package com.example.cicdprojectone.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class UserRepoImpl(private val prefsDataStore: DataStore<Preferences>):UserRepoStore {
    override suspend fun setUSerData(data: islam) {
        prefsDataStore.edit { pref->
            pref[PreferenceKeys.UserName]=data.name
            pref[PreferenceKeys.UserTitle]=data.title
        }
    }

    override suspend fun getUSerData(): Flow<islam>{
        return prefsDataStore.data.catch {  exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            islam(name = preferences[PreferenceKeys.UserName] ?: "",
                title = preferences[PreferenceKeys.UserTitle]?:"")
        }
    }
}