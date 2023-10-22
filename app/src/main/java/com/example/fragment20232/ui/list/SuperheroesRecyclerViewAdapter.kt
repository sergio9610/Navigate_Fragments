package com.example.fragment20232.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment20232.R
import com.example.fragment20232.databinding.CardViewItemSuperheroesBinding
import com.example.fragment20232.model.Superheroe

class SuperheroesRecyclerViewAdapter(
    private val superheroesList: MutableList<Superheroe>,
    private val onItemClicked: (Superheroe) -> Unit
) : RecyclerView.Adapter<SuperheroesRecyclerViewAdapter.SuperheroeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_superheroes, parent, false)
        return SuperheroeViewHolder(itemView)

    }

    override fun getItemCount(): Int = superheroesList.size


    override fun onBindViewHolder(holder: SuperheroeViewHolder, position: Int) {
        val superheroe = superheroesList[position]
        holder.bindSuperheroe(superheroe)
        holder.itemView.setOnClickListener{ onItemClicked(superheroe) }
    }

    class SuperheroeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val binding = CardViewItemSuperheroesBinding.bind(itemView)

        fun bindSuperheroe(superheroe: Superheroe){
            with(binding){
                nameTextView.text = superheroe.name
                superheroeImageView.setImageResource(superheroe.image)
            }
        }

    }

}