package com.example.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.*

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopList(shopItem: ShopItem)  {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeConditionState(shopItem: ShopItem) {
        val newItem = shopItem.copy(condition = !shopItem.condition)
        editShopItemUseCase.editShopItem(newItem)
    }
}