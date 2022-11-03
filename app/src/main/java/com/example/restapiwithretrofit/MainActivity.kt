package com.example.restapiwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scope = CoroutineScope(Dispatchers.Main)
        scope.launch {
            try{
                val response = ApiClient.apiService.getOffres()
                if (response.isSuccessful && response.body() != null) {
                    Log.i("Success",response.body().toString())
                }else{
                    Log.e("Error",response.message())
                }
            } catch (e: Exception) {

                Log.e("Error",e.message.toString())
            }
        }
    }
}