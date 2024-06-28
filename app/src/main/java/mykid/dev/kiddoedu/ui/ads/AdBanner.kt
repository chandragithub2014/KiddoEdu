package mykid.dev.kiddoedu.ui.ads

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun AdBanner(modifier : Modifier = Modifier) {
    AndroidView(
        modifier = modifier.fillMaxWidth(),
        factory = { context ->
            AdView(context).apply {
                setAdSize(AdSize.BANNER)
                adUnitId = "ca-app-pub-5163649868847747/7897813808"
                loadAd(AdRequest.Builder().build())
            }
        }
    )
}


//AppId : ca-app-pub-5163649868847747~1309807423
//AdUnitID : ca-app-pub-5163649868847747/7897813808


//Sample AppId: ca-app-pub-3940256099942544~3347511713
//Sample AddUnitId : ca-app-pub-3940256099942544/9214589741