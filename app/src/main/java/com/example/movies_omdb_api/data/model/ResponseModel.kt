package com.example.movies_omdb_api.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseModel {
        @SerializedName("Search")
        @Expose
        var searchModelList: List<SearchModel>? = null

        @SerializedName("totalResults")
        @Expose
        var totalResults: String? = null

        @SerializedName("Response")
        @Expose
        var response: String? = null
}