package com.example.sampleuiautomatorproject.test

import android.util.Log
import com.example.sampleuiautomatorproject.application.AbstractApplication
import com.example.sampleuiautomatorproject.util.device
import org.junit.After
import org.junit.Before

abstract class AbstractApplicationTest<T : AbstractApplication>(val app : T) {

    @Before
    fun assertPackageInstalled() {
        app.assertInstalled()
    }


}
