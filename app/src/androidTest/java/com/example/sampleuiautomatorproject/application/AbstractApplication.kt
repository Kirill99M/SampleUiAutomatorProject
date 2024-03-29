package com.example.sampleuiautomatorproject.application

import android.bluetooth.BluetoothClass
import android.content.Context
import android.content.Intent
import com.example.sampleuiautomatorproject.util.context
import com.example.sampleuiautomatorproject.util.device
import org.junit.Assert.assertNotNull

abstract class AbstractApplication(val packageName: String) {

    open fun open() {
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)?.apply {


        }
        device.pressHome()
        context.startActivity(intent)
    }

    fun assertInstalled() {
        assertNotNull(
            "App $packageName is not installed",
            context.packageManager.getLaunchIntentForPackage(packageName)
            )
    }
}
