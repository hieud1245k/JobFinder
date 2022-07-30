package com.hieuminh.jobfinder.utils

import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.ActivityResultLauncher
import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult

class CustomActivityResult<Input, Result> private constructor(
    caller: ActivityResultCaller,
    contract: ActivityResultContract<Input, Result>,
    private var onActivityResult: OnActivityResult<Result>?
) {
    interface OnActivityResult<O> {
        fun onActivityResult(result: O)
    }

    private val launcher: ActivityResultLauncher<Input>

    fun setOnActivityResult(onActivityResult: OnActivityResult<Result>?) {
        this.onActivityResult = onActivityResult
    }

    @JvmOverloads
    fun launch(input: Input, onActivityResult: OnActivityResult<Result>? = this.onActivityResult) {
        if (onActivityResult != null) {
            this.onActivityResult = onActivityResult
        }
        launcher.launch(input)
    }

    private fun callOnActivityResult(result: Result) {
        if (onActivityResult != null) onActivityResult!!.onActivityResult(result)
    }

    companion object {
        private fun <Input, Result> registerForActivityResult(
            caller: ActivityResultCaller,
            contract: ActivityResultContract<Input, Result>,
            onActivityResult: OnActivityResult<Result>?
        ): CustomActivityResult<Input, Result> {
            return CustomActivityResult(caller, contract, onActivityResult)
        }

        private fun <Input, Result> registerForActivityResult(
            caller: ActivityResultCaller,
            contract: ActivityResultContract<Input, Result>
        ): CustomActivityResult<Input, Result> {
            return registerForActivityResult(caller, contract, null)
        }

        @JvmStatic
        fun registerActivityForResult(
            caller: ActivityResultCaller
        ): CustomActivityResult<Intent, ActivityResult> {
            return registerForActivityResult(caller, StartActivityForResult())
        }
    }

    init {
        launcher = caller.registerForActivityResult(contract) { result: Result -> callOnActivityResult(result) }
    }
}
