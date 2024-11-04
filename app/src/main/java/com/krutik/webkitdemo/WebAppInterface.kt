package com.krutik.webkitdemo

import android.content.Context
import android.webkit.JavascriptInterface
import com.krutik.webkitdemo.sample.MainActivity

class WebAppInterface(private val context: Context) {

    // Reference to the activity that contains the navigateToTab method
    private val activity: MainActivity = context as MainActivity

    @JavascriptInterface
    fun navigateTo(route: String, params: String?) {
        println("testing nav 4444 with route: $route and params: $params")
        // Handle the navigation based on the route parameter
        when (route) {
            "dashboard" -> {
                println("testing nav 5555 with route: $route and params: $params")
                activity.navigateToTab(0)
                // Navigate to Dashboard activity or fragment
            }
            "accounts" -> {
                activity.navigateToTab(1)
                // Navigate to Accounts activity or fragment
            }
            "rewards+" -> {
                activity.navigateToTab(3)
                // Navigate to Accounts activity or fragment
            }
            // Add more cases as needed
        }
    }


}