package com.hieuminh.jobfinder.utils

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionUtils {
    fun isRequirePermission(activity: Activity?, arrPers: Array<String>, requestCode: Int): Boolean {
        activity?.let {
            val isShow = arrPers.any {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                        ContextCompat.checkSelfPermission(activity, it) != PackageManager.PERMISSION_GRANTED
            }

            if (isShow) {
                val isShowDialog = arrPers.any { ActivityCompat.shouldShowRequestPermissionRationale(activity, it) }
                if (!isShowDialog) {
                    val builder = AlertDialog.Builder(activity)
                    builder.setTitle("You do not permission!")
                    builder.setMessage("Do you want to request permission?")
                        .setCancelable(false)
                        .setPositiveButton("Yes") { dialog, id ->
                            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                            val uri: Uri? = Uri.fromParts("package", activity.packageName, null)
                            uri?.let {
                                intent.data = uri
                                activity.startActivity(intent)
                            }
                        }
                        .setNegativeButton("No") { dialog, id ->
                            dialog.dismiss()
                        }
                    val alert = builder.create()
                    alert.show()
                } else {
                    ActivityCompat.requestPermissions(activity,
                        arrPers,
                        requestCode)
                }
            }
            return isShow
        }
        return true
    }
}