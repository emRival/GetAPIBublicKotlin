package com.rival.getapipublic.response

import com.google.gson.annotations.SerializedName

data class ResponseAnime(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
)

data class DataItem(

	@field:SerializedName("anime_img")
	val animeImg: String? = null,

	@field:SerializedName("anime_name")
	val animeName: String? = null,

	@field:SerializedName("anime_id")
	val animeId: Int? = null
)
