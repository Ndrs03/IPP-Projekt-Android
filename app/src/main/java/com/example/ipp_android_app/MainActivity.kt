package com.example.ipp_android_app



import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById<View>(R.id.webview) as WebView
        webView!!.webViewClient = WebViewClient()
        webView!!.loadUrl("https://drive.google.com/drive/folders/1yUN6WLTOArxmyBChM1uaiaTgh3bMZ1Vc")
        val webSettings = webView!!.settings
        webSettings.javaScriptEnabled = true
        CookieManager.getInstance().setAcceptCookie(true)

        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)

        webSettings.domStorageEnabled = true

        webView!!.webViewClient = WebViewClient()


    }

    override fun onBackPressed() {
        if (webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }
}