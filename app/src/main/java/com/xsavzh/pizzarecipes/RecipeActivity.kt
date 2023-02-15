package com.xsavzh.pizzarecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xsavzh.pizzarecipes.databinding.ActivityRecipeBinding

class RecipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.titleTextView.text = intent.getStringExtra("title")
        binding.recipeTextView.text = intent.getStringExtra("recipe")
    }
}

