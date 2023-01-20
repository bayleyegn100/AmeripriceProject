package com.yedebkid.ameriprisecodechallenge.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yedebkid.ameriprisecodechallenge.data.AppRepository
import com.yedebkid.ameriprisecodechallenge.data.Response
import com.yedebkid.ameriprisecodechallenge.data.base.BaseApiModel
import com.yedebkid.ameriprisecodechallenge.data.base.LiveDataResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val appRepository: AppRepository
): ViewModel() {

    private val _weatherData: MutableLiveData<LiveDataResource<BaseApiModel<Response>>> = MutableLiveData()
    val weatherData = _weatherData

    fun getWeatherResponse() {
        viewModelScope.launch(Dispatchers.IO) {
            _weatherData.value = LiveDataResource.loading(null)
            val response = appRepository.getWeatherData()
            if(response?.StatusCode == 200) {
                _weatherData.value = LiveDataResource.success(response)
            } else {
                _weatherData.value = LiveDataResource.error(response)
            }
        }
    }
}