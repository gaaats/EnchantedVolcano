package com.snake.io.slither

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.snake.io.slither.gamerrrrr.GameHolderActivity

class SortedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorted)

        val sharPref = getSharedPreferences("SP", MODE_PRIVATE)
        val nameTest: String? = sharPref.getString(AplClasssssssss.C1, "null")
        val deepTest: String? = sharPref.getString(AplClasssssssss.D1, "null")
        if (nameTest!!.contains("tdb2")){
            Intent(this, WeeeeebStartActivity::class.java)
                .also { startActivity(it) }
            finish()
        }
        else if(deepTest!!.contains("tdb2")){
            Intent(this, WeeeeebStartActivity::class.java)
                .also { startActivity(it) }
            finish()
        }
        else{
            Intent(this, GameHolderActivity::class.java)
                .also { startActivity(it) }
            finish()
        }

    }
}