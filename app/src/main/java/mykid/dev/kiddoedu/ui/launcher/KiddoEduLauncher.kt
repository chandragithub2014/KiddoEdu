package mykid.dev.kiddoedu.ui.launcher

import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import mykid.dev.kiddoedu.common.AppScaffold
import mykid.dev.kiddoedu.ui.category.DisplayKiddoEduCategory
import mykid.dev.kiddoedu.ui.selectedCategory.DisplaySelectedCategoryGrid
import mykid.dev.kiddoedu.utils.SelectedCategory
import java.util.Locale


@Composable
fun KiddoEduLauncherComposable(
    navController: NavHostController

) {
    var selectedCategory by remember { mutableStateOf(SelectedCategory.ANIMALS) }
    var textToSpeech by remember { mutableStateOf<TextToSpeech?>(null) }
    val context = LocalContext.current
    val listState = rememberLazyGridState()
    val coroutineScope = rememberCoroutineScope()
    AppScaffold(title = "KiddoEdu") { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LaunchedEffect(Unit) {
                textToSpeech = TextToSpeech(context) { status ->
                    if (status == TextToSpeech.SUCCESS) {
                        val result = textToSpeech?.setLanguage(Locale.US)
                        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                            // Language data is missing or the language is not supported.
                            Toast.makeText(
                                context,
                                "Language data is missing or the language is not supported",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else {
                        Toast.makeText(context, "Initialization Failed", Toast.LENGTH_LONG).show()
                    }
                }
            }
            DisposeTextToSpeech(textToSpeech)
            ConstraintLayout(kiddoEduLayoutConstraints(), modifier = Modifier.fillMaxSize()) {
                DisplayKiddoEduCategory(modifier = Modifier.layoutId("categoryContainer")){
                    println("Selected Category is $it")
                    selectedCategory = it.categoryName
                    coroutineScope.launch {
                        listState.scrollToItem(0, 0)
                    }

                }
                textToSpeech?.let {textToSpeechConverter ->
                    DisplaySelectedCategoryGrid(modifier = Modifier.layoutId("categoryGrid"),selectedCategory,textToSpeechConverter,listState)
                }

                Box(
                    modifier = Modifier
                        .layoutId("adsContainer")
                        .fillMaxWidth()
                        .background(Color.Cyan)
                ) {
                    Text(
                        text = "BottomContainer",
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
private fun DisposeTextToSpeech(textToSpeech: TextToSpeech?) {
    DisposableEffect(Unit) {
        onDispose {
            textToSpeech?.shutdown()
        }
    }
}


private fun kiddoEduLayoutConstraints(): ConstraintSet {
    return ConstraintSet {
        val kiddoEduCategoryContainer = createRefFor("categoryContainer")
        val selectedCategoryGrid = createRefFor("categoryGrid")
        val addContainer = createRefFor("adsContainer")


        constrain(kiddoEduCategoryContainer) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent

        }

        constrain(selectedCategoryGrid) {
            top.linkTo(kiddoEduCategoryContainer.bottom)
            bottom.linkTo(addContainer.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints

        }

        constrain(addContainer) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.value(100.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KiddoEduLauncherComposablePreview() {
    KiddoEduLauncherComposable(navController = rememberNavController())
}