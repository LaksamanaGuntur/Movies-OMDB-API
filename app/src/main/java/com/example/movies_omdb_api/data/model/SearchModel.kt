package com.example.movies_omdb_api.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "media")
data class SearchModel constructor(

    @PrimaryKey
    @SerializedName("imdbID")
    var imdbid: String,

    @SerializedName("Title")
    var title: String? = null,

    @SerializedName("Year")
    var year: String? = null,

    @SerializedName("Type")
    var type: String? = null,

    @SerializedName("Poster")
    var poster: String? = null
)