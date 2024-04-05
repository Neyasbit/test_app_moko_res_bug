package ru.test.design

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import dev.icerock.moko.resources.FontResource
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.posix.memcpy

internal fun NSData.toByteArray(): ByteArray {
    return ByteArray(this@toByteArray.length.toInt()).apply {
        usePinned { pinned ->
            memcpy(pinned.addressOf(0), this@toByteArray.bytes, this@toByteArray.length)
        }
    }
}

actual fun FontResource.asFontNonComposable(
    weight: FontWeight,
    style: FontStyle
): Font = Font(
    identity = fontName,
    data = data.toByteArray(),
    weight = weight,
    style = style
)