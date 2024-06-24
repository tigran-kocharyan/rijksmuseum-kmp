package com.totowka.kmp.util

import platform.Foundation.NSURL
import platform.UIKit.UIApplication

internal actual fun openUrl(url: String) {
    val nsUrl = NSURL.URLWithString(url) ?: return
    UIApplication.sharedApplication.openURL(nsUrl, emptyMap<Any?, Any>(), null)
}