package com.droid.app.extractor.data;

import android.graphics.drawable.Drawable;
import com.droid.app.extractor.AppsApplication
import com.droid.app.extractor.util.convertUnit
import java.io.File

data class App(val packageName: String,
               val icon: Drawable,
               val label: String,
               internal val path: String,
               val versionName: String?) {

    var checked: Boolean = false

    var processed: Boolean = false

    val size: String
        get() {
            val file: File = File(path)
            return convertUnit(file.length())
        }

    val srcFile: File
        get() = File(path)

    val destFile: File
        get() = File(AppsApplication.destDir, "${label}-v${versionName}.apk")

    val exported: Boolean
        get() {
            return destFile.exists();
        }
}