package com.example.toasty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.activity.viewModels

import com.example.toasty.databinding.ActivityMainBinding

import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val viewModel:MainActivityViewModel by viewModels()
    private  lateinit var  mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        viewModel.currentTime.observe(this) {
            val seconds = TimeUnit.MILLISECONDS.toSeconds(it*100)- TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(it*100)
            )
            val minutes = TimeUnit.MILLISECONDS.toMinutes(it*100)
            Log.v("timmer", "$minutes : ${seconds}")
            mBinding.progressBar.progress = it.toInt()

        }
       mBinding.btn.setOnClickListener {
            mBinding.mtrlCardChecked.visibility= View.VISIBLE
           mBinding.progressBar.visibility=View.VISIBLE
           mBinding.mtrlCardChecked.startAnimation(AnimationUtils.loadAnimation(this, R.anim.animation))
           viewModel.timer(1500L)
           mBinding.progressBar.max=15*1
        }

    }
}