package com.example.harrypotter.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.harrypotter.api.CharacterAPI
import com.example.harrypotter.models.HPCharacterItem
import javax.inject.Inject

class HpRepository @Inject constructor(private val characterAPI: CharacterAPI) {

    private val _characters = MutableLiveData<List<HPCharacterItem>>()
    val character : LiveData<List<HPCharacterItem>>
        get() = _characters

    suspend fun getCharacterList(){
        val result = characterAPI.getCharacterList()
        if(result.isSuccessful && result.body()!=null) {

             Log.d("_prabhat","${result.body()}")
            _characters.postValue(result.body())
        }
    }


}