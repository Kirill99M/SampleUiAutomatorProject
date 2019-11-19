package com.example.sampleuiautomatorproject.application

import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.Until
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.device
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import org.junit.Assert

class LoginPage {
    private val emailText = byStringRes("ru.ozon.app.android:id/emailEt")
    private val loginButton = byStringRes("ru.ozon.app.android:id/submitBtn")
    private val headingLogin = byText("Вход или регистрация")
    private val incorrectEmailError =
        byStringRes("ru.ozon.app.android:id/textinput_error").text("Некорректный формат почты")
    private val emailLogButton = By.clazz("android.widget.TextView").text("Войти по почте")
    @Override
    fun BySelector.waitHasObject(): Boolean {
        return device.wait(Until.hasObject(this), 1500L)
    }

    fun incorrectEmail(condition: Boolean) {
        Assert.assertEquals(condition, incorrectEmailError.waitHasObject())
    }

    fun loginByEmail() {
        emailLogButton.waitFindObject().click()
    }

    fun enterEmail(email: String) {
        emailText.waitFindObject().text = email
    }

    fun login() {
        loginButton.waitFindObject().click()
    }

    fun checkLoginPage() {
        Assert.assertTrue(
            "Вы не на странице входа или регистрации",
           headingLogin.waitHasObject()
        )
    }

}