package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    //TODO (Refactor to replace Thread code with coroutines)

    lateinit var cakeImageView: ImageView

//    val handler = Handler(Looper.getMainLooper(), Handler.Callback {
//        cakeImageView.alpha = it.what / 100f
//        true
//    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cakeImageView = findViewById(R.id.imageView)

        findViewById<Button>(R.id.revealButton).setOnClickListener{
            CoroutineScope(Dispatchers.Default).launch{
                repeat(100) {
                    withContext(Dispatchers.Main){
                        cakeImageView.alpha = it / 100f
                    }
                    delay(40)
                }
            }


//            Thread{
//                repeat(100) {
//                    handler.sendEmptyMessage(it)
//                    Thread.sleep(40)
//                }
//            }.start()
        }
    }
}