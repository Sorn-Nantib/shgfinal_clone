package com.example.shg_clone

data class AboutUsX(
    val data: List<DataAboutUs>
)

data class DataRes(
    val data: List<DataAboutUs> = arrayListOf()
)