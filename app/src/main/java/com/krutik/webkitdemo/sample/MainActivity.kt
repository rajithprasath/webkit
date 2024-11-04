package com.krutik.webkitdemo.sample

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.ConsoleMessage
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import androidx.webkit.WebViewAssetLoader
import com.krutik.webkitdemo.Bridge
import com.krutik.webkitdemo.CallResolver
import com.krutik.webkitdemo.JSFunctionWithArg
import com.krutik.webkitdemo.JSFunctionWithPromise
import com.krutik.webkitdemo.JSFunctionWithPromiseAndArg
import com.krutik.webkitdemo.R
import com.krutik.webkitdemo.databinding.ActivityMainBinding
import com.krutik.webkitdemo.sample.adapter.ViewPagerAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    var counter = 0;

    private lateinit var binding : ActivityMainBinding
    lateinit var sharedViewModel: SharedViewModel
    // Boolean to determine which API call to make
    val useNativeCall: Boolean = true // Change this to false to use web request
    val apiService = ApiService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]
        WebView.setWebContentsDebuggingEnabled(true)


        // Set up ViewPagerAdapter
        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        // Sync ViewPager2 with BottomNavigationView
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> binding.viewPager.currentItem = 0
                R.id.nav_accounts -> binding.viewPager.currentItem = 1
                R.id.nav_wealth -> binding.viewPager.currentItem = 2
                R.id.nav_rewards -> binding.viewPager.currentItem = 3
                R.id.nav_services -> binding.viewPager.currentItem = 4
            }
            true
        }

        // Sync BottomNavigationView selection with ViewPager swipe
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding.bottomNavigationView.selectedItemId = R.id.nav_home
                    1 -> binding.bottomNavigationView.selectedItemId = R.id.nav_accounts
                    2 -> binding.bottomNavigationView.selectedItemId = R.id.nav_wealth
                    3 -> binding.bottomNavigationView.selectedItemId = R.id.nav_rewards
                    4 -> binding.bottomNavigationView.selectedItemId = R.id.nav_services
                }
            }


        })

        sharedViewModel.index.observe(this) { index ->
            println("testing nav native to js 88888" + index)
          navigateToTab(index)
        }
    }

    // Method to navigate to a specific tab
    fun navigateToTab(index: Int) {
        println("testing nav 6666 with route:" + index)
        runOnUiThread {
            println("testing nav 6666 with route: $index")
            binding.viewPager.currentItem = index
        }
    }

//        val bridge = Bridge(applicationContext, binding.webView)
//        bridge.addJSInterface(AndroidNativeInterface(this@MainActivity))
//
//        val assetLoader = WebViewAssetLoader.Builder()
//            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(this))
//            .build()
//
//        binding.webView.webViewClient = object : WebViewClient() {
//
//            override fun shouldInterceptRequest(view: WebView, request: WebResourceRequest): WebResourceResponse? {
//                return assetLoader.shouldInterceptRequest(request.url)
//            }
//
//            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
//                bridge.init()
//            }
//        }
//
//        binding.webView.loadUrl("https://appassets.androidplatform.net/assets/www/index.html")




    // This function is called from the JavaScript when the button is clicked
//    fun fetchData(promise: CallResolver<String>) {
//        CoroutineScope(Dispatchers.IO).launch {
//            println("checking my task 3333 ")
//            val result = apiService.fetchData(useNativeCall) // Fetch data based on the boolean
//            withContext(Dispatchers.Main) {
//                updateWebViewWithResult(result)
//                promise.resolve(result) // Resolve the promise with the fetched result
//            }
//        }
//    }

//    private fun updateWebViewWithResult(result: String) {
//        // Pass the result to the WebView
//        binding.webView.evaluateJavascript("javascript:updateText('$result')", null)
//    }
//
//    fun registerFunctionToButton1(function: JSFunctionWithArg<Int>) {
//        binding.button.setOnClickListener {
//            ++counter
//            function.call(counter)
//        }
//    }
//
//    fun registerFunctionToButton2(function: JSFunctionWithPromise<String>) {
//        binding.button2.setOnClickListener {
//            function.call().then {
//                runOnUiThread { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
//            }.catch {
//                runOnUiThread { Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show() }
//            }
//        }
//    }
//
//    fun registerFunctionToButton3(function: JSFunctionWithPromiseAndArg<Add, String>) {
//        binding.button3.setOnClickListener {
//            function.call(Add((Math.random() * 10).toInt(), (Math.random() * 10).toInt())).then {
//                runOnUiThread { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
//            }.catch {
//                runOnUiThread { Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show() }
//            }
//        }
//    }

    fun showToast(message: String) {
        runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}
