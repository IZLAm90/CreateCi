package com.example.cicdprojectone.datastore

import kotlinx.coroutines.flow.Flow

interface UserRepoStore {
    suspend fun setUSerData(data:islam)
    suspend fun getUSerData(): Flow<islam>
}
data class islam(val name:String, val title:String)