package com.example.sampleuiautomatorproject.application

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import com.example.sampleuiautomatorproject.util.ext.waitHasObject
import org.junit.Assert

class FavoritePage {
    private val favoritesTool = byStringRes("").text("Избранное")
    private val unfavoriteButton = byStringRes("ru.ozon.app.android:id/favoriteAction")
    fun unfavorite() {
        unfavoriteButton.waitFindObject().click()
    }

    fun checkGoToFavorites() {
        Assert.assertTrue(
            "Не перешел в избранное",
            favoritesTool.waitHasObject()
        )
    }

    fun checkProductInFavorites(productName: String) {
        val product = byText(productName)
        Assert.assertTrue(
            "Продукт не добавился в избранное",
            product.waitHasObject()
        )
    }


}