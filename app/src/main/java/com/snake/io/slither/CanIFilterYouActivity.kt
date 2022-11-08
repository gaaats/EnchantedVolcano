package com.snake.io.slither

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.snake.io.slither.AplClasssssssss.Companion.NAMING
import com.snake.io.slither.AplClasssssssss.Companion.jsoupCheckFak
import com.snake.io.slither.AplClasssssssss.Companion.linkFilter1111111
import com.snake.io.slither.AplClasssssssss.Companion.linkFilter2222222
import com.snake.io.slither.AplClasssssssss.Companion.some_shit
import com.snake.io.slither.gamerrrrr.GameHolderActivity
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class CanIFilterYouActivity : AppCompatActivity() {
    lateinit var againJsoup: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_can_ifilter_you)
        againJsoup = ""
        val job = GlobalScope.launch(Dispatchers.IO) {
            againJsoup = taaaaask()
        }

        runBlocking {
            try {
                job.join()

                if (againJsoup == jsoupCheckFak) {
                    Intent(applicationContext, GameHolderActivity::class.java).also {
                        startActivity(
                            it
                        )
                    }
                } else {
                    Intent(
                        applicationContext,
                        WeeeeebStartActivity::class.java
                    ).also { startActivity(it) }
                }
                finish()
            } catch (e: Exception) {

            }
        }

    }

    private fun fegrhtjy(link: String) {
        val frgdthyjj8 = URL(link)
        val urlConnection = frgdthyjj8.openConnection() as HttpURLConnection

        try {
            val textfgrthy = urlConnection.inputStream.bufferedReader().readText()
            if (textfgrthy.isNotEmpty()) {
                againJsoup = textfgrthy
            } else {
            }
        } catch (ex: Exception) {

        } finally {
            urlConnection.disconnect()
        }
    }

    private suspend fun taaaaask(): String {
        val sharPref = getSharedPreferences("SP", MODE_PRIVATE)
        val gthyjukik: String? = sharPref.getString(NAMING, "null")
        val rtyjuki =
            "${linkFilter1111111}${linkFilter2222222}${some_shit}$gthyjukik"

        withContext(Dispatchers.IO) {
            fegrhtjy(rtyjuki)
        }
        return againJsoup
    }


}