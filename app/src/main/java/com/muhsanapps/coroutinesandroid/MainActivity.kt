package com.muhsanapps.coroutinesandroid

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.muhsanapps.coroutinesandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val url = URL("https://firebasestorage.googleapis.com/v0/b/fir-testing-myscholars.appspot.com/o/Screenshot_20220616-181427_E%20Commerce.jpg?alt=media&token=5b283d99-3976-4120-a54a-6d216992e27a")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//
//        val btnLoadImage = findViewById<Button>(R.id.btnLoadImage);
//        val btnBlockingVSSuspendingCallActivityScreen =
//            findViewById<Button>(R.id.btnBlockingVSSuspendingCall);
//        val imageView = findViewById<ImageView>(R.id.imageView);

        binding.btnLoadImage.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    Log.d("MyTag", "on Create: ThreadName: ${Thread.currentThread().name}")

                    val bitmap = BitmapFactory.decodeStream(url.openStream())

                    withContext(Dispatchers.Main) {
                        Log.d(
                            "MyTag",
                            "onCreate withContext: ThreadName: ${Thread.currentThread().name}"
                        )
                        binding.imageView.setImageBitmap(bitmap)
                    }
                } catch (e: Exception) {
                    Log.d("MyTag", "onCreate: $e")
                }

            }

        }


        binding.btnNextActivity.setOnClickListener {
            val i = Intent(this@MainActivity, BlockingCallActivity::class.java)
            startActivity(i)
        }
        binding.btnCoroutineBuilders.setOnClickListener {
            startActivity(Intent(this@MainActivity, CoroutineBuildersActivity::class.java))
        }
    }
}