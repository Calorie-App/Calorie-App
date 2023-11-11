package com.example.gameofthroneapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
import com.example.calorieapp.Food
import com.example.calorieapp.R

class FoodAdapter(val foodList: MutableList<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder (view: View) : RecyclerView.ViewHolder(view){

       // val gameOfThroneImageView: ImageView
        val foodName: TextView
        val calories : TextView
        val saturatedFat : TextView
        val protein : TextView
        val carbohydrate : TextView
        val fiber : TextView

        // set the gameOfThroneImageView value in the init body of the GameOfThroneViewHolder class
        // the code inside the init body will always run when the class is instantiated
        init {
           // gameOfThroneImageView = view.findViewById(R.id.gameOfThrone_image)
            foodName = view.findViewById(R.id.food_name_textView)
            calories = view.findViewById(R.id.calories_textView)
            saturatedFat = view.findViewById(R.id.fatSaturated_textView)
            protein = view.findViewById(R.id.protein_TextView)
            carbohydrate = view.findViewById(R.id.carbohydrate_textView)
            fiber = view.findViewById(R.id.fiber_textView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent,false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {

        val food : Food
        food = foodList.get(position)

        holder.foodName.setText(food.getName())
        holder.calories.setText(food.getCalorie().toString())
        holder.saturatedFat.setText(food.getFatSaturated().toString())
        holder.protein.setText(food.getProtein().toString())
        holder.carbohydrate.setText(food.getCarbohydrate().toString())
        holder.fiber.setText(food.getFiber().toString())


//        Glide.with(holder.itemView)
//            .load(food.getCharacterImageURL()) // gameOfThroneList contains a list of URLs to the character photos
//            .centerCrop()
//            .into(holder.gameOfThroneImageView) // in this method basically you're passing the imageView that you want to put this photo URL into


    }

}


