package com.example.fragment20232.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.fragment20232.R
import com.example.fragment20232.databinding.FragmentDetailBinding
import com.example.fragment20232.databinding.FragmentListBinding

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        val root: View = detailBinding.root

        val superheroe = args.superheroe

        with(detailBinding){
            pictureImageView.setImageResource(superheroe.image)
            nameTextView.text = superheroe.name
            aliasTextView.text = superheroe.alias
            powersTextView.text = superheroe.powers
        }

        return root
    }

}