package com.example.sequel.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sequel.data.BaseSqlData
import com.example.sequel.data.Lecture
import com.example.sequel.data.MainRepository
import com.example.sequel.network.DataService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class LectureViewModel @Inject constructor(val mainRepository: MainRepository) : ViewModel() {
    private var _lectureList = MutableLiveData<List<Lecture>>()
    val lectureList: LiveData<List<Lecture>> = _lectureList

//    val api = retrofit.create(DataService::class.java)

    fun asd() {
        viewModelScope.launch {
            _lectureList.postValue(mainRepository.getLectures())
        }
    }
}