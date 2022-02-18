package de.apps.LittleNemo.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.CoilImage


@Composable
fun Image(data:String){
    CoilImage(
        data = data,
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .height(225.dp),
        contentScale = ContentScale.Crop,)
}
