package com.lomovskiy.lib.qrscan

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.zxing.client.android.Intents
import com.journeyapps.barcodescanner.CaptureActivity

object ActivityResultContractScanQr : ActivityResultContract<Int?, String?>() {

    override fun createIntent(context: Context, input: Int?): Intent {
        return Intent(context, CaptureActivity::class.java).apply {
            if (input != null) {
                putExtra(Intents.Scan.PROMPT_MESSAGE, context.getString(input))
            }
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if (resultCode != Activity.RESULT_OK || intent == null) {
            return null
        }
        return intent.getStringExtra("SCAN_RESULT")
    }

}