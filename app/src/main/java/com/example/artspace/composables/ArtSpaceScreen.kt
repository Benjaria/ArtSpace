package com.example.artspace.composables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

    var stage by remember { mutableStateOf(1) }

    val imageRes = when (stage){
        1 -> R.drawable.photo1
        2 -> R.drawable.photo2
        3 -> R.drawable.photo3
        4 -> R.drawable.photo4
        5 -> R.drawable.photo5
        6 -> R.drawable.photo6
        7 -> R.drawable.photo7
        else -> R.drawable.photo8
    }

    val artNameRes = when (stage){
        1 -> R.string.leaf_zoomed
        2 -> R.string.mountain
        3 -> R.string.car
        4 -> R.string.leaves
        5 -> R.string.autumn_leaves
        6 -> R.string.coffee_shop
        7 -> R.string.flowers
        else -> R.string.building
    }
    val artistRes = when (stage) {
        1 -> R.string.artist1
        2 -> R.string.artist2
        3 -> R.string.artist3
        4 -> R.string.artist4
        5 -> R.string.artist5
        6 -> R.string.artist6
        7 -> R.string.artist7
        else -> R.string.artist8
    }


    Column(modifier = modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        ArtCard(modifier = modifier.weight(1f), imageRes)
        ArtInfo(modifier = Modifier.weight(0.12f), artNameRes, artistRes)
        NavigationButtons(
            modifier = modifier.weight(0.12f),
            onPreviousClick = { if (stage > 1) stage -= 1 else stage = 8 },
            onNextClick = { if (stage < 8) stage += 1 else stage = 1 })
    }
}

@Composable
fun ArtCard(modifier: Modifier = Modifier, @DrawableRes imageRes: Int) {
    Box(modifier = modifier) {
        Card(modifier = Modifier.background(color = Color.Transparent), elevation = CardDefaults.cardElevation(24.dp)) {
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
fun ArtInfo(modifier: Modifier = Modifier, @StringRes artInfo: Int, @StringRes artistInfo: Int) {
    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                stringResource(artInfo),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
            )
            Text(stringResource(artistInfo))

        }
    }
}

@Composable
fun NavigationButtons(
    modifier: Modifier = Modifier,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
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
