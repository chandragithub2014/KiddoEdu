package mykid.dev.kiddoedu.ui.selectedCategory

import android.speech.tts.TextToSpeech
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mykid.dev.kiddoedu.domain.model.KiddoEduSelectedCategory
import mykid.dev.kiddoedu.utils.fetchSelectedCategoryList

@Composable
fun DisplaySelectedCategoryGrid(modifier: Modifier = Modifier, selectedType: String, textToSpeech: TextToSpeech,  listState: LazyGridState ) {
    val selectedCategoryInfoList = fetchSelectedCategoryList(selectedType)

    LazyVerticalGrid(
        columns = GridCells.Fixed(3), verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
        modifier = modifier
            // Add extra padding at the bottom to allow scrolling
            .padding(top = 30.dp, bottom = 20.dp),
        state = listState

        //.verticalScroll(rememberScrollState(), enabled = true)
    ) {
        items(selectedCategoryInfoList) { selectedCategoryItem ->
            SelectedCategoryItem(selectedCategoryItem) {selectedCategoryInfo->
                println("Selected item: $selectedCategoryInfo")
                textToSpeech.speak(
                    selectedCategoryInfo,
                    TextToSpeech.QUEUE_FLUSH,
                    null,
                    ""
                )
            }
        }

    }

}


@Composable
fun SelectedCategoryItem(
    selectedCategoryItem: KiddoEduSelectedCategory,
    onClick: (String) -> Unit
) {
    var isSelected by remember { mutableStateOf(false) }
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isSelected) 8f else 1f,
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
        label = "scale"
    )
    LaunchedEffect(isSelected) {
        if (isSelected) {
            delay(1000) // Adjust the duration of the animation as needed
            isSelected = false
        }
    }

    Card(
        //backgroundColor = Color.White,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
                modifier = Modifier
          //  .width(110.dp) // Set width
            .widthIn(min = 110.dp)
            .height(110.dp)

           // .padding(10.dp)
            .clickable {
                onClick(selectedCategoryItem.selectedCategoryName)
                isSelected = !isSelected
            },
        //  .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(2.dp)),
        shape = RoundedCornerShape(1.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {



            Box(
                modifier = Modifier
                    .fillMaxSize()
                   // .padding(bottom =  1.dp)
                    .semantics(mergeDescendants = true) {
                        contentDescription = selectedCategoryItem.selectedCategoryName
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = selectedCategoryItem.selectedCategoryName,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                         .padding(bottom = 2.dp)
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            transformOrigin = TransformOrigin.Center
                        },
                    style = TextStyle(
                        color = Color(android.graphics.Color.parseColor("#AF1818")),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                        // Set the desired font size here
                    )
                )
                Image(
                    painter = painterResource(id = selectedCategoryItem.selectedCategoryImage),
                    contentDescription = selectedCategoryItem.selectedCategoryName,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 8.dp)
                )
               /* Column(horizontalAlignment = Alignment.CenterHorizontally) { // Use a Column for better layout
                    Image(
                        painter = painterResource(id = selectedCategoryItem.selectedCategoryImage),
                        contentDescription = selectedCategoryItem.selectedCategoryName,
                        modifier = Modifier
                            .padding(top = 8.dp)
                           // .size(48.dp) // Adjust image size as needed
                    )
                    Text(
                        text = selectedCategoryItem.selectedCategoryName,
                        modifier = Modifier
                            .padding(top = 4.dp) // Add padding above text
                            .graphicsLayer {
                                scaleX = scale
                                scaleY = scale
                                transformOrigin = TransformOrigin.Center
                            },
                        textAlign = TextAlign.Center, // Center the text
                        style = TextStyle(
                            color = Color(android.graphics.Color.parseColor("#AF1818")),
                            fontSize = 24.sp, // Adjust font size as needed
                            fontWeight = FontWeight.Bold
                        )
                    )
                }*/
            }
        }

}