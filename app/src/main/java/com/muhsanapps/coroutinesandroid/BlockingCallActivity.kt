package com.muhsanapps.coroutinesandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.muhsanapps.coroutinesandroid.databinding.ActivityBlockingCallBinding
import com.muhsanapps.coroutinesandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.math.BigInteger

class BlockingCallActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityBlockingCallBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set app Theme
        //setTheme(R.style.Theme_Coroutines_In_Android_Practices)
        binding = ActivityBlockingCallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        
        binding.btnRunCode.setOnClickListener {
//            CoroutineScope(Dispatchers.Main.immediate).launch {
//                delay(3000)
//                showMessage()
//            }
//            Thread.sleep(3000)
//            showMessage()

            CoroutineScope(Dispatchers.Main).launch {
                //showMessage()          // Blocking call or Suspending call?
                findBigPrime()
                //showMessage()
            }
        }
        
        //showMessage()
        
    }

    private suspend fun showMessage() {
        Toast.makeText(applicationContext, "Hello !!", Toast.LENGTH_SHORT).show()

        findBigPrime()
    }

    suspend fun findBigPrime(): BigInteger = withContext(Dispatchers.Default) {
        BigInteger.probablePrime(4096, java.util.Random())
    }
}