package com.hamza.characterapp.data.model


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info") val info: Info, @SerializedName("results") val results: List<Character>
) {
    data class Info(
        @SerializedName("count") val count: Int,
        @SerializedName("next") val next: String,
        @SerializedName("pages") val pages: Int,
        @SerializedName("prev") val prev: Any
    )

    data class Character(
        @SerializedName("created") val created: String,
        @SerializedName("episode") val episode: List<String>,
        @SerializedName("gender") val gender: String,
        @SerializedName("id") val id: Int,
        @SerializedName("image") val image: String,

        @SerializedName("name") val name: String,

        @SerializedName("species") val species: String,
        @SerializedName("status") val status: String,
        @SerializedName("type") val type: String,
        @SerializedName("url") val url: String
    )
}