package com.example.coroutineswithoutmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcvMain.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rcvMain.setHasFixedSize(true)
        val apiservice=RetrofitObj.apiservice
        CoroutineScope(Dispatchers.IO).launch {
            val response=apiservice.getAllPosts()
            withContext(Dispatchers.Main)
            {
                if(response.isSuccessful) {
                    rcvMain.adapter = response.body()?.let { PostAdapter(it) }

                }
                else
                {
                    Toast.makeText(this@MainActivity,"Error",Toast.LENGTH_LONG)
                }
            }
        }
    }
}
