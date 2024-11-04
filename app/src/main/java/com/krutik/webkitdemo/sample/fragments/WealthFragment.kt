package com.krutik.webkitdemo.sample.fragments

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModelProvider
import androidx.webkit.WebViewAssetLoader
import com.krutik.webkitdemo.Bridge
import com.krutik.webkitdemo.WebAppInterface
import com.krutik.webkitdemo.databinding.FragmentWealthBinding
import com.krutik.webkitdemo.sample.AndroidNativeInterface
import com.krutik.webkitdemo.sample.SharedViewModel

class WealthFragment : Fragment() {

    private var _binding: FragmentWealthBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel
    private var pageLoaded = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWealthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // Observe route changes
        sharedViewModel.route.observe(viewLifecycleOwner) { route ->
            println("testing nav native to js 88888" + route)
            // Load the route in the WebView
            binding.webView.loadUrl("file:///android_asset/web/pbdemo-build/index.html#$route")
        }

        WebView.setWebContentsDebuggingEnabled(true)
        binding.webView.addJavascriptInterface(WebAppInterface(requireContext()), "Android")
        val bridge = context?.let { Bridge(it, binding.webView) }
        bridge?.addJSInterface(AndroidNativeInterface(requireActivity()))
        val assetLoader = WebViewAssetLoader.Builder()
            .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(requireContext()))
            .build()

        binding.webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                println("testing 1111  + " + url)
                return super.shouldOverrideUrlLoading(view, url)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                bridge?.init()
                println("testing 222  + " + url)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                println("testing 333  + " + url)
                pageLoaded = true
            }

            override fun shouldInterceptRequest(view: WebView, request: WebResourceRequest): WebResourceResponse? {
                return assetLoader.shouldInterceptRequest(request.url)
            }
        }



        // Enable JavaScript in WebView settings
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE // Disable cache
        binding.webView.clearCache(true) // Clear cache if needed
        // Load the URL
        binding.webView.loadUrl("file:///android_asset/web/pbdemo-build/index.html")
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
    }
}
