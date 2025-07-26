package com.hamza.characterapp.ui.characters

import androidx.lifecycle.ViewModel
import com.hamza.characterapp.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: CharacterRepository) :
    ViewModel() {


    private val allCharacters = repository.characterLiveData
    private val oneCharacter = repository.oneCharacterLiveData

    init {
        getAllCharacters()
    }

    fun getAllCharacters() = repository.getAllCharacters()
    fun getOneCharacter(id: String) = repository.getOneCharacters(id)
}