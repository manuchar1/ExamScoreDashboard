package com.tbcacademy.examscoredashboard.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tbcacademy.examscoredashboard.models.Teams
import com.tbcacademy.examscoredashboard.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val teams = MutableLiveData<Teams>().apply {
        mutableListOf<Teams>()
    }

    val _teamsLiveData: LiveData<Teams> = teams

    private val loadingLiveData = MutableLiveData<Boolean>()
    val _loadingLiveData: LiveData<Boolean> = loadingLiveData

    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            getCountries()
        }
    }

    private suspend fun getCountries() {
        loadingLiveData.postValue(true)
        val result = RetrofitInstance.api.getData()
        if (result.isSuccessful) {
            val items = result.body()
            teams.postValue(items)
        }
        loadingLiveData.postValue(false)

    }
}