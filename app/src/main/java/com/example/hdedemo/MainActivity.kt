package com.example.hdedemo

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.hdedemo.ui.theme.HDEDemoTheme

const val CHAT_URL =
    "https://ashunicorn.helpdeskeddy.com/ru/omnichannel/chat?id=6270f045-2efd-482d-bcfb-0dc98c048248"
//    "https://google.com"

class MainActivity : ComponentActivity() {
    //    private lateinit var webViewClient: WebViewClient
    private var currentWebView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        webViewClient = WebViewClient()
        val webView = WebView(this)
        webView.webViewClient = WebViewClient()
        webView.loadUrl(CHAT_URL)
        currentWebView = webView

        setContent {
            HDEDemoTheme {
                AndroidView(factory = {
                    return@AndroidView currentWebView!!
                })
            }
        }
    }

    override fun onBackPressed() {
        if (currentWebView?.canGoBack() == true) {
            currentWebView?.goBack()
        } else {
            Toast.makeText(this, "Closing chat window", Toast.LENGTH_SHORT).show()
        }
    }
}
