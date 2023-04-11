package com.example.harrypotter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotter.models.HPCharacterItem
import com.example.harrypotter.repository.HpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: HpRepository) : ViewModel() {

    val characterLiveData: LiveData<List<HPCharacterItem>>
        get() = repository.character

    init {
        viewModelScope.launch {
            repository.getCharacterList()
        }
    }

}