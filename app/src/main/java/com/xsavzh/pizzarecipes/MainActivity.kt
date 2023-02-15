package com.xsavzh.pizzarecipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.xsavzh.pizzarecipes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PizzaRecyclerViewAdapter.OnItemClickListener {
    private val pizzaList = ArrayList<Pizza>()

    private lateinit var binding: ActivityMainBinding
    private var adapter = PizzaRecyclerViewAdapter(pizzaList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.recyclerView.adapter = adapter

        adapter.addPizza()
    }

    override fun onItemClick(position: Int) {
        val pizza: Pizza = pizzaList[position]

        val intent = Intent(this@MainActivity, RecipeActivity::class.java)

        intent.putExtra("title", pizza.title)
        intent.putExtra("recipe", pizza.recipe)

        startActivity(intent)
    }
}