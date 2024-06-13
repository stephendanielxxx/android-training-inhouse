package app.training.androidtraininginhouse.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.training.androidtraininginhouse.local.AppDatabase
import app.training.androidtraininginhouse.local.DatabaseUtil
import app.training.androidtraininginhouse.local.LordDataClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class LordViewModel(): ViewModel() {
    private lateinit var database: AppDatabase
    private val lordMutableLiveData = MutableLiveData<List<LordDataClass>>()
    val lordLiveData = lordMutableLiveData

    fun initDatabase(context: Context){
        database = DatabaseUtil.getDatabase(context)
    }
    fun addLord(lordName: String, lordStr: Int, lordInt: Int){
        val lord = LordDataClass(name = lordName, strength = lordStr,
            intelligence = lordInt)
        viewModelScope.launch {
            database.lordDao().insertLord(lord)
        }
    }

    fun getLords(){
        viewModelScope.launch {
            database.lordDao().getLords().flowOn(Dispatchers.IO).collect{
                lordMutableLiveData.value = it
            }
        }
    }
}