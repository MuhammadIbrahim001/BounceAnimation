package com.example.toasty



import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class MainActivityViewModel :ViewModel() {
    private var _count: Int = 0
    private var ONE_SEC = 100L
    lateinit var mCountDownTimer: CountDownTimer

    private val _currentTime: MutableLiveData<Long> = MutableLiveData<Long>(0)
    val currentTime: LiveData<Long> = _currentTime
    fun timer(countTimer: Long) {
        mCountDownTimer = object : CountDownTimer(countTimer, ONE_SEC) {
            override fun onTick(p0: Long) {

                _currentTime.value=(p0 / ONE_SEC)

            }

            override fun onFinish() {

            }
        }
        mCountDownTimer.start()
    }
}