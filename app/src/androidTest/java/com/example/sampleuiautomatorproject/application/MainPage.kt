package com.example.sampleuiautomatorproject.application

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.ext.waitFindObject

class MainPage {
    private val searchSelector = byStringRes("ru.ozon.app.android:id/searchTv")
    private val favoritesMenu = byStringRes("ru.ozon.app.android:id/menu_favorites")
    private val profileButton = byStringRes("ru.ozon.app.android:id/menu_profile")
    fun clickSearch() {
        searchSelector.waitFindObject().click()
    }

    fun favoritesPage() {
        favoritesMenu.waitFindObject().click()
    }

    fun goToProfile() {
        byStringRes("ru.ozon.app.android:id/uWidgetHeaderCl").waitFindObject()
        profileButton.waitFindObject().click()
    }

}