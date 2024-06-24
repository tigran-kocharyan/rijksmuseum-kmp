package com.totowka.kmp.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentCompositeKeyHash
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import com.totowka.kmp.domain.model.PaintingDomain
import com.totowka.kmp.ui.screens.detail.DetailScreen
import com.totowka.kmp.util.openUrl
import org.jetbrains.compose.resources.stringResource
import yandexschool.composeapp.generated.resources.Res
import yandexschool.composeapp.generated.resources.museum_url
import yandexschool.composeapp.generated.resources.no_data_available

data object ListScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val screenModel: ListScreenModel = koinScreenModel()

        LaunchedEffect(currentCompositeKeyHash) {
            screenModel.getPaintings()
        }

        val museumState by screenModel.state.collectAsState()

        when (val state = museumState) {
            is ListScreenModel.State.Data -> {
                Content(state.paintings, navigator)
            }
            is ListScreenModel.State.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(stringResource(Res.string.no_data_available))
                }
            }
            else -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(48.dp),
                    )
                }
            }
        }
    }
}

@Composable
private fun Content(
    paintings: List<PaintingDomain>,
    navigator: Navigator,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
            onClick = { openUrl("https://www.rijksmuseum.nl/en/rijksstudio") },
        ) {
            Text(stringResource(Res.string.museum_url))
        }
        PaintingsGrid(
            paintings = paintings,
            onPaintingClick = { painting ->
                navigator.push(DetailScreen(painting))
            }
        )
    }
}

@Composable
private fun PaintingsGrid(
    paintings: List<PaintingDomain>,
    onPaintingClick: (PaintingDomain) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(130.dp),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(paintings, key = { it.id }) { painting ->
            PaintingFrame(
                painting = painting,
                onClick = { onPaintingClick(painting) },
            )
        }
    }
}

@Composable
private fun PaintingFrame(
    painting: PaintingDomain,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = painting.imageUrl,
            contentDescription = painting.title,
            imageLoader = ImageLoader(LocalPlatformContext.current),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(Color.LightGray),
            contentScale = ContentScale.Crop,
        )

        Spacer(Modifier.height(2.dp))

        Text(
            text = painting.title,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = TextUnit(18F, TextUnitType.Sp),
            textAlign = TextAlign.Center,
        )
        Text(
            text = painting.artistName,
            fontWeight = FontWeight.Normal,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = TextUnit(14F, TextUnitType.Sp),
            textAlign = TextAlign.Center,
        )
    }
}
