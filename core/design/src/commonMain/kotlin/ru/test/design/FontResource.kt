package ru.test.design

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.icerock.moko.resources.FontResource

expect fun FontResource.asFontNonComposable(
    weight: FontWeight = FontWeight.Normal,
    style: FontStyle = FontStyle.Normal
): Font