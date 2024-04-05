package ru.test.design.text

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import ru.test.resources.Resources

@Composable
fun StickerTittle(
    modifier: Modifier = Modifier,
    title: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(Resources.images.backgraund_tittle),
            contentDescription = title
        )
        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterStart)
                .padding(vertical = 8.dp, horizontal = 8.dp),
            text = title.uppercase(),
            style = MaterialTheme.typography.titleSmall,
            color = Color.White
        )
    }
}