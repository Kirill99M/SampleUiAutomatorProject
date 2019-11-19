package com.example.sampleuiautomatorproject.application

import androidx.test.uiautomator.UiObjectNotFoundException
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.ext.waitFindObject

class ProductPage {
    private val favoriteButton = byStringRes("ru.ozon.app.android:id/favoritesIv")
    private val buyButton = byStringRes("ru.ozon.app.android:id/mainBtnContainer")
    private val reviewButton = byStringRes("ru.ozon.app.android:id/writeReviewBtn")
    fun scrollTo(someName: String) {
        buyButton.waitFindObject()
        val appViews = UiScrollable(UiSelector().scrollable(true))
        try {
            appViews.scrollIntoView(UiSelector().text(someName))
        } catch (e: UiObjectNotFoundException) {
            e.printStackTrace()
        }
    }

    fun addFavorite() {
        buyButton.waitFindObject()
        favoriteButton.waitFindObject().click()
    }

    fun clickReviewButton() {
        reviewButton.waitFindObject().click()
    }

}