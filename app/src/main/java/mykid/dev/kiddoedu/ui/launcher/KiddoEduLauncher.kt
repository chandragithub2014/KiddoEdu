package mykid.dev.kiddoedu.ui.launcher

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import mykid.dev.kiddoedu.common.AppScaffold
import mykid.dev.kiddoedu.ui.category.DisplayKiddoEduCategory


@Composable
fun KiddoEduLauncherComposable(
    navController: NavHostController

) {
    AppScaffold(title = "KiddoEdu") { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            ConstraintLayout(kiddoEduLayoutConstraints(), modifier = Modifier.fillMaxSize()) {
                DisplayKiddoEduCategory(modifier = Modifier.layoutId("categoryContainer")){
                    println("Selected Category is $it")
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