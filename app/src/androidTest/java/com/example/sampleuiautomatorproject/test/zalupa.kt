package com.example.sampleuiautomatorproject.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sampleuiautomatorproject.application.Chrome
import org.junit.Test
import com.example.sampleuiautomatorproject.application.PlayMarket
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.device
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class zalupa: AbstractApplicationTest<Chrome>(Chrome()) {

    @Test
    fun wtf() = with(app){
        open()
        Thread.sleep(123213123123)
        click("Accept & continue")
        click("No thanks")
        click("Search or type web address")
        byText("Search or type web address").waitFindObject().text = "https://web.whatsapp.com/"
        device.pressEnter()


        Thread.sleep(123213123123)
    }

    fun click(string: String){
        byText(string).waitFindObject().click()
    }
}