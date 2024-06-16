package mykid.dev.kiddoedu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mykid.dev.kiddoedu.ui.launcher.KiddoEduLauncherComposable
import mykid.dev.kiddoedu.ui.theme.KiddoEduTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //  enableEdgeToEdge()
        setContent {
            KiddoEduTheme {
               /* Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    val navController = rememberNavController()
                    Navigator(navController, innerPadding)
                }*/
                val navController = rememberNavController()
                Navigator(navController)
            }
        }
    }
}

@Composable
fun Navigator(navHostController: NavHostController/*, innerPadding: PaddingValues*/) {
    NavHost(navController = navHostController, startDestination = "kiddoEduLauncherScreen"/*,  modifier = Modifier.padding(innerPadding)*/) {
        composable("kiddoEduLauncherScreen") {
            KiddoEduLauncherComposable(navController = navHostController)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KiddoEduTheme {
        Greeting("Android")
    }
}