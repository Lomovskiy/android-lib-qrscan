package com.lomovskiy.lib.qrscan

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import androidx.annotation.StringRes
import com.google.zxing.client.android.Intents
import com.journeyapps.barcodescanner.CaptureActivity

class QrScanConfig(@StringRes val prompt: Int)

object ActivityResultContractScanQr : ActivityResultContract<QrScanConfig?, String?>() {

    override fun createIntent(context: Context, input: QrScanConfig?): Intent {
        return Intent(context, CaptureActivity::class.java).apply {
            if (input != null) {
                putExtra(Intents.Scan.PROMPT_MESSAGE, context.getString(input.prompt))
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