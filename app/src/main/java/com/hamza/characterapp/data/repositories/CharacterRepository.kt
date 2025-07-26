package com.hamza.characterapp.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hamza.characterapp.data.model.CharacterResponse
import com.hamza.characterapp.data.retrofit.ApiCalls
import com.hamza.characterapp.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val api: ApiCalls) {

    private val _characterLiveData = MutableLiveData<Resource<CharacterResponse>>()
    val characterLiveData: LiveData<Resource<CharacterResponse>>
        get() = _characterLiveData


    fun getAllCharacters() {
        _characterLiveData.postValue(Resource.loading())
        val callData = api.getAllCharacters()
        callData.enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse?>, response: Response<CharacterResponse?>
            ) {
                if (response.body() != null) {
                    _characterLiveData.postValue(Resource.success(response.body()!!))
                } else {
                    _characterLiveData.postValue(Resource.error("Network Error"))
                }
            }

            override fun onFailure(
                call: Call<CharacterResponse?>, t: Throwable
            ) {
                _characterLiveData.postValue(Resource.error("Error: ${t.message.toString()}"))
            }

        })
    }

    //get one character

    private val _oneCharacterLiveData = MutableLiveData<Resource<CharacterResponse.Character>>()
    val oneCharacterLiveData: LiveData<Resource<CharacterResponse.Character>>
        get() = _oneCharacterLiveData

    fun getOneCharacters(id: String) {
        _oneCharacterLiveData.postValue(Resource.loading())
        val callData = api.getSingleCharacter(id)
        callData.enqueue(object : Callback<CharacterResponse.Character> {
            override fun onResponse(
                call: Call<CharacterResponse.Character?>,
                response: Response<CharacterResponse.Character?>
            ) {
                if (response.body() != null) {
                    _oneCharacterLiveData.postValue(Resource.success(response.body()!!))
                } else {
                    _oneCharacterLiveData.postValue(Resource.error("Network Error"))
                }
            }

            override fun onFailure(
                call: Call<CharacterResponse.Character?>, t: Throwable
            ) {
                _oneCharacterLiveData.postValue(Resource.error("Error: ${t.message.toString()}"))
            }


        })
    }
}
