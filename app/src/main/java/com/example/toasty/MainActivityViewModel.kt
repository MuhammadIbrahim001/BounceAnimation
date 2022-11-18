package com.example.toasty

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainActivityViewModel : ViewModel() {
    private var ONE_SEC = 100L
    lateinit var mCountDownTimer: CountDownTimer

    private val _currentTime: MutableLiveData<Long> = MutableLiveData<Long>(0)
    val currentTime: LiveData<Long> = _currentTime
    fun timer(countTimer: Long) {
        mCountDownTimer = object : CountDownTimer(countTimer, ONE_SEC) {
            override fun onTick(p0: Long) {
                _currentTime.value = (p0 / ONE_SEC)

            }
            override fun onFinish() {
            }
        }
        mCountDownTimer.start()
    }
}