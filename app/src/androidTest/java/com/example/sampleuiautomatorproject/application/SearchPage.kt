package com.example.sampleuiautomatorproject.application

import androidx.test.uiautomator.By
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import com.example.sampleuiautomatorproject.util.ext.waitHasObject
import org.junit.Assert

class SearchPage {
    private val searchInputSelector = byStringRes("ru.ozon.app.android:id/search_src_text")
    private val hintCost = byStringRes("ru.ozon.app.android:id/priceTv")


    fun clickHint(productName: String) {
        By.clazz("android.widget.TextView").text(productName).waitFindObject().click()
    }


    fun typeToSearch(text: String) {
        searchInputSelector.waitFindObject().text = text
    }

    fun checkHintTitle(text: String) {
        val hintText = byText("Философия Java")
        Assert.assertTrue(
            "Не правильное название",
            hintText.waitHasObject()
        )
    }

    fun checkHintCost(cost: String) {
        Assert.assertTrue(
            "Не правильная ценна",
            hintCost.waitFindObject().text == cost
        )
    }
}