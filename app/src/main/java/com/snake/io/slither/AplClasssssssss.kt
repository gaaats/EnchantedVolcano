package com.snake.io.slither

import android.app.Application
import android.content.Context
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AplClasssssssss: Application() {
    companion object {

        const val jsoupCheckFak = "1c4v"

        const val ONE__SIGNAL_APP_ID = "27031b24-0e90-424c-bec0-7726ad09dd3f"
        const val ApppsFfffff_DEV_KEY = "SUGw82QBQbHPmJzRne8p73"

        val linkFilter2222222 = "volcano.xyz/go.php?to=1&"
        val linkFilter1111111 = "http://enchanted"

        val linkAppsCheck11111111 = "http://enchanted"
        val linkAppsCheck22222222 = "volcano.xyz/apps.txt"

        val some_shit = "sub_id_1="

        var NOT_VERY_MAIN_ID: String? = ""
        val NAMING: String? = "c11"
        var DIPING: String? = "d11"
        var CHHH: String? = "check"

    }

    override fun onCreate() {
        super.onCreate()

        GlobalScope.launch(Dispatchers.IO) {
            aaaaapplyDeviceId(context = applicationContext)
        }
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)


        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONE__SIGNAL_APP_ID)

    }

    private suspend fun aaaaapplyDeviceId(context: Context) {
        val advertisingInfo = Advuuuuu(context)
        val idInfo = advertisingInfo.frghyhyhyhy()

        val prefs = getSharedPreferences("SP", MODE_PRIVATE)
        val editor = prefs.edit()

        editor.putString(NOT_VERY_MAIN_ID, idInfo)
        editor.apply()
    }

}

class Advuuuuu (context: Context) {
    private val adInfo = AdvertisingIdClient(context.applicationContext)

    suspend fun frghyhyhyhy(): String =
        withContext(Dispatchers.IO) {
            adInfo.start()
            val adIdInfo = adInfo.info
            adIdInfo.id
        }
}