package ru.test.design.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.fontFamilyResource
import ru.test.resources.Resources

@Composable
fun SecondaryFilledIconButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: Painter,
    onClick: () -> Unit
) {
    FilledTonalButton(
        modifier = modifier,
        onClick = onClick,
        shape = RectangleShape
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = icon,
                contentDescription = text,
                tint = MaterialTheme.colorScheme.primaryContainer
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = fontFamilyResource(Resources.fonts.sofiasans),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primaryContainer,
                maxLines = 1
            )
        }
    }
}