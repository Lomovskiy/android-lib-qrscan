package com.lomovskiy.lib.qrscan.sample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.lomovskiy.lib.qrscan.QrScanContract
import com.lomovskiy.lib.ui.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button

    private val scanQrLauncher = registerForActivityResult(QrScanContract) {
        if (it != null) {
            showToast(it)
        } else {
            showToast("null")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            scanQrLauncher.launch(null)
        }
    }

}
