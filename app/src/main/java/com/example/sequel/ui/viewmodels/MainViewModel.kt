package com.example.sequel.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sequel.data.Lecture
import com.example.sequel.data.MainRepository
import com.example.sequel.data.Practice
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {
    private var _lectureList = MutableLiveData<List<Lecture>>()
    val lectureList: LiveData<List<Lecture>> = _lectureList

    private var _practiceList = MutableLiveData<List<Practice>>()
    val practiceList: LiveData<List<Practice>> = _practiceList


    fun getPractice(id: Int): Practice {
        return runBlocking {
            mainRepository.getPractice(id)
        }
//        val practice: Practice
//        val job = viewModelScope.async {
//            mainRepository.getPractice(id)
//        }
//        return runBlocking { job.await() }
    }

    init {
        asd()
    }
    fun asd() {
        viewModelScope.launch {
            _lectureList.postValue(mainRepository.getLectures())
        }
        viewModelScope.launch {
            _practiceList.postValue(mainRepository.getPractices())
        }
    }
}