package com.joy.browser

import android.os.Bundle
import android.webkit.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var webView: WebView
    lateinit var urlInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        urlInput = findViewById(R.id.urlInput)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://www.google.com")

        findViewById<Button>(R.id.goBtn).setOnClickListener {
            var url = urlInput.text.toString()
            if (!url.startsWith("http")) url = "https://$url"
            webView.loadUrl(url)
        }

        findViewById<Button>(R.id.backBtn).setOnClickListener {
            if (webView.canGoBack()) webView.goBack()
        }

        findViewById<Button>(R.id.refreshBtn).setOnClickListener {
            webView.reload()
        }
    }
}
