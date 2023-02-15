package com.xsavzh.pizzarecipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.xsavzh.pizzarecipes.databinding.PizzaRecipeItemBinding

class PizzaRecyclerViewAdapter(private val pizzaList: ArrayList<Pizza>, private val listener: OnItemClickListener): RecyclerView.Adapter<PizzaRecyclerViewAdapter.PizzaViewHolder>() {

    inner class PizzaViewHolder(item: View): ViewHolder(item), View.OnClickListener{
        private val binding = PizzaRecipeItemBinding.bind(item)

        fun bind(pizza: Pizza) = with(binding) {
            pizzaImageView.setImageResource(pizza.imageId)
            titleTextView.text = pizza.title
            descriptionTextView.text = pizza.description
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pizza_recipe_item, parent, false)
        return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.bind(pizzaList[position])
    }

    fun addPizza() {
        pizzaList.add(Pizza(R.drawable.margarita,
            Utils.MARGARITA_TITLE,
            Utils.MARGARITA_DESCRIPTION,
            Utils.MARGARITA_RECIPE))
        pizzaList.add(Pizza(R.drawable.capricciosa,
            Utils.CAPRICCIOSA_TITLE,
            Utils.CAPRICCIOSA_DESCRIPTION,
            Utils.CAPRICCIOSA_RECIPE))
        pizzaList.add(Pizza(R.drawable.fourcheese,
            Utils.FOUR_CHEESE_TITLE,
            Utils.FOUR_CHEESE_DESCRIPTION,
            Utils.FOUR_CHEESE_RECIPE))
        pizzaList.add(Pizza(R.drawable.hawaiian,
            Utils.HAWAIIAN_TITLE,
            Utils.HAWAIIAN_DESCRIPTION,
            Utils.HAWAIIAN_RECEPT))
        pizzaList.add(Pizza(R.drawable.margarita,
            Utils.MARGARITA_TITLE,
            Utils.MARGARITA_DESCRIPTION,
            Utils.MARGARITA_RECIPE))
        pizzaList.add(Pizza(R.drawable.marinara,
            Utils.MARINARA_TITLE,
            Utils.MARINARA_DESCRIPTION,
            Utils.MARINARA_RECIPE))
        pizzaList.add(Pizza(R.drawable.neapolitana,
            Utils.NEAPOLITANA_TITLE,
            Utils.NEAPOLITANA_DESCRIPTION,
            Utils.NEAPOLITANA_RECIPE))
        pizzaList.add(Pizza(R.drawable.sea,
            Utils.SEA_TITLE,
            Utils.SEA_DESCRIPTION,
            Utils.SEA_RECIPE))
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }
}