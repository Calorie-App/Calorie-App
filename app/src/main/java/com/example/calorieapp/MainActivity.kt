package com.example.calorieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import okhttp3.Call
import okhttp3.Callback


import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestHeaders
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.example.gameofthroneapp.FoodAdapter
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicHeader
import okhttp3.Headers
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.internal.http2.Header
import org.w3c.dom.Text
import java.net.URL
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {

    private lateinit var foodList : MutableList<Food>
//    private lateinit var foodRecyclerView : RecyclerView

    private var calorieGoal : Double = 0.0
    private lateinit var userInput : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        foodRecyclerView = findViewById<RecyclerView>(R.id.foodRecyclerView)
        foodList = mutableListOf<Food>()



        val searchButton = findViewById<Button>(R.id.search_button)
        searchButton.setOnClickListener(){
            // Assuming your EditText is defined in your XML layout file with the id "calorie_goal_answer"
            val calorieGoalEditText = findViewById<EditText>(R.id.calorie_goal_answer)

            // Get the text from the EditText
            val calorieGoalText = calorieGoalEditText.text.toString().trim()

            // Convert the text to a Double
            calorieGoal = try {
                calorieGoalText.toDouble()
            } catch (e: NumberFormatException) {
                // Handle the case where the input is not a valid Double
                // For now, let's set it to 0.0 as a default value.
                calorieGoal
            }
            println(calorieGoal)
             userInput = findViewById<EditText>(R.id.food_answer).text.toString()
             getFoodInfo(userInput)
        }


    //       val textView = findViewById<TextView>(R.id.apiTester)
//        val button = findViewById<Button>(R.id.search_button)
//        button.setOnClickListener(){
//            val userInput = findViewById<EditText>(R.id.food_answer).text.toString()
//            getNutritionInfo(textView, userInput)
//        }

    }


    private fun getNutritionInfo(textView: TextView, food: String) {
        val client = OkHttpClient()
        val url = "https://api.api-ninjas.com/v1/nutrition?query=${food}"
        val request = Request.Builder().url(url)
            .addHeader("x-api-key", "QpWHeJe+v61Szjf1tIYvPg==edPDwj9M04faGItV").build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    runOnUiThread {
                        textView.text = response.body!!.string()
                    }
                }
            }
        })
    }

    private fun getFoodInfo(food: String) {
        val client = AsyncHttpClient()
        val API_KEY = "QpWHeJe+v61Szjf1tIYvPg==edPDwj9M04faGItV"
        val url = "https://api.api-ninjas.com/v1/nutrition?query=${food}"


        client[url,object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.d("Food", "response successful$json")

                val foodArray = json.jsonArray
                foodList = Food.fromJSONArray(foodArray)

                //Now we need to bind Game Of Throne data (these URLs) to our Adapter
                val foodAdapter = FoodAdapter(foodList)
//                foodRecyclerView.adapter = foodAdapter
//                foodRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
//                foodRecyclerView.addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL))
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Food Error", errorResponse)
            }
        }]
    }


}


