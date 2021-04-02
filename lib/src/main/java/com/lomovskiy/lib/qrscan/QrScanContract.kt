package com.lomovskiy.lib.qrscan

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.zxing.client.android.Intents
import com.journeyapps.barcodescanner.CaptureActivity

object QrScanContract : ActivityResultContract<Void, String?>() {

    override fun createIntent(context: Context, input: Void?): Intent {
        return Intent(context, CaptureActivity::class.java)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if (resultCode != Activity.RESULT_OK || intent == null) {
            return null
        }
        return intent.getStringExtra("SCAN_RESULT")
    }

}