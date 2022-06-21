package com.muhsanapps.coroutinesandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhsanapps.coroutinesandroid.databinding.ActivityCoroutineBuildersBinding

class CoroutineBuildersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutineBuildersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBuildersBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}