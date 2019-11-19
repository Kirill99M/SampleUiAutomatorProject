package com.example.sampleuiautomatorproject.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sampleuiautomatorproject.application.*
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Tests : AbstractApplicationTest<Ozon>(Ozon()) {
    private val productName = "Философия Java"
    private val mainPage = MainPage()
    private val favoritesPage = FavoritePage()
    private val loginPage = LoginPage()
    private val productPage = ProductPage()
    private val searchPage = SearchPage()
    @After

    @Test
    fun checkHintTest() = with(app) {
        open()
        mainPage.clickSearch()
        searchPage.typeToSearch(productName)
        searchPage.checkHintTitle(productName)
        searchPage.checkHintCost("1 499 \u20BD")
    }

    @Test
    fun addFavoriteBookTest() = with(app) {
        open()
        mainPage.clickSearch()
        searchPage.typeToSearch(productName)
        searchPage.clickHint(productName)
        productPage.addFavorite()
        mainPage.favoritesPage()
        favoritesPage.checkGoToFavorites()
        favoritesPage.checkProductInFavorites(productName)
        favoritesPage.unfavorite()
    }

    @Test
    fun emailCheckTest() = with(app) {
        open()
        mainPage.goToProfile()
        loginPage.loginByEmail()
        loginPage.enterEmail("qwerty")
        loginPage.login()
        loginPage.incorrectEmail(true)
        loginPage.enterEmail("qwerty@gmail.com")
        loginPage.login()
        loginPage.incorrectEmail(false)
    }

    @Test
    fun loginForWriteReview() = with(app) {
        open()
        mainPage.clickSearch()
        searchPage.typeToSearch(productName)
        searchPage.clickHint(productName)
        productPage.scrollTo("Написать отзыв")
        productPage.clickReviewButton()
        loginPage.checkLoginPage()
    }
}