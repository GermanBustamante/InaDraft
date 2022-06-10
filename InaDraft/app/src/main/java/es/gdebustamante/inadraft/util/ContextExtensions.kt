package es.gdebustamante.inadraft.util

import android.content.Context
import android.content.res.Configuration

fun Context.isDarkThemeOn() = resources.configuration.uiMode and
        Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

fun Context.getAppName() = applicationInfo
    .loadLabel(packageManager)
    .toString()