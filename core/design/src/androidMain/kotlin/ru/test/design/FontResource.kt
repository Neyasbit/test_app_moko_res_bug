package ru.test.design

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.icerock.moko.resources.FontResource
actual fun FontResource.asFontNonComposable(
    weight: FontWeight,
    style: FontStyle
): Font =
    Font(
        resId = fontResourceId,
        weight = weight,
        style = style
    )