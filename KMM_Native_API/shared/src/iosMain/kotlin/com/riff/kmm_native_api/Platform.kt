package com.riff.kmm_native_api

import cocoapods.AFNetworking.AFHTTPRequestSerializer
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}
