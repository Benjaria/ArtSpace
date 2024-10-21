package com.example.artspace.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.R

@Preview(showBackground = true)
@Composable
fun ArtSpaceApp() {
    ArtSpace(modifier = Modifier.fillMaxSize())
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        ArtCard(modifier = modifier.weight(1f), R.drawable.photo1)
        ArtInfo(modifier = Modifier.weight(0.12f))
        NavigationButtons(modifier = modifier.weight(0.12f), {}, {})
    }
}

@Composable
fun ArtCard(modifier: Modifier = Modifier, @DrawableRes imageRes: Int) {
    Box(modifier = modifier) {
        Card {
            Image(
                painterResource(imageRes),
                null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(24.dp)
            )
        }
    }
}

@Composable
fun ArtInfo(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "Artwork Title",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
            )
            Row {
                Text("Artist")
                Spacer(modifier = Modifier.padding(4.dp))
                Text("(Year)")
            }
        }
    }
}

@Composable
fun NavigationButtons(
    modifier: Modifier = Modifier,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(0.2f))
            Button(onClick = onPreviousClick, modifier = Modifier.weight(1f)) { Text("Previous") }
            Spacer(modifier = Modifier.weight(0.2f))
            Button(onClick = onNextClick, modifier = Modifier.weight(1f)) { Text("Next") }
            Spacer(modifier = Modifier.weight(0.2f))
        }
    }
}
