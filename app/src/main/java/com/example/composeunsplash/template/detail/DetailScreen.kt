package com.example.composeunsplash.template.detail


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.composeunsplash.data.local.Photo
import org.koin.androidx.compose.getViewModel


@OptIn(ExperimentalCoilApi::class)
@Composable
fun DetailScreen(photoId : String?){
    val viewModel = getViewModel<DetailViewModel>()
    photoId?.let { viewModel.searchPhoto(it) }
    Log.d("CekFavoriteId",photoId.toString())
    val result = viewModel.detailPhoto().observeAsState()
    Scaffold() {
        result.value?.let {
            val photo = Photo(
                imagePath = it.urls?.small,
                description = it.altDescription,
                id = it.id
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
            ) {
                Image(
                    painter = rememberImagePainter(it.urls?.small),
                    contentDescription = "",
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                )
                Text(text = "Description")
                Text(text = it.altDescription.toString())
                Button(
                    onClick = { viewModel.insertPhoto(photo)}
                ) {
                    Text(text = "Favorite")
                }
            }
        }
    }

    }

@Preview
@Composable
fun DefaultPreview() {
    DetailScreen(photoId = "B04Xpnu5JQ4")
}


