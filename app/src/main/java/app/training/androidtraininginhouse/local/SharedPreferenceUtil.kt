package app.training.androidtraininginhouse.local

import android.content.Context

object SharedPreferenceUtil {
    // save string data to shared preference
    fun saveStringData(context: Context, key: String, value: String){
        val sharedPref = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    // get string data from shared preference
    fun getStringData(context: Context, key: String): String? {
        val sharedPref = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        return sharedPref.getString(key, "")
    }

}