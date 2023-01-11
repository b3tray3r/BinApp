package com.example.binapp

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class BinListResponse(val items: List<BinListItem> )


data class BinListItem(
    @SerializedName("name")
    @Expose
    private val name: String? = null,

    @SerializedName("url")
    @Expose
    private val url: String? = null,

    @SerializedName("phone")
    @Expose
    private val phone: String? = null,

    @SerializedName("city")
    @Expose
    private val city: String? = null,
    )
