package mykid.dev.kiddoedu.ui.category

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import kotlinx.coroutines.launch
import mykid.dev.kiddoedu.domain.model.KiddoEduCategory
import mykid.dev.kiddoedu.utils.fetchKiddoEduCategories
import com.google.accompanist.pager.HorizontalPagerIndicator
import kotlinx.coroutines.CoroutineScope
import mykid.dev.kiddoedu.R
import kotlin.math.absoluteValue

val IsPageIndicatorKey = SemanticsPropertyKey<Boolean>("IsPageIndicator")
var SemanticsPropertyReceiver.isPageIndicator by IsPageIndicatorKey
var kiddoEduCategories = listOf<KiddoEduCategory>()

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DisplayKiddoEduCategory(
    modifier: Modifier = Modifier,
    categoryList: List<KiddoEduCategory> = fetchKiddoEduCategories(
        LocalContext.current
    ),
    onSelectCategory: (KiddoEduCategory) -> Unit
) {
    kiddoEduCategories = categoryList
    val state = rememberPagerState(
        initialPage = categoryList.size / 2,
        initialPageOffsetFraction = 0f
    ) { categoryList.size }
    val coroutineScope = rememberCoroutineScope()
    var currentPage by remember { mutableIntStateOf(categoryList.size / 2) }
    LaunchedEffect(key1 = currentPage) {
        state.animateScrollToPage(currentPage)
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .onKeyEvent { event ->
                if (event.type == KeyEventType.KeyDown) {
                    when (event.key) {
                        Key.DirectionLeft -> {
                            currentPage = (currentPage - 1).coerceAtLeast(0)
                            true
                        }

                        Key.DirectionRight -> {
                            currentPage = (currentPage + 1).coerceAtMost(categoryList.size - 1)
                            true
                        }

                        else -> {
                            false
                        }

                    }

                } else {
                    false
                }


            },

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        KiddoEduCategoryCarousel(state, coroutineScope){ category ->
            onSelectCategory(category)
        }

        KiddoEduCategoryPagerIndicator(state, categoryList, coroutineScope)

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun KiddoEduCategoryPagerIndicator(
    state: PagerState,
    categoryList: List<KiddoEduCategory>,
    coroutineScope: CoroutineScope
) {
    HorizontalPagerIndicator(
        pagerState = state, pageCount = categoryList.size,
        modifier = Modifier
            .minimumInteractiveComponentSize()
            //.align(Alignment.CenterHorizontally)
            .padding(16.dp)
            .clickable {
                val currentPage = state.currentPage
                val totalPages = categoryList.size
                val nextPage =
                    if (currentPage < totalPages - 1) currentPage + 1 else 0
                coroutineScope.launch { state.animateScrollToPage(nextPage) }
            }
            .focusable()
            .semantics {
                isPageIndicator = true
                stateDescription = "Page ${state.currentPage + 1} of ${state.pageCount}"

            },
        activeColor = Color.Blue,
        inactiveColor = Color.LightGray
    )
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun KiddoEduCategoryCarousel(
    state: PagerState,
    coroutineScope: CoroutineScope,
    onSelectCategory: (KiddoEduCategory) -> Unit
) {
    HorizontalPager(
        state = state, contentPadding = PaddingValues(horizontal = 64.dp),
        modifier = Modifier.focusable(),
        pageSpacing = (-32).dp
    ) { page ->
        KiddoEduCategoryItem(pagerState = state, page = page) { selectedPage,selectedCategory ->
            onSelectCategory(selectedCategory)
            coroutineScope.launch {
                state.animateScrollToPage(selectedPage)
            }

        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun KiddoEduCategoryItem(pagerState: PagerState, page: Int, onSelectPage: (Int,KiddoEduCategory) -> Unit) {
    val red = colorResource(id = R.color.red)
    val pink = colorResource(id = R.color.pink)
    val green = colorResource(id = R.color.green)
    val indigo = colorResource(id = R.color.indigo)
    val purple = colorResource(id = R.color.purple)

    val abstractArtText = buildAnnotatedString {

        withStyle(
            style = SpanStyle(
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Medium,
                fontSize = 40.sp,
                //  brush = Brush.horizontalGradient(listOf(Color.Red, Color.Blue, Color.Green))
                brush = Brush.horizontalGradient(listOf(red, pink, green, indigo, purple))
            )
        ) {
            append(kiddoEduCategories[page].categoryName)
        }
    }
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
        modifier = Modifier
            .graphicsLayer {
                // Calculate the scale based on distance from the center
                val pageOffset =
                    (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                val scale = lerp(
                    start = 0.8f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(-1f, 1f).absoluteValue
                )
                scaleX = scale
                scaleY = scale
            }
            .width(IntrinsicSize.Min)
            .padding(horizontal = 10.dp)
            .aspectRatio(1f)
            .clickable {
                onSelectPage(page,kiddoEduCategories[page])
            }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),

            ) {
            Column(modifier = Modifier.align(Alignment.Center)) {
                Text(
                    text = abstractArtText,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Medium,
                    fontSize = 60.sp

                )
                Image(
                    painter = painterResource(id = kiddoEduCategories[page].categoryImage),
                    contentDescription = "Page ${page + 1} ${kiddoEduCategories[page].categoryName}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

            }


        }
    }

}