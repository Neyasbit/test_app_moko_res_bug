package ru.test.design.chips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun TagChip(
    modifier: Modifier = Modifier,
    color: Color,
    text: String,
    fonSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize
) {
    Text(
        modifier = modifier
            .background(color = color, shape = RoundedCornerShape(60.dp))
            .padding(vertical = 6.dp, horizontal = 8.dp),
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        fontSize = fonSize,
        maxLines = 1
    )
}