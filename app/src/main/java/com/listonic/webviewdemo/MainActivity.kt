package com.listonic.webviewdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupWebClient()
        webView.settings.javaScriptEnabled = true

        webView.loadUrl("https://vitalia.pl/index.php/mid/134/fid/1734/kalorie/diety/action/reload/")
    }

    private fun setupWebClient() {

        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest): Boolean {

                val host = Uri.parse(request.url.toString())?.host

                if (host?.contains("listonic") == true) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(request.url.toString()))
                    startActivity(intent)
                    return true
                }

                return false
            }
        }
    }

}
