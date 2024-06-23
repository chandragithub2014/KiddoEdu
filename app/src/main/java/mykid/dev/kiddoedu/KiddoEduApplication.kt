package mykid.dev.kiddoedu

import android.app.Application
import com.google.android.gms.ads.MobileAds

class KiddoEduApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) {} // Initialize the SDK
    }
}