package com.mirongdev.demoads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.solodroid.ads.sdk.format.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    InterstitialAd.Builder interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadInterstitialAd();
    }
    private void loadInterstitialAd() {
        Log.d(TAG, "loadInterstitialAd()");
        interstitialAd = new InterstitialAd.Builder(this)
                .setAdStatus(Constant.AD_STATUS)
                .setAdNetwork(Constant.AD_NETWORK)
                .setBackupAdNetwork(Constant.BACKUP_AD_NETWORK)
                .setAdMobInterstitialId(Constant.ADMOB_INTERSTITIAL_ID)
                .setGoogleAdManagerInterstitialId(Constant.GOOGLE_AD_MANAGER_INTERSTITIAL_ID)
                .setFanInterstitialId(Constant.FAN_INTERSTITIAL_ID)
                .setUnityInterstitialId(Constant.UNITY_INTERSTITIAL_ID)
                .setAppLovinInterstitialId(Constant.APPLOVIN_INTERSTITIAL_ID)
                .setAppLovinInterstitialZoneId(Constant.APPLOVIN_INTERSTITIAL_ZONE_ID)
                .setIronSourceInterstitialId(Constant.IRONSOURCE_INTERSTITIAL_ID)
                .setWortiseInterstitialId(Constant.WORTISE_INTERSTITIAL_ID)
                .setInterval(Constant.INTERSTITIAL_AD_INTERVAL)
                .build(() -> {
                    Log.d(TAG, "onAdDismissed");
                });
    }

    private void showInterstitialAd() {
        interstitialAd.show(() -> {
            Log.d(TAG, "onAdShowed");
        }, () -> {
            Log.d(TAG, "onAdDismissed");
        });

    }

    public void interShow(View view) {
        startActivity(new Intent(getApplicationContext(), ShowActivity.class));
        showInterstitialAd();
        Log.d(TAG, "button pencet");
    }
}