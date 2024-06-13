package app.training.androidtraininginhouse

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.training.androidtraininginhouse.activity.HomeActivity
import app.training.androidtraininginhouse.local.SharedPreferenceUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("On Create")

        // Open url using browser
//        val openLink = Intent(Intent.ACTION_VIEW)
//        openLink.data = Uri.parse("https://www.google.com")
//        startActivity(openLink)

        val username = SharedPreferenceUtil.getStringData(this, "username")
        username?.let {
            if(it.isEmpty()){
                // show login activity
                val intent = Intent(this, UiControlActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // destroy activity
            }
        }
    }

    override fun onStart() {
        super.onStart()
        println("On Start")
    }

    override fun onResume() {
        super.onResume()
        println("On Resume")
    }

    override fun onPause() {
        super.onPause()
        println("On Pause")
    }

    override fun onStop() {
        super.onStop()
        println("On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("On Destroy")
    }
}