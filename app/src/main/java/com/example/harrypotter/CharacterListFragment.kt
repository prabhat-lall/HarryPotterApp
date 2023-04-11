package com.example.harrypotter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harrypotter.adapter.CharacterListAdapter
import com.example.harrypotter.databinding.FragmentCharacterListBinding
import com.example.harrypotter.models.HPCharacterItem
import com.example.harrypotter.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : Fragment() {
   // private val viewModel: MainViewModel by viewModels()

private lateinit var viewModel : MainViewModel
    private lateinit var binding: FragmentCharacterListBinding
    lateinit var adapter: CharacterListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_character_list,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        Log.d("_prabhat","${viewModel.characterLiveData.value}")
        viewModel.characterLiveData.observe(viewLifecycleOwner) {
            binding.rvCharacter.layoutManager = LinearLayoutManager(requireContext())
            val adapter = CharacterListAdapter(requireContext(),it)
            binding.rvCharacter.adapter = adapter
        }


//        mainViewModel.coinsLiveData.observe(this, Observer {
//            recyclerView.layoutManager = LinearLayoutManager(this)
//            val adapter = CoinAdapter(it)
//            recyclerView.adapter = adapter
//
//            adapter.onItemClick = { it ->
//                val intent = Intent(this, CoinDetailActivity::class.java)
//                intent.putExtra("coinId", it.id)
//                Toast.makeText(this, it.id, Toast.LENGTH_SHORT).show()
//                startActivity(intent)
//            }
//        })

        binding.fbSearch.setOnClickListener {
            findNavController().navigate(R.id.action_characterListFragment_to_characterSearchFragment)
        }

        binding.fbFav.setOnClickListener {
            findNavController().navigate(R.id.action_characterListFragment_to_characterSearchFragment)
        }

    }





}