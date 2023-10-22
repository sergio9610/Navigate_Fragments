package com.example.fragment20232.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragment20232.R
import com.example.fragment20232.databinding.FragmentListBinding
import com.example.fragment20232.model.Superheroe

class ListFragment : Fragment() {

    private lateinit var listBinding : FragmentListBinding
    private val superheroesList  = mutableListOf<Superheroe>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        val root : View = listBinding.root

        loadSuperheroes()


        val superheroesRecyclerViewAdapter = SuperheroesRecyclerViewAdapter(superheroesList, onItemClicked = { onSuperheroeItemClicked(it) })

        listBinding.superheroesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = superheroesRecyclerViewAdapter
            setHasFixedSize(false)
        }

        return root
    }

    private fun loadSuperheroes() {
        superheroesList.clear()
        var superheroe = Superheroe(
            id = 0,
            name = resources.getString(R.string.batman_name),
            alias = resources.getString(R.string.batman_alias),
            image = R.drawable.batman,
            powers = resources.getString(R.string.batman_powers))
        superheroesList.add(superheroe)

        superheroe = Superheroe(
            id = 1,
            name = resources.getString(R.string.flash_name),
            alias = resources.getString(R.string.flash_alias),
            image = R.drawable.flash,
            powers = resources.getString(R.string.flash_powers))
        superheroesList.add(superheroe)

        superheroe = Superheroe(
            id = 2,
            name = resources.getString(R.string.superman_name),
            alias = resources.getString(R.string.superman_alias),
            image = R.drawable.superman,
            powers = resources.getString(R.string.superman_powers))
        superheroesList.add(superheroe)

        superheroe = Superheroe(
            id = 3,
            name = resources.getString(R.string.wonder_woman_name),
            alias = resources.getString(R.string.wonder_woman_alias),
            image = R.drawable.mujer_maravilla,
            powers = resources.getString(R.string.wonder_woman_powers))
        superheroesList.add(superheroe)

    }

    private fun onSuperheroeItemClicked(superheroe: Superheroe) {
        // con un fragmento detalle
        when(superheroe.id){
            0 -> findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(superheroe = superheroe))
            1 -> findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(superheroe = superheroe))
            2 -> findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(superheroe = superheroe))
            else -> findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(superheroe = superheroe))
        }


        /* con fragmentos para cada superheroe
        when(superheroe.id){
            0 -> findNavController().navigate(ListFragmentDirections.actionListFragmentToBatmanFragment())
            1 -> findNavController().navigate(ListFragmentDirections.actionListFragmentToFlashFragment())
            2 -> findNavController().navigate(ListFragmentDirections.actionListFragmentToSupermanFragment())
            else -> findNavController().navigate(ListFragmentDirections.actionListFragmentToWonderWomanFragment())
        }
        */
    }
}