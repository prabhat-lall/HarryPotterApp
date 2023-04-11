package com.example.harrypotter.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harrypotter.CharacterListFragment
import com.example.harrypotter.R
import com.example.harrypotter.databinding.CharacterItemBinding
import com.example.harrypotter.models.HPCharacterItem


class CharacterListAdapter(private val context: Context, private val characterList: List<HPCharacterItem>) :
    RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder>() {
    private lateinit var binding: CharacterItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = characterList[position]
        binding.tvName.text = item.name
        Glide.with(context).load(item.image).error(R.drawable.baseline_logo_dev_24).into(binding.ivImage)

        binding.root.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_characterListFragment_to_characterDetailFragment)
        }

    }


    class CharacterViewHolder(view : CharacterItemBinding) : RecyclerView.ViewHolder(view.root) {
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<HPCharacterItem>(){
        override fun areItemsTheSame(oldItem: HPCharacterItem, newItem: HPCharacterItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: HPCharacterItem,
            newItem: HPCharacterItem
        ): Boolean {
            return oldItem==newItem
        }

    }

}