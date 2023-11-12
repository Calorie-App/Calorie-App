package com.example.calorieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


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
import okhttp3.Headers

class MainActivity : AppCompatActivity() {

    private lateinit var foodList : MutableList<Food>
 //   private lateinit var foodRecyclerView : RecyclerView

    private var calorieGoal : Double = 0.0
    private lateinit var userInput : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      // foodRecyclerView = findViewById<RecyclerView>(R.id.foodRecyclerView)
        foodList = mutableListOf<Food>()

        val searchButton = findViewById<Button>(R.id.search_button)
        searchButton.setOnClickListener(){

            val calorieGoalEditText = findViewById<EditText>(R.id.calorie_goal_answer)
            //  convertEditTextToDouble(calorieGoalEditText)
            //  userInput = findViewById<EditText>(R.id.food_answer).text.toString()
            //  getFoodInfo(userInput)
            userInput = findViewById<EditText>(R.id.food_answer).text.toString()

            if(calorieGoalEditText.text.toString().isNotEmpty() && userInput.isNotEmpty()){
                convertEditTextToDouble(calorieGoalEditText)
                getFoodInfo(userInput)
            }
            else {
                // Display a message or perform some action if either EditText is empty
                Toast.makeText(this, "Please enter values in both fields", Toast.LENGTH_SHORT).show()
            }





//            // Get references to the EditText fields
//            val calorieGoalEditText = findViewById<EditText>(R.id.calorie_goal_answer)
//            val foodAnswerEditText = findViewById<EditText>(R.id.food_answer)
//
//            // Get the text from the EditText fields
//            val calorieGoalText = calorieGoalEditText.text.toString()
//            val foodAnswerText = foodAnswerEditText.text.toString()
//
//            // Check if both EditText fields are not empty
//            if (calorieGoalText.isNotEmpty() && foodAnswerText.isNotEmpty()) {
//
//                // Convert calorieGoalText to Double
//                calorieGoal = convertEditTextToDouble(calorieGoalText)
//
//                // Get food information using the input from the second EditText
//                getFoodInfo(foodAnswerText)
//
//            } else {
//                // Display a message or perform some action if either EditText is empty
//                Toast.makeText(this, "Please enter values in both fields", Toast.LENGTH_SHORT).show()
//            }




        }
    }

    private fun convertEditTextToDouble(calorieGoalEditText: EditText?) {
        // Get the text from the EditText
        val calorieGoalText = calorieGoalEditText?.text.toString().trim()

        // Convert the text to a Double
        calorieGoal = try {
            calorieGoalText.toDouble()
        } catch (e: NumberFormatException) {
            // Handle the case where the input is not a valid Double
            // For now, let's set it to 0.0 as a default value.
            calorieGoal
        }
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

        val params =  RequestParams()
        val requestHeaders = RequestHeaders()
        requestHeaders["x-api-key"] = API_KEY

        client[url,requestHeaders, params, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {

                val foodArray = json.jsonArray
                foodList = Food.fromJSONArray(foodArray)

                var countCalories = 0.0
                while(countCalories <= calorieGoal){
                    for (food in foodList) {
                        val caloriesValue = food.getCalories()
                        countCalories += caloriesValue
                    }
                }
                Log.d("Food", "response successful$json")

                //Now we need to bind food data (these Foods) to our Adapter
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



    // Define a simple fragment
//    class MyFragment : Fragment() {
//        // Fragment code goes here
//    }

//    // Use the fragment in an activity
//    class FoodItem : AppCompatActivity() {
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            setContentView(R.layout.food_item)
//
//
//            val yesButton = findViewById<Button>(R.id.yes_button)
//            val noButton = findViewById<Button>(R.id.no_button)
//            noButton.setOnClickListener {
//
//                    // Remove the fragment when "No" button is clicked
//                    val fragmentTransaction = supportFragmentManager.beginTransaction()
//                    val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
//                    fragment?.let {
//                        fragmentTransaction.remove(it)
//                        fragmentTransaction.commit()
//                    }
//            }
//        }
//
//    }
//
//

}





