package com.example.shoppinglist.domain

data class ShopItem(
    private val name: String,
    private val count: Int,
    private val condition: Boolean
)
