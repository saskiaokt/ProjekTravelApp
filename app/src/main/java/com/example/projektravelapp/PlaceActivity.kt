package com.example.projektravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.projektravelapp.api.RetrofitHelper
import com.example.projektravelapp.api.TravelApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlaceActivity : AppCompatActivity() {
    lateinit var ChooseAPlace : TextView
    lateinit var listTodo : ListView

    val apiKey = "apiKey"
    val token = "Bearer $apiKey"

    val Items = ArrayList<Model>()
    val todoApi = RetrofitHelper.getInstance().create(TravelApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place)

        ChooseAPlace = findViewById(R.id.textchooseaplace)
        listTodo = findViewById(R.id.listtodo)

        val result = intent.getStringExtra("result")
        ChooseAPlace.text = "Choose A Place, $result?"

        CoroutineScope(Dispatchers.Main).launch {
            val response = todoApi.get(token=token, apiKey=apiKey)

            response.body()?.forEach {
                Items.add(
                    Model(
                        Id=it.id,
                        Title=it.title,
                        Description=it.description
                    )
                )
            }

            setList(Items)
        }
        listTodo.setOnItemClickListener { adapterView, view, position, id ->
            val item = adapterView.getItemAtPosition(position) as Model
            val title = item.Title

            Toast.makeText(
                applicationContext,
                "Kamu memilih $title",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun setList(Items: ArrayList<Model>) {
        val adapter = TravelAdapter(this, R.layout.travel_item, Items)
        listTodo.adapter = adapter

    }
}