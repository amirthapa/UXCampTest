package com.uxcamp.analytics.data

import androidx.annotation.RestrictTo
import com.chibatching.kotpref.KotprefModel
import com.chibatching.kotpref.enumpref.enumValuePref
enum class ENVIRONMENT {
    PRODUCTION, DEBUG, UAT, PREPRODUCTION
}
@RestrictTo(RestrictTo.Scope.LIBRARY)
object UserInfo : KotprefModel() {
    var environment by enumValuePref(default = ENVIRONMENT.DEBUG)
    var appVersion by stringPref(default = "")
    var apiKey by stringPref(default = "")
    var chukkaEnable by booleanPref(default = false)
    var deviceOsVersion by intPref()
    var deviceModel by stringPref("")
}