package com.snake.io.slither

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.snake.io.slither.AplClasssssssss.Companion.C1
import com.snake.io.slither.AplClasssssssss.Companion.jsoupCheck
import com.snake.io.slither.AplClasssssssss.Companion.linkFilterPart1
import com.snake.io.slither.AplClasssssssss.Companion.linkFilterPart2
import com.snake.io.slither.AplClasssssssss.Companion.odone
import com.snake.io.slither.gamerrrrr.GameHolderActivity
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class CanIFilterYouActivity : AppCompatActivity() {
    lateinit var jsoup: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_can_ifilter_you)
        jsoup = ""
        val job = GlobalScope.launch(Dispatchers.IO) {
            jsoup = coroutineTask()
        }

        runBlocking {
            try {
                job.join()

                if (jsoup == jsoupCheck) {
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

    private suspend fun coroutineTask(): String {
        val sharPref = getSharedPreferences("SP", MODE_PRIVATE)
        val hawk: String? = sharPref.getString(C1, "null")
        val forJsoupSetNaming =
            "${linkFilterPart1}${linkFilterPart2}${odone}$hawk"

        withContext(Dispatchers.IO) {
            getCodeFromUrl(forJsoupSetNaming)
        }
        return jsoup
    }

    private fun getCodeFromUrl(link: String) {
        val url = URL(link)
        val urlConnection = url.openConnection() as HttpURLConnection

        try {
            val text = urlConnection.inputStream.bufferedReader().readText()
            if (text.isNotEmpty()) {
                jsoup = text
            } else {
            }
        } catch (ex: Exception) {

        } finally {
            urlConnection.disconnect()
        }
    }
}